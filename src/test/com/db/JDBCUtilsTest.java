package com.db;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/14.
 */
public class JDBCUtilsTest {

    JDBCUtils jdbcUtils = new JDBCUtils();

    @Test
    public void dataCount() throws Exception {
        String dataTable = "wd_info";
        int channelId = 3;
        int sortId = 1;
        int count = jdbcUtils.dataCount(dataTable,channelId,sortId);

        System.out.println(count);
    }

    @Test
    public void queryPage() throws Exception {
        String dataTable = "Wd_info";
        String orderBy = "Wt_infoId";
        int pageIndex = 1;
        int pageSize = 3;
        int channelId = 3;
        int sortId = 1;
        Object [] objects = new Object[2];
        objects = jdbcUtils.queryPage(dataTable,orderBy,pageIndex,pageSize,channelId,sortId);
        List<Map<String,Object>>list = (List<Map<String, Object>>) objects[0];
        int count = (int) objects[1];
        System.out.println(list);
        System.out.println(count);
    }

}