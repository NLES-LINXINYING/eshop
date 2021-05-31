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
                url: '/eshop/product/query', //请求数据的url地址
                method: 'post',
                loadMsg: 'Loading......',
                queryParams: {name: ''},
                fitColumns: true, //水平自动展开，如果设置此属性则不会有水平滚动条
                striped: true, //显示斑马线
                nowrap: true, //当数据多的时候不换行
                singleSelect: false, // 如果为真，只允许单行显示，全选功能失效

                pagination: true, // 设置分页
                pageSize: 5, // 设置每页显示的记录数，默认是10个
                pageList: [5, 10, 15, 20], // 设置可选的每页记录数，供用户选择，默认是10,20,30,40...
                idField: 'id', // 指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页时，换页不会影响选中的项

                toolbar: [{
                    /*iconCls: 'icon-add',
                    text: '添加商品',
                    handler: function () {
                        parent.$("#win").window({
                            title: "添加商品",
                            width: 350,
                            height: 150,
                            content: '<iframe src="/eshop/product/save.jsp" frameborder="0" width="100%" height="100%"/>'
                        });
                    }*/
                }, '-', {
                    iconCls: 'icon-edit',
                    text: '更新商品',
                    handler: function () {
                        /*var rows = $("#dg").datagrid("getSelections");
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
                                title: "更新商品",
                                width: 350,
                                height: 250,
                                content: '<iframe src="/eshop/category/update.jsp" frameborder="0" width="100%" height="100%"/>'
                            });
                        }*/
                    }
                }, '-', {
                    iconCls: 'icon-remove',
                    text: '删除商品',
                    handler: function () {
                        /*var rows = $("#dg").datagrid("getSelections");
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
                        }*/
                    }
                }, '-', {
                    text: "<input id='ss' name='serach' />"
                }],

                rowStyler: function (index, row) {
                    if (index % 2 == 0) {
                        return 'background-color:#fff;';
                    } else {
                        return 'background-color:#ff0;';
                    }

                },

                // 同列属性，但是这些列将会冻结在左侧,大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内
                frozenColumns: [[
                    {field: 'checkbox', checkbox: true},
                    {field: 'id', title: '商品编号', width: 200}
                ]],

                //field：列字段的名称，与json的key捆绑
                //title：列标题，是显示给人看的
                columns: [[
                    {field: 'name', title: '商品名称', width: 100},
                    {field: 'price', title: '商品价格', width: 100},
                    {field: 'remark', title: '商品简述', width: 100},
                    {field: 'xremark', title: '商品详情', width: 100},
                    {field: 'date', title: '上架时间', width: 100},
                    {
                        field: 'commend', title: '推荐商品', width: 100,
                        styler: function (value, row, index) {
                            if(value) {
                                return "<input type='checkbox' checked='true' disabled='true' />";
                            } else {
                                return "<input type='checkbox' checked='true' disabled='true' />";
                            }
                        }
                    },
                    {
                        field: 'open', title: '有效商品', width: 100,
                        styler: function (value, row, index) {
                            if(value) {
                                return "<input type='checkbox' checked='checked' disabled='true' />";
                            } else {
                                return "<input type='checkbox' disabled='true' />";
                            }
                        }
                    },
                    {
                        field: 'category.type', title: '所属商品类别', width: 200,
                        formatter: function (value, row, index) {
                            if (row.category != null && row.category.type != null) {
                                return row.category.type;
                            } else {
                                return "此商品暂时没有分类";
                            }
                        }
                    }
                ]]
            });

            //把普通的文本框转化为查询搜索文本框
            $('#ss').searchbox({
                //触发查询事件
                searcher: function (value, name) { //value表示输入的值
                    $('#dg').datagrid('load', {
                        name: value
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