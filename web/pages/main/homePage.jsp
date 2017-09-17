<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/13
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>深圳市上城物业管理有限公司</title>
    <meta name="Keywords" content="深圳市，上城物业，物业管理">
    <meta name="Description" content="深圳市上城物业管理有限公司成立于1993年11月，为深圳市上步实业股份有限公司全资子公司。多年以来，公司全体员工以优质服务开创了一条具有上城特色的管理模式。正朝着“培养一流人才，创造优质服务，塑造知名品牌，争当行业先锋”的发展目标大踏步前进。">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
    <script src="/js/nav.js" language="JavaScript" type="text/javascript"></script>
</head>
<body>
<%@ include file="/pages/commons/common_1.jsp"%>
    <script language="JavaScript">
        function killErrors() {
            return true;
        }
        window.onerror = killErrors;
    </script>
    <div class="banner">
        <script type="text/javascript" language="javascript">
            var imgUrl = new Array();
            var imgtext = new Array();
            var imgLink = new Array();
            imgLink[1] = "#";imgUrl[1] = "upImg/20140521060947.jpg";
            imgLink[2] = "/contact.php";imgUrl[2] = "upImg/20140626015329.jpg";
            imgLink[3] = "/classic.php";imgUrl[3] = "upImg/20140626015023.jpg";
            imgLink[4] = "/about.php";imgUrl[4] = "upImg/20140626014753.jpg";
            var pics=imgUrl[1];
            var links=imgLink[1];
            var texts=imgtext[1];
            for(var i=2;i<imgUrl.length;i++){
                pics+='|'+imgUrl[i];
                links+='|'+imgLink[i];
            }
            var swf_width=980
            var swf_height=243
            document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ swf_width +'" height="'+ swf_height +'">');
            document.write('<param name="movie" value="swf/flash.swf"><param name="quality" value="high">');
            document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
            document.write('<param name="FlashVars" value="bcastr_file='+pics+'&bcastr_link='+links+'&bcastr_title='+texts+'">');
            document.write('<embed src="swf/flash.swf" wmode="opaque" FlashVars="bcastr_file='+pics+'&bcastr_link='+links+'&bcastr_title='+texts+'& menu="false" quality="high" width="'+ swf_width +'" height="'+ swf_height +'" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');
            document.write('</object>');
        </script>
        <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="980" height="243">
        <param name="movie" value="swf/flash.swf">
        <param name="quality" value="high">
        <param name="menu" value="false"><param name="wmode" value="opaque">
        <param name="FlashVars" value="bcastr_file=upImg/20140521060947.jpg|upImg/20140626015329.jpg|upImg/20140626015023.jpg|upImg/20140626014753.jpg&amp;bcastr_link=#|/contact.php|/classic.php|/about.php&amp;bcastr_title=undefined">
        <embed src="swf/flash.swf" wmode="opaque" flashvars="bcastr_file=upImg/20140521060947.jpg|upImg/20140626015329.jpg|upImg/20140626015023.jpg|upImg/20140626014753.jpg&amp;bcastr_link=#|/contact.php|/classic.php|/about.php&amp;bcastr_title=undefined&amp; menu=" + false="" + quality="high" width="980" height="243" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
    </object>
    </div>
    <div class="main">
        <div class="main_left">
            <div class="main_left_1">
                <div class="left_img"><img src="/img/left_img.jpg" width="10" height="470"></div>
                <div class="main_head_top"><a href="/sortServlet?channelId=2&sortId=1">公司简介</a><em>About	US</em></div>
                <div class="xh"><img src="/img/xh_1.jpg" width="269" height="2"></div>
                <p>
                    深圳市上城物业管理有限公司成立于1993年11月，为深圳市上步实业股份有限公司全资子公司。多年以来，公司全体员工以优质服务开创了一条具有上城特色的管理模式。正朝着“培养一流人才，创造优质服务，塑造知名品牌，争当行业先锋”的发展目标大踏步前进。
                </p>
            </div>
            <div class="main_left_2">
                <div class="main_head_top">经典项目<em>Classic	Project</em></div>
                <div class="proj_img">
                    <a href="http://www.sz-scwy.com/classic.php"><img src="/img/20140521061048.jpg" width="262" height="180"></a>
                </div>
                <select name="pageselect" onchange="self.location.href=options[selectedIndex].value">
                    <option value="">&lt;更多经典项目 </option>
                    <option value="/sortServlet?channelId=5&sortId=1">上步大厦</option>
                    <option value="/sortServlet?channelId=5&sortId=2">鹏丽大厦</option>
                    <option value="/sortServlet?channelId=5&sortId=3">御景华城</option>
                </select>
            </div>
            <div class="ge"></div>
        </div>
        <div class="main_cenner">
            <div class="main_cenner_1">
                <div class="left_img"><img src="/img/left_img.jpg" width="10" height="470"></div>
                <div class="main_head_top"><a href="/sortServlet?channelId=3&sortId=2">More&gt;</a>公司新闻<em>Company	news</em></div>
                <div class="xh"><img src="/img/xh_2.jpg" width="365" height="2"></div>
                <ul>
                    <li><em>	2017-04-12</em><a href="http://www.sz-scwy.com/viewnews.php?id=43"><b>&lt; 	上城物业成功举办机电岗位技能竞赛</b></a></li>
                    <li><em>	2017-03-29</em><a href="http://www.sz-scwy.com/viewnews.php?id=41"><b>&lt; 	御景华城开展露天电影放映活动</b></a></li>
                    <li><em>	2017-03-21</em><a href="http://www.sz-scwy.com/viewnews.php?id=40"><b>&lt; 	上城物业喜获深圳市物业管理协会优秀会员</b></a></li>
                    <li><em>	2017-01-23</em><a href="http://www.sz-scwy.com/viewnews.php?id=38"><b>&lt; 	上城物业举办员工新春晚会</b></a></li>
                    <li><em>	2016-10-26</em><a href="http://www.sz-scwy.com/viewnews.php?id=36"><b>&lt; 	拾金不昧品格高</b></a></li>
                    <li><em>	2016-09-26</em><a href="http://www.sz-scwy.com/viewnews.php?id=35"><b>&lt; 	御景华城举办第十届“社区邻里节”</b></a></li>
                    <li><em>	2016-09-20</em><a href="http://www.sz-scwy.com/viewnews.php?id=34"><b>&lt; 	上步大厦管理处举行第十七届“上城物业”杯乒乓球比赛</b></a></li>
                </ul>
            </div>
            <div class="main_cenner_2">
                <div class="main_head_top"><a href="/sortServlet?channelId=3&sortId=1">More&gt;</a>行业新闻<em>Industry news</em></div>
                <div class="xh"><img src="/img/xh_2.jpg" width="365" height="2"></div>
                <ul>
                    <li><em>	2017-06-16</em><a href="http://www.sz-scwy.com/viewnews.php?id=49"><b>&lt; 	广东省安全生产监督管理局关于印发《广东省安全生产监督管理局关于〈生产安全事故应急预案管理办法〉的实施细则》的通知粤安监应急〔2017〕9号</b></a></li>
                    <li><em>	2017-05-11</em><a href="http://www.sz-scwy.com/viewnews.php?id=45"><b>&lt; 	深圳市人力资源和社会保障局关于明确深圳市重特大疾病补充医疗保险待遇有关事项的通知</b></a></li>
                    <li><em>	2017-05-11</em><a href="http://www.sz-scwy.com/viewnews.php?id=46"><b>&lt; 	深圳市人力资源和社会保障局关于明确深圳市重特大疾病补充医疗保险待遇有关事项的通知</b></a></li>
                    <li><em>	2017-05-11</em><a href="http://www.sz-scwy.com/viewnews.php?id=47"><b>&lt; 	深圳市重特大疾病补充医疗保险试行办法</b></a></li>
                </ul>
            </div>
            <div class="ge"></div>
        </div>
        <div class="main_right">
            <div class="main_right_1">
                <div class="main_head_top">信息中心<em>Business	Resources</em></div>
                <div class="xh"><img src="/img/xh_3.jpg" width="257" height="2"></div>
                <ul>
                    <li><a href="/sortServlet?channelId=6&sortId=1"><em>	2014-08-04</em><b>&lt; 	安管员招聘</b></a></li>
                </ul>
                <p>	<a href="/sortServlet?channelId=7&sortId=1"><img src="/img/20140521062130.jpg" width="253" height="68"></a></p>
                <p>	<a href="/sortServlet?channelId=8&sortId=1"><img src="/img/20140521062257.jpg" width="253" height="68"></a></p>
            </div>
            <style>
                .abo_img{ padding:0px 45px;}
            </style>
            <div class="main_right_2">
                <div class="main_right_img"><img src="/img/img4.jpg" width="74" height="92"></div>
                <div class="main_right_cen">
                    <h1><a href="/sortServlet?channelId=1&sortId=2">上城物业内刊</a></h1>
                    <p>Shang	Cheng<br>Property	Report</p>
                    <div class="ge"></div>
                </div>
                <a href="http://www.sz-scwy.com/property.php" class="abo_img"><img src="/img/botton.jpg"></a>
                <select onchange="window.open(this.options[this.selectedIndex].value)" name="select">
                    <option value="/sortServlet?channelId=1&sortId=2">&lt;友情链接相关信息 </option>
                </select>
            </div>
        </div>
        <div class="ge"></div>
    </div>
</div>
<%@ include file="/pages/commons/common_2.jsp"%>
</body></html>
