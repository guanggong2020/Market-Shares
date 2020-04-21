
function addFunctionAlty(value, row, index) {
    return [
        '<button id="bind" type="button" class="btn btn-default" >图形化</button>'
    ].join('');
}
window.operateEvents = {
    'click #bind': function (e, value, row, index) {
        var value=row.code;
        window.location.href='/data/Amodel?code='+row.code;
    }
};

    $('#exampleTable').bootstrapTable(
        {
        url : "/page/USAfund", // 请求的后台URL（*）
        method : 'get', // 请求方式：get/post（*）
        showRefresh : false, // 是否显示刷新按钮
        showToggle : false, // 是否显示详细视图和列表视图的切换按钮
        showColumns : true, // 是否显示列操作按钮
        detailView : false, // 是否显示详细视图
        striped : true, // 设置为true会有隔行变色效果
        dataType : "json", // 服务器返回的数据类型
        pagination : true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // 设置为limit则会发送符合RESTFull格式的参数
        singleSelect : true, // 设置为true将禁止多选
        clickToSelect : true, // 是否启用点击选中行

        // contentType : "application/x-www-form-urlencoded",
        // 发送到服务器的数据编码类型
        pageSize : 10, // 如果设置了分页，每页数据条数
        pageNumber : 1, // 如果设置了分布，首页页码
        search : false, // 是否显示搜索框

        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit : params.limit,
                pageSize : 10,
                offset : params.offset,
                search : $("#search1").val(),
                sort : "closingPrice",
                order : "DESC",
            };
        },
        // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
        // queryParamsType = 'limit' ,返回参数必须包含
        // limit, offset, search, sort, order 否则, 需要包含:
        // pageSize, pageNumber, searchText, sortName,
        // sortOrder.
        // 返回false将会终止请求

        columns : [ {
            title : '日期',
            field : 'date',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'
        }, {
            title : '代码',
            field : 'code',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left',


        }, {
            title : '名称',
            field : 'fundName',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left',
            width:80
        }, {
            title : '发行商',
            field : 'company',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'
        }, {
            title : '收盘价',
            field : 'closingPrice',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'
        }, {
            title : '增长率',
            field : 'growthRate',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'
        }, {
            title : '前收盘',
            field : 'previousClose',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'

        }, {
            title : '涨跌额',
            field : 'change',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left',
            class:'data-table'
        }, {
            title : '周转率',
            field : 'turnover',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left',
            class:'data-table'

        }, {
            title : 'ROE',
            field : 'roe',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left',
            class:'data-table'

        },  {
            title : '一年',
            field : 'oneYearChange',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'

        },  {
            title : 'ROA',
            field : 'roa',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'

        }, {
            title : '晨星评级',
            field : 'morningstarRating',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'

        }, {
            title : '风险评级',
            field : 'riskRating',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'
        }, {
            title : '十二个月收益率',
            field : 'ttmyield',
            align:'left',
            halign:'left',
            valign:'top',
            falign:'left'
        }, {
            field: 'operate',
            title: '操作',
            events: operateEvents,//给按钮注册事件
            formatter: addFunctionAlty,//表格中增加按钮

            //  
        }]

    });
var dls = document.querySelectorAll('dl:not(.select)');
var selected=document.querySelector('.select');

for (var i = 0; i < dls.length; i++) {
    dls[i].mark=false;	//给每一行的dl标签添加一条属性，用于对应下面的dd标签。我们约定如果这个属性的值为true表示对应的标签没有创建。如果值为false表示对应的标签已经创建了
    select(i);
}
function select(n) {
    var dds = dls[n].querySelectorAll('dd');
    var prev=null;
    var dd=null;	//每一行都需要创建一个dd标签，放到这里是为了如果标签已经被创建了，通过这个变量能够找到这个标签

    for (var i = 0; i < dds.length; i++) {
        dds[i].onclick = function () {
            //给当前点击的添加一个高亮
            //prev && (prev.className = '');

            if(prev){
                prev.className = ''
            }

            this.className = 'active';

            prev = this;


            //创建dd标签
            var parent=this.parentNode;
            if(!parent.mark){	//这个条件满足说明对应的dd标签还没有创建
                dd=document.createElement('dd');
                dd.innerHTML=this.innerHTML;
                var sort=$("#sort .active").attr("title");
                var order=$("#order .active").attr("title");
                var change=$("#change .active").attr("title");
                if(typeof (sort)==='undefined'){
                    sort="收盘价";
                }
                if(typeof (order)==='undefined'){
                    order="DESC";
                }
                if(typeof (change)==='undefined'){
                    change="0";
                }
                //走这里的时候说明对应的标签已经创建了，只需要把内容修改了就可以了
                dd.innerHTML=this.innerHTML;
                dd.title=this.title;
                $('#exampleTable').bootstrapTable('destroy');
                $('#exampleTable').bootstrapTable(
                    {
                        url : "/page/USAfundJuge", // 请求的后台URL（*）
                        method : 'get', // 请求方式：get/post（*）
                        showRefresh : false, // 是否显示刷新按钮
                        showToggle : false, // 是否显示详细视图和列表视图的切换按钮
                        showColumns : true, // 是否显示列操作按钮
                        detailView : false, // 是否显示详细视图
                        striped : true, // 设置为true会有隔行变色效果
                        dataType : "json", // 服务器返回的数据类型
                        pagination : true, // 设置为true会在底部显示分页条
                        // queryParamsType : "limit",
                        // 设置为limit则会发送符合RESTFull格式的参数
                        singleSelect : true, // 设置为true将禁止多选
                        clickToSelect : true, // 是否启用点击选中行

                        // contentType : "application/x-www-form-urlencoded",
                        // 发送到服务器的数据编码类型
                        pageSize : 10, // 如果设置了分页，每页数据条数
                        pageNumber : 1, // 如果设置了分布，首页页码
                        search : false, // 是否显示搜索框

                        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                        queryParams : function(params) {
                            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                                // limit: params.limit,   //页面大小
                                offset: params.offset,  //页码
                                pageSize:10,
                                limit : params.limit,
                                search:$("#search1").val(),
                                order:order,
                                sort: sort,
                                change:change,

                            };
                            return temp;
                        },
                        // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                        // queryParamsType = 'limit' ,返回参数必须包含
                        // limit, offset, search, sort, order 否则, 需要包含:
                        // pageSize, pageNumber, searchText, sortName,
                        // sortOrder.
                        // 返回false将会终止请求

                        columns : [ {
                            title : '日期',
                            field : 'date',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '代码',
                            field : 'code',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',


                        }, {
                            title : '名称',
                            field : 'fundName',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            width:80
                        }, {
                            title : '发行商',
                            field : 'company',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '收盘价',
                            field : 'closingPrice',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '增长率',
                            field : 'growthRate',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '前收盘',
                            field : 'previousClose',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '涨跌额',
                            field : 'change',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'
                        }, {
                            title : '周转率',
                            field : 'turnover',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'

                        }, {
                            title : 'ROE',
                            field : 'roe',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'

                        },  {
                            title : '一年',
                            field : 'oneYearChange',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        },  {
                            title : 'ROA',
                            field : 'roa',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '晨星评级',
                            field : 'morningstarRating',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '风险评级',
                            field : 'riskRating',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '十二个月收益率',
                            field : 'ttmyield',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            field: 'operate',
                            title: '操作',
                            events: operateEvents,//给按钮注册事件
                            formatter: addFunctionAlty,//表格中增加按钮

                            //  
                        }]

                    });
                dd.title=this.title;
                selected.appendChild(dd);

                parent.mark=true;

            }else{
                var sort=$("#sort .active").attr("title");
                var order=$("#order .active").attr("title");
                var change=$("#change .active").attr("title");
                if(typeof (sort)==='undefined'){
                    sort="closingPrice";
                }
                if(typeof (order)==='undefined'){
                    order="DESC";
                }
                if(typeof (change)==='undefined'){
                    change="0";
                }
                //走这里的时候说明对应的标签已经创建了，只需要把内容修改了就可以了
                dd.innerHTML=this.innerHTML;
                dd.title=this.title;
                $('#exampleTable').bootstrapTable('destroy');
                $('#exampleTable').bootstrapTable(
                    {
                        url : "/page/USAfundJuge", // 请求的后台URL（*）
                        method : 'get', // 请求方式：get/post（*）
                        showRefresh : false, // 是否显示刷新按钮
                        showToggle : false, // 是否显示详细视图和列表视图的切换按钮
                        showColumns : true, // 是否显示列操作按钮
                        detailView : false, // 是否显示详细视图
                        striped : true, // 设置为true会有隔行变色效果
                        dataType : "json", // 服务器返回的数据类型
                        pagination : true, // 设置为true会在底部显示分页条
                        // queryParamsType : "limit",
                        // 设置为limit则会发送符合RESTFull格式的参数
                        singleSelect : true, // 设置为true将禁止多选
                        clickToSelect : true, // 是否启用点击选中行

                        // contentType : "application/x-www-form-urlencoded",
                        // 发送到服务器的数据编码类型
                        pageSize : 10, // 如果设置了分页，每页数据条数
                        pageNumber : 1, // 如果设置了分布，首页页码
                        search : false, // 是否显示搜索框

                        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                        queryParams : function(params) {
                            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                                // limit: params.limit,   //页面大小
                                offset: params.offset,  //页码
                                pageSize:10,
                                limit : params.limit,
                                search:$("#search1").val(),
                                order:order,
                                sort: sort,
                                change:change,

                            };
                            return temp;
                        },
                        // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                        // queryParamsType = 'limit' ,返回参数必须包含
                        // limit, offset, search, sort, order 否则, 需要包含:
                        // pageSize, pageNumber, searchText, sortName,
                        // sortOrder.
                        // 返回false将会终止请求

                        columns : [ {
                            title : '日期',
                            field : 'date',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '代码',
                            field : 'code',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',


                        }, {
                            title : '名称',
                            field : 'fundName',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            width:80
                        }, {
                            title : '发行商',
                            field : 'company',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '收盘价',
                            field : 'closingPrice',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '增长率',
                            field : 'growthRate',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '前收盘',
                            field : 'previousClose',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '涨跌额',
                            field : 'change',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'
                        }, {
                            title : '周转率',
                            field : 'turnover',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'

                        }, {
                            title : 'ROE',
                            field : 'roe',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'

                        },  {
                            title : '一年',
                            field : 'oneYearChange',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        },  {
                            title : 'ROA',
                            field : 'roa',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '晨星评级',
                            field : 'morningstarRating',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '风险评级',
                            field : 'riskRating',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '十二个月收益率',
                            field : 'ttmyield',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            field: 'operate',
                            title: '操作',
                            events: operateEvents,//给按钮注册事件
                            formatter: addFunctionAlty,//表格中增加按钮

                            //  
                        }]

                    });
            }

            var span=document.createElement('span');
            var This=this;
            span.innerHTML='X';
            span.onclick=function(){


                /*
                    点击关闭后要做的事情
                        1、移除掉dd
                        2、把上面点击的那个class去掉
                        3、父级身上的mark属性要更新
                 */
                selected.removeChild(dd);

                This.className='';
                var sort=$("#sort .active").attr("title");
                var order=$("#order .active").attr("title");
                var change=$("#change .active").attr("title");
                if(typeof (sort)==='undefined'){
                    sort="closingPrice";
                }
                if(typeof (order)==='undefined'){
                    order="DESC";
                }
                if(typeof (change)==='undefined'){
                    change="0";
                }
                //走这里的时候说明对应的标签已经创建了，只需要把内容修改了就可以了
                dd.innerHTML=this.innerHTML;
                dd.title=this.title;
                $('#exampleTable').bootstrapTable('destroy');
                $('#exampleTable').bootstrapTable(
                    {
                        url : "/page/USAfundJuge", // 请求的后台URL（*）
                        method : 'get', // 请求方式：get/post（*）
                        showRefresh : false, // 是否显示刷新按钮
                        showToggle : false, // 是否显示详细视图和列表视图的切换按钮
                        showColumns : true, // 是否显示列操作按钮
                        detailView : false, // 是否显示详细视图
                        striped : true, // 设置为true会有隔行变色效果
                        dataType : "json", // 服务器返回的数据类型
                        pagination : true, // 设置为true会在底部显示分页条
                        // queryParamsType : "limit",
                        // 设置为limit则会发送符合RESTFull格式的参数
                        singleSelect : true, // 设置为true将禁止多选
                        clickToSelect : true, // 是否启用点击选中行

                        // contentType : "application/x-www-form-urlencoded",
                        // 发送到服务器的数据编码类型
                        pageSize : 10, // 如果设置了分页，每页数据条数
                        pageNumber : 1, // 如果设置了分布，首页页码
                        search : false, // 是否显示搜索框

                        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                        queryParams : function(params) {
                            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                                // limit: params.limit,   //页面大小
                                offset: params.offset,  //页码
                                pageSize:10,
                                limit : params.limit,
                                search:$("#search1").val(),
                                order:order,
                                sort: sort,
                                change:change,

                            };
                            return temp;
                        },
                        // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                        // queryParamsType = 'limit' ,返回参数必须包含
                        // limit, offset, search, sort, order 否则, 需要包含:
                        // pageSize, pageNumber, searchText, sortName,
                        // sortOrder.
                        // 返回false将会终止请求

                        columns : [ {
                            title : '日期',
                            field : 'date',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '代码',
                            field : 'code',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',


                        }, {
                            title : '名称',
                            field : 'fundName',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            width:80
                        }, {
                            title : '发行商',
                            field : 'company',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '收盘价',
                            field : 'closingPrice',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '增长率',
                            field : 'growthRate',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '前收盘',
                            field : 'previousClose',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '涨跌额',
                            field : 'change',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'
                        }, {
                            title : '周转率',
                            field : 'turnover',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'

                        }, {
                            title : 'ROE',
                            field : 'roe',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left',
                            class:'data-table'

                        },  {
                            title : '一年',
                            field : 'oneYearChange',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        },  {
                            title : 'ROA',
                            field : 'roa',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '晨星评级',
                            field : 'morningstarRating',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'

                        }, {
                            title : '风险评级',
                            field : 'riskRating',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            title : '十二个月收益率',
                            field : 'ttmyield',
                            align:'left',
                            halign:'left',
                            valign:'top',
                            falign:'left'
                        }, {
                            field: 'operate',
                            title: '操作',
                            events: operateEvents,//给按钮注册事件
                            formatter: addFunctionAlty,//表格中增加按钮

                            //  
                        }]

                    });
                parent.mark=false;
            };
            dd.appendChild(span);
        };
    }
}
$("#search1").bind('input porpertychange',function () {
    var sort=$("#sort .active").attr("title");
    var order=$("#order .active").attr("title");
    var change=$("#change .active").attr("title");
    if(typeof (sort)==='undefined'){
        sort="closingPrice";
    }
    if(typeof (order)==='undefined'){
        order="DESC";
    }
    if(typeof (change)==='undefined'){
        change="0";
    }
    $('#exampleTable').bootstrapTable('destroy');
    $('#exampleTable').bootstrapTable(
        {
            url : "/page/USAfundJuge", // 请求的后台URL（*）
            method : 'get', // 请求方式：get/post（*）
            showRefresh : false, // 是否显示刷新按钮
            showToggle : false, // 是否显示详细视图和列表视图的切换按钮
            showColumns : true, // 是否显示列操作按钮
            detailView : false, // 是否显示详细视图
            striped : true, // 设置为true会有隔行变色效果
            dataType : "json", // 服务器返回的数据类型
            pagination : true, // 设置为true会在底部显示分页条
            // queryParamsType : "limit",
            // 设置为limit则会发送符合RESTFull格式的参数
            singleSelect : true, // 设置为true将禁止多选
            clickToSelect : true, // 是否启用点击选中行

            // contentType : "application/x-www-form-urlencoded",
            // 发送到服务器的数据编码类型
            pageSize : 10, // 如果设置了分页，每页数据条数
            pageNumber : 1, // 如果设置了分布，首页页码
            search : false, // 是否显示搜索框

            sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
            queryParams : function(params) {
                var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    // limit: params.limit,   //页面大小
                    offset: params.offset,  //页码
                    pageSize:10,
                    limit : params.limit,
                    search:$("#search1").val(),
                    order:order,
                    sort: sort,
                    change:change,

                };
                return temp;
            },
            // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
            // queryParamsType = 'limit' ,返回参数必须包含
            // limit, offset, search, sort, order 否则, 需要包含:
            // pageSize, pageNumber, searchText, sortName,
            // sortOrder.
            // 返回false将会终止请求

            columns : [ {
                title : '日期',
                field : 'date',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'
            }, {
                title : '代码',
                field : 'code',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left',


            }, {
                title : '名称',
                field : 'fundName',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left',
                width:80
            }, {
                title : '发行商',
                field : 'company',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'
            }, {
                title : '收盘价',
                field : 'closingPrice',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'
            }, {
                title : '增长率',
                field : 'growthRate',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'
            }, {
                title : '前收盘',
                field : 'previousClose',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'

            }, {
                title : '涨跌额',
                field : 'change',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left',
                class:'data-table'
            }, {
                title : '周转率',
                field : 'turnover',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left',
                class:'data-table'

            }, {
                title : 'ROE',
                field : 'roe',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left',
                class:'data-table'

            },  {
                title : '一年',
                field : 'oneYearChange',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'

            },  {
                title : 'ROA',
                field : 'roa',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'

            }, {
                title : '晨星评级',
                field : 'morningstarRating',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'

            }, {
                title : '风险评级',
                field : 'riskRating',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'
            }, {
                title : '十二个月收益率',
                field : 'ttmyield',
                align:'left',
                halign:'left',
                valign:'top',
                falign:'left'
            }, {
                field: 'operate',
                title: '操作',
                events: operateEvents,//给按钮注册事件
                formatter: addFunctionAlty,//表格中增加按钮

                //  
            }]

        });

})