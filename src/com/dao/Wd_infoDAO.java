package com.dao;

import com.db.JDBCUtils;
import com.models.Wd_info;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/8.
 */
public class Wd_infoDAO {

    JDBCUtils jdbcUtils = new JDBCUtils();

    public int addArticle(Wd_info wd_info){
        int result = -1;
        String sql = "INSERT INTO wd_info(Wt_title,Wt_keyword,Wt_description,Wt_time,Wt_author,Wt_content,Wt_channelId,Wt_sortId) " +
                "VALUES(?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[8];
        objects[0] = wd_info.getTitle();
        objects[1] = wd_info.getKeyword();
        objects[2] = wd_info.getDescription();
        objects[3] = wd_info.getDate();
        objects[4] = wd_info.getAuthor();
        objects[5] = wd_info.getContent();
        objects[6] = wd_info.getChannelId();
        objects[7] = wd_info.getSortId();
        result = jdbcUtils.update(sql,objects);

        return result;
    }

    public int reviseArticle(Wd_info wd_info){
        int result = -1;
        String sql = "UPDATE wd_info SET Wt_title=?,Wt_keyword=?,Wt_description=?,Wt_time=?,Wt_author=?,Wt_content=? WHERE Wt_infoid= "
                + wd_info.getId();
        Object[] objects = new Object[6];

        objects[0] = wd_info.getTitle();
        objects[1] = wd_info.getKeyword();
        objects[2] = wd_info.getDescription();
        objects[3] = wd_info.getDate();
        objects[4] = wd_info.getAuthor();
        objects[5] = wd_info.getContent();
        result = jdbcUtils.update(sql,objects);

        return result;
    }

    public List<Map<String,Object>> viewArticle(Wd_info wd_info){
        String sql = "SELECT * FROM Wd_info WHERE Wt_infoId=?";
        Object[] objects = new Object[1];
        objects[0] = wd_info.getId();
        List<Map<String,Object>>list = jdbcUtils.query(sql,objects);

        return list;
    }

    public List<Map<String,Object>> queryData(Wd_info wd_info) {
        List<Map<String,Object>> result=null;
        String sql="select * from wd_info WHERE Wt_channelId=? AND Wt_sortId=?";
        Object[] objects = new Object[2];
        objects[0] = wd_info.getChannelId();
        objects[1] = wd_info.getSortId();
        result=jdbcUtils.query(sql,objects);
        return  result;
    }

    public int deleteArticle(Wd_info wd_info){
        int result = -1;
        String sql = "DELETE FROM Wd_info WHERE Wt_infoId=?";
        Object[] objects = new Object[1];
        objects[0] = wd_info.getId();
        result = jdbcUtils.update(sql,objects);

        return result;
    }
}
