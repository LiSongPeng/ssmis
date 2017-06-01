/**
 * Created by tose on 2017/5/31.
 */
function getAppeals(type) {
    var param = {operation:type};
    $.getJSON("getAppeals",param,function (data) {
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
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">'+stuName+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">'+stuId+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">'+stuGrade+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">'+stuclassNo+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">S</span><span class="mdl-chip__text">'+stuGender+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">D</span><span class="mdl-chip__text">'+dpmName+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">D</span><span class="mdl-chip__text">'+dpmId+'</span></span><br/>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">C</span><span class="mdl-chip__text">'+crsName+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">C</span><span class="mdl-chip__text">'+crsId+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">T</span><span class="mdl-chip__text">'+tchName+'</span></span>' +
                    '<span class="mdl-chip mdl-chip--contact"><span class="mdl-chip__contact mdl-color--teal mdl-color-text--white">T</span><span class="mdl-chip__text">'+tchId+'</span></span>' +
                    '</div><div class="mdl-card__supporting-text" align="left">' +content+ '</div>' +
                    '<div mdl-card__actions mdl-card--border><button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="width: 96px">回复</button></div>' +
                    '<div class="mdl-card__menu"><button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect"><i class="material-icons">more_vert</i></button></div>' +
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
    getAppeals(-1);
    $("#ap_table").delegate(".expand-content","click",function () {
        $(this).css("font-weight","");
        $(this).next().fadeToggle("fast");
    })
    $("#tab-link-1").click(function () {
        $("#np_tag").fadeOut("fast");
    })
})