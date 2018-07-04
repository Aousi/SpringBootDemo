var changeFlag = false;


$(function () {
    var data = window.localStorage.getItem('name');
    if (data != null){
        $('#userNav').html('<li class="dropdown">\n' +
            ' <a href="#"  class="dropdown-toggle" data-toggle="dropdown" Role="button" aria-haspopup="true"\n' +
            ' aria-expanded="false"><span class="glyphicon glyphicon-user"></span>    '+data+'<span class="caret"></span></a>\n' +
            ' <ul class="dropdown-menu">\n' +
            ' <li><a href="/user/getPerson.do?name='+data+'">个人信息</a></li>\n' +
            ' <li><a href="/user/editPerson.do?name='+data+'">修改个人信息</a></li>\n' +
            ' <li><a href="/user/editPassword.do?name='+data+'">修改密码</a></li>\n' +
            ' <li role="separator" class="divider"></li>'+
            ' <li><a id="consoleKey" href="/intoConsole?name='+data+'">进入后台</a></li>\n' +
            ' </ul>\n' +
            ' </li>' +
            '<li><a href="#" onclick="logout()"><span class="glyphicon glyphicon-off"/>   log out</a></li>')
    }

    $('#order').on('click',function () {
        window.location.href = "/canteen/orderPage?uid=" + window.localStorage.getItem('uid') + "";
    });
    $('#userOrders').on('click',function () {
        window.location.href = "/canteen/userOrders?uid=" + window.localStorage.getItem('uid') + "";
    });

    $('#userCR').on('click',function () {
        window.location.href = "/CR/userCRPage?uid=" + window.localStorage.getItem('uid') + "";
    });

    $('#home').on('click',function () {
        gotoHome();
    })
})

function goToPersonCtrl() {
    var name = window.localStorage.getItem('name');
    // window.location.href ='/sysBackend-persons?name='+name+ '';
    var f = document.createElement('form');
    f.style.display = 'none';
    f.action = '/sysBackend-persons';
    f.method = 'post';
    f.innerHTML ='<input type="hidden" name="name" value="'+name+'"/>';
    document.body.appendChild(f);
    f.submit();
}

function goToCanteenCtrl() {
    var name = window.localStorage.getItem('name');
    // window.location.href ='/sysBackend-persons?name='+name+ '';
    var f = document.createElement('form');
    f.style.display = 'none';
    f.action = '/sysBackend-canteen';
    f.method = 'post';
    f.innerHTML ='<input type="hidden" name="name" value="'+name+'"/>';
    document.body.appendChild(f);
    f.submit();
}

function goToCtrlHome() {
    var name = $('#name').text();
    window.location.href ='/Console?name='+name+ '';
}

function logout() {
    window.localStorage.clear();
    window.location.href='/user/logout.do';
}

function gotoHome() {
    window.location.href='/';
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

function confirmChange(flag) {
    var i = flag;
    $('.updateData').change(function () {
        i = $(this).val();
        console.log('i=>   '+i);

        if (i == ''){
            changeFlag = false;
            i = '';
        }else {
            changeFlag =  true;
            i = '';
        }
    })

    return changeFlag;
}

function convertToJson(str) {
    var obj ={"uid":$('#uid').val(),"name":$('#username').val()};
    for (var i in str){
        obj[str[i].name]=str[i]['value'];
    }
    return obj;
}