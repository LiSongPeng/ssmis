<%--
  Created by IntelliJ IDEA.
  User: lihuibo
  Date: 5/18/17
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<%=basePath%>/res/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link rel="stylesheet" href="<%=basePath%>/res/css/jquery-ui.min.css"/>
    <style>
        #testCenterTabs li .ui-icon-close {
            float: left;
            margin: 0.4em 0.2em 0 0;
            cursor: pointer;
        }

        .collection-item {
            cursor: pointer;
        }

        .tabBody {
            display: none;
            line-height: 100%;
            text-align: center;
        }

        .loadingImg {
            position: relative;
            margin: 0 auto;
            height: 200px;
            width: 200px;
        }

        .refreshImg {
            margin: 0 auto;
            width: 80px;
            height: 80px;
        }
    </style>
</head>
<body title="<%=basePath%>">
<div class="row">
    <div class="col s2">
        <ul class="collapsible" data-collapsible="accordion">
            <li>
                <div class="collapsible-header"><i class="material-icons">filter_drama</i>考试信息</div>
                <div class="collapsible-body">
                    <div class="collection">
                        <a disabled="disabled" class="collection-item" id="testPlan">考试安排</a>
                        <a class="collection-item" id="testScore">考试成绩</a>
                    </div>
                </div>
            </li>
            <li>
                <div class="collapsible-header"><i class="material-icons">place</i>申诉信息</div>
                <div class="collapsible-body">
                    <div class="collection">
                        <a class="collection-item" id="progressAppeal">审核中申诉</a>
                        <a class="collection-item" id="responsedAppeal">已回执申诉</a>
                        <a class="collection-item" id="closedAppeal">已关闭申诉</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div class="col s10">
        <div id="testCenterTabs">
            <ul>
                <li><a href="#testCenterWelcome">欢迎</a></li>
            </ul>
            <div id="testCenterWelcome" style="line-height: 100%;text-align:center;font-size: 36px;height:600px">
                欢迎来到考试中心！
            </div>
            <div id="testPlanTabBody" class="tabBody"></div>
            <div id="testScoreTabBody" class="tabBody"></div>
            <div id="progressAppealTabBody" class="tabBody"></div>
            <div id="responsedAppealTabBody" class="tabBody"></div>
            <div id="closedAppealTabBody" class="tabBody"></div>
        </div>
    </div>
</div>
</body>
<script src="<%=basePath%>/res/js/jquery-3.0.0.min.js"></script>
<script src="<%=basePath%>/res/js/materialize.min.js"></script>
<script src="<%=basePath%>/res/js/jquery-ui.min.js"></script>
<script src="<%=basePath%>/res/js/testCenter.js"></script>
</html>

