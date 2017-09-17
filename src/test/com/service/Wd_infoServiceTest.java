package com.service;

import com.models.Wd_info;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/12.
 */
public class Wd_infoServiceTest {

    Wd_infoService wd_infoService = new Wd_infoService();
    Wd_info wd_info = new Wd_info();

    @Test
    public void viewArticle() throws Exception {
        wd_info.setId(1);
        Map<String,Object>list = wd_infoService.viewArticle(wd_info);

        System.out.println();
        System.out.println();
        System.out.println(list);
    }

    @Test
    public void queryData(){
        wd_info.setChannelId(3);
        wd_info.setSortId(1);
        List<Map<String,Object>>list = wd_infoService.queryData(wd_info);
        System.out.println(list);
    }

}