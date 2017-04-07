<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <title>我的信息</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<%=basePath%>/res/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <style type="text/css">
        body {
            background-color: #F5F5F5;
        }
    </style>
</head>
<%--<s:property value="#session.currUser.headImgUrl"/>--%>
<body>
<div style="height: 100px"></div>
<div class="row">
    <div class="col s10 offset-s1 white">
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">account_circle</i>
                <input id="name" type="text" length="10" disabled="disabled" value="<s:property value="#session.currUser.nickName"/>">
                <label for="name">昵称</label>
            </div>
        </div>
        <div class="row">
            <div class="col s2">
                <img src="<s:property value="#session.currUser.headImgUrl"/>" id="headImage" class="circle"
                     width="64" height="64">
            </div>
            <div class="file-field input-field col s7">
                <div class="btn">
                    <span>文件</span>
                    <input type="file" disabled="disabled"  id="headImg">
                </div>
                <div class="file-path-wrapper">
                    <input class="file-path validate" type="text" placeholder="上传头像">
                </div>
            </div>
            <div class="col s3">
                <a class="waves-effect waves-light btn" id="ChangeheadImg">更改</a>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">lock</i>
                <input id="password" type="text" length="14" disabled="disabled" value="<s:property value="#session.currUser.password"/>">
                <label for="password">密码</label>
            </div>
            <div class="col s3">
                <a class="waves-effect waves-light btn" id="Changepassword">更改</a>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="email" type="email" disabled="disabled" value="<s:property value="#session.currUser.email"/>">
                <label for="email">邮箱</label>
            </div>
            <div class="col s3">
                <a class="waves-effect waves-light btn" id="Changeemail">更改</a>
            </div>
        </div>
    </div>
</div>
</body>
<script src="<%=basePath%>/res/js/jquery-3.0.0.min.js"></script>
<script src="<%=basePath%>/res/js/materialize.min.js"></script>
<script src="<%=basePath%>/res/js/myInfo.js"></script>
</html>
