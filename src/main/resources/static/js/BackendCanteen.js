$('#orderTable').bootstrapTable({
    url: '/canteen/getBackendOrders.do',         //请求后台的URL（*）
    method: 'get',                      //请求方式（*）
    toolbar: '#toolbar',                //工具按钮用哪个容器
    striped: true,                      //是否显示行间隔色
    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    pagination: true,                   //是否显示分页（*）
    sortable: true,                     //是否启用排序
    sortName:"UID",
    sortOrder: "asc",                   //排序方式
    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
    pageNumber:1,                       //初始化加载第一页，默认第一页
    pageSize: 20,                       //每页的记录行数（*）
    pageList: [20, 35, 50, 100],        //可供选择的每页的行数（*）
    queryParams:  function (params) {
        //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            sort: params.sort,      //排序列名
            sortOrder: params.order //排位命令（desc，asc）
        };
        return temp;
    },//传递参数（*）
    // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
    // strictSearch: true,
    showColumns: true,                  //是否显示所有的列
    showRefresh: true,                  //是否显示刷新按钮
    minimumCountColumns: 2,             //最少允许的列数
    clickToSelect: true,                //是否启用点击选中行
    height: 1000,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
    uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
    showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
    cardView: false,                    //是否显示详细视图
    detailView: false,                   //是否显示父子表
    icons:{
        paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
        paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
        refresh: 'glyphicon-refresh icon-refresh',
        toggle: 'glyphicon-list-alt icon-list-alt',
        columns: 'glyphicon-th icon-th',
        detailOpen: 'glyphicon-plus icon-plus',
        detailClose: 'glyphicon-minus icon-minus'
    },
    columns:[[
        {
            field: 'coid',
            title: '订餐编号',
            rowspan:2
        },{
            field: '',
            title: '早餐',
            colspan:2
        },{
            field: '',
            title: '午餐',
            colspan:2
        },{
            field: '',
            title: '晚餐',
            colspan:2
        },{
            field: 'oTime',
            title: '预定日期',
            rowspan:2
        },{
            field: 'user',
            title: '订餐人',
            rowspan:2,
            formatter:function (value,row,index) {


                return row.user.username;
            }
        }
    ],[
        {
            field: 'breakfast',
            title: '订餐情况'
        },{
            field: 'bfMany',
            title: '数量/份'
        },{
            field: 'lunch',
            title: '订餐情况'
        },{
            field: 'lMany',
            title: '数量/份'
        },{
            field: 'dinner',
            title: '晚餐'
        },{
            field: 'dMany',
            title: '数量/份'
        },
    ]]
})