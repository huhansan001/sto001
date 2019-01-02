<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>业务表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>
</head>
<body>
	<div class="demoTable"
		style="position: absolute; left: 90px; top: 22px; z-index: 99999999999999999999999999999999999999999999999999999999999;">
		搜索ID：
		<div class="layui-inline">
			<input class="layui-input" name="id" id="demoReload"
				autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload">搜索</button>
	</div>
	<table class="layui-hide" id="SeviceTable_xwc"
		lay-filter="SeviceTable_xwc"></table>
	<!-- 添加一个新增按钮 -->
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="insert"><i class="layui-icon">&#xe654;</i>新增</button>
</div>
	<form class="layui-form" action="" style="position:absolute;right:120px;bottom:-10px;">
		 <div class="layui-form-item">
   	 <label class="layui-form-label" style="width:100px;">订单状态</label>
    	<div class="layui-input-inline">
    	 <select name="interest" id="interest" lay-filter="interest">
       		<option value="" class="select">请选择</option>
			<option value="1" class="select">已取消</option>
			<option value="2" class="select">处理中</option>
			<option value="3" class="select">已处理</option>
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
		layui.use([ 'form', 'table','element', 'layedit', 'jquery', 'layer' ],function() {
						//得到所有组件
						var form = layui.form,
							layer = layui.layer, 
							element = layui.element,
							table = layui.table,
							$ = layui.jquery;
						//form表单提交监听事件
						form.on('submit(saveSeviceTable_xwc)',function(data) {
								$.post('insertServiceTable.action',
									data.field,
									function(msg) {
									layer.msg(msg);
									window.location.href = "SeviceTable_xwc.jsp";
							});
						});
						 form.render('select');
						form.on('select(interest)',function(data){
							//alert($("select option[value='"+data.value+"']").text());
							var select = $("select option[value='"+data.value+"']").text();
							layui.use([ 'form', 'table', 'jquery', 'layer' ],function() {
						    	var form = layui.form,
								layer = layui.layer, 
								table = layui.table,
								$ = layui.jquery;
						    	var demoReload = $('#demoReload');
							  table.reload('testReload', {
							        page: {
							          curr: 1 //重新从第 1 页开始
							        }
							        ,where:{
							        	select: select
							        }
							      });
						  	});
						}); 
						
			//表格数据填充	
			layui.use('table', function() {
				var table = layui.table;
				table.render({
					elem : '#SeviceTable_xwc',
					url : 'selectServiceTableAll.action',
					toolbar : '#toolbarDemo',
					title : '收件订单表',
					cols : [ [ {
						type : 'numbers'
					}, {
						type : 'checkbox'
					}, {
						field : 'orderNumber',
						title : '订单号'
					}, {
						field : 'ordersId',
						edit : 'text',
						title : '收件人id'
					}, {
						field : 'orderStatus',
						edit : 'text',
						title : '订单状态'
					}, {
						field : 'remarks',
						edit : 'text',
						title : '备注'
					}, {
						field : 'customer',
						edit : 'text',
						title : '客服'
					}, {
						fixed : 'right',
						title : '操作',
						width : 200,
						toolbar : '#barDemo',
						event : "test"
					} ] ],
					page : true,
					id: 'testReload',
				   });
				
				/////////////////////////////////////////////////////////////////
				 
			  $('.demoTable .layui-btn').on('click', function(){
			    layui.use([ 'form', 'table', 'jquery', 'layer' ],function() {
			    	var form = layui.form,
					layer = layui.layer, 
					table = layui.table,
					$ = layui.jquery;
			    	var demoReload = $('#demoReload');
				  table.reload('testReload', {
				        page: {
				          curr: 1 //重新从第 1 页开始
				        }
				        ,where: {
				            id: demoReload.val()
				        }
				      });
			  	});
			  })
				/////////////////////////////////////////////////////////////
			//监听行工具事件
			table.on('toolbar(SeviceTable_xwc)', function(obj) {
				var data = obj.data;
				if (obj.event === 'insert') {
					layer.open({
						type : 1,
						title : '新增',
						anim : 6,
						content : $("#SeviceTable_xwcPnal"),
						area : [ '430px', '400px' ],
						cancel : function() {
							$("#SeviceTable_xwcPnal").css({
								"display" : "none"
							});
						}
					});
				}
			})
			table.on('edit(SeviceTable_xwc)', function(objs) {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
			});
			table.on('tool(SeviceTable_xwc)', function(obj) {
				var data = obj.data;
				if (obj.event === 'edit') {
					$.post("updateServiceTable.action", data);
					layer.msg("修改成功！");
				} else if (obj.event === 'del') {
					$.post("deleteServiceTable.action", data, function(msg) {
						layer.msg(msg);
						window.location.href = "SeviceTable_xwc.jsp";
					});
					layer.msg("删除成功！");
				}
			});
			});
			
		});
	</script>
	<!-- 新增所有的表单  -->
	<div class="layui-row" id="SeviceTable_xwcPnal" style="display: none;">
		<div class="layui-col-md10">
			<form action="insertServiceTable.action" class="layui-form"
				id="addSeviceTable_xwc">

				<div class="layui-form-item">
					<label class="layui-form-label">收件人id</label>
					<div class="layui-input-block">
						<input type="text" name="ordersId" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">订单状态</label>
					<div class="layui-input-block">
						<input type="text" name="orderStatus" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<input type="text" name="remarks" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">客服</label>
					<div class="layui-input-block">
						<input type="text" name="customer" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 50px">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" lay-submit=""
							lay-filter="saveSeviceTable_xwc">保存</button>
						<button type="button" class="layui-btn layui-layer-close">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>