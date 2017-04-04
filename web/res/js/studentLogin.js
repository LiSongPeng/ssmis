/**
 * Created by lihuibo on 17-4-4.
 */
function makeToast(text, duration) {
    Materialize.toast(text, duration);
}

$(function () {
    $("form").submit(function () {
        var stu_id = $("input[name='stu.stu_id']").val();
        var password = $("input[name='stu.password']").val();
        if (stu_id == "" || password == "") {
            makeToast("用户名或密码不能为空", 1000);
            return false;
        }
        $("#loginMessage").html("登录中...请稍后...");
        $('.modal').modal({dismissible: false});
        $("#loginModal").modal("open");
        $.ajax({
            url: $("body").prop("title") + "/student/login",
            async: true,
            data: {"stu.stu_id": stu_id, "stu.password": password},
            dataType: "json",
            type: "GET",
            success: function (json) {
                json=$.parseJSON(json);
                if (json.result == "Error") {
                    $("#loginModal").modal("close");
                    makeToast("用户名或密码错误", 1000);
                } else if (json.result == "Success") {
                    $("#loginMessage").html("登录成功,正在跳转到首页...");
                    window.setTimeout(function () {
                        $("#loginModal").modal("close");
                        window.location.href = "index.jsp";
                    }, 1000);
                }
            }
        });
        return false;
    });
});
