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
        passedAppealTabBody: 0,
        failedAppealTabBody: 0
    }
    var timer
    var resolver = {
        testPlanTabBody: function () {
            var tabBodyId = 'testPlanTabBody'
            $.getJSON($("body").prop("title") + "/student/getExamInfo.action",function (json) {
                if (json) {
                    var table = "<table><thead><tr><td>课程编号</td><td>院系编号</td><td>教师编号</td><td>课程名称</td><td>院系名称</td><td>教师名称</td><td>学期</td><td>操作</td></tr></thead><tbody>"
                    currPage[tabBodyId]++
                    window.clearTimeout(timer)
                    endLoading(tabBodyId)
                    for (var i = 0; i < json.length; i++) {
                        table += "<tr>"
                        for (var j = 0; j < 7; j++) {
                            table += "<td>" + json[i][j] + "</td>"
                        }
                        table += "<td><a class='waves-effect waves-light btn cancelCourse'>退选</a></td>"
                        table += "</tr>"
                    }
                    table += "</tbody></table>"
                    var control = "<div><a class='waves-effect waves-light btn' id='stPrevious'>上一页</a>&nbsp;&nbsp;<a class='waves-effect waves-light btn' id='stNext'>下一页</a></div>"
                    table += control
                    $("#" + tabBodyId).html(table)
                    $(".cancelCourse").click(
                        function () {
                            var tr = $(this).closest("tr")
                            var tds = $(tr).children()
                            var crsId = tds[0].innerHTML
                            alert("crsId" + crsId)
                            var dpmId = tds[1].innerHTML
                            var tchId = tds[2].innerHTML
                            $.getJSON($("body").prop("title") + "/student/cancalCourse.action", {
                                'csche.dpmId': dpmId,
                                'csche.crsId': crsId,
                                'csche.tchId': tchId
                            }, function (json) {
                                json = $.parseJSON(json)
                                if (json.result == 'Success') {
                                    Materialize.toast("退选成功", 1000)
                                    $(tr).remove()
                                } else {
                                    Materialize.toast("退选失败,稍后重试", 1000)
                                }
                            })
                        }
                    )
                    $("#stPrevious").click(
                        function () {
                            if (currPage[tabBodyId] > 1) {
                                currPage[tabBodyId] -= 2
                                resolver[tabBodyId]()
                            }
                        }
                    )
                    $("#stNext").click(
                        function () {
                            resolver[tabBodyId]()
                        }
                    )
                } else {
                    Materialize.toast("无数据可显示", 1000)
                }
            })
        },

        testScoreTabBody: function () {
            var tabBodyId = 'testScoreTabBody'
        },

        progressAppealTabBody: function () {
            var tabBodyId = 'progressAppealTabBody'
        },

        passedAppealTabBody: function () {
            var tabBodyId = 'passedAppealTabBody'
        },
        failedAppealTabBody: function () {
            var tabBodyId = 'failedAppealTabBody'
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
        $('#' + tabBodyId).append(loadingImg)
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

