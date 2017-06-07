/**
 * Created by lihuibo on 5/24/17.
 */

$(function () {
    var tabs = $('#testCenterTabs').tabs()
    var lastTab = 0
    var tabsChain = {}
    var currPage = {
        testScoreTabBody: 0,
        progressAppealTabBody: 0,
        responsedAppealTabBody: 0,
        closedAppealTabBody: 0
    }
    var timer
    var resolver = {
        testPlanTabBody: function () {
            var tabBodyId = 'testPlanTabBody'
            $.getJSON($("body").prop("title") + "/student/getExamInfo.action", function (json) {
                window.clearTimeout(timer)
                endLoading(tabBodyId)
                if (typeof json != 'string') {
                    var table = "<table><thead><tr><td>课程编号</td><td>院系编号</td><td>课程名称</td><td>院系名称</td><td>考试地点</td><td>考试时间</td><td>考试状态</td></tr></thead><tbody>"
                    currPage[tabBodyId]++
                    for (var i = 0; i < json.length; i++) {
                        table += "<tr>"
                        for (var j = 0; j < 7; j++) {
                            table += "<td>" + json[i][j] + "</td>"
                        }
                        table += "</tr>"
                    }
                    table += "</tbody></table>"
                    $("#" + tabBodyId).html(table)
                } else {
                    Materialize.toast("无数据可显示", 1000)
                }
            })
        },

        testScoreTabBody: function () {
            var tabBodyId = 'testScoreTabBody'
            $.getJSON($("body").prop("title") + "/student/getScoreInfo.action", {'pageNumber': currPage[tabBodyId] + 1}, function (json) {
                window.clearTimeout(timer)
                endLoading(tabBodyId)
                if (typeof json != 'string') {
                    var table = "<table><thead><tr><td>课程编号</td><td>院系编号</td><td>教师编号</td><td>课程名称</td><td>院系名称</td><td>教师名称</td><td>学期</td><td>得分</td><td>状态</td><td>操作</td></tr></thead><tbody>"
                    currPage[tabBodyId]++
                    for (var i = 0; i < json.length; i++) {
                        table += "<tr>"
                        for (var j = 0; j < 9; j++) {
                            table += "<td>" + json[i][j] + "</td>"
                        }
                        table += "<td><a class='waves-effect waves-light btn appeal'>申诉</a></td>"
                        table += "</tr>"
                    }
                    table += "</tbody></table>"
                    var control = "<div><a class='waves-effect waves-light btn' id='tsPrevious'>上一页</a>&nbsp;&nbsp;<a class='waves-effect waves-light btn' id='tsNext'>下一页</a></div>"
                    table += control
                    $("#" + tabBodyId).html(table)
                    $(".appeal").click(
                        function () {
                            var appealContent
                            var tr = $(this).closest("tr")
                            var tds = tr.children()
                            var score = tds[7].innerHTML
                            var examStatus = tds[8].innerHTML
                            if (examStatus != "正常") {
                                Materialize.toast("你由于" + examStatus + ",无法进行申诉", 1000)
                                return
                            }
                            if (score == '未录入') {
                                Materialize.toast("成绩尚未录入!", 1000)
                                return
                            }
                            var crsId = tds[0].innerHTML
                            var dpmId = tds[1].innerHTML
                            var tchId = tds[2].innerHTML
                            $(".background").css("display", "block")
                            $("#cancelAppeal").click(function () {
                                $("#appealContent").val("")
                                $(".background").css("display", "none")
                                $("#cancelAppeal").click(undefined)
                                $("#confirmAppeal").click(undefined)
                            })
                            $("#confirmAppeal").click(function () {
                                appealContent = $("#appealContent").val()
                                if (appealContent == "") {
                                    Materialize.toast("申诉内容不能为空", 1000)
                                    return
                                }
                                $(".background").css("display", "none")
                                $.getJSON($("body").prop("title") + "/student/appeal.action", {
                                    'csche.dpmId': dpmId,
                                    'csche.crsId': crsId,
                                    'csche.tchId': tchId,
                                    'appealContent': appealContent
                                }, function (json) {
                                    json = $.parseJSON(json)
                                    if (json.result == 'Success') {
                                        Materialize.toast("申诉成功", 1000)
                                    } else {
                                        Materialize.toast("申诉失败或您已经进行过申诉", 1000)
                                    }
                                })
                            })
                        }
                    )
                    $("#tsPrevious").click(
                        function () {
                            if (currPage[tabBodyId] > 1) {
                                currPage[tabBodyId] -= 2
                                resolver[tabBodyId]()
                            }
                        }
                    )
                    $("#tsNext").click(
                        function () {
                            resolver[tabBodyId]()
                        }
                    )
                } else {
                    Materialize.toast("无数据可显示", 1000)
                }
            })
        },

        progressAppealTabBody: function () {
            var tabBodyId = 'progressAppealTabBody'
            $.getJSON($("body").prop("title") + "/student/getProgressAppeal.action", {'pageNumber': currPage[tabBodyId] + 1}, function (json) {
                window.clearTimeout(timer)
                endLoading(tabBodyId)
                if (typeof json != 'string') {
                    var table = "<table><thead><tr><td>课程编号</td><td>院系编号</td><td>教师编号</td><td>课程名称</td><td>院系名称</td><td>申诉时间</td><td>申诉内容</td><td>申诉状态</td><td>操作</td></tr></thead><tbody>"
                    currPage[tabBodyId]++
                    for (var i = 0; i < json.length; i++) {
                        table += "<tr>"
                        for (var j = 0; j < 8; j++) {
                            table += "<td>" + json[i][j] + "</td>"
                        }
                        table += "<td><a class='waves-effect waves-light btn closeAppeal'>关闭</a></td>"
                        table += "</tr>"
                    }
                    table += "</tbody></table>"
                    var control = "<div><a class='waves-effect waves-light btn' id='paPrevious'>上一页</a>&nbsp;&nbsp;<a class='waves-effect waves-light btn' id='paNext'>下一页</a></div>"
                    table += control
                    $("#" + tabBodyId).html(table)
                    $(".closeAppeal").click(
                        function () {
                            var tr = $(this).closest("tr")
                            var tds = tr.children()
                            var crsId = tds[0].innerHTML
                            var dpmId = tds[1].innerHTML
                            var tchId = tds[2].innerHTML
                            $.getJSON($("body").prop("title") + "/student/closeAppeal.action", {
                                'csche.dpmId': dpmId,
                                'csche.crsId': crsId,
                                'csche.tchId': tchId
                            }, function (json) {
                                json = $.parseJSON(json)
                                if (json.result == 'Success') {
                                    Materialize.toast("关闭成功", 1000)
                                    $(tr).remove()
                                } else {
                                    Materialize.toast("关闭失败,请稍后重试", 1000)
                                }
                            })
                        }
                    )
                    $("#paPrevious").click(
                        function () {
                            if (currPage[tabBodyId] > 1) {
                                currPage[tabBodyId] -= 2
                                resolver[tabBodyId]()
                            }
                        }
                    )
                    $("#paNext").click(
                        function () {
                            resolver[tabBodyId]()
                        }
                    )
                } else {
                    Materialize.toast("无数据可显示", 1000)
                }
            })
        },

        responsedAppealTabBody: function () {
            var tabBodyId = 'responsedAppealTabBody'
            $.getJSON($("body").prop("title") + "/student/getResponsedAppeal.action", {'pageNumber': currPage[tabBodyId] + 1}, function (json) {
                window.clearTimeout(timer)
                endLoading(tabBodyId)
                if (typeof json != 'string') {
                    var table = "<table><thead><tr><td>课程编号</td><td>院系编号</td><td>教师编号</td><td>课程名称</td><td>院系名称</td><td>申诉时间</td><td>申诉内容</td><td>申诉状态</td><td>回执内容</td></tr></thead><tbody>"
                    currPage[tabBodyId]++
                    for (var i = 0; i < json.length; i++) {
                        table += "<tr>"
                        for (var j = 0; j < 9; j++) {
                            table += "<td>" + json[i][j] + "</td>"
                        }
                        table += "</tr>"
                    }
                    table += "</tbody></table>"
                    var control = "<div><a class='waves-effect waves-light btn' id='raPrevious'>上一页</a>&nbsp;&nbsp;<a class='waves-effect waves-light btn' id='raNext'>下一页</a></div>"
                    table += control
                    $("#" + tabBodyId).html(table)
                    $("#raPrevious").click(
                        function () {
                            if (currPage[tabBodyId] > 1) {
                                currPage[tabBodyId] -= 2
                                resolver[tabBodyId]()
                            }
                        }
                    )
                    $("#raNext").click(
                        function () {
                            resolver[tabBodyId]()
                        }
                    )
                } else {
                    Materialize.toast("无数据可显示", 1000)
                }
            })
        },
        closedAppealTabBody: function () {
            var tabBodyId = 'closedAppealTabBody'
            $.getJSON($("body").prop("title") + "/student/getClosedAppeal.action", {'pageNumber': currPage[tabBodyId] + 1}, function (json) {
                window.clearTimeout(timer)
                endLoading(tabBodyId)
                if (typeof json != 'string') {
                    var table = "<table><thead><tr><td>课程编号</td><td>院系编号</td><td>教师编号</td><td>课程名称</td><td>院系名称</td><td>申诉时间</td><td>申诉内容</td><td>申诉状态</td><td>回执内容</td></tr></thead><tbody>"
                    currPage[tabBodyId]++
                    for (var i = 0; i < json.length; i++) {
                        table += "<tr>"
                        for (var j = 0; j < 9; j++) {
                            table += "<td>" + json[i][j] + "</td>"
                        }
                        table += "</tr>"
                    }
                    table += "</tbody></table>"
                    var control = "<div><a class='waves-effect waves-light btn' id='caPrevious'>上一页</a>&nbsp;&nbsp;<a class='waves-effect waves-light btn' id='caNext'>下一页</a></div>"
                    table += control
                    $("#" + tabBodyId).html(table)
                    $("#caPrevious").click(
                        function () {
                            if (currPage[tabBodyId] > 1) {
                                currPage[tabBodyId] -= 2
                                resolver[tabBodyId]()
                            }
                        }
                    )
                    $("#caNext").click(
                        function () {
                            resolver[tabBodyId]()
                        }
                    )
                } else {
                    Materialize.toast("无数据可显示", 1000)
                }
            })
        }
    }
    tabs.on("click", "span.ui-icon-close", function () {
        var tabBodyId = $(this).closest("li").remove().attr("aria-controls");
        $(tabBodyId).prop('display', 'none')
        for (each in tabsChain) {
            if (tabsChain[each] > tabsChain[tabBodyId])
                tabsChain[each]--
        }
        currPage[tabBodyId] = 0
        delete tabsChain[tabBodyId]
        tabs.tabs("refresh")
        lastTab--
    })
    function loading(tabBodyId) {
        var loadingImg = "<img src='/ssmis/res/img/loading.gif' class='loadingImg'/>"
        $('#' + tabBodyId).html(loadingImg)
    }

    function endLoading(tabBodyId) {
        $('#' + tabBodyId + ' img[class="loadingImg"]').remove()
    }

    function refresh(tabBodyId) {
        endLoading(tabBodyId)
        var refreshImg = "<img src='/ssmis/res/img/refresh.jpg' class='refreshImg'/>"
        $('#' + tabBodyId).append(refreshImg)
        $('#' + tabBodyId + ' img[class="refreshImg"]').click(function () {
            $(this).remove()
            loading(tabBodyId)
            resolver[tabBodyId]()
        })
    }


    $('.collection-item').click(
        function () {
            var tabBodyId = this.id + 'TabBody'
            if (!tabsChain[tabBodyId]) {
                var tabName = $(this).html()
                var tabTitle = "<li><a href='#" + tabBodyId + "'>" + tabName + "</a><span class='ui-icon ui-icon-close' role='presentation'></span></li>"
                $(tabBodyId).prop('display', 'block')
                tabs.find(".ui-tabs-nav").append(tabTitle);
                tabs.tabs("refresh");
                tabsChain[tabBodyId] = ++lastTab
                tabs.tabs('option', 'active', lastTab)
                loading(tabBodyId)
                timer = window.setTimeout(function () {
                    refresh(tabBodyId)
                }, 60000)
                resolver[tabBodyId]()
            } else {
                tabs.tabs('option', 'active', tabsChain[tabBodyId])
            }
        }
    )
})

