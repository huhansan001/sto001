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
<title>用户信息</title>
</head>
<body>
	<table class="layui-hide" id="package" lay-filter="package"></table>
	<!-- 添加审核和入库按钮 -->
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
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="userName" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<input type="text" name="userSex" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">民族</label>
					<div class="layui-input-block">
						<input type="text" name="userNation" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生日</label>
					<div class="layui-input-block">
						<input type="text" name="userBirthday" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">身份证</label>
					<div class="layui-input-block">
						<input type="text" name="userIDnumber" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-block">
						<input type="text" name="homeAddress" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">国家</label>
					<div class="layui-input-block">
						<input type="text" name="detailedAddress" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">电话</label>
					<div class="layui-input-block">
						<input type="text" name="phoneNumber" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-block">
						<input type="text" name="userPass" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item" style="margin-left: 75px">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" lay-submit=""
							lay-filter="saveSender">保存</button>
						<button type="button" class="layui-btn layui-layer-close">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script>
<!-- 用户新增表单提交-->
	layui.use(
					[ 'form', 'element', 'layedit', 'jquery', 'layer' ],
					function() {
						//得到所有组件
						var form = layui.form, layer = layui.layer, element = layui.element, table = layui.table, $ = layui.jquery;
						//form表单提交监听事件
						form.on('submit(saveSender)', function(data) {
							$.post('insertUserRela.action', data.field,
									function(msg) {
										layer.msg(msg);
										window.location.href = "用户信息表.jsp";
									});
						});
					});

	<!--表格数据填充-->
	layui.use('table', function() {
		var table = layui.table;
		table.render({
			elem : '#package',
			url : 'selectUserRelaAll.action',
			toolbar : '#toolbarDemo',
			title : '用户信息',
			cols : [ [ {
				type : 'numbers'
			}, {
				type : 'checkbox'
			}, {
				field : 'urealNameId',
				title : 'ID',
			}, {
				field : 'userName',
				title : '姓名',
				edit: 'text',
			}, {
				field : 'userSex',
				title : '性别',
				edit: 'text',
			}, {
				field : 'userNation',
				title : '民族',
				edit: 'text',
			}, {
				field : 'userBirthday',
				title : '生日',
				edit: 'text',
			}, {
				field : 'userIDnumber',
				title : '身份证 ',
				edit: 'text',
			}, {
				field : 'homeAddress',
				title : '详细地址',
				edit: 'text',
			}, {
				field : 'detailedAddress',
				title : '国家',
				edit: 'text',
			}, {
				field : 'phoneNumber',
				title : '电话',
				edit: 'text',
			}, {
				fixed : 'right',
				title : '操作',
				toolbar : '#barDemo',
				width : 200,
				event : "test"
			} ] ],
			page : true
		});
		//监听行工具事件
		table.on('toolbar(package)', function(obj) {
			var data = obj.data;
			if (obj.event === 'insert') {
				layer.open({
					type : 1,
					title : '新增',
					anim : 3,
					content : $("#senderPnal"),
					area : [ '500px', '650px' ],
					cancel : function() {
						$("#senderPnal").css({
							"display" : "none"
						});
					}
				});
			}
		})
		table.on('edit(package)', function(objs) {
			layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
		});
		//修改信息
		table.on('tool(package)', function(obj) {
			var data = obj.data;
			if (obj.event === 'edit') {
				$.post("updateUserRela.action", data);
				layer.msg("编辑成功！");
				//删除信息
			}  if (obj.event === 'del') {
				$.post("deleteUserRela.action", data, function(msg) {
					layer.msg(msg);
					window.location.href = "package.jsp";
				});
				layer.msg("删除成功！");
			}
		});
	});
</script>
</html>