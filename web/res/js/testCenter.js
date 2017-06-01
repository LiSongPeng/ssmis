/**
 * Created by lihuibo on 5/24/17.
 */

$(function () {
    var tabs = $('#testCenterTabs').tabs()
    var lastTab = 0
    var tabsChain = {}
    var currPage = {
        testPlanTabBody: 0,
        testScoreTabBody: 0,
        progressAppealTabBody: 0,
        passedAppealTabBody: 0,
        failedAppealTabBody: 0
    }
    var timer
    var resolver = {
        testPlanTabBody: function () {
            var tabBodyId = 'testPlanTabBody'
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

