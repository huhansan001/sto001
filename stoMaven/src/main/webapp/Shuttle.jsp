<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>车辆管理</title>
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
	<!-- 修改，删除 -->
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>

	</script>
	<!-- 新增所有的表单  -->
	<div class="layui-row" id="senderPnal" style="display: none;">
		<div class="layui-col-md10">
			<div class="layui-form-item">
				<label class="layui-form-label">班车编号</label>
				<div class="layui-input-block">
					<input type="text" name="carNumber" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">司机编号</label>
				<div class="layui-input-block">
					<input type="text" name="driverNumber" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">班车状态</label>
				<div class="layui-input-block">
					<input type="text" name="state" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">发车时间</label>
				<div class="layui-input-block">
					<input type="text" name="departureTime" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">到站时间</label>
				<div class="layui-input-block">
					<input type="text" name="arrivalTime" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">起点</label>
				<div class="layui-input-block">
					<input type="text" name="startingPoint" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">终点</label>
				<div class="layui-input-block">
					<input type="text" name="Terminus" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">网点ID</label>
				<div class="layui-input-block">
					<input type="text" name="dotId" autocomplete="off"
						class="layui-input">
						<button type="button" class="layui-btn" lay-submit="" lay-filter="saveSender">保存</button>
				      <button type="button" class="layui-btn layui-layer-close">取消</button>
				</div>
			</div>
		</div>
	</div>

</body>
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
			'insertReceiptOrders.action',
			data.field,
			function(msg){
				layer.msg(msg);
				window.location.href="receiptOrders.jsp";
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
		title : '班车表',
		cols : [ [ {
			type : 'numbers'
		}, {
			type : 'checkbox'
		}, {
			field : 'carNumber',
			title : '班车编号'
		}, {
			field : 'driverNumber',
			edit: 'text',
			title : '司机编号'
		}, {
			field : 'state',
			edit: 'text',
			title : '班车状态'
		}, {
			field : 'departureTime',
			edit: 'text',
			title : '发车时间'
		}, {
			field : 'arrivalTime',
			edit: 'text',
			title : '到站时间'
		}, {
			field : 'startingPoint',
			edit: 'text',
			title : '起点'
		}, {
			field : 'Terminus',
			edit: 'text',
			title : '终点'
		},{
			field : 'dotId',
			edit: 'text',
			title : '网点ID'
		},{
			fixed : 'right',
			title : '修改',
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
				 anim:4,
				 content :$("#senderPnal"),
				 area: ['430px', '600px'],
				 cancel:function(){
					$("#senderPnal").css({"display":"none"});
				}
			});
		 }
	})
	//修改提示
	 table.on('edit(sender)', function(objs) {
		layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
	}); 
	//修改信息
	table.on('tool(sender)', function(obj) {
		var data=obj.data;
		if (obj.event === 'edit') {
			  $.post("updateReceiptOrders.action", data);  
			layer.msg("编辑成功！");
			//删除信息
		}else if(obj.event === 'del'){
			 $.post("deleteReceiptOrders.action", data,
					 function(msg){
					layer.msg(msg);
					window.location.href="receiptOrders.jsp";
			}); 
			
			 layer.msg("删除成功！");
			
		}
	});
});

</script>
</html>