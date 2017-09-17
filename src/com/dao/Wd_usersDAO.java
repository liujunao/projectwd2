package com.dao;

import com.db.JDBCUtils;
import com.models.Wd_users;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/7.
 */
public class Wd_usersDAO {
    JDBCUtils jdbcUtils = new JDBCUtils();

    public int userLogin(Wd_users wd_users){
        int result = 0;
        String sql = "SELECT * FROM wd_users WHERE wt_userName = ? AND wt_userPwd = ?";
        Object[] objects = new Object[2];
        objects[0] = wd_users.getWt_userName();
        objects[1] = wd_users.getWt_userPwd();
        List<Map<String,Object>>list = jdbcUtils.query(sql,objects);
        result = list.size();
        return result;
    }

    public int userRegister(Wd_users wd_users){
        int result = -1;
        String sql = "INSERT INTO wd_users VALUES(?,?,?)";
        Object[] objects = new Object[3];
        //objects[0] = wd_users.getWt_userId();
        objects[1] = wd_users.getWt_userName();
        objects[2] = wd_users.getWt_userPwd();
        result = jdbcUtils.update(sql,objects);
        return result;
    }
}
