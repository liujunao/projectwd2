<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/13
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/css/style.css">
    <script src="/js/nav.js" language="JavaScript" type="text/javascript"></script>
</head>
<body>
<div id="body">
    <div class="top1">
        <div class="top_logo fl">
            <div class="top_logo1 fl"><img src="/img/logo_bg.png" width="174" height="40"></div>
        </div>
        <div class="nav_mbg">
            <div id="menu">
                <ul>
                    <li id="m_1" class="m_li_a"><a href="/homePage.jsp?channelId=1&sortId=1">首页</a></li>
                    <li id="m_2" onmouseover="mover(2);" onmouseout="mout(2);"><a href="/aboutServlet?channelId=2&sortId=1">了解我们</a></li>
                    <li id="m_3" onmouseover="mover(3);" onmouseout="mout(3);"><a href="/newsServlet?channelId=3&sortId=1">上城新闻</a></li>
                    <li id="m_4" onmouseover="mover(4);" onmouseout="mout(4);" class="m_li"><a href="/newsServlet?channelId=4&sortId=1">法律法规</a></li>
                    <li id="m_5" onmouseover="mover(5);" onmouseout="mout(5);"><a href="/aboutServlet?channelId=5&sortId=1">经典项目</a></li>
                    <li id="m_7" onmouseover="mover(6);" onmouseout="mout(6);"><a href="/businessServlet?channelId=6&sortId=1">信息中心</a></li>
                    <li id="m_6" onmouseover="mover(7);" onmouseout="mout(7);"><a href="/messageServlet?channelId=7&sortId=1">投诉及意见</a></li>
                    <li id="m_8" onmouseover="mover(8);" onmouseout="mout(8);"><a href="/contactServlet?channelId=8&sortId=1">联系我们</a></li>
                    <div class="ge"></div>
                </ul>
            </div>
            <ul id="smenu">
                <li style="padding-left:80px;display:none;" id="s_2" class="s_li" onmouseover="mover(2);" onmouseout="mout(2);">
                    <a href="/aboutServlet?channelId=2&sortId=1">公司简介</a>
                    <a href="/aboutServlet?channelId=2&sortId=2">组织架构</a>
                    <a href="/aboutServlet?channelId=2&sortId=3">管理体系</a>
                    <a href="/aboutServlet?channelId=2&sortId=4">公司资质</a>
                    <a href="/aboutServlet?channelId=2&sortId=5">企业文化</a>
                    <a href="/aboutServlet?channelId=2&sortId=6">《上城物业》内刊</a>
                    <a href="/aboutServlet?channelId=2&sortId=7">公司荣誉</a>
                </li>
                <li style="padding-left:166px;display:none;" id="s_3" class="s_li" onmouseover="mover(3);" onmouseout="mout(3);">
                    <a href="/newsServlet?channelId=3&sortId=1">行业新闻</a>
                    <a href="/newsServlet?channelId=3&sortId=2">公司动态</a>
                    <a href="/newsServlet?channelId=3&sortId=3">业主公告</a>
                </li>
                <li style="padding-left: 250px; display: none;" id="s_4" class="s_li" onmouseover="mover(4);" onmouseout="mout(4);">
                    <a href="/newsServlet?channelId=4&sortId=1">法律法规</a>
                </li>
                <li style="padding-left:335px;display:none;" id="s_5" class="s_li" onmouseover="mover(5);" onmouseout="mout(5);">
                    <a href="/aboutServlet?channelId=5&sortId=1">上步大厦</a>
                    <a href="/aboutServlet?channelId=5&sortId=2">鹏丽大厦</a>
                    <a href="/aboutServlet?channelId=5&sortId=3">御景华城</a>
                </li>
                <li style="padding-left:420px;display:none;" id="s_6" class="s_li" onmouseover="mover(6);" onmouseout="mout(6);">
                    <a href="/businessServlet?channelId=6&sortId=1">招聘信息</a>
                    <a href="/businessServlet?channelId=6&sortId=2">租赁信息</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
