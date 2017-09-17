package com.handler.minor;

import com.models.Wd_info;
import com.service.Wd_infoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/9.
 */
@WebServlet(name = "ViewArticleServlet",urlPatterns = "/ViewArticleServlet")
public class ViewArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String idValue = request.getParameter("id");
        int id = Integer.parseInt(idValue);

        Wd_info wd_info = new Wd_info();
        wd_info.setId(id);
        Wd_infoService wd_infoService = new Wd_infoService();
        Map<String,Object> list = wd_infoService.viewArticle(wd_info);

        String title = (String) list.get("Wt_title");
        String date = (String) list.get("Wt_time");
        String keyword = (String) list.get("Wt_keyword");
        String description = (String) list.get("Wt_description");
        String author = (String) list.get("Wt_author");
        String content = (String) list.get("Wt_content");

        request.getSession().setAttribute("pid",id);
        request.getSession().setAttribute("title",title);
        request.getSession().setAttribute("date",date);
        request.getSession().setAttribute("keyword",keyword);
        request.getSession().setAttribute("description",description);
        request.getSession().setAttribute("author",author);
        request.getSession().setAttribute("content",content);

        String name = request.getParameter("name");
        if (name != null && name.equalsIgnoreCase("revise")){
            response.sendRedirect("/pages/minor/reviseArticle.jsp");
        }else if (name != null && name.equalsIgnoreCase("view")){
            response.sendRedirect("/pages/minor/viewArticle.jsp");
        }else if (name != null && name.equalsIgnoreCase("delete")){
            int result = -1;
            result = wd_infoService.deleteArticle(wd_info);
            if (result > 0){
                System.out.println("删除成功！");
                response.sendRedirect("/pages/main/news.jsp");
            }else {
                System.out.println("删除失败！");
                response.sendRedirect("http://www.baidu.com");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
