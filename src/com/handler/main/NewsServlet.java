package com.handler.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/7/13.
 */
@WebServlet(name = "NewsServlet", urlPatterns = "/newsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String channelId = request.getParameter("channelId");
        String sortId = request.getParameter("sortId");
        int channelIdNumber = Integer.parseInt(String.valueOf(channelId) != null ? channelId : "1");
        int sortIdNumber = Integer.parseInt(String.valueOf(sortId) != null ? sortId : "1");
        if (channelIdNumber == 3){
            request.setAttribute("common1","行业新闻");
            request.setAttribute("common2","新闻中心");
            request.setAttribute("common3","News");
            if (sortIdNumber == 1){
                request.setAttribute("common4","News");
                request.setAttribute("common5","行业新闻");
            }else if (sortIdNumber == 2){
                request.setAttribute("common4","Company news");
                request.setAttribute("common5","公司动态");
            }else if (sortIdNumber == 3){
                request.setAttribute("common4","News");
                request.setAttribute("common5","业主公告");
            }
        }else if (channelIdNumber == 4){
            request.setAttribute("common1","法律法规");
            request.setAttribute("common2","法律法规");
            request.setAttribute("common3","Law");
            if (sortIdNumber == 1){
                request.setAttribute("common4","Business Model");
                request.setAttribute("common5","法律法规");
            }
        }
        request.getSession().setAttribute("channelId",channelId);
        request.getSession().setAttribute("sortId",sortId);

        request.getRequestDispatcher("/pages/main/news.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
