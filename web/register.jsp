<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/7
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<script>
    function isEnAndNum() {
        var regStr = /^[a-zA-Z0-9]{6-20}$/;
        var reg = new RegExp(regStr);
        var name = document.getElementsByName("username");
        var password = document.getElementsByName("password");
        if (reg.test(name) && reg.test(password)){
            return true;
        }else {
            alert("用户名或密码必须为6-20位的字母或数字！");
            window.location.href = "index.jsp";
            return false;
        }
    }
</script>
<center>
    <div>
        <h1>请注册</h1>
        <form action="RegisterServlet" method="post" onsubmit="isEnAndNum()">
            <table>
                <tr>
                    <td colspan="2"><input type="text" name="username" placeholder="用户名" style="width:200px;height: 25px;"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="password" name="password" placeholder="输入密码" style="width:200px;height:25px;"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="password" name="password2" placeholder="确认密码" style="width:200px;height:25px;"/></td>
                </tr>
                <tr>
                    <td width="108" valign="middle"><input type="text" name="validation"placeholder="验证码" style="width: 200px;height: 30px"/></td>
                </tr>
                <tr>
                    <td width="100" colspan="8" valign="middle" align="center"><img src="ValidationServlet" id="validate" border="0" onclick="this.src=this.src+'?'"></td>
                </tr>
                <tr><td colspan="3" align="center"><input type="submit" value="注册" style="width:130px;height:30px;background-color: blue;color: white"/></td></tr>
            </table>
        </form>
        <font color="red" size="2"> ${msg }</font>
    </div>
</center>

</body>
</html>
