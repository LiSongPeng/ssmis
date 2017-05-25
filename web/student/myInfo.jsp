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
<body title="<%=basePath%>">
<div style="height: 100px">
</div>
<div class="row">
    <div class="col s10 offset-s1 white">
        <div class="row">
            <div class="col s2">
                <img src="<%=basePath%>/<s:property value="#session.currStu.stuId"/>.jpg" id="photoImg" class="circle"
                     width="64" height="64">
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">account_circle</i>
                <input id="stuId" type="text" length="10" disabled="disabled"
                       value="<s:property value="#session.currStu.stuId"/>">
                <label for="name">学号</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">account_circle</i>
                <input id="name" type="text" length="10" disabled="disabled"
                       value="<s:property value="#session.currStu.name"/>">
                <label for="name">姓名</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">lock</i>
                <input id="password" type="text" length="14" disabled="disabled"
                       value="<s:property value="#session.currStu.password"/>">
                <label for="password">密码</label>
            </div>
            <div class="col s3">
                <a class="waves-effect waves-light btn" id="Changepassword">更改</a>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="email" type="email" disabled="disabled"
                       value="<s:property value="#session.currStu.email"/>">
                <label for="email">邮箱</label>
            </div>
            <div class="col s3">
                <a class="waves-effect waves-light btn" id="Changeemail">更改</a>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="address" type="text" disabled="disabled"
                       value="<s:property value="#session.currStu.address"/>">
                <label for="address">地址</label>
            </div>
            <div class="col s3">
                <a class="waves-effect waves-light btn" id="Changeaddress">更改</a>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="phone" type="text" disabled="disabled"
                       value="<s:property value="#session.currStu.phone"/>" maxlength="11">
                <label for="phone">手机</label>
            </div>
            <div class="col s3">
                <a class="waves-effect waves-light btn" id="Changephone">更改</a>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="birthday" type="text" disabled="disabled"
                       value="<s:date name='#session.currStu.birthday' format='MM/dd/YYYY'/>">
                <label for="birthday">出生日期</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="gender" type="text" disabled="disabled"
                       value="<s:property value="#session.currStu.gender"/>">
                <label for="gender">性别</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="grade" type="text" disabled="disabled"
                       value="<s:property value="#session.currStu.grade"/>">
                <label for="grade">年级</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="classNo" type="text" disabled="disabled"
                       value="<s:property value="#session.currStu.classNo"/>">
                <label for="classNo">班级</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">email</i>
                <input id="stuStatus" type="text" disabled="disabled"
                       value="<s:property value="#session.currStu.stuStatus"/>">
                <label for="stuStatus">学生状态</label>
            </div>
        </div>
    </div>
</div>
</body>
<script src="<%=basePath%>/res/js/jquery-3.0.0.min.js"></script>
<script src="<%=basePath%>/res/js/materialize.min.js"></script>
<script src="<%=basePath%>/res/js/myInfo.js"></script>
</html>
