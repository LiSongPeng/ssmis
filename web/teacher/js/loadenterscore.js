/**
 * Created by Administrator on 2017/6/3.
 */
(function(){
    $("#enterScore").load("./enterscore.html")
})();

//加载个人信息
(function(){
    console.log("---")
    $.ajax({
        type:"post",
        url:"/ssmis/teacher/selfInfo",
        data:{
            tid:sessionStorage.tchid
        },
        success:function(data){
            console.log(data);
            var tchId = data.tchId;
            var name = data.name;
            var phone = data.phone;
            var email = data.email;
            var gender = data.gender == 0? "男":"女";
            var address = data.address;
            var birthday = data.birthday.split("T")[0];
            var dpmName = data.departmentByDpmId.dpmName;
            var content = "<a class='mdl-navigation__link' href='#'>教师号"+tchId+"</a>";
             content += "<a class='mdl-navigation__link' href='#'>姓名:"+name+"</a>";
             content += "<a class='mdl-navigation__link' href='#'>电话:"+phone+"</a>";
             content += "<a class='mdl-navigation__link' href='#'>邮件:"+email+"</a>";

             content += "<a class='mdl-navigation__link' href='#'>性别:"+gender+"</a>";
             content += "<a class='mdl-navigation__link' href='#'>地址:"+address+"</a>";
             content += "<a class='mdl-navigation__link' href='#'>生日:"+birthday+"</a>";
             content += "<a class='mdl-navigation__link' href='#'>所在院系:"+dpmName+"</a>";
            $("#logout").before(content);
        }
    })
})();