<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户地址中心</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>
</head>
<body>
	<table class="layui-hide" id="UserAddress_xwc" lay-filter="UserAddress_xwc"></table>
	<!-- 添加一个新增按钮 -->
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="insert"><i class="layui-icon">&#xe654;</i>新增</button>
</div>
	<form class="layui-form" action="" style="position:absolute;left:100px;bottom:-10px;">
		 <div class="layui-form-item">
    <label class="layui-form-label" style="width:100px;">订单搜索</label>
    <div class="layui-input-inline">
      <select name="interest" lay-filter="aihao">
       
      </select>
    </div>
  </div>
	</form>
	</script>
	<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	  <div class="layui-form-item">
    	<div class="layui-input-block">
    	  <input type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchTest" lay-text="已签收|未签收">
   		</div>
 	 </div>
	</script>


	

	<script>
		layui.use([ 'form', 'element', 'layedit', 'jquery', 'layer' ],function() {
						//得到所有组件
						var form = layui.form,
							layer = layui.layer, 
							element = layui.element,
							table = layui.table,
							$ = layui.jquery;
						//form表单提交监听事件
						form.on('submit(saveUserAddress_xwc)',function(data) {
								$.post('insertUserAddress.action',
									data.field,
									function(msg) {
									layer.msg(msg);
									window.location.href = "UserAddress_xwc.jsp";
							});
						});
					
			//表格数据填充	
			layui.use('table', function() {
				var table = layui.table;
				table.render({
					elem : '#UserAddress_xwc',
					url : 'selectUserAddressAll.action',
					toolbar : '#toolbarDemo',
					title : '收件订单表',
					cols : [ [ {
						type : 'numbers'
					}, {
						type : 'checkbox'
					}, {
						field : 'userName',
						title : '姓名'
					}, {
						field : 'userPhone',
						edit : 'text',
						title : '手机号码'
					}, {
						field : 'landlineNumbers',
						edit : 'text',
						title : '座机号码'
					}, {
						field : 'fullAddress',
						edit : 'text',
						title : '详细地址'
					}, {
						field : 'category',
						edit : 'text',
						title : '类别'
					}, {
						field : 'sendName',
						edit : 'text',
						title : '寄件人姓名'
					},{
						fixed : 'right',
						title : '操作',
						width : 200,
						toolbar : '#barDemo',
						event : "test"
					} ] ],
					page : true,
					
				   });
			});
	
			//监听行工具事件
			table.on('toolbar(UserAddress_xwc)', function(obj) {
				var data = obj.data;
				if (obj.event === 'insert') {
					layer.open({
						type : 1,
						title : '新增',
						anim : 6,
						content : $("#UserAddress_xwcPnal"),
						area : [ '430px', '400px' ],
						cancel : function() {
							$("#UserAddress_xwcPnal").css({
								"display" : "none"
							});
						}
					});
				}
			})
			table.on('edit(UserAddress_xwc)', function(objs) {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
			});
			table.on('tool(UserAddress_xwc)', function(obj) {
				var data = obj.data;
				if (obj.event === 'edit') {
					$.post("updateUserAddress.action", data);
					layer.msg("修改成功！");
				} else if (obj.event === 'del') {
					$.post("deleteUserAddress.action", data, function(msg) {
						layer.msg(msg);
						window.location.href = "UserAddress_xwc.jsp";
					});
					layer.msg("删除成功！");
				}
			});
		});
	</script>
	<!-- 新增所有的表单  -->
	<div class="layui-row" id="UserAddress_xwcPnal" style="display: none;">
		<div class="layui-col-md10">
			<form action="insertServiceTable.action" class="layui-form"
				id="addUserAddress_xwc">
				
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="userName" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号码</label>
					<div class="layui-input-block">
						<input type="text" name="userPhone" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">座机号码</label>
					<div class="layui-input-block">
						<input type="text" name="landlineNumbers" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">详细地址</label>
					<div class="layui-input-block">
						<input type="text" name="fullAddress" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">类别</label>
					<div class="layui-input-block">
						<input type="text" name="category" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">寄件人姓名</label>
					<div class="layui-input-block">
						<input type="text" name="sendName" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 50px">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" lay-submit=""
							lay-filter="saveUserAddress_xwc">保存</button>
						<button type="button" class="layui-btn layui-layer-close">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>