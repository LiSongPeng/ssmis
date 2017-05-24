<%--
  Created by IntelliJ IDEA.
  User: lihuibo
  Date: 2017-03-23
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <title>首页</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<%=basePath%>/res/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <style type="text/css">
        body {
            background-color: #F5F5F5;
        }
    </style>
</head>
<body title="<%=basePath%>">
<%--侧边栏--%>
<ul id="slide-out" class="side-nav">
    <li>
        <div class="userView">
            <div class="background">
                <img src="<%=basePath%>/res/img/personalInfoBG.jpg">
            </div>
            <a><img class="circle" src="<%=basePath%>/<s:property value='#session.currStu.photoUri'/>"></a>
            <a><span class="white-text name"><s:property value="#session.currStu.name"/> </span></a>
            <a><span class="white-text email"><s:property value="#session.currStu.email"/> </span></a>
        </div>
    </li>
    <li><a class="waves-effect">手机号:<s:property value="#session.currStu.phone"/> </a></li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a class="waves-effect">年级:<s:property value="#session.currStu.grade"/>级</a></li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a class="waves-effect">班级:<s:property value="#session.currStu.classNo"/>班</a></li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a class="waves-effect btn" href="myInfo.jsp">修改个人信息</a></li>
</ul>
<%--导航栏--%>
<nav class="nav-extended purple">
    <div class="nav-wrapper">
        <ul class="left">
            <li id="date-section"></li>
            <li>&nbsp;&nbsp;欢迎您！<s:property value="#session.currStu.name"/>同学</li>
        </ul>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a data-activates="slide-out" id="personalInfo">个人信息</a></li>
            <li><a id="courseCenterBtn">课程中心</a></li>
            <li><a id="testCenterBtn">考试中心</a></li>
        </ul>
    </div>
    <div class="nav-content">
        <ul class="tabs tabs-transparent">
            <li class="tab"><a href="#courseCenter" class="active">课程中心</a></li>
            <li class="tab"><a href="#testCenter">考试中心</a></li>
        </ul>
    </div>
</nav>
<div id="courseCenter" class="col s12">
    <iframe src="<%=basePath%>/student/courseCenter.jsp" frameborder="0" scrolling="no" width="100%"
            height="100%"></iframe>
</div>
<div id="testCenter" class="col s12">
    <iframe src="<%=basePath%>/student/testCenter.jsp" frameborder="0" scrolling="no" width="100%"
            height="100%"></iframe>
</div>
</body>
<script src="<%=basePath%>/res/js/jquery-3.0.0.min.js"></script>
<script src="<%=basePath%>/res/js/materialize.min.js"></script>
<script src="<%=basePath%>/res/js/studentIndex.js"></script>
</html>
