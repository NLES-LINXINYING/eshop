<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="../public/head.jsp" %>

    <style type="text/css">
        body {
            margin: 1px;
        }

        .searchbox {
            margin: -3px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                url: '/eshop/category/query', //请求数据的url地址
                method: 'post',
                loadMsg: 'Loading......',
                queryParams: {type: ''}, //参数
                fitColumns: true, //水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置
                striped: true, //显示斑马线
                nowrap: true, //当数据多的时候不换行
                singleSelect: false, // 如果为真，只允许单行显示，全选功能失效

                pagination: true, // 设置分页
                pageSize: 5, // 设置每页显示的记录数，默认是10个
                pageList: [5, 10, 15, 20], // 设置可选的每页记录数，供用户选择，默认是10,20,30,40...
                idField: 'id', // 指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页时，换页不会影响选中的项

                toolbar: [{
                    iconCls: 'icon-add',
                    text: '添加类别',
                    handler: function () {
                        // console.log("添加类别")
                        parent.$("#win").window({ //因为<div>放在了aindex.jsp中，所以这里创建窗口要先调用parent
                            title: "添加类别",
                            width: 350,
                            height: 150,
                            content: '<iframe src="/eshop/category/save.jsp" frameborder="0" width="100%" height="100%"/>'
                        });
                    }
                }, '-', {
                    iconCls: 'icon-edit',
                    text: '更新类别',
                    handler: function () {
                        //判断是否有选中行记录，使用getSelections获取选中的所有行
                        var rows = $("#dg").datagrid("getSelections");
                        if (rows.length == 0) {
                            $.messager.show({
                                title: '错误提示',
                                msg: '至少要选择一条记录',
                                timeout: 2000,
                                showType: 'slide',
                            });
                        } else if (rows.length != 1) {
                            $.messager.show({
                                title: '错误提示',
                                msg: '每次只能更新一条记录',
                                timeout: 2000,
                                showType: 'slide',
                            });
                        } else {
                            parent.$("#win").window({
                                title: "更新类别",
                                width: 350,
                                height: 250,
                                content: '<iframe src="/eshop/category/update.jsp" frameborder="0" width="100%" height="100%"/>'
                            });
                        }
                    }
                }, '-', {
                    iconCls: 'icon-remove',
                    text: '删除类别',
                    handler: function () {
                        //判断是否有选中行记录，使用getSelections获取选中的所有行
                        var rows = $("#dg").datagrid("getSelections");
                        if (rows.length == 0) {
                            //弹出提示信息
                            $.messager.show({
                                title: '错误提示',
                                msg: '至少要选择一条记录',
                                timeout: 2000,
                                showType: 'slide',
                            });
                        } else {
                            $.messager.confirm('删除的确认对话框', '您确定要删除此项吗？', function (r) {
                                if (r) {
                                    //1. 从获取的记录中获取相应的的id,拼接id的值，然后发送后台1,2,3,4
                                    var ids = "";
                                    for (var i = 0; i < rows.length; i++) {
                                        ids += rows[i].id + ",";
                                    }
                                    ids = ids.substr(0, ids.lastIndexOf(","));

                                    //2. 发送ajax请求
                                    $.post("/eshop/category/delete", {ids: ids}, function (result) {
                                        if (result == "true") {
                                            //将刚刚选中的记录删除，要不然会影响后面更新的操作
                                            $("#dg").datagrid("uncheckAll");
                                            //刷新当前页，查询的时候我们用的是load，刷新第一页，reload是刷新当前页
                                            $("#dg").datagrid("reload"); //不带参数默认为上面的queryParams
                                        } else {
                                            $.messager.show({
                                                title: '删除异常',
                                                msg: '删除失败，请检查操作',
                                                timeout: 2000,
                                                showType: 'slide',
                                            });
                                        }
                                    }, "text");
                                }
                            });
                        }
                    }
                }, '-', {
                    text: "<input id='ss' name='serach' />"
                }],

                rowStyler: function (index, row) {
                    // console.info("index" + index + "," + row)
                    if (index % 2 == 0) {
                        return 'background-color:#fff;';
                    } else {
                        return 'background-color:#ff0;';
                    }

                },

                // 同列属性，但是这些列将会冻结在左侧,大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内
                frozenColumns: [[
                    {field: 'checkbox', checkbox: true},
                    {field: 'id', title: '编号', width: 200}
                ]],

                //配置datagrid的列字段
                //field：列字段的名称，与json的key捆绑
                //title：列标题，是显示给人看的
                columns: [[
                    {
                        field: 'type', title: '类别名称', width: 100,
                        //用来格式化当前列的值，返回的是最终的数据
                        formatter: function (value, row, index) {
                            return "<span title=" + value + ">" + value + "</span>";
                        }
                    },
                    {
                        field: 'hot', title: '热卖', width: 100,
                        styler: function (value, row, index) {
                            //设置当前单元格的样式，返回的字符串直接交给 style属性
                            if (value < 20) {
                                return 'color:red;';
                            }
                        }
                    },
                    {
                        field: 'account.login', title: '所属管理员', width: 200,
                        formatter: function (value, row, index) {
                            if (row.account != null && row.account.login != null) {
                                return row.account.login; //如果登录名不为空，显示登录名
                            } else {
                                return "此类别没有管理员";
                            }
                        }
                    }
                ]]
            });

            //把普通的文本框转化为查询搜索文本框
            $('#ss').searchbox({
                //触发查询事件
                searcher: function (value, name) { //value表示输入的值
                    //alert(value + "," + name)
                    //获取当前查询的关键字，通过DataGrid加载相应的信息，使用load加载和显示第一页的所有行。
                    //如果指定了参数，它将取代'queryParams'属性。通常可以通过传递一些参数执行一次查询，通过调用这个方法会向上面url指定的action去发送请求，从服务器加载新数据。
                    $('#dg').datagrid('load', {
                        type: value
                    });

                },
                prompt: '请输入搜索关键字'
            });
        });
    </script>
</head>

<body>
<table id="dg"></table>
</body>
</html>