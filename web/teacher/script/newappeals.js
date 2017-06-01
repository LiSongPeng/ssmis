/**
 * Created by tose on 2017/5/31.
 */
function getAppeals(type) {
    var param = {operation:type};
    $.getJSON("getAppeals",param,function (data) {
        $("#p2").toggle();
        var list = $.parseJSON(data);
        if(list.length>0){
            $("#np_tag").attr("data-badge",list.length);
            $("#np_tag").show();
            $("#zone").show();
            $.each(list,function(i,n){
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
                var aid = dpmId+"_"+crsId+"_"+tchId+"_"+"_"+stuId+"_"+n.date;
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
                    '<div class="mdl-card__actions mdl-card--border"><button id="btn_'+aid+'" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="width: 96px">回复</button></div>' +
                    '</div></td></tr>';
                $("#ap_table").append(tr);
                // console.log(content+" "+crsId+" "+crsName+" "+dpmName+" "+dpmId+" "+ tchId+" "+tchName);
                // console.log(stuId+" "+stuName+" "+stuGrade+" "+stuclassNo+" "+stuGender);
                // console.log(date);
            })
        }
    })
}

$(function () {
    $("#ly_4").click(function () {
        getAppeals(-1);
        $("#ap_table").delegate(".expand-content","click",function () {
            $(this).css("font-weight","");
            $(this).next().fadeToggle("fast");
        })
        $("#tab-link-1").click(function () {
            $("#np_tag").fadeOut("fast");
        })
    })
})