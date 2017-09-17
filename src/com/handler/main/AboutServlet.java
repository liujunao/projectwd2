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
@WebServlet(name = "AboutServlet",urlPatterns = "/aboutServlet")
public class AboutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        int channelId = Integer.parseInt(request.getParameter("channelId"));
        int sortId = Integer.parseInt(request.getParameter("sortId"));

        String about1 = null;
        String about2 = null;
        String about3 = null;
        if (channelId == 2){
            about2 = "About us";
            about3 = "关于我们";
            if (sortId == 1){
                about1 = "About Us";
            }else if (sortId == 2){
                about1 = "Structure";
            }else if (sortId == 3){
                about1 = "Management System";
            }else if (sortId == 4){
                about1 = "Enterprise Qualification";
            }else if (sortId == 5){
                about1 = "Enterprise Culture";
            }else if (sortId == 6){
                about1 = "Property Report";
            }
        }else if (channelId == 5){
            about2 = "Classic Project";
            about3 = "经典项目";
            if (sortId == 1){
                about1 = "ShangBu Building";
            }else if (sortId == 2){
                about1 = "Pengli Builing";
            }else if (sortId == 3){
                about1 = "Chines Garden City";
            }
        }
        request.setAttribute("about1",about1);
        request.setAttribute("about2",about2);
        request.setAttribute("about3",about3);

        request.getSession().setAttribute("channelId",channelId);
        request.getSession().setAttribute("sortId",sortId);

        request.getRequestDispatcher("/pages/main/about.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
