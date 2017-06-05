/**
 * Created by tose on 2017/5/31.
 */
function writeToTbody(tbodyid,appeals) {
    tbodyid = '#'+tbodyid;
    $(tbodyid).html("");
    $.each(appeals,function(i,n){
        var content = n.content;
        var crsName = n.courseByCrsId.crsName;
        var crsId = n.crsId;
        var dpmName = n.departmentByDpmId.dpmName;
        var dpmId = n.dpmId;
        var tchName = n.departmentByDpmId.teachersByDpmId[0].name;
        var tchId = n.tchId;
        var stuName = n.studentByStuId.name;
        var stuId = n.stuId;
        var stuGrade = "女";
        if(n.studentByStuId.grade=='1') stuGender = "男";
        var stuGender = n.studentByStuId.gender;
        var stuclassNo = n.studentByStuId.classNo;
        var date = new Date(n.date);
        var aid = dpmId+"_"+crsId+"_"+tchId+"_"+stuId+"_"+n.date;

        var tr = "<tr style='font-weight:bold;' class='expand-content'>" +
            '<td><i class="material-icons">input</i></td>' +
            '<td><span class="mdl-chip"><span class="mdl-chip__text">'+dpmName+"("+dpmId+")</span></span></td>" +
            '<td><span class="mdl-chip"><span class="mdl-chip__text">'+crsName+'('+crsId+")</span></span></td>" +
            '<td><span class="mdl-chip"><span class="mdl-chip__text">'+stuName+'('+stuId+')</span></span></td>' +
            '<td><span class="mdl-chip"><span class="mdl-chip__text">'+tchName+"("+tchId+')</span></span></td>' +
            '<td><span class="mdl-chip"><span class="mdl-chip__text">'+date+'</span></span></td>' +
            '</tr>' +
            '<tr style="display:none"><td colspan="6">' +
            '<div class="mdl-card mdl-shadow--2dp through mdl-shadow--16dp" style="width:auto" align="left"><div>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">学生：'+stuName+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">学号：'+stuId+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">年级：'+stuGrade+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">班级：'+stuclassNo+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">性别：'+stuGender+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">D</span><span class="mdl-chip__text">院系名：'+dpmName+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">D</span><span class="mdl-chip__text">院系号：'+dpmId+'</span></span><br>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">C</span><span class="mdl-chip__text">课程名称：'+crsName+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">C</span><span class="mdl-chip__text">课程号：'+crsId+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">T</span><span class="mdl-chip__text">教师：'+tchName+'</span></span>' +
            '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">T</span><span class="mdl-chip__text">教师号：'+tchId+'</span></span>' +
            '</div><div class="mdl-card__supporting-text" align="left">' +content+ '</div>' +
            '<div class="mdl-card__actions mdl-card--border" style="display: none"><div class="mdl-textfield mdl-js-textfield" style="width:100%;margin: 0 auto"><textarea class="mdl-textfield__input" type="text" rows= "3" id="rsp_'+aid+'" ></textarea><label class="mdl-textfield__label" for="rsp_'+aid+'"></label></div>' +
            '<div><button class="send-rsp mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"><i class="material-icons">send</i></button>' +
            '<button class="send-rsp-cancel mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"><i class="material-icons">cancel</i></button></div></div>' +
            '<div class="mdl-card__actions mdl-card--border"><button id="btn_'+aid+'" class="appeal-respond mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="width: 96px"><i class="material-icons">edit</i>回复</button></div></div></td></tr>';

        $(tbodyid).append(tr);

    })
}
function getNewAppeals() {
    var param = {operation:0};
    $.getJSON("getAppeals",param,function (data) {
        $("#p2").hide();
        var list = $.parseJSON(data);
        if(list.length>0){
            $("#np_tag").attr("data-badge",list.length);
            $("#np_tag").show();
            $("#zone").show();
            writeToTbody("ap_table",list);
        }
        else{
            $("#zone").hide();
            $("#np_tag").hide();
            $("#zone").parent().html("<h2 style='width: 25%;margin: 0 auto'>无新的复查请求</h2>")
        }
    })
}


function updateStatus(appealId, status) {
    var idArray = appealId.split("_");
    var appeal={
        'appeal.dpmId':idArray[1],
        'appeal.crsId':idArray[2],
        'appeal.tchId':idArray[3],
        'appeal.stuId':idArray[4],
        'date': idArray[5],
        'appeal.status':status
    };
    var json = $.param(appeal);
    // console.log(json);
    $.getJSON('updateAppeals',json,function (data) {});
}

function updateAppealResponse(appealId, content) {
    var idArray = appealId.split("_");
    var appeal={
        'appeal.dpmId':idArray[1],
        'appeal.crsId':idArray[2],
        'appeal.tchId':idArray[3],
        'appeal.stuId':idArray[4],
        'date': idArray[5],
        'appeal.response': content,
        'appeal.status':4
    };
    var json = $.param(appeal);

    $.getJSON('updateAppeals',json,function (data) {
        var obj = $.parseJSON(data);
        rs = obj.result;
    });

}

function saveDraw(appealId, content) {
    var idArray = appealId.split("_");
    var appeal={
        'appeal.dpmId':idArray[1],
        'appeal.crsId':idArray[2],
        'appeal.tchId':idArray[3],
        'appeal.stuId':idArray[4],
        'date': idArray[5],
        'appeal.content': content,
        'appeal.status': 6
    };
    var json = $.param(appeal);
    $.getJSON('updateAppeals',json,function () {});
}
$(function () {
    $("#ly_4").click(function () {
        getNewAppeals();
    })

    $("#ap_table").delegate(".expand-content","click",function () {
        $(this).css("font-weight","");
        $(this).next().fadeToggle("fast");
        var obj = $(this).next().find("button").get(2);
        var id = $(obj).attr("id");
        updateStatus(id,1)
    })

    $("#tab-link-1").click(function () {
        $("#np_tag").fadeOut("fast");
    })

    $("#ap_table").delegate(".appeal-respond","click",function () {
        $(this).parent().prev().slideToggle("fast");
        $(this).parent().slideToggle("fast");

    })

    $("#ap_table").delegate(".send-rsp-cancel","click",function(){
        $(this).parent().parent().slideToggle("fast");
        $(this).parent().parent().next().slideToggle("fast");

    })
    $("#ap_table").delegate(".send-rsp","click",function () {
        var text = $(this).parent().prev().children("textarea").get(0);
        var id = '#'+$(text).attr("id");
        var content = $(id).val();
        updateAppealResponse($(text).attr("id"),content);
        console.log($(this).parent().parent().parent().parent());

    })
})