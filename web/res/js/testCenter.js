/**
 * Created by lihuibo on 5/24/17.
 */

$(function () {
    var tabs = $('#courseCenterTabs').tabs()
    var lastTab = 0
    var tabsChain = {}
    tabs.on("click", "span.ui-icon-close", function () {
        var tabBodyId = $(this).closest("li").remove().attr("aria-controls");
        $(tabBodyId).prop('display', 'none')
        for (each in tabsChain) {
            if (tabsChain[each] > tabsChain[tabBodyId])
                tabsChain[each]--
        }
        delete tabsChain[tabBodyId]
        tabs.tabs("refresh")
        lastTab--
    })
    var resolver = {
        selected: function (pageNumber) {

        },

        selectable: function (pageNumber) {

        },

        selectResult: function (pageNumber) {

        },

        courseSchedule: function (pageNumber) {

        },

        personalCourseTable: function () {

        }
    }

    $('.collection-item').click(
        function () {
            var tabBodyId = this.id + 'TabBody'
            if (!tabsChain[tabBodyId]) {
                var tabName = $(this).html()
                var tabTitle = "<li><a href='#" + tabBodyId + "'>" + tabName + "</a><span class='ui-icon ui-icon-close' role='presentation'></span></li>"
                resolver[this.id](1)
                $(tabBodyId).prop('display', 'block')
                tabs.find(".ui-tabs-nav").append(tabTitle);
                tabs.tabs("refresh");
                tabsChain[tabBodyId] = ++lastTab
                tabs.tabs('option', 'active', lastTab)
            } else {
                tabs.tabs('option', 'active', tabsChain[tabBodyId])
            }
        }
    )
})
