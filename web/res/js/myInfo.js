function callBack(json) {
    if (json.result == 'Success')
        Materialize.toast("修改成功", 1000)
    else
        Materialize.toast('修改失败', 1000)
}
$(function () {
    var basePath = $('body').prop('title') + '/student/updateUser'
    $('#Changeaddress').click(function () {
        if ($(this).html() == "更改") {
            $('#address').prop("disabled", false)
            $(this).html("确认")
        } else {
            $.getJSON(basePath, {'stu.address': $('#address').val()}, callBack)
            $(this).html('更改')
        }
    })
    $('#Changeemail').click(function () {
        if ($(this).html() == "更改") {
            $('#email').prop("disabled", false)
            $(this).html("确认")
        } else {
            $.getJSON(basePath, {'stu.email': $('#email').val()}, callBack)
            $(this).html('更改')
        }
    })
    $('#Changepassword').click(function () {
        if ($(this).html() == "更改") {
            $('#password').prop("disabled", false)
            $(this).html("确认")
        } else {
            $.getJSON(basePath, {'stu.password': $('#password').val()}, callBack)
            $(this).html('更改')
        }
    })
    $('#Changephone').click(function () {
        if ($(this).html() == "更改") {
            $('#phone').prop("disabled", false)
            $(this).html("确认")
        } else {
            $.getJSON(basePath, {'stu.address': $('#phone').val()}, callBack)
            $(this).html('更改')
        }
    })
})