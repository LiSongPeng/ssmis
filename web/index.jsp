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
    <script defer src="res/js/jquery-3.0.0.min.js"></script>

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
            <a href="student/login.jsp" class="mdl-layout__tab">学生</a>
            <a href="#fixed-tab-2" class="mdl-layout__tab is-active">教师</a>
            <a href="#fixed-tab-3" class="mdl-layout__tab">管理员</a>
        </div>
    </header>
    <main class="mdl-layout__content">
        <section class="mdl-layout__tab-panel is-active" id="fixed-tab-2">
            <div class="page-content">
                <form action="#" style="margin-left: auto;margin-right: auto;width: 300px">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="tch_id">
                        <label class="mdl-textfield__label" for="tch_id">教工号...</label>
                        <span class="mdl-textfield__error">Input is not a number!</span>
                    </div>
                    <br>
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="password" id="tch_pw">
                        <label class="mdl-textfield__label" for="tch_pw">密码...</label>
                    </div>
                    <br>

                    <div>
                        <button id="tch_sbm" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="float: left">
                            登陆
                        </button>
                        <button class="mdl-button mdl-js-button mdl-button--accent">
                            忘记密码
                        </button>
                        <div style="float: right">
                            <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="tch_rm">
                                <input type="checkbox" id="tch_rm" class="mdl-switch__input">
                                <span class="mdl-switch__label"></span>
                            </label>
                            保持登陆
                        </div>
                    </div>

                </form>
            </div>
        </section>
        <section class="mdl-layout__tab-panel" id="fixed-tab-3">
            <div class="page-content">
                <form action="#" style="margin-left: auto;margin-right: auto;width: 300px">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?" id="adm">
                        <label class="mdl-textfield__label" for="adm">管理员账号...</label>
                        <span class="mdl-textfield__error">Input is not a number!</span>
                    </div>
                    <br>
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="password" id="adm_pw">
                        <label class="mdl-textfield__label" for="adm_pw">密码...</label>
                    </div>
                    <br>
                    <div>
                        <button id="adm_sbm" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="float:left">
                            登陆
                        </button>
                        <button class="mdl-button mdl-js-button mdl-button--accent">
                            忘记密码
                        </button>
                        <div style="float:right">
                            <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="adm_rm">
                                <input type="checkbox" id="adm_rm" class="mdl-switch__input">
                                <span class="mdl-switch__label"></span>
                            </label>
                            保持登陆
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </main>
</div>
<script>
    $(function () {
        $("#tch_sbm").click(function () {|
            if($("#tch_id").val()==""||$("#tch_pw").val()==""){

            }
        })

    })
</script>
</body>
</html>
