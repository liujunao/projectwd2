package com.service;

import com.dao.Wd_infoDAO;
import com.models.Wd_info;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/8.
 */
public class Wd_infoService {

    Wd_infoDAO wd_infoDAO = new Wd_infoDAO();

    public int addArticle(Wd_info wd_info){
        int result = -1;
        result = wd_infoDAO.addArticle(wd_info);

        return result;
    }

    public int reviseArticle(Wd_info wd_info){
        int result = -1;
        result = wd_infoDAO.reviseArticle(wd_info);

        return result;
    }

    public Map<String,Object> viewArticle(Wd_info wd_info){
        List<Map<String,Object>> result=wd_infoDAO.viewArticle(wd_info);
        Map<String,Object> map=result.get(0);
        return  map;
    }

    public List<Map<String,Object>> queryData(Wd_info wd_info) {
        List<Map<String,Object>> result=null;
        result=wd_infoDAO.queryData(wd_info);
        return  result;
    }

    public int deleteArticle(Wd_info wd_info){
        int result = -1;
        result = wd_infoDAO.deleteArticle(wd_info);

        return result;
    }
}
