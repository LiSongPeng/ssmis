/**
 * Created by lihuibo on 17-4-4.
 */
function makeToast(text, duration) {
    Materialize.toast(text, duration);
}
$(function () {
    $('#personalInfo').sideNav();
    $('#courseCenterBtn').click(function () {
        $('ul.tabs').tabs('select_tab', 'courseCenter');
    });
    $('#testCenterBtn').click(function () {
        $('ul.tabs').tabs('select_tab', 'testCenter');
    });
    var date = new Date();
    var week = ['日', '一', '二', '三', '四', '五', '六'];
    $('#date-section').html(date.getFullYear() + '年' + (date.getMonth() + 1) + '月' + date.getDate() + '日' + date.toLocaleTimeString() + ',周' + week[date.getDay()]);
    window.setInterval(function () {
        $('#date-section').html(date.getFullYear() + '年' + (date.getMonth() + 1) + '月' + date.getDate() + '日' + date.toLocaleTimeString() + ',周' + week[date.getDay()]);
    }, 60000);
});