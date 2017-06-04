/**
 * Created by Administrator on 2017/6/3.
 */
(function(){
    $.ajax({
        type:"post",
        url:"/ssmis/teacher/getExamed",
        data:{
            "dpm":"1",
            "tid":sessionStorage.tchid
        },
        success:function(data){
            console.log(data)
            var content = "<table align='center' class='mdl-data-table mdl-js-data-table mdl-shadow--2dp'>";
            for(var i in data){
                var crsId = data[i].crsId;
                var crsName = data[i].crsName;
                content += "<tr>";
                content += "<td class='mdl-data-table__cell--non-numeric'>"+crsName+"</td>";
                content += "<td><input class='mdl-button mdl-js-button mdl-button--raised' type='button' value='选择该课程录入' onclick='enter("+crsId+")'></td>";
                content += "</tr>";
            }

            content += "</table>";
            $("#content").html(content)
        },
        error:function(){

        }
    });



})();


function enter(crs) {
    console.log("---")
    $.ajax({
        type:"post",
        url:"/ssmis/teacher/getChooseCourseStudents",
        data:{
            "dpm":"1",
            "crs":crs,
        },
        success:function(data){
            console.log(data);
            var content = "<table align='center' class='mdl-data-table mdl-js-data-table mdl-shadow--2dp'>";
            for (var i in data){
                var stuId = data[i].stuId;
                var stuName = data[i].name;
                content += "<tr>";
                content += "<td class='mdl-data-table__cell--non-numeric'>"+stuName+"</td>";
                content += "<td><input type='text' class='button score' crs='"+crs+"' sid='"+stuId+"'></td>";
                content += "<td><select name='' class='examStatus' crs='"+crs+"' sid='"+stuId+"'>" +
                    "<option value='0'>正常</option>" +
                    "<option value='1'>缺考</option>" +
                    "<option value='2'>禁止考试</option>" +
                    "</select>";
                content += "</tr>";
            }

            content += "</table>";
            content += "<button class='mdl-button mdl-js-button mdl-button--raised' onclick='enterAllScore()'>录入学生成绩</button>"

            $("#content").html(content)
        }
    })
}

function enterAllScore() {

    var studentSchedules = [];

    $(".score").each(function (index, el) {


        console.log("12323")
        var score = $(this).val();
        var sid = $(this).attr("sid");
        var d = {};
        d.stu = sid;
        d.score = score;
        d.crs = $(this).attr("crs");
        d.dpm = sessionStorage.tdpm

        $(".examStatus option:selected").each(function(i, e){
            console.log("sid = " + $(this).parent().attr("sid"))
            console.log("sid1 = " + sid)
            if($(this).parent().attr("sid") == sid){
                console.log("123")
                d.examStatus = $(this).val()
            }
        });


        studentSchedules.push(d)
        console.log(d)
    });
    $.ajax({
        type:"post",
        url:"/ssmis/teacher/enterScore",
        data:{
            "studentSchedules":JSON.stringify(studentSchedules)
        },
        success:function(data){
            console.log(data)
        }
    })

    alert("录入成功！")
    parent.location.reload()

}