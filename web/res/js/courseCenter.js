/**
 * Created by lihuibo on 5/24/17.
 */

$(function () {
    var tabs = $('#courseCenterTabs').tabs()
    var tabCounter = 0
    tabs.on("click", "span.ui-icon-close", function () {
        var panelId = $(this).closest("li").remove().attr("aria-controls");
        $("#" + panelId).remove();
        tabs.tabs("refresh");
        tabCounter--;
    });
    function addTab(tabTitle, tabBody) {
        tabs.find(".ui-tabs-nav").append(tabTitle);
        tabs.append(tabBody);
        tabs.tabs("refresh");
        tabCounter++;
    }
})