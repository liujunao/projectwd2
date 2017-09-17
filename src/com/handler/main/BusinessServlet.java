package com.handler.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/7/14.
 */
@WebServlet(name = "BusinessServlet",urlPatterns = "/businessServlet")
public class BusinessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        int channelId = Integer.parseInt(request.getParameter("channelId"));
        int sortId = Integer.parseInt(request.getParameter("sortId"));

        request.getRequestDispatcher("/pages/main/business.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
