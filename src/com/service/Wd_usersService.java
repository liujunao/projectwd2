package com.service;

import com.dao.Wd_usersDAO;
import com.models.Wd_users;

/**
 * Created by lenovo on 2017/7/7.
 */
public class Wd_usersService {

    Wd_usersDAO wd_usersDAO = new Wd_usersDAO();
    public int userLogin(Wd_users wd_users){
        int result = 0;
        result = wd_usersDAO.userLogin(wd_users);
        return result;
    }
    public int userRegister(Wd_users wd_users){
        int result = -1;
        result = wd_usersDAO.userRegister(wd_users);
        return result;
    }
}
