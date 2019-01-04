<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>
<title>派发订单</title>

</head>
<body>
	<table class="layui-hide" id="distribute" lay-filter="distribute"></table>
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
	<div class="layui-row" id="senderPnal"style="display: none;">
		<div class="layui-col-md10">
			<form action="empAdd.action" class="layui-form" id="addEmp">
				<div class="layui-form-item">
					<label class="layui-form-label">员工编号</label>
					<div class="layui-input-block">
						<input type="text" name="employee" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">订单号</label>
					<div class="layui-input-block">
						<input type="text" name="indent" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">运单号</label>
					<div class="layui-input-block">
						<input type="text" name="waybill" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">寄件人id</label>
					<div class="layui-input-block">
						<input type="text" name="sender" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">收件人id</label>
					<div class="layui-input-block">
						<input type="text" name="recipients" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">区县id（网点）</label>
					<div class="layui-input-block">
						<input type="text" name="county" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">收件人详细地址</label>
					<div class="layui-input-block">
						<input type="text" name="address" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">收件人电话号码</label>
					<div class="layui-input-block">
						<input type="text" name="number" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">运单状态</label>
					<div class="layui-input-block">
						<input type="text" name="shippingState" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 30px" >
					<div class="layui-input-block" >
						<button type="button"  class="layui-btn" lay-submit="" 	lay-filter="saveSender">保存</button>
						<button type="button" class="layui-btn layui-layer-close">取消</button>
					</div>
				</div>
			</form>
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
				'insertDistribute.action',
				data.field,
				function(msg){
					layer.msg(msg);
					window.location.href="distribute.jsp";
				}
			);
		});
	});
	
	
		//表格数据填充
		layui.use('table', function() {	
			var table = layui.table;
			table.render({
				elem : '#distribute',
				url : 'selectdistributeAll.action',
				toolbar : '#toolbarDemo',
				title : '派发订单表',
				cols : [ [ {
					type : 'numbers'
				}, {
					type : 'checkbox'

				}, {
					field : 'employee',
					title : '员工编号',
				} , {
					field : 'indent',
					title : '订单号',
					
				} , {
					field : 'waybill',
					title : '运单号',
					
				} , {
					field : 'sender',
					edit: 'text',
					title : '寄件人id',
					
				} , {
					field : 'recipients',
					edit: 'text',
					title : '收件人id',
					
				} , {
					field : 'county',
					edit: 'text',
					title : '区县id（网点）',
					
				} , {
					field : 'address',
					edit: 'text',
					title : '收件人详细地址',
					
				} , {
					field : 'number',
					edit: 'text',
					title : '收件人电话号码',
					
				} , {
					field : 'shippingState',
					edit: 'text',
					title : '运单状态',
					
				}, {
					fixed:'right',
					title : '操作',
					toolbar:'#barDemo',
					width:200,
					event:"test"
				}  ] ],
				page : true
			});
			//监听行工具事件
			table.on('toolbar(distribute)', function(obj) {
				var data=obj.data;
				 if (obj.event === 'insert') {
					 layer.open({
						 type :1,
						 title :'新增',
						 anim:3,
						 content :$("#senderPnal"),
						 area: ['400px', '650px'],
						 cancel:function(){
							$("#senderPnal").css({"display":"none"});
						}
					});
				 }
			})
			
			table.on('edit(distribute)', function(objs) {
			layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
		});
		
			//修改信息
			table.on('tool(distribute)', function(obj) {
				var data=obj.data;
				if (obj.event === 'edit') {
					  $.post("updatedistribute.action", data);  
					layer.msg("编辑成功！");
					//删除信息
				}else if(obj.event === 'del'){
					 $.post("deletedistribute.action", data,
							 function(msg){
							layer.msg(msg);
							window.location.href="distribute.jsp";
					}); 
					
					 layer.msg("删除成功！");
					
				}
			});
			
		});
		
	</script>
</html>