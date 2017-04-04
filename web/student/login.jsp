<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <title>登录页面</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<%=basePath%>/res/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body title="<%=basePath%>">
<div class="row light-blue">
    <div class="col s2 white-text"><h4>学生用户登录</h4></div>
    <div class="col s2 offset-s6">
        <div style="height: 20px;"></div>
        <button class="btn waves-effect waves-light pink" type="submit">联系我们
        </button>
    </div>
    <div class="col s2">
        <div style="height: 20px;"></div>
        <button class="btn waves-effect waves-light pink" type="submit">网站信息
        </button>
    </div>
</div>
<div class="row container">
    <div class="col s3"></div>
    <form class="col s9" action="" method="get">
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">account_circle</i>
                <input id="stu_id" name="stu.stu_id" type="text" class="validate" length="16">
                <label for="stu_id">学号</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s9">
                <i class="material-icons prefix">lock</i>
                <input id="password" type="password" class="validate" name="stu.password" length="16">
                <label for="password">密码</label>
            </div>
        </div>
        <div class="row">
            <div class="col s6">
                <button class="btn waves-effect waves-light" type="submit">登陆
                    <i class="material-icons right">send</i>
                </button>
            </div>
            <div class="col s6">
                <button class="btn waves-effect waves-light" type="reset">重置
                    <i class="material-icons right">contacts</i>
                </button>
            </div>
        </div>
    </form>
</div>
<div id="loginModal" class="modal">
    <div class="modal-content">
        <div style="text-align: center;">
            <div class="preloader-wrapper big active">
                <div class="spinner-layer spinner-blue-only">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
            </div>
            <div id="loginMessage" style="text-align: center;"></div>
        </div>
    </div>
</div>
</body>
<script src="<%=basePath%>/res/js/jquery-3.0.0.min.js"></script>
<script src="<%=basePath%>/res/js/materialize.min.js"></script>
<script src="<%=basePath%>/res/js/login.js"></script>
</html>
