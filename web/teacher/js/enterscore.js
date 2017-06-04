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
            var content = "<table>";
            for(var i in data){
                var crsId = data[i].crsId;
                var crsName = data[i].crsName;
                content += "<tr>";
                content += "<td>"+crsName+"</td>";
                content += "<td><input type='button' value='选择该课程录入' onclick='enter("+crsId+")'></td>";
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
            "crs":crs
        },
        success:function(data){
            console.log(data)
            var content = "<table>";
            for (var i in data){
                var stuId = data[i].stuId;
                var stuName = data[i].name;
                content += "<tr>";
                content += "<td>"+stuName+"</td>";
                content += "<td><input type='text' class='button score' crs='"+crs+"' sid='"+stuId+"'></td>";
                content += "</tr>";
            }
            content += "</table>";
            content += "<button onclick='enterAllScore()'>录入学生成绩</button>"
            $("#content").html(content)
        }
    })
}

function enterAllScore() {

    var studentSchedules = [];

    $(".score").each(function (index, el) {
        var score = $(this).val();
        var sid = $(this).attr("sid");
        var d = {};
        d.stu = sid;
        d.score = score;
        d.crs = $(this).attr("crs");
        d.dpm = sessionStorage.tdpm
        studentSchedules.push(d)
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

}