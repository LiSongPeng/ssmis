/**
 * Created by lihuibo on 5/24/17.
 */

$(function () {
    var tabs = $('#courseCenterTabs').tabs()
    var tabCounter = 1
    /*    tabs.on("click", "span.ui-icon-close", function () {
     var panelId = $(this).closest("li").remove().attr("aria-controls");
     $("#" + panelId).remove();
     tabs.tabs("refresh");
     tabCounter--;
     });*/
    function addTab(tabTitle) {
        tabs.find(".ui-tabs-nav").append(tabTitle);
        tabCounter++;
        $('#courseCenterTabs').tabs('option', 'active', 2)
        tabs.tabs("refresh");
    }

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
            var tabName = $(this).html()
            var tabBodyId = this.id + 'TabBody'
            var tabTitle = "<li><a href='#" + tabBodyId + "'>" + tabName + "</a></li>"
            resolver[this.id](1)
            $(tabBodyId).prop('display', 'block')
            addTab(tabTitle)
        }
    )
})