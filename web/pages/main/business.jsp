<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/15
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>安管员招聘</title>
    <meta name="Keywords" content="">
    <meta name="Description" content="常年招聘安管员">
</head>
<body>
<%@include file="/pages/commons/common_1.jsp"%>
    <script language="JavaScript">
        function killErrors() {
            return true;
        }
        window.onerror = killErrors;
    </script>
    <div class="banner">
        <a href=""><img src="/img/20140529093029.jpg" width="980" height="220"></a>
    </div>
    <div class="ny_main">
        <div class="ny_main_left">
            <h1><span>Business Resources</span>信息中心</h1>
            <ul>
                <li><a href="/businessServlet?channelId=6&sortId=1">招聘信息</a></li>
                <li><a href="/businessServlet?channelId=6&sortId=2">租赁信息</a></li>
            </ul>
            <div class="ge"></div>
        </div>
        <div class="ny_main_right">
            <div class="ny_main_head_top"></div>
            <div class="ny_main_head">招聘信息<em>Recruitment Information</em></div>
            <div class="ny_cenner">
                <div class="pd_nc_zw">
                    <table style="WIDTH: 90%" border="1" cellspacing="0" bordercolor="#cccccc" cellpadding="2" align="center">
                        <tbody>
                        <tr>
                            <td><span style="COLOR: #337fe5">&nbsp;</span><span style="COLOR: #337fe5">招聘说明：</span><br>人才热线：0755—83996156
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                招聘邮箱：<a href="mailto:sz_scwy@sina.com">sz_scwy@sina.com</a>
                            </td></tr></tbody></table>
                    <table style="WIDTH: 90%" border="1" cellspacing="0" bordercolor="#cccccc" cellpadding="2" align="center">
                        <tbody>
                        <tr>
                            <td bgcolor="#999999">&nbsp;招聘职位：<span class="STYLE1"><a href="http://www.sz-scwy.com/business-show.php?id=20" target="_blank">安管员招聘</a></span></td>
                            <td bgcolor="#999999">&nbsp;招聘人数：<span class="STYLE1">不限</span></td>
                            <td bgcolor="#999999">&nbsp;<a href="http://www.sz-scwy.com/job.php?id=20" target="_blank">在线投放简历</a> </td></tr>
                        <tr>
                            <td colspan="3">&nbsp;&nbsp;
                                <p style="text-align:left;margin-left:0.05pt;" class="MsoNormal" align="left">
                                    <span style="font-family:宋体;color:black;font-size:12pt;"></span>&nbsp;
                                </p>
                                <%@ include file="/pages/commons/common_2.jsp"%>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
