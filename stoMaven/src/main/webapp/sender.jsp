<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>寄件人</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>
</head>
<body>
	<table class="layui-hide" id="sender" lay-filter="sender"></table>
	<!-- 添加一个新增按钮 -->
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="insert"><i class="layui-icon">&#xe654;</i>新增</button>
  </div>
	</script>
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
	<!-- 新增所有的表单  -->
	<div class="layui-row" id="senderPnal" style="display: none;">
		<div class="layui-col-md10">
			<form action="empAdd.action" class="layui-form" id="addEmp">
				 <div class="layui-form-item">
				    <label class="layui-form-label">寄件人姓名</label>
				    <div class="layui-input-block">
				      <input type="text" name="senderName" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">寄件人姓名</label>
				    <div class="layui-input-block">
				      <input type="text" name="senderPhone" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">寄件人姓名</label>
				    <div class="layui-input-block">
				      <input type="text" name="senderPlane" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">寄件人姓名</label>
				    <div class="layui-input-block">
				      <input type="text" name="senderSite" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">寄件人姓名</label>
				    <div class="layui-input-block">
				      <input type="text" name="senderAddress" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">寄件人姓名</label>
				    <div class="layui-input-block">
				      <input type="text" name="senderCategory" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				<div class="layui-form-item" style="margin-left: 50px">
				    <div class="layui-input-block">
				      <button type="button" class="layui-btn" lay-submit="" lay-filter="saveSender">保存</button>
				      <button type="button" class="layui-btn layui-layer-close">取消</button>
				    </div>
				  </div>
			</form>
		</div>
	</div>

	<script>
	layui.use(['form','element','layedit','jquery','layer'], function(){
		//得到所有组件
		var form=layui.form,
		layer = layui.layer,
		element=layui.element,
		table = layui.table,
		$=layui.jquery;
		//form表单提交监听事件
		form.on('submit(saveSender)',function(data){
			$.post(
				'insertSender.action',
				data.field,
				function(msg){
					layer.msg(msg);
					window.location.href="sender.jsp";
				}
			);
		});
	});
	
		//表格数据填充
		layui.use('table', function() {
			var table = layui.table;
			table.render({
				elem : '#sender',
				url : 'selectSenderAll.action',
				toolbar : '#toolbarDemo',
				title : '寄件信息表',
				cols : [ [ {
					type : 'numbers'
				}, {
					type : 'checkbox'
				}, {
					field : 'senderName',
					edit: 'text',
					title : '寄件人姓名'
				} , {
					field : 'senderPhone',
					edit: 'text',
					title : '寄件人姓名'
				}, {
					field : 'senderPlane',
					edit: 'text',
					title : '寄件人姓名'
				}, {
					field : 'senderSite',
					edit: 'text',
					title : '寄件人姓名'
				}, {
					field : 'senderAddress',
					edit: 'text',
					title : '寄件人姓名'
				}, {
					field : 'senderCategory',
					edit: 'text',
					title : '寄件人姓名'
				},{
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 200,
					event : "test"
				}] ],
				page : true
			});
			//监听行工具事件
			table.on('toolbar(sender)', function(obj) {
				var data=obj.data;
				 if (obj.event === 'insert') {
					 layer.open({
						 type :1,
						 title :'新增',
						 anim:6,
						 content :$("#senderPnal"),
						 area: ['430px', '500px'],
						 cancel:function(){
							$("#senderPnal").css({"display":"none"});
						}
					});
				 }
			})
			//
			table.on('edit(sender)', function(objs) {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
			});
			table.on('tool(sender)', function(obj) {
				var data=obj.data;
				if (obj.event === 'edit') {
					$.post("updateSender.action", data);
					layer.msg("编辑成功！");
				}
			});
		});
	</script>
</body>
</html>