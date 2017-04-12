<%--
  Created by IntelliJ IDEA.
  User: tose
  Date: 2017/4/12
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="res/jiangtao/lib/mdl/material.indigo-pink.min.css">
    <link rel="stylesheet" href="res/jiangtao/lib/mdl/icon.css">
    <script defer src="res/jiangtao/lib/mdl/material.min.js"></script>

</head>
<body>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header
            mdl-layout--fixed-tabs">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">学生成绩信息管理系统</span>
        </div>
        <!-- Tabs -->
        <div class="mdl-layout__tab-bar mdl-js-ripple-effect">
            <a href="#fixed-tab-1" class="mdl-layout__tab is-active">学生</a>
            <a href="#fixed-tab-2" class="mdl-layout__tab">教师</a>
            <a href="#fixed-tab-3" class="mdl-layout__tab">管理员</a>
        </div>
    </header>
    <main class="mdl-layout__content">
        <section class="mdl-layout__tab-panel is-active" id="fixed-tab-1">
            <div class="page-content">
                <!-- Your content goes here -->
                Students content
            </div>
        </section>
        <section class="mdl-layout__tab-panel" id="fixed-tab-2">
            <div class="page-content">
                <!-- Your content goes here -->
                Teachers content
            </div>
        </section>
        <section class="mdl-layout__tab-panel" id="fixed-tab-3">
            <div class="page-content">
                <!-- Your content goes here -->
                Admin content
            </div>
        </section>
    </main>
</div>

</body>
</html>
