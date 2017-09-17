package com.handler.minor;

import com.dao.Wd_infoDAO;
import com.db.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/12.
 */
@WebServlet(name = "PageServlet",urlPatterns = "/pageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Wd_infoDAO wd_infoDAO = new Wd_infoDAO();
        int pageNumber = 1;
        int pageSize = 2;
        int totalPage = 1;
        int pageIndex = 1;

        String value = request.getParameter("pageNumber");
        if (value != null && !value.equals("") && !value.equals("null")){
            pageNumber = Integer.parseInt(value);
        }else {
            pageNumber = 1;
        }
        String dataTable = "Wd_info";
        String orderBy = "Wt_infoId";
        pageIndex = (pageNumber - 1)*pageSize;
        JDBCUtils jdbcUtils = new JDBCUtils();
        Object[] objects = new Object[2];
        int channelId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("channelId") != null ? request.getSession().getAttribute("channelId") : 1));
        int sortId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("sortId") != null ? request.getSession().getAttribute("sortId") : 1));
        objects = jdbcUtils.queryPage(dataTable,orderBy,pageIndex,pageSize,channelId,sortId);
        int totalRecord = (int) objects[1];
        totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord /pageSize + 1;
        List<Map<String,Object>>list = (List<Map<String, Object>>) objects[0];
        request.setAttribute("pageNumber",pageNumber);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("list",list);

        request.getRequestDispatcher("/pages/main/news.jsp?pageNumber="+pageNumber).forward(request,response);
    }
}
