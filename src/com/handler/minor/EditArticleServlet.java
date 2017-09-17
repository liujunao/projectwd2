package com.handler.minor;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.models.Wd_info;
import com.service.Wd_infoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/7/8.
 */
@WebServlet(name = "EditArticleServlet" , urlPatterns = "/EditArticleServlet")
public class EditArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(getServletConfig(),request,response);

        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        String title = smartUpload.getRequest().getParameter("editTitle");
        String date = smartUpload.getRequest().getParameter("editDate");
        String content = smartUpload.getRequest().getParameter("editContent");
        String keyword = smartUpload.getRequest().getParameter("editKeyword");
        String author = smartUpload.getRequest().getParameter("editAuthor");
        String description = smartUpload.getRequest().getParameter("editDescription");
        String buttonName = smartUpload.getRequest().getParameter("submit");

        int channelId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("channelId") != null ? request.getSession().getAttribute("channelId") : "1"));
        int sortId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("sortId") != null ? request.getSession().getAttribute("sortId") : "1"));

        int id = Integer.parseInt(String.valueOf( request.getSession().getAttribute("pid") != null ?  request.getSession().getAttribute("pid") : "1"));

        Wd_info wd_info = new Wd_info();
        wd_info.setId(id);
        wd_info.setAuthor(author);
        wd_info.setContent(content);
        wd_info.setDate(date);
        wd_info.setDescription(description);
        wd_info.setKeyword(keyword);
        wd_info.setTitle(title);
        wd_info.setChannelId(channelId);
        wd_info.setSortId(sortId);

        Wd_infoService wd_usersService = new Wd_infoService();
        int result = -1;
        if (buttonName != null && buttonName.equalsIgnoreCase("add")){
            result = wd_usersService.addArticle(wd_info);
            if (result > 0){
                response.sendRedirect("/pages/minor/Success.jsp");
                request.getSession().setAttribute("success","文章添加成功！");
            }else {
                response.sendRedirect("/pages/minor/fail.jsp");
                request.getSession().setAttribute("fail","文章添加失败！");
            }
        }else if (buttonName != null && buttonName.equalsIgnoreCase("revise")){
            result = wd_usersService.reviseArticle(wd_info);
            if (result > 0){
                response.sendRedirect("/pages/minor/Success.jsp");
                request.getSession().setAttribute("success","文章修改成功！");
            }else {
                response.sendRedirect("/pages/minor/fail.jsp");
                request.getSession().setAttribute("fail","文章修改失败！");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}