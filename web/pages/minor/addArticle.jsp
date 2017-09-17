<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/8
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DouPHP 管理中心 - 添加文章 </title>
    <meta name="Copyright" content="Douco Design." />
    <link href="css/public.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/global.js"></script>
    <script type="text/javascript" src="/js/jquery.autotextarea.js"></script>

    <script charset="UTF-8" src="/ueditor/ueditor.config.js"></script>
    <script charset="UTF-8" src="/ueditor/ueditor.all.js"></script>
</head>
<body>
    <div id="dcMain">
        <form action="/EditArticleServlet" method="post" enctype="multipart/form-data">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                <tr>
                    <td width="90" align="right">文章名称</td>
                    <td>
                        <input type="text" name="editTitle" value="" size="80" class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">文章分类</td>
                    <td>
                        <select name="cat_id">
                            <option value="0">未分类</option>
                            <option value="1"> 公司动态</option>
                            <option value="2"> 行业新闻</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right" valign="top">文章内容</td>
                    <td>
                        <link rel="stylesheet" href="/css/default.css" />
                        <link rel="stylesheet" href="/css/prettify.css" />
                        <script charset="utf-8" src="/js/kindeditor.js"></script>
                        <script charset="utf-8" src="/js/kindeditor/zh_CN.js"></script>
                        <script charset="utf-8" src="/js/prettify.js"></script>
                        <textarea id="content" name="editContent" style="width:780px;height:400px;" class="textArea"></textarea>

                        <script>
                            var editor = new UE.ui.Editor();
                            editor.render("content");
                        </script>

                    </td>
                </tr>
                <tr>
                    <td align="right">关键字</td>
                    <td>
                        <input type="text" name="editKeyword" value="" size="50" class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">简单描述</td>
                    <td>
                        <input type="text" name="editDescription" value="" size="50" class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">作者</td>
                    <td>
                        <input type="text"name="editAuthor"size="50"class="inpMain"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">日期</td>
                    <td><input type="date"name="editDate"size="50"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="token" value="7e4a88fb" />
                        <input type="hidden" name="image" value="">
                        <input type="hidden" name="id" value="">
                        <input name="submit" class="btn" type="submit" value="add" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
