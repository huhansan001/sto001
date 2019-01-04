<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>
</head>
<body>
	<table class="layui-hide" id="stoEmp" lay-filter="stoEmp"></table>

	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs layui-btn-warm"lay-event="look"><i class="layui-icon">&#xe642;</i>查看角色</a>
  		<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
	<script type="text/html" id="insert">
		<div class="layui-btn-container">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="insert"><i class="layui-icon">&#xe608;</i>新增</button>
			<button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="deletep"><i class="layui-icon">&#xe640;</i>批量删除</button>
		</div>
	</script>
	<script type="text/html" id="switchTpl">
		<input type="checkbox" name="empState" value="{{d.empNo}}" lay-skin="switch" lay-text="启用|停用"  lay-filter="sexDemo" {{ d.empState == '启用' ? 'checked' : '' }}>
	</script>

	<!-- 需要弹出的添加员工界面  -->
	<div class="layui-row" id="pnal" style="display: none;">
		<div class="layui-col-md10">
			<form action="empAdd.action" class="layui-form" id="addEmp">
				<div class="layui-form-item">
					<label class="layui-form-label">员工编号：</label>
					<div class="layui-input-block">
						<input  lay-verify="res" type="text" name="empNo" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">员工姓名：</label>
					<div class="layui-input-block">
						<input lay-verify="res" type="text" name="empName" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">入职日期：</label>
					<div class="layui-input-block">
						<input lay-verify="res" type="text" name="empDate" class="layui-input" id="dates"
							placeholder="yyyy-MM-dd HH:mm:ss">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">员工账号：</label>
					<div class="layui-input-block">
						<input lay-verify="res" type="text" name="posi_account" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码：</label>
					<div class="layui-input-block">
						<input lay-verify="res" type="text" lay-filter="dat" name="posi_pass"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">员工状态：</label>
					<div class="layui-input-inline">
						<select name="empState">
							<option value="启用">启用</option>
							<option value="停用">停用</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 50px">
					<div class="layui-input-block">
						<button type="button" lay-submit=""
							class="layui-btn layui-btn-sm layui-btn-normal"  lay-filter="saveStoEmp">保存</button>
						<button type="button"
							class="layui-btn layui-btn-sm layui-btn-warm layui-layer-close layui-layer-close1">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>



	<!-- js代码 -->
	<script>
		layui.use(['form','element','layedit','jquery','layer'], function(){
			var form=layui.form,
			layer = layui.layer,
			element=layui.element,
			table = layui.table,
			$=layui.jquery;
			//表单验证
			form.verify({
				res:function(value){
					if(value.length<1){
						return'必填项不能为空';
					}
				}
			});
			//提交表单
			form.on('submit(saveStoEmp)',function(data){
			$.ajax({
				type:'post',
				url:'insertStoEmp.action',
				data:data.field,
				success:function(msg){
					if(msg=='ok'){
					 window.location.href="stoEmp.jsp";
					}
				}
			});
			return true;
		});
			//添加下拉列表
			form.render('select');
			//监听员工状态操作
			form.on('switch(sexDemo)', function(obj){
				var state="";
				if(obj.elem.checked === false){
					state="停用"
				}else{
					state="启用"
				}
				$.post('updateStateByEmpNo.action','empNo='+this.value+'&empState='+state);
			});
		});
		layui.use('laydate', function(){
			 var laydate = layui.laydate;
			//日期时间选择器
			  laydate.render({
			    elem: '#dates'
			    ,type: 'datetime'
			  });
		});
	
		//表格填充数据
		layui.use('table', function() {
			var table = layui.table;
			table.render({
				elem : '#stoEmp',
				url : 'selectEmpAll.action',
				toolbar : '#insert',
				title : '员工数据表',
				cols : [ [ {
					type : 'numbers'
				}, {
					type : 'checkbox'
				}, {
					field : 'empNo',
					title : '员工编号',
					width : 100,
					unresize : true
				}, {
					field : 'empName',
					title : '员工姓名',
					edit : 'text'
				}, {
					field : 'empDate',
					title : '入职日期',
					edit : 'text',
					type: 'datetime',
					sort : true
				}, {
					field : 'posi_account',
					title : '员工账号',
					edit : 'text'
				}, {
					field : 'posi_pass',
					title : '密码',
					edit : 'text'
				}, {
					field : 'empState',
					title : '员工状态',
					templet:'#switchTpl',
					minWidth:50,
					unresize : true
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 300,
					edit : 'text',
					event : "test"
				} ] ],
				page : true
			});
			//监听行工具事件
			table.on('tool(stoEmp)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						obj.del();
						$.post("deleteStoEmp.action", {
							"empNo" : data.empNo
						});
						layer.close(index);
					});
				} else if (obj.event === 'edit') {
					$.post("updateStoEmpByEmpNo.action", data);
					layer.msg("编辑成功！");
				}else if (obj.event === 'look') {
					//layer.msg("查看"+data.empNo);
					$.post(
						'lookPosition.action',
						'empNo='+data.empNo,
						function(msg){
							//layer.msg(msg);
							if(msg ===''){
								layer.msg('无职位');
							}else{
								layer.msg(msg);
							}
						}
					);
				}
			});
			//监听单元格编辑
			table.on('edit(stoEmp)', function(objs) {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
			});
			table.on('toolbar(stoEmp)', function(obj) {//新增
				var data = obj.data;
				var checkStatus = table.checkStatus(obj.config.id);
				if (obj.event === 'insert') {
					layer.open({
						type:1,
						anim:1,
						area:['400px','420px'],
						title:'新增员工',
						maxmin: true,
						content:$("#pnal"),
						cancel:function(){
							$("#pnal").css({"display":"none"});
						}
					});
				} else if (obj.event === 'deletep') {//批量删除
					var data = checkStatus.data;
					//判断未选中
					if (data.length === 0) {
						layer.msg("您未选中！");
					} else {
						layer.confirm('真的删除选中行么', function(index) {
							var data = checkStatus.data;
							var array=new Array();
							for (var i = 0; i < data.length; i++) {
								array[i]=data[i].empNo;
							}
							$.post(
								"deleteBatchStoEmp.action",
								{"empNo":array}
							); 
							$(".layer-from-checked").not('.header').parents('tr').remove();
							location.reload(true);
						});
					}
				}
			});
		});
	</script>
</body>
</html>