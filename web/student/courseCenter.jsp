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
    <title>Title</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<%=basePath%>/res/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link rel="stylesheet" href="<%=basePath%>/res/css/jquery-ui.min.css"/>
    <style>
        #courseCenterTabs li .ui-icon-close {
            float: left;
            margin: 0.4em 0.2em 0 0;
            cursor: pointer;
        }

        .collection-item {
            cursor: pointer;
        }

        .tabBody {
            display: none;
        }
    </style>
</head>
<body>
<div class="row">
    <div class="col s2">
        <ul class="collapsible" data-collapsible="accordion">
            <li>
                <div class="collapsible-header"><i class="material-icons">filter_drama</i>选课系统</div>
                <div class="collapsible-body">
                    <div class="collection">
                        <a disabled="disabled" class="collection-item" id="selectable">可选课程</a>
                        <a class="collection-item" id="selected">已选课程</a>
                        <a class="collection-item" id="selectResult">选课结果</a>
                    </div>
                </div>
            </li>
            <li>
                <div class="collapsible-header"><i class="material-icons">place</i>排课查询</div>
                <div class="collapsible-body">
                    <div class="collection">
                        <a class="collection-item" id="courseSchedule">课程安排查询</a>
                    </div>
                </div>
            </li>
            <li>
                <div class="collapsible-header"><i class="material-icons">whatshot</i>个人课程查询</div>
                <div class="collapsible-body">
                    <div class="collection">
                        <a class="collection-item" id="personalCourseTable">个人课表</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div class="col s10">
        <div id="courseCenterTabs">
            <ul>
                <li><a href="#welcome">欢迎</a> <%--<span class="ui-icon ui-icon-close" role="presentation"></span>--%>
                </li>
            </ul>
            <div id="welcome" style="line-height: 100%;text-align:center;font-size: 36px;">
                欢迎来到课程中心！
            </div>
            <div id="selectableTabBody" class="tabBody">selectableTabBody</div>
            <div id="selectedTabBody" class="tabBody">selectedTabBody</div>
            <div id="selectResultTabBody" class="tabBody">selectResultTabBody</div>
            <div id="courseScheduleTabBody" class="tabBody">courseScheduleTabBody</div>
            <div id="personalCourseTableTabBody" class="tabBody">personalCourseTableTabBody</div>
        </div>
    </div>
</div>
</body>
<script src="<%=basePath%>/res/js/jquery-3.0.0.min.js"></script>
<script src="<%=basePath%>/res/js/materialize.min.js"></script>
<script src="<%=basePath%>/res/js/jquery-ui.min.js"></script>
<script src="<%=basePath%>/res/js/courseCenter.js"></script>
</html>
