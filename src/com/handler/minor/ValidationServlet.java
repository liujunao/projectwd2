package com.handler.minor;

import com.commons.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by lenovo on 2017/7/7.
 */
@WebServlet(name = "ValidationServlet",urlPatterns = "/ValidationServlet")
public class ValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Validation validation = new Validation();
        BufferedImage bufferedImage = validation.getImage(100,30);//设置验证图片的大小
        request.getSession().setAttribute("sessionValidation",validation.getText());;
        Validation.output(bufferedImage,response.getOutputStream());;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
