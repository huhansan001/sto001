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
<title>包裹表</title>

</head>
<body>
	<table class="layui-hide" id="package" lay-filter="package"></table>
	<!-- 添加审核和入库按钮 -->
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="approved">通过审核</button>
	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="unreviewed">未审核</button>
  </div>
</script>
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
	<!-- 新增所有的表单  -->

</body>
<script>
	layui
			.use(
					[ 'form', 'element', 'layedit', 'jquery', 'layer' ],
					function() {
						//得到所有组件
						var form = layui.form, layer = layui.layer, element = layui.element, table = layui.table, $ = layui.jquery;
						//form表单提交监听事件
						form.on('submit(saveSender)', function(data) {
							$.post('insertpackage.action', data.field,
									function(msg) {
										layer.msg(msg);
										window.location.href = "package.jsp";
									});
						});
					});

	//表格数据填充
	layui.use('table', function() {
		var table = layui.table;
		table.render({
			elem : '#package',
			url : 'selectpackageAll.action',
			toolbar : '#toolbarDemo',
			title : '包裹表',
			cols : [ [ {
				type : 'numbers'
			}, {
				type : 'checkbox'

			}, {
				field : 'packageId',
				title : '包裹id',
			}, {
				field : 'workOrderNumber',
				title : '工单号',

			}, {
				field : 'nameOfSender',
				title : '寄件人姓名',

			}, {
				field : 'senderAddress',
				edit : 'text',
				title : '寄件人地址 ',

			}, {
				field : 'fullAddressOfSender',
				edit : 'text',
				title : '寄件人详细地址',

			}, {
				field : 'sendersTelephoneNumber',
				edit : 'text',
				title : '寄件人电话',

			}, {
				field : 'addresseeName',
				edit : 'text',
				title : '收件人姓名',

			}, {
				field : 'direction',
				edit : 'text',
				title : '收件人地址',

			}, {
				field : 'addresseeDetailedAddress',
				edit : 'text',
				title : '收件人详细地址',

			}, {
				field : 'addresseeTelephoneNumber',
				edit : 'text',
				title : '收件人电话',

			}, {
				field : 'theParcelWeighs',
				edit : 'text',
				title : '包裹重量',

			}, {
				field : 'freight',
				edit : 'text',
				title : '运费',

			}, {
				field : 'auditStatus',
				edit : 'text',
				title : '审核状态',

			}, {
				field : 'waybillNumber',
				edit : 'text',
				title : '运单号',

			}, {
				field : 'remark',
				edit : 'text',
				title : '备注',

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
				$.post("updatepackage.action", data);
				layer.msg("编辑成功！");
				//删除信息
			} else if (obj.event === 'del') {
				$.post("deletepackage.action", data, function(msg) {
					layer.msg(msg);
					window.location.href = "package.jsp";
				});

				layer.msg("删除成功！");

			}
		});

	});
</script>
</html>