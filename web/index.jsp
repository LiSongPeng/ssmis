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
                <!-- Numeric Textfield with Floating Label -->
                <form action="#">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="stu">
                        <label class="mdl-textfield__label" for="stu">学工号...</label>
                        <span class="mdl-textfield__error">Input is not a number!</span>
                    </div>
                </form>
            </div>
        </section>
        <section class="mdl-layout__tab-panel" id="fixed-tab-2">
            <div class="page-content">
                <!-- Your content goes here -->
                <!-- Numeric Textfield with Floating Label -->
                <form action="#">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="tch">
                        <label class="mdl-textfield__label" for="tch">学工号...</label>
                        <span class="mdl-textfield__error">Input is not a number!</span>
                    </div>
                </form>
            </div>
        </section>
        <section class="mdl-layout__tab-panel" id="fixed-tab-3">
            <div class="page-content">
                <!-- Your content goes here -->
                <!-- Numeric Textfield with Floating Label -->
                <form action="#">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="adm">
                        <label class="mdl-textfield__label" for="adm">学工号...</label>
                        <span class="mdl-textfield__error">Input is not a number!</span>
                    </div>
                </form>
            </div>
        </section>
    </main>
</div>

</body>
</html>
