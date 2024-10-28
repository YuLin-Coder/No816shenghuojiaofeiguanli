<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
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
                    <h3 class="block-title">编辑水表缴费记录</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">水表缴费记录管理</li>
                        <li class="breadcrumb-item active">编辑水表缴费记录</li>
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
                        <h3 class="widget-title">水表缴费记录信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6">
                                        <label>水表</label>
                                        <div>
                                            <select id="shuibiaoSelect" name="shuibiaoSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>用户</label>
                                        <input id="yonghuId" name="yonghuId" class="form-control"
                                               placeholder="用户" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>水表编号</label>
                                        <input id="shuibiaoNumber" name="shuibiaoNumber" class="form-control"
                                               placeholder="水表编号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>水表余额</label>
                                        <input id="shuibiaoMoney" name="shuibiaoMoney" class="form-control"
                                               placeholder="水表余额" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>水表编号所在地址</label>
                                        <input id="shuibiaoAddress" name="shuibiaoAddress" class="form-control"
                                               placeholder="水表编号所在地址" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="shuibiaoId" name="shuibiaoId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>缴费前余额</label>
                                        <input id="shuibiaoListOldMoney" name="shuibiaoListOldMoney" class="form-control"
                                               onchange="shuibiaoListOldMoneyChickValue(this)" placeholder="缴费前余额">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>缴费金额(元)</label>
                                        <input id="shuibiaoListNewMoney" name="shuibiaoListNewMoney" class="form-control"
                                               onchange="shuibiaoListNewMoneyChickValue(this)" placeholder="缴费金额(元)">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>是否缴费成功</label>
                                        <select id="successTypesSelect" name="successTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
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
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "shuibiaoList";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var successTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var shuibiaoOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#shuibiaoId") !=null){
               var shuibiaoId = $("#shuibiaoId").val();
               if(shuibiaoId == null || shuibiaoId =='' || shuibiaoId == 'null'){
                   alert("用户不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';
            }
            httpJson("shuibiaoList/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addshuibiaoList');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function successTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=success_types", "GET", {}, (res) => {
                if(res.code == 0){
                    successTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function shuibiaoSelect() {
            //填充下拉框选项
            http("shuibiao/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    shuibiaoOptions = res.data.list;
                }
            });
        }

        function shuibiaoSelectOne(id) {
            http("shuibiao/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                shuibiaoShowImg();
                shuibiaoShowVideo();
                shuibiaoDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationSuccesstypesSelect(){
            var successTypesSelect = document.getElementById('successTypesSelect');
            if(successTypesSelect != null && successTypesOptions != null  && successTypesOptions.length > 0 ){
                for (var i = 0; i < successTypesOptions.length; i++) {
                    successTypesSelect.add(new Option(successTypesOptions[i].indexName,successTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationshuibiaoSelect() {
            var shuibiaoSelect = document.getElementById('shuibiaoSelect');
            if(shuibiaoSelect != null && shuibiaoOptions != null  && shuibiaoOptions.length > 0 ) {
                for (var i = 0; i < shuibiaoOptions.length; i++) {
                        shuibiaoSelect.add(new Option(shuibiaoOptions[i].shuibiaoName, shuibiaoOptions[i].id));
                }

                $("#shuibiaoSelect").change(function(e) {
                        shuibiaoSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var successTypesSelect = document.getElementById("successTypesSelect");
        if(successTypesSelect != null && successTypesOptions != null  && successTypesOptions.length > 0 ) {
            for (var i = 0; i < successTypesOptions.length; i++) {
                if (successTypesOptions[i].codeIndex == ruleForm.successTypes) {//下拉框value对比,如果一致就赋值汉字
                        successTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var shuibiaoSelect = document.getElementById("shuibiaoSelect");
            if(shuibiaoSelect != null && shuibiaoOptions != null  && shuibiaoOptions.length > 0 ) {
                for (var i = 0; i < shuibiaoOptions.length; i++) {
                    if (shuibiaoOptions[i].id == ruleForm.shuibiaoId) {//下拉框value对比,如果一致就赋值汉字
                        shuibiaoSelect.options[i+1].selected = true;
                        $("#shuibiaoSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function shuibiaoListOldMoneyChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }
        function shuibiaoListNewMoneyChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addshuibiaoList');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                shuibiaoId: "required",
                shuibiaoListOldMoney: "required",
                shuibiaoListNewMoney: "required",
                insertTime: "required",
                successTypes: "required",
            },
            messages: {
                shuibiaoId: "用户不能为空",
                shuibiaoListOldMoney: "缴费前余额不能为空",
                shuibiaoListNewMoney: "缴费金额(元)不能为空",
                insertTime: "缴费时间不能为空",
                successTypes: "是否缴费成功不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addshuibiaoList = window.sessionStorage.getItem("addshuibiaoList");
        if (addshuibiaoList != null && addshuibiaoList != "" && addshuibiaoList != "null") {
            window.sessionStorage.removeItem('addshuibiaoList');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("shuibiaoList/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        shuibiaoDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#shuibiaoId").val(ruleForm.shuibiaoId);
        $("#shuibiaoListOldMoney").val(ruleForm.shuibiaoListOldMoney);
        $("#shuibiaoListNewMoney").val(ruleForm.shuibiaoListNewMoney);
        $("#insertTime-input").val(ruleForm.insertTime);

    }
    <!--  级联表的数据回显  -->
    function shuibiaoDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#shuibiaoId").val(ruleForm.id);

        $("#yonghuId").val(ruleForm.yonghuId);
        $("#shuibiaoNumber").val(ruleForm.shuibiaoNumber);
        $("#shuibiaoMoney").val(ruleForm.shuibiaoMoney);
        $("#shuibiaoAddress").val(ruleForm.shuibiaoAddress);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        shuibiaoShowImg();
    }


    <!--  级联表的图片  -->

    function shuibiaoShowImg() {
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        shuibiaoShowVideo();
    }


    <!--  级联表的视频  -->

    function shuibiaoShowVideo() {
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            successTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            shuibiaoSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationSuccesstypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationshuibiaoSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>