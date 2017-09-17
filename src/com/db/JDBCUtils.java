package com.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Created by lenovo on 2017/7/7.
 */
public class JDBCUtils {
    //获取连接
    public Connection getConnection(){
        Connection connection = null;
        String driver_class = null;
        String driver_url = null;
        String database_user = null;
        String database_password = null;

        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driver_class = properties.getProperty("driver").trim();
            driver_url = properties.getProperty("url").trim();
            database_user = properties.getProperty("user");
            database_password = properties.getProperty("password");
            Class.forName(driver_class);
            connection = DriverManager.getConnection(driver_url,database_user,database_password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭连接
    public void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //查询数据
    public List<Map<String,Object>>query(String sql,Object ... args){
        ResultSet resultSet = null;
        List<Map<String,Object>> list = null;
        try {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                connection = getConnection();
                preparedStatement = connection.prepareStatement(sql);
                if (args != null && args.length > 0){
                    for (int i = 0;i < args.length;i++){
                        preparedStatement.setObject(i+1,args[i]);
                    }
                }
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null){
                    list = getResultMap(resultSet);
                    closeAll(connection,preparedStatement,resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeAll(connection,preparedStatement,resultSet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    private List<Map<String,Object>>getResultMap(ResultSet resultSet) throws SQLException {
        Map<String,Object>map = null;
        List<Map<String,Object>>list = new ArrayList<Map<String, Object>>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int count = resultSetMetaData.getColumnCount();
        while (resultSet.next()){
            map = new HashMap<String,Object>();
            for (int i = 1;i <= count;i++){
                String key = resultSetMetaData.getColumnLabel(i);
                Object value = resultSet.getString(i);
                map.put(key,value);
            }
            list.add(map);
        }
        return list;
    }
    //增删改
    public int update(String sql,Object ... args){
        int result = -1;
        try {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                connection = getConnection();
                preparedStatement = connection.prepareStatement(sql);
                if (args != null && args.length > 0){
                    for (int i = 0 ; i < args.length ; i++){
                        preparedStatement.setObject(i+1,args[i]);
                    }
                    result = preparedStatement.executeUpdate();
                    closeAll(connection,preparedStatement,null);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    //获取数据的总条数
    public int dataCount(String dataTable,int channelId,int sortId){
        String sql = "SELECT count(*) as num FROM "+ dataTable +" WHERE Wt_channelId="+ channelId +" AND Wt_sortId=" + sortId;
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()){
                count = Integer.parseInt(resultSet.getString("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAll(connection,preparedStatement,resultSet);
        return count;
    }
    //分页:object[] 数组第一个值是 数据集  第二个值是 数据总数
    public Object[] queryPage(String dataTable,String orderBy,int pageIndex,int pageSize,int channelId,int sortId){
        Object[] objects = new Object[2];
        //这个不会是.net里面的语句吧
        //String sql = "SELECT (@i:=@i+1) AS row_id,tab.* FROM ("+ dataTable + ") AS TAB,(SELECT @i:=0) AS it " +
               // "ORDER BY "+ orderBy + "LIMIT"+ (pageIndex - 1)+","+pageSize;
        String sql = "SELECT * FROM "+ dataTable + " WHERE Wt_channelId="+ channelId + " AND Wt_sortId=" + sortId + " ORDER BY "
                + orderBy + " LIMIT "+ (pageIndex - 1)+","+pageSize;
        List<Map<String,Object>>list = query(sql,null);
        int count = dataCount(dataTable,channelId,sortId);
        objects[0] = list;
        objects[1] = count;
        return objects;
    }
}