function callBack(json) {
    json = $.parseJSON(json)
    if (json.result == 'Success')
        Materialize.toast("修改成功", 1000)
    else
        Materialize.toast('修改失败', 1000)
}
$(function () {
    var changeFlag = {
        Changeaddress: false,
        Changeemail: false,
        Changepassword: false,
        Changephone: false
    }
    var basePath = $('body').prop('title') + '/student/updateUser.action'
    $('#Changeaddress').click(function () {
        if (!changeFlag[this.id]) {
            $('#address').prop("disabled", false)
            this.innerHTML = "确认"
            changeFlag[this.id] = true
        } else {
            $.getJSON(basePath, {'stu.address': $('#address').val()}, callBack)
            this.innerHTML = "更改"
            $('#address').prop("disabled", "disabled")
            changeFlag[this.id] = false
        }
    })
    $('#Changeemail').click(function () {
        if (!changeFlag[this.id]) {
            $('#email').prop("disabled", false)
            this.innerHTML = "确认"
            changeFlag[this.id] = true
        } else {
            $.getJSON(basePath, {'stu.email': $('#email').val()}, callBack)
            this.innerHTML = "更改"
            $('#email').prop("disabled", "disabled")
            changeFlag[this.id] = false
        }
    })
    $('#Changepassword').click(function () {
        if (!changeFlag[this.id]) {
            $('#password').prop("disabled", false)
            this.innerHTML = "确认"
            changeFlag[this.id] = true
        } else {
            $.getJSON(basePath, {'stu.password': $('#password').val()}, callBack)
            this.innerHTML = "更改"
            $('#password').prop("disabled", "disabled")
            changeFlag[this.id] = false
        }
    })
    $('#Changephone').click(function () {
        if (!changeFlag[this.id]) {
            $('#phone').prop("disabled", false)
            this.innerHTML = "确认"
            changeFlag[this.id] = true
        } else {
            $.getJSON(basePath, {'stu.phone': $('#phone').val()}, callBack)
            this.innerHTML = "更改"
            $('#phone').prop("disabled", "disabled")
            changeFlag[this.id] = false
        }
    })
})