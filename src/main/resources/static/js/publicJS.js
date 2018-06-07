$(function () {
    var data = window.sessionStorage.getItem('name');
    if (data != null){
        $('#userNav').html('<li class="dropdown">\n' +
            ' <a href="#"  class="dropdown-toggle" data-toggle="dropdown" Role="button" aria-haspopup="true"\n' +
            ' aria-expanded="false"><span class="glyphicon glyphicon-user"></span>    '+data+'<span class="caret"></span></a>\n' +
            ' <ul class="dropdown-menu">\n' +
            ' <li><a href="/user/getPerson.do?name='+data+'">个人信息</a></li>\n' +
            ' <li><a href="/user/editPerson.do?name='+data+'">修改个人信息</a></li>\n' +
            ' <li><a href="/user/editPassword.do?name='+data+'">修改密码</a></li>\n' +
            ' </ul>\n' +
            ' </li>' +
            '<li><a href="#" onclick="logout()"><span class="glyphicon glyphicon-off"/>   log out</a></li>')
    }

    $('#order').on('click',function () {
        window.location.href = "/canteen/orderPage?uid=" + window.sessionStorage.getItem('uid') + "";
    });
    $('#userOrders').on('click',function () {
        window.location.href = "/canteen/userOrders?uid=" + window.sessionStorage.getItem('uid') + "";
    });

    $('#userCR').on('click',function () {
        window.location.href = "/CR/userCRPage?uid=" + window.sessionStorage.getItem('uid') + "";
    })
})

function logout() {
    window.sessionStorage.removeItem('name');
    window.location.href='/user/logout.do'
}

function dateFmt_yyMMdd(str) {
    var org = new Date(str);
    var yy = org.getFullYear();
    var MM = org.getMonth()+1;
    var dd = org.getDate();

    return yy+'-'+MM+'-'+dd;
}

function dateFmt_yyMMdd_hhmmss(str) {
    var org = new Date(str);
    var yy = org.getFullYear();
    var MM = org.getMonth()+1;
    var dd = org.getDate();

    var hh = org.getHours();

    var mm = org.getMinutes();
    mm = mm < 10 ? ('0' + mm) : mm;
    var ss = org.getSeconds();
    ss = ss < 10 ? ('0' + ss) : ss;

    return yy+'-'+MM+'-'+dd+' '+hh+':'+mm+':'+ss;
}