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
                var stuGrade = n.studentByStuId.grade;
                var stuGender = n.studentByStuId.gender;
                var stuclassNo = n.studentByStuId.classNo;
                var date = new Date(n.date);
                var tr = "<tr style='font-weight:bold;' class='expand-content'>" +
                    '<td><i class="material-icons">input</i></td>' +
                    "<td>"+dpmName+"("+dpmId+")</td>" +
                    "<td>"+crsName+"</td>" +
                    '<td><span class="mdl-chip__text stu-name" id="stu_'+stuId+'">'+stuName+'</span>' +
                    '<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="stu_'+stuId+'">' +
                    '<li class="mdl-menu__item">姓名：'+stuName+'</li>' +
                    '<li class="mdl-menu__item">学号：'+stuId+'</li>' +
                    '<li class="mdl-menu__item">班级：'+stuclassNo+'</li>' +
                    '<li class="mdl-menu__item">年级：'+stuGrade+'</li>' +
                    '</ul>' +
                    '</td>' +
                    '<td>'+tchName+"("+tchId+')</td>' +
                    '<td>'+date+'</td>' +
                    '</tr>' +
                    '<tr style="display:none"><td colspan="6"><div style="width: auto;height: 320px;background-color: #00acc1;margin-left: auto;margin-right: auto">' +
                    '<button class="mdl-button mdl-js-button mdl-button--icon"> <i class="material-icons">more_vert</i> </button>' +
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
    // $("#ap_table").delegate("tr","click",function () {
    //     console.log("hello world");
    // })
    $("tr").on("click",function () {
            console.log("hello world");
    })
})