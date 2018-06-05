$(function () {
    var data = window.sessionStorage.getItem('name');
    if (data !=""){
        $('#userNav').html('<li class="dropdown">\n' +
            ' <a href="#"  class="dropdown-toggle" data-toggle="dropdown" Role="button" aria-haspopup="true"\n' +
            ' aria-expanded="false" >'+data+'<span class="caret"></span></a>\n' +
            ' <ul class="dropdown-menu">\n' +
            ' <li><a href="/user/getPerson.do?name='+data+'">个人信息</a></li>\n' +
            ' <li><a href="/user/editPerson.do?name='+data+'">修改个人信息</a></li>\n' +
            ' <li><a href="/user/editPassword.do?name='+data+'">修改密码</a></li>\n' +
            ' </ul>\n' +
            ' </li>' +
            '<li><a href="#" onclick="logout()">log out</a></li>')
    }

    $('#order').on('click',function () {
        window.location.href = "/canteen/orderPage?uid=" + window.sessionStorage.getItem('uid') + "";
    });
    $('#userOrders').on('click',function () {
        window.location.href = "/canteen/userOrders?uid=" + window.sessionStorage.getItem('uid') + "";
    });
})

function logout() {
    window.sessionStorage.removeItem('name');
    window.location.href='/'
}