package com.handler.minor;

import com.commons.DesUtil;
import com.commons.GetDes;
import com.models.Wd_users;
import com.service.Wd_usersService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/7/7.
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String validation = request.getParameter("validation");

        Pattern pattern = Pattern.compile(".{6,20}");
        Pattern pattern1 = Pattern.compile(".*[A-Z]+");
        Pattern pattern2 = Pattern.compile(".*[a-z]+");
        Pattern pattern3 = Pattern.compile(".*\\d+");
        Matcher matcherUsername = pattern.matcher(username);
        Matcher matcherUsername1 = pattern1.matcher(username);
        Matcher matcherUsername2 = pattern2.matcher(username);
        Matcher matcherUsername3 = pattern3.matcher(username);
        Matcher matcherPassword = pattern3.matcher(password);
        Matcher matcherPassword1 = pattern3.matcher(password);
        Matcher matcherPassword2 = pattern3.matcher(password);
        Matcher matcherPassword3 = pattern3.matcher(password);

        if (username == null || username.equals("")){
            request.setAttribute("msg","用户名不能为空！<br>");
            return;
        }else if (!matcherUsername.lookingAt() || matcherUsername1.lookingAt() || matcherUsername2.lookingAt() || matcherUsername3.lookingAt()){
            response.sendRedirect("register.jsp");
            return;
        }
        if (password == null || password.equals("")){
            request.setAttribute("msg","密码不能为空！<br>");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }else if (!matcherPassword.lookingAt() || matcherPassword1.lookingAt() || matcherPassword2.lookingAt() || matcherPassword3.lookingAt()){
            response.sendRedirect("register.jsp");
            return;
        }
        if (!password2.equals(password)){
            request.setAttribute("msg","输入的密码不一致！<br>");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        String svc =(String) request.getSession().getAttribute("sessionValidation");
        if(!svc.equalsIgnoreCase(validation)){
            request.setAttribute("msg", "验证码错误！");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        Wd_users wd_users = new Wd_users();
        Wd_usersService wd_usersService = new Wd_usersService();
        wd_users.setWt_userName(username);
        GetDes getDes = new GetDes();
        String encrypt = null;
        try {
            encrypt = DesUtil.encrypt(password,getDes.GetDesKey());
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        wd_users.setWt_userPwd(encrypt);

        int result = wd_usersService.userRegister(wd_users);

        if (result > 0){
            request.setAttribute("msg","注册成功，欢迎"+ username +"登录");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            System.out.print("注册成功！");
        }else {
            response.sendRedirect("register.jsp");
            System.out.print("注册失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
