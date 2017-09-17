package com.dao;

import com.models.Wd_info;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/12.
 */
public class Wd_infoDAOTest {

    Wd_infoDAO wd_infoDAO = new Wd_infoDAO();
    Wd_info wd_info = new Wd_info();

    @Test
    public void viewArticle() throws Exception {
    }

    @Test
    public void reviseArticle()throws Exception{
        wd_info.setId(6);
        wd_info.setKeyword("ni");
        wd_info.setAuthor("ni");
        wd_info.setDate("2002-10-01");
        wd_info.setDescription("ni");
        wd_info.setContent("ni");
        wd_info.setTitle("ni");
        int result = wd_infoDAO.reviseArticle(wd_info);

        System.out.println(result);
    }

    @Test
    public void queryData(){
        wd_info.setChannelId(2);
        wd_info.setSortId(1);
        List<Map<String,Object>>list = wd_infoDAO.queryData(wd_info);
        Map<String,Object>map = list.get(0);

        System.out.println(list);
        System.out.println(map);
    }

}