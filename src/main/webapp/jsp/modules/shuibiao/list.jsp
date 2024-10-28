<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">



<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">


    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <!-- layui -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<style>

</style>
<body>


    <%--  新增入入入入入入入入入入入入入入入 新增出出出出出出出出出出出出出出出 --%>
    <div class="modal fade" id="shuibiaoListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <%-- 模态框标题--%>
                <div class="modal-header">
                    <h5 class="modal-title" id="shuibiaoListModalTitle">列表</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%-- 模态框内容 --%>
                <div class="modal-body">
                    <div class="col-sm-12">
                        <%-- 当前表 --%>
                        <label class="col-sm-10">
                            用户
                            <select id="yonghuSelect" name="yonghuSelect"
                                    class="selectpicker form-control"  data-live-search="true"
                                    title="请选择" data-header="请选择" data-size="5">
                            </select>
                        </label>
                        <%-- 详情表 --%>
                        <input type="hidden" id="shuibiaoListFlag">
                        <label class="col-sm-1">
                            <button onclick="addShuibiaoList()" type="button" class="btn btn-success 新增">添加</button>
                        </label>
                    </div>
                    <%-- 列表 --%>
                    <table id="shuibiaoTable" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th >缴费前余额</th>
                            <th >缴费金额(元)</th>
                            <th >是否缴费成功</th>
                            <th >创建时间</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody id="shuibiaoListTableTbody">
                        </tbody>
                    </table>
                </div>
                <%-- 模态框按钮 --%>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" onclick="submitShuibiaoList()" class="btn btn-primary">提交</button>
                </div>
            </div>
        </div>
    </div>


    <%--  列表查看 --%>
    <div class="modal fade" id="showShuibiaoListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <%-- 模态框标题--%>
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-list-title">查看列表</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%-- 模态框内容 --%>
                <div class="modal-body">
                    <%--<div class="col-sm-12">
                        &lt;%&ndash; 当前表 &ndash;%&gt;
                        <label class="col-sm-1">
                            <button onclick="addShowShuibiaoList()" type="button" class="btn btn-success 新增">添加</button>
                        </label>
                    </div>--%>
                    <table id="inOutTableList" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th >缴费前余额</th>
                            <th >缴费金额(元)</th>
                            <th >是否缴费成功</th>
                            <th >创建时间</th>
                            <%--<th >操作</th>--%>

                        </tr>
                        </thead>
                        <tbody id="showShuibiaoListTableTbody">
                        </tbody>
                    </table>
                </div>
                <%-- 模态框按钮 --%>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <%--<button type="button" onclick="submitInOutGoods()" class="btn btn-primary">提交</button>--%>
                </div>
            </div>
        </div>
    </div>

    <%--  缴费 --%>
    <div class="modal fade" id="jiaofeiModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <%-- 模态框标题--%>
                <div class="modal-header">
                    <h5 class="modal-title">缴费</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%-- 模态框内容 --%>
                <div class="modal-body">
                    <div class="layui-inline" style="margin-bottom: 10px;">
                        缴费金额
                        <div class="layui-input-inline">
                            <input type="number" id="jiaofeiMoney" style="width: 300px;" class="form-control form-control-sm"
                                   placeholder="缴费金额" aria-controls="tableId" >
                        </div>
                    </div>

                </div>
                <%-- 模态框按钮 --%>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" onclick="jiaofeiSubmit()" class="btn btn-primary">提交</button>
                </div>
            </div>
        </div>
    </div>



    <!-- Pre Loader -->
    <div class="loading">
        <div class="spinner">
            <div class="double-bounce1"></div>
            <div class="double-bounce2"></div>
        </div>
    </div>
<!--/Pre Loader -->
    <div class="wrapper">
        <!-- Page Content -->
        <div id="content">
            <!-- Top Navigation -->
            <%@ include file="../../static/topNav.jsp" %>
            <!-- Menu -->
            <div class="container menu-nav">
                <nav class="navbar navbar-expand-lg lochana-bg text-white">
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="ti-menu text-white"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul id="navUl" class="navbar-nav mr-auto">
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- /Menu -->
            <!-- Breadcrumb -->
            <!-- Page Title -->
            <div class="container mt-0">
                <div class="row breadcrumb-bar">
                    <div class="col-md-6">
                        <h3 class="block-title">水表管理</h3>
                    </div>
                    <div class="col-md-6">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}/index.jsp">
                                    <span class="ti-home"></span>
                                </a>
                            </li>
                            <li class="breadcrumb-item">水表管理</li>
                            <li class="breadcrumb-item active">水表列表</li>
                        </ol>
                    </div>
                </div>
            </div>
            <!-- /Page Title -->

            <!-- /Breadcrumb -->
            <!-- Main Content -->
            <div class="container">

                <div class="row">
                    <!-- Widget Item -->
                    <div class="col-md-12">
                        <div class="widget-area-2 lochana-box-shadow">
                            <h3 class="widget-title">水表列表</h3>
                            <div class="table-responsive mb-3">
                                <div class="col-sm-12">
                                                                                                             
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        水表编号
                                        <div class="layui-input-inline">
                                            <input type="text" id="shuibiaoNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="水表编号" aria-controls="tableId">
                                        </div>
                                    </div>
                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        水表余额
                                        <div class="layui-input-inline">
                                            <input type="text" id="shuibiaoMoneyStartSearch" style="width: 100px;" class="form-control form-control-sm" onchange="shuibiaoMoneyChickValue(this)"
                                                   placeholder="开始" aria-controls="tableId">
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        <div class="layui-input-inline">
                                            <input type="text" id="shuibiaoMoneyEndSearch" style="width: 100px;" class="form-control form-control-sm" onchange="shuibiaoMoneyChickValue(this)"
                                                   placeholder="结束" aria-controls="tableId">
                                        </div>
                                    </div>
                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        水表编号所在地址
                                        <div class="layui-input-inline">
                                            <input type="text" id="shuibiaoAddressSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="水表编号所在地址" aria-controls="tableId">
                                        </div>
                                    </div>
                                    
                                                                                                         
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        姓名
                                        <div class="layui-input-inline">
                                            <input type="text" id="yonghuNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="姓名" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        手机号
                                        <div class="layui-input-inline">
                                            <input type="text" id="yonghuPhoneSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="手机号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        身份证号
                                        <div class="layui-input-inline">
                                            <input type="text" id="yonghuIdNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="身份证号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                             
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        余额
                                        <div class="layui-input-inline">
                                            <input type="text" id="newMoneyStartSearch" style="width: 100px;" class="form-control form-control-sm" onchange="newMoneyChickValue(this)"
                                                   placeholder="开始" aria-controls="tableId">
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        <div class="layui-input-inline">
                                            <input type="text" id="newMoneyEndSearch" style="width: 100px;" class="form-control form-control-sm" onchange="newMoneyChickValue(this)"
                                                   placeholder="结束" aria-controls="tableId">
                                        </div>
                                    </div>
                                                    
                                    <div class="layui-inline" style="margin-left: 30px;margin-bottom: 10px;">
                                        <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                        <button onclick="add()" type="button" class="btn btn-success 新增">添加</button>
                                        <%--<button onclick="outShuibiaoList()" type="button" class="btn btn-success 新增">出出出出出出出出出出出出出出出</button>--%>
                                        <button onclick="graph()" type="button" class="btn btn-success 报表">报表</button>
                                        <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                                    </div>
                                </div>
                                <table id="tableId" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="no-sort" style="min-width: 35px;">
                                            <div class="custom-control custom-checkbox">
                                                <input class="custom-control-input" type="checkbox" id="select-all"
                                                       onclick="chooseAll()">
                                                <label class="custom-control-label" for="select-all"></label>
                                            </div>
                                        </th>

                                        <th >姓名</th>
                                        <th >手机号</th>
                                        <th >身份证号</th>
                                        <th >头像</th>
                                        <th >性别</th>
                                        <th >余额</th>

                                        <th >水表编号</th>
                                        <th >水表余额</th>
                                        <th >水表编号所在地址</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="thisTbody">
                                    </tbody>
                                </table>
                                <div class="col-md-6 col-sm-3">
                                    <div class="dataTables_length" id="tableId_length">

                                        <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                                onchange="changePageSize()">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                        条 每页

                                    </div>
                                </div>
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination justify-content-end">
                                        <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                            <a class="page-link" href="#" tabindex="-1">上一页</a>
                                        </li>

                                        <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                            <a class="page-link" href="#">下一页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <!-- /Widget Item -->
                </div>
            </div>
            <!-- /Main Content -->

        </div>
        <!-- /Page Content -->
    </div>
    <!-- Back to Top -->
    <a id="back-to-top" href="#" class="back-to-top">
        <span class="ti-angle-up"></span>
    </a>
    <!-- /Back to Top -->
    <%@ include file="../../static/foot.jsp" %>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
    <script>

        <%@ include file="../../utils/menu.jsp"%>
        <%@ include file="../../static/setMenu.js"%>
        <%@ include file="../../utils/baseUrl.jsp"%>
        <%@ include file="../../static/getRoleButtons.js"%>
        <%@ include file="../../static/crossBtnControl.js"%>
        var tableName = "shuibiao";
        var pageType = "list";
        var searchForm = {key: ""};
        var pageIndex = 1;
        var pageSize = 10;
        var totalPage = 0;
        var dataList = [];
        var sortColumn = '';
        var sortOrder = '';
        var ids = [];
        var checkAll = false;

        var id = null;//查看详情中的订单id
// 当前表关联
        var yonghuOptions = [];
        var yonghu = null;
        // 详情表的关联



        <!-- 级联表的级联字典表 -->

        <!-- 本表的级联字段表 -->

        function init() {
            // 满足条件渲染提醒接口
        }

        // 改变每页记录条数
        function changePageSize() {
            var selection = document.getElementById('selectPageSize');
            var index = selection.selectedIndex;
            pageSize = selection.options[index].value;
            getDataList();
        }



        // 查询
        function search() {
            searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                         
                            //姓名
            var yonghuNameSearchInput = $('#yonghuNameSearch');
            if( yonghuNameSearchInput != null){
                if (yonghuNameSearchInput.val() != null && yonghuNameSearchInput.val() != '') {
                    searchForm.yonghuName = $('#yonghuNameSearch').val();
                }
            }
                     
                            //手机号
            var yonghuPhoneSearchInput = $('#yonghuPhoneSearch');
            if( yonghuPhoneSearchInput != null){
                if (yonghuPhoneSearchInput.val() != null && yonghuPhoneSearchInput.val() != '') {
                    searchForm.yonghuPhone = $('#yonghuPhoneSearch').val();
                }
            }
                     
                            //身份证号
            var yonghuIdNumberSearchInput = $('#yonghuIdNumberSearch');
            if( yonghuIdNumberSearchInput != null){
                if (yonghuIdNumberSearchInput.val() != null && yonghuIdNumberSearchInput.val() != '') {
                    searchForm.yonghuIdNumber = $('#yonghuIdNumberSearch').val();
                }
            }
                                                             
                        //余额
            var newMoneyStartSearchInput = $('#newMoneyStartSearch');
            if(newMoneyStartSearchInput != null){
                var newMoneyStartSearchValue = newMoneyStartSearchInput.val();
                if( newMoneyStartSearchValue  != 0){
                    searchForm.newMoneyStart = newMoneyStartSearchValue;
                }
            }
            var newMoneyEndSearchInput = $('#newMoneyEndSearch');
            if(newMoneyEndSearchInput != null){
                var newMoneyEndSearchValue = newMoneyEndSearchInput.val();
                if( newMoneyEndSearchValue  != 0){
                    searchForm.newMoneyEnd = newMoneyEndSearchValue;
                }
            }
                        <!-- 本表的查询条件 -->

             
            //水表编号
            var shuibiaoNumberSearchInput = $('#shuibiaoNumberSearch');
            if( shuibiaoNumberSearchInput != null){
                if (shuibiaoNumberSearchInput.val() != null && shuibiaoNumberSearchInput.val() != '') {
                    searchForm.shuibiaoNumber = $('#shuibiaoNumberSearch').val();
                }
            }
     
            //水表余额
            var shuibiaoMoneyStartSearchInput = $('#shuibiaoMoneyStartSearch');
            if(shuibiaoMoneyStartSearchInput != null){
                var shuibiaoMoneyStartSearchValue = shuibiaoMoneyStartSearchInput.val();
                if( shuibiaoMoneyStartSearchValue  != 0){
                    searchForm.shuibiaoMoneyStart = shuibiaoMoneyStartSearchValue;
                }
            }
            var shuibiaoMoneyEndSearchInput = $('#shuibiaoMoneyEndSearch');
            if(shuibiaoMoneyEndSearchInput != null){
                var shuibiaoMoneyEndSearchValue = shuibiaoMoneyEndSearchInput.val();
                if( shuibiaoMoneyEndSearchValue  != 0){
                    searchForm.shuibiaoMoneyEnd = shuibiaoMoneyEndSearchValue;
                }
            }
     
            //水表编号所在地址
            var shuibiaoAddressSearchInput = $('#shuibiaoAddressSearch');
            if( shuibiaoAddressSearchInput != null){
                if (shuibiaoAddressSearchInput.val() != null && shuibiaoAddressSearchInput.val() != '') {
                    searchForm.shuibiaoAddress = $('#shuibiaoAddressSearch').val();
                }
            }
                getDataList();
        }

        // 获取数据列表
        function getDataList() {
            http("shuibiao/page", "GET", {
                page: pageIndex,
                limit: pageSize,
                sort: sortColumn,
                order: sortOrder,
                //本表的
                shuibiaoNumber: searchForm.shuibiaoNumber,
                shuibiaoMoneyStart: searchForm.shuibiaoMoneyStart,
                shuibiaoMoneyEnd: searchForm.shuibiaoMoneyEnd,
                shuibiaoAddress: searchForm.shuibiaoAddress,
            //级联表的
                yonghuName: searchForm.yonghuName,
                yonghuPhone: searchForm.yonghuPhone,
                yonghuIdNumber: searchForm.yonghuIdNumber,
                newMoneyStart: searchForm.newMoneyStart,
                newMoneyEnd: searchForm.newMoneyEnd,


            }, (res) => {
                if(res.code == 0) {
                    clear();
                    $("#thisTbody").html("");
                    dataList = res.data.list;
                    totalPage = res.data.totalPage;
                    for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                        var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                        $('#thisTbody').append(trow);
                    }
                    pagination(); //渲染翻页组件
                    getRoleButtons();// 权限按钮控制
                }
            });
        }

        // 渲染表格数据
        function setDataRow(item, number) {
            //创建行 
            var row = document.createElement('tr');
            row.setAttribute('class', 'useOnce');
            //创建勾选框
            var checkbox = document.createElement('td');
            var checkboxDiv = document.createElement('div');
            checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
            var checkboxInput = document.createElement('input');
            checkboxInput.setAttribute("class", "custom-control-input");
            checkboxInput.setAttribute("type", "checkbox");
            checkboxInput.setAttribute('name', 'chk');
            checkboxInput.setAttribute('value', item.id);
            checkboxInput.setAttribute("id", number);
            checkboxDiv.appendChild(checkboxInput);
            var checkboxLabel = document.createElement('label');
            checkboxLabel.setAttribute("class", "custom-control-label");
            checkboxLabel.setAttribute("for", number);
            checkboxDiv.appendChild(checkboxLabel);
            checkbox.appendChild(checkboxDiv);
            row.appendChild(checkbox)


                    //姓名
            var yonghuNameCell = document.createElement('td');
            yonghuNameCell.innerHTML = item.yonghuName;
            row.appendChild(yonghuNameCell);


                    //手机号
            var yonghuPhoneCell = document.createElement('td');
            yonghuPhoneCell.innerHTML = item.yonghuPhone;
            row.appendChild(yonghuPhoneCell);


                    //身份证号
            var yonghuIdNumberCell = document.createElement('td');
            yonghuIdNumberCell.innerHTML = item.yonghuIdNumber;
            row.appendChild(yonghuIdNumberCell);


                //头像
            var yonghuPhotoCell = document.createElement('td');
            var yonghuPhotoImg = document.createElement('img');
            var yonghuPhotoImgValue = item.yonghuPhoto;
            if(yonghuPhotoImgValue !=null && yonghuPhotoImgValue !='' && yonghuPhotoImgValue !='null'){
                    yonghuPhotoImg.setAttribute('src', yonghuPhotoImgValue);
                    yonghuPhotoImg.setAttribute('height', 100);
                    yonghuPhotoImg.setAttribute('width', 100);
                    yonghuPhotoCell.appendChild(yonghuPhotoImg);
            }else{
                    yonghuPhotoCell.innerHTML = "暂无图片";
            }
            row.appendChild(yonghuPhotoCell);

                        //性别
            var sexTypesCell = document.createElement('td');
            sexTypesCell.innerHTML = item.sexValue;
            row.appendChild(sexTypesCell);


                    //余额
            var newMoneyCell = document.createElement('td');
            newMoneyCell.innerHTML = item.newMoney;
            row.appendChild(newMoneyCell);



            //水表编号
            var shuibiaoNumberCell = document.createElement('td');
            shuibiaoNumberCell.innerHTML = item.shuibiaoNumber;
            row.appendChild(shuibiaoNumberCell);


            //水表余额
            var shuibiaoMoneyCell = document.createElement('td');
            shuibiaoMoneyCell.innerHTML = item.shuibiaoMoney;
            row.appendChild(shuibiaoMoneyCell);


            //水表编号所在地址
            var shuibiaoAddressCell = document.createElement('td');
            shuibiaoAddressCell.innerHTML = item.shuibiaoAddress;
            row.appendChild(shuibiaoAddressCell);



            //每行按钮
            var btnGroup = document.createElement('td');

            //详情按钮
            var detailBtn = document.createElement('button');
            var detailAttr = "detail(" + item.id + ')';
            detailBtn.setAttribute("type", "button");
            detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
            detailBtn.setAttribute("onclick", detailAttr);
            detailBtn.innerHTML = "查看";
            btnGroup.appendChild(detailBtn);
            //修改按钮
            var editBtn = document.createElement('button');
            var editAttr = 'edit(' + item.id + ')';
            editBtn.setAttribute("type", "button");
            editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
            editBtn.setAttribute("onclick", editAttr);
            editBtn.innerHTML = "修改";
            btnGroup.appendChild(editBtn);
            //查看订单详情
            var detailListBtn = document.createElement('button');
            var detailListAttr = "getId(" + item.id+')';
            detailListBtn.setAttribute("type", "button");
            detailListBtn.setAttribute("class", "btn btn-info btn-sm 新增");
            detailListBtn.setAttribute("onclick", detailListAttr);
            detailListBtn.innerHTML = "查看缴费详情";
            btnGroup.appendChild(detailListBtn);

            //缴费
            var detailListBtn = document.createElement('button');
            var detailListAttr = "jiaofei(" + item.id+')';
            detailListBtn.setAttribute("type", "button");
            detailListBtn.setAttribute("class", "btn btn-info btn-sm 新增");
            detailListBtn.setAttribute("onclick", detailListAttr);
            detailListBtn.innerHTML = "缴费";
            btnGroup.appendChild(detailListBtn);

            //删除按钮
            var deleteBtn = document.createElement('button');
            var deleteAttr = 'remove(' + item.id + ')';
            deleteBtn.setAttribute("type", "button");
            deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            deleteBtn.setAttribute("onclick", deleteAttr);
            deleteBtn.innerHTML = "删除";
            btnGroup.appendChild(deleteBtn);
            row.appendChild(btnGroup);

            return row;
    }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            // 小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


            //小数
            function shuibiaoMoneyChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("只允许输入整数6位,小数2位的数字");
                    return false;
                }
            }


        // 翻页
        function pageNumChange(val) {
            if (val == 'pre') {
                pageIndex--;
            } else if (val == 'next') {
                pageIndex++;
            } else {
                pageIndex = val;
            }
            getDataList();
        }

        // 下载
        function download(url) {
            window.open(url);
        }
        // 打开新窗口播放媒体
        function mediaPlay(url){
            window.open(url);
        }

        // 渲染翻页组件
        function pagination() {
            var beginIndex = pageIndex;
            var endIndex = pageIndex;
            var point = 4;
            //计算页码
            for (var i = 0; i < 3; i++) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            for (var i = 0; i < 3; i++) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--;
            }
            if (point > 0) {
                while (point > 0) {
                    if (endIndex == totalPage) {
                        break;
                    }
                    endIndex++;
                    point--;
                }
                while (point > 0) {
                    if (beginIndex == 1) {
                        break;
                    }
                    beginIndex--;
                    point--
                }
            }
            // 是否显示 前一页 按钮
            if (pageIndex > 1) {
                $('#tableId_previous').show();
            } else {
                $('#tableId_previous').hide();
            }
            // 渲染页码按钮
            for (var i = beginIndex; i <= endIndex; i++) {
                var pageNum = document.createElement('li');
                pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
                if (pageIndex == i) {
                    pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
                } else {
                    pageNum.setAttribute('class', 'paginate_button page-item useOnce');
                }
                var pageHref = document.createElement('a');
                pageHref.setAttribute('class', 'page-link');
                pageHref.setAttribute('href', '#');
                pageHref.setAttribute('aria-controls', 'tableId');
                pageHref.setAttribute('data-dt-idx', i);
                pageHref.setAttribute('tabindex', 0);
                pageHref.innerHTML = i;
                pageNum.appendChild(pageHref);
                $('#tableId_next').before(pageNum);
            }
            // 是否显示 下一页 按钮
            if (pageIndex < totalPage) {
                $('#tableId_next').show();
                $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
            } else {
                $('#tableId_next').hide();
            }
            var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
            $('#tableId_info').html(pageNumInfo);
        }

        // 跳转到指定页
        function toThatPage() {
            //var index = document.getElementById('pageIndexInput').value;
            if (index < 0 || index > totalPage) {
                alert('请输入正确的页码');
            } else {
                pageNumChange(index);
            }
        }

        // 全选/全不选
        function chooseAll() {
            checkAll = !checkAll;
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                boxs[i].checked = checkAll;
            }
        }

        // 批量删除
        function deleteMore() {
            ids = []
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                if (boxs[i].checked) {
                    ids.push(boxs[i].value)
                }
            }
            if (ids.length == 0) {
                alert('请勾选要删除的记录');
            } else {
                remove(ids);
            }
        }

        // 删除
        function remove(id) {
            var mymessage = confirm("真的要删除吗,会级联删除缴费记录？");
            if (mymessage == true) {
                var paramArray = [];
                if (id == ids) {
                    paramArray = id;
                } else {
                    paramArray.push(id);
                }
                httpJson("shuibiao/delete", "POST", paramArray, (res) => {
                    if(res.code == 0){
                        getDataList();
                        alert('删除成功');
                    }
                });
            } else {
                alert("已取消操作");
            }
        }

        // 用户登出
        <%@ include file="../../static/logout.jsp"%>

        //修改
        function edit(id) {
            window.sessionStorage.setItem('updateId', id)
            window.location.href = "add-or-update.jsp"
        }

        //清除会重复渲染的节点
        function clear() {
            var elements = document.getElementsByClassName('useOnce');
            for (var i = elements.length - 1; i >= 0; i--) {
                elements[i].parentNode.removeChild(elements[i]);
            }
        }

        //添加
        function add() {
            window.sessionStorage.setItem("addshuibiao", "addshuibiao");
            window.location.href = "add-or-update.jsp"
        }

        //报表
        function graph() {
            window.location.href = "graph.jsp"
        }

        // 查看详情
        function detail(id) {
            window.sessionStorage.setItem("updateId", id);
            window.location.href = "info.jsp";
        }

    //填充级联表搜索下拉框
                                         
                     
                     
                                                             
                    
    //填充本表搜索下拉框
             
     
     
    
    //查询级联表搜索条件所有列表

    //查询当前表搜索条件所有列表











        // 新增入入入入入入入入入入入入入入入 新增出出出出出出出出出出出出出出出

        //出出出出出出出出出出出出出出出
        function outShuibiaoList() {
            document.getElementById("shuibiaoListModalTitle").innerHTML = "出出出出出出出出出出出出出出出列表";
            $("#shuibiaoListFlag").val(2);
            $('#shuibiaoListModal').modal('show');
        }
        //入入入入入入入入入入入入入入入
        function inShuibiaoList() {
            document.getElementById("shuibiaoListModalTitle").innerHTML = "入入入入入入入入入入入入入入入列表";
            $("#shuibiaoListFlag").val(1);
            $('#shuibiaoListModal').modal('show');

        }

        // 模态框打开
        $('#shuibiaoListModal').on('show.bs.modal', function () {

            // 当前表
            yonghuSelect();
            initializationYonghuSelect();
            // 详情表
            $(".selectpicker" ).selectpicker('refresh');
        });
        // 模态框关闭
        $('#shuibiaoListModal').on('hide.bs.modal', function () {
            $("#shuibiaoListModalTitle").val("")
            $("#shuibiaoListFlag").val(0);
            $("#shuibiaoName").val("");
            $("#shuibiaoListTableTbody").html("");
            // 当前表
            $("#yonghuSelect").empty();
            // 详情表
            $(".selectpicker" ).selectpicker('refresh');
        });

        // 当前表
            // 模态框的 用户初始化和查询
        function yonghuSelect() {
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }
        function initializationYonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].yonghuName, yonghuOptions[i].id));
                }
            }
            $("#yonghuSelect").change(function(e) {
                var id = e.target.value;
                http("yonghu/info/"+id, "GET", {}, (res) => {
                    if(res.code == 0){
                        yonghu = res.data;
                    }
                });
            });
        }

        // 详情表

        // 模态框的添加按钮
        function addShuibiaoList() {
        }

        // 添加水表缴费记录到待提交列表
        function setShuibiaoListDataRow(item) {
            //创建行 
            var row = document.createElement('tr');
                //缴费前余额
            var shuibiaoListOldMoneyCell = document.createElement('td');
            shuibiaoListOldMoneyCell.innerHTML = item.shuibiaoListOldMoney;
            row.appendChild(shuibiaoListOldMoneyCell);
                //缴费金额(元)  
            var shuibiaoListNewMoneyCell = document.createElement('td');
            shuibiaoListNewMoneyCell.innerHTML = item.shuibiaoListNewMoney;
            row.appendChild(shuibiaoListNewMoneyCell);
                //是否缴费成功  
            var successTypesCell = document.createElement('td');
            successTypesCell.innerHTML = item.successValue;
            row.appendChild(successTypesCell);
                //创建时间
            var createTimeCell = document.createElement('td');
            createTimeCell.innerHTML = item.createTime;
            row.appendChild(createTimeCell);


            //每行按钮
            var btnGroup = document.createElement('td');
            //删除按钮
            var deleteBtn = document.createElement('button');
            deleteBtn.setAttribute("type", "button");
            deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            deleteBtn.setAttribute("onclick","removeShowShuibiaoOne("+item.id+")");
            deleteBtn.innerHTML = "删除";
            btnGroup.appendChild(deleteBtn);

            row.appendChild(btnGroup);

            return row;
        }

        function chickShuibiaoNumber(e,id){
            var this_val = e.value || 0;
            if(this_val == 0){
                e.value = "";
                alert("数量为0无意义");
                return false;
            }
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只能输入正整数数字");
                return false;
            }
            var tdid = "#td"+id;
            var number = $(tdid).text();
            if(number==null || number==""){
                alert("商品数量不正确,请进入商品中修改该商品数量");
                return false;
            }
        }

        function removeShuibiaoOne(id) {
            var rowId = "#rowId"+ id;
            $(rowId).remove();

        }

        // 提交操作
        function submitShuibiaoList() {

            var elementsByName = document.getElementsByName("inputNumber"); // 获取当前模态框表格中输入的input值
            var flag=false;// 用于判断是否有输入为空或者0这种无意义参数情况
            let map = {};//map就是传到后台的值,key:id value:数字
            for (var i = 0; i < elementsByName.length; i++) { //遍历一下表格数据  
                var value = elementsByName[i].value;
                if(value ==null || value =="" ||  value =="null" || value == 0){
                    flag=true;
                }else{
                    var id = parseInt(elementsByName[i].id.replace("inputId",""));
                    map[id]=parseInt(value);
                }
            }
            if(flag){
                alert("数量中有空或者为0情况");
                return false;
            }

            var flag = parseInt($("#shuibiaoListFlag").val());
            var urlParam=null;



            var msg=null;
            if(flag==1){
                urlParam="inShuibiaoList";
                msg="入入入入入入入入入入入入入入入成功";
            }else if(flag==2){
                urlParam="outShuibiaoList";
                msg="出出出出出出出出出出出出出出出成功";
            }else{
                alert("未知错误,请联系管理员");
                return false;
            }
            if(map == null || Object.keys(map).length==0){
                alert("不允许添加空值");
                return false;
            }

            httpJson("shuibiao/" + urlParam, "POST", {
                map : map,
                shuibiaoName : shuibiaoName,
                // 当前表表关联
                yonghuId : $('#yonghuSelect option:selected').val(),//把下拉框选中的值传过去,没有就传个空
        }, (res) => {
                if(res.code == 0){
                    alert(msg);
                    $('#shuibiaoListModal').modal('hide');
                    getDataList();
                }else{
                    alert(res.msg);
                }
            });
        }







        //列表查看
        // 获取选择的列表的id
        function getId(thisId) {
            if(thisId == null || thisId=="" || thisId=="null"){
                alert("未知错误,请联系管理员处理");
                return;
            }
            id=thisId;
            $('#showShuibiaoListModal').modal('show');
        }

        //模态框打开的时候会执行这个里面的东西
        $('#showShuibiaoListModal').on('show.bs.modal', function () {
            //清理表格内容,防止重复回显
            $("#showShuibiaoListTableTbody").html("");
            if(id ==null){
                alert("获取当前列id错误,请联系管理员处理");
                $('#showShuibiaoListModal').modal('hide');
                return;
            }
            // 当前表
            yonghuSelect();//查询列表
            initializationYonghuSelect();//列表赋值
            //详情表
            $(".selectpicker" ).selectpicker('refresh');//刷新赋值,否则下拉框还是原来的内容
            showShuibiaoList();//查询数据列表
        });
        //模态框关闭的时候会执行这个里面的东西
        $('#showShuibiaoListModal').on('hide.bs.modal', function () {
            $("#showShuibiaoListTableTbody").html("");
            id=null;

                // 当前表
            $("#yonghuSelect").empty();//置位空,下次打开模态框再重新查,
            $("#yonghuName").val("");
                //详情表
            $(".selectpicker" ).selectpicker('refresh');//刷新赋值,否则下拉框还是原来的内容
            getDataList();
        });

        // 查询所有数据
        function showShuibiaoList() {

            // 当前表的级联表 id定义
            var yonghuId = "";
            // 查询当前数据详情
            http("shuibiao/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                // 当前表的级联表id赋值
                yonghuId = res.data.yonghuId;
                }
            });

            // 查询当前表级联表的数据
            if(yonghuId != null && yonghuId != "" && yonghuId != "null"){
                http("yonghu/info/"+yonghuId, "GET", {}, (res) => {
                    if(res.code == 0){
                        yonghu = res.data;
                        $("#yonghuName").val(yonghu.yonghuName);
                    }
                });
            }


            //查询列表详情
            http("shuibiaoList/page", "GET", {
                page: 1,
                limit: 100,
                shuibiaoId: id,
            }, (res) => {
                if(res.code == 0){
                    var list = res.data.list;
                    $("#showShuibiaoListTableTbody").html("");
                    for (var i = 0; i < list.length; i++) { //遍历一下表格数据  
                        var trow = setShowShuibiaoListDataRow(list[i]); //在 setShowShuibiaoListDataRow 中拼接数据,然后返回再追加到列表中
                        $('#showShuibiaoListTableTbody').append(trow);
                    }
                }else{
                    alert("查询列表错误,请联系管理员处理");
                    $('#showShuibiaoListModal').modal('hide');
                    return;
                }
            });
        }

        // 列表回显
        function setShowShuibiaoListDataRow(item) {
            //创建行 
            var row = document.createElement('tr');
                //缴费前余额
            var shuibiaoListOldMoneyCell = document.createElement('td');
            shuibiaoListOldMoneyCell.innerHTML = item.shuibiaoListOldMoney;
            row.appendChild(shuibiaoListOldMoneyCell);
                //缴费金额(元)  
            var shuibiaoListNewMoneyCell = document.createElement('td');
            shuibiaoListNewMoneyCell.innerHTML = item.shuibiaoListNewMoney;
            row.appendChild(shuibiaoListNewMoneyCell);
                //是否缴费成功  
            var successTypesCell = document.createElement('td');
            successTypesCell.innerHTML = item.successValue;
            row.appendChild(successTypesCell);
                //创建时间
            var createTimeCell = document.createElement('td');
            createTimeCell.innerHTML = item.createTime;
            row.appendChild(createTimeCell);


            // //每行按钮
            // var btnGroup = document.createElement('td');
            // //删除按钮
            // var deleteBtn = document.createElement('button');
            // deleteBtn.setAttribute("type", "button");
            // deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            // deleteBtn.setAttribute("onclick","removeShowShuibiaoOne("+item.id+")");
            // deleteBtn.innerHTML = "删除";
            // btnGroup.appendChild(deleteBtn);
            //
            // row.appendChild(btnGroup);

            return row;
        }

        // 删除
        function removeShowShuibiaoOne(id) {
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
                httpJson("shuibiaoList/delete?id="+id, "GET",null, (res) => {
                    if(res.code == 0){
                    alert('删除成功');
                    showShuibiaoList();
                }else{
                    alert(res.msg);
                }
            });
            } else {
                alert("已取消操作");
            }
        }

        //新增
        function addShowShuibiaoList() {
            httpJson("shuibiaoList/save", "POST", paramArray, (res) => {
                if(res.code == 0){
                    alert('新增成功');
                    showShuibiaoList();
                }else{
                    alert(res.msg);
                }
            });
        }



        //缴费
        function jiaofei(thisId) {
            if(thisId == null || thisId=="" || thisId=="null"){
                alert("未知错误,请联系管理员处理");
                return;
            }
            id=thisId;
            $('#jiaofeiModal').modal('show');
        }

        //模态框打开的时候会执行这个里面的东西
        $('#jiaofeiModal').on('show.bs.modal', function () {
            $("#jiaofeiMoney").val("");
        });
        //模态框关闭的时候会执行这个里面的东西
        $('#jiaofeiModal').on('hide.bs.modal', function () {
            $("#jiaofeiMoney").val("");
        });

        // 提交操作
        function jiaofeiSubmit() {
            var jiaofeiMoney = $("#jiaofeiMoney").val();
            if(jiaofeiMoney == null ||jiaofeiMoney == ""){
                alert("不允许缴费金额为空");
                return false;
            }

            httpJson("shuibiao/jiaofei", "POST", {
                jiaofeiMoney : jiaofeiMoney,
                id : id
            }, (res) => {
                if(res.code == 0){
                alert("缴费成功");
                $('#jiaofeiModal').modal('hide');
                getDataList();
            }else{
                alert(res.msg);
            }
        });
        }


        $(document).ready(function () {
            //激活翻页按钮
            $('#tableId_previous').attr('class', 'paginate_button page-item previous')
            $('#tableId_next').attr('class', 'paginate_button page-item next')
            //隐藏原生搜索框
            $('#tableId_filter').hide()
            //设置右上角用户名
            $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
            //设置项目名
            $('.sidebar-header h3 a').html(projectName)
            setMenu();
            init();

            //查询级联表的搜索下拉框

            //查询当前表的搜索下拉框
            getDataList();

        //级联表的下拉框赋值
                                                 
                         
                         
                                                                         
                        
        //当前表的下拉框赋值
                                     
             
             
            
        <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>