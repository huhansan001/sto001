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
<title>仓库管理</title>
</head>
<body>
	<table class="layui-hide" id="distribute" lay-filter="distribute"></table>
	<!-- 添加一个新增按钮 -->
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="comPackage"><i class="layui-icon">&#xe654;</i>合包</button>   
</div>
    <!--选择派件员派件-->
         <form class="layui-form" action=""style="width: 371px;position: absolute;left: 70px;bottom: -9px;">
        <div class="layui-form-item">
       <label style="width: 100px;" class="layui-form-label">选择派件员</label>
      <div class="layui-input-inline">
     <select name="interest" lay-filter="aihao">
    </select>
   </div>
 </div>
	<!-- 添加一个发送按钮 -->
  <button type="button" lay-submit=""
 class="layui-btn layui-btn-danger
 layui--btn-sm" style="position: absolute;bottom: 14px;left: 300px;">发送</button>
 <!--添加一个合包按钮>
<div>
  <button type="button" lay-submit=""
 class="layui-btn layui-btn-danger
 layui--btn-sm" style="position: absolute;bottom: 14px;left: 380px;">一键合包</button>
</div>
	</script>
	<!-- 表内按钮 -->
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
  	</script>
	<!-- 新增所有的表单  -->
	<div class="layui-row" id="senderPnal" style="display: none;">
		<div class="layui-col-md10">
			<form action="empAdd.action" class="layui-form" id="addEmp">
				<div class="layui-form-item">
					<label class="layui-form-label">包裹ID</label>
					<div class="layui-input-block">
						<input type="text" name="packageId" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">派件人</label>
					<div class="layui-input-block">
						<input type="text" name="courier" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">是否卸货</label>
					<div class="layui-input-block">
						<input type="text" name="whether" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">卸货人</label>
					<div class="layui-input-block">
						<input type="text" name="unloading" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 30px">
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
	layui
			.use(
					[ 'form', 'element', 'layedit', 'jquery', 'layer','laydate' ],
					function() {
						//得到所有组件
						var form = layui.form,
						layer = layui.layer,
						element = layui.element,
						table = layui.table,
						$ = layui.jquery,
						laydate = layui.laydate;
						//form表单提交监听事件
						form.on('submit(saveSender)', function(data) {
							$.post('insertSenders.action', data.field, function(
									msg) {
								layer.msg(msg);
								window.location.href = "stoWarehouse.jsp";
							});
						});
					});
	//表格数据填充
	layui.use([ 'table', 'laypage' ], function() {
		var table = layui.table;
		var laypage = layui.laypage;
		table.render({
			elem : '#distribute',
			url : 'warehouses.action',
			toolbar : '#toolbarDemo',
			title : '包裹',
			cols : [ [ {
				type : 'numbers'
			}, {
				type : 'checkbox'

			}, {
				field : 'packageId',
				title : '包裹id',
			}, {
				field : 'courier',
				title : '派件人',

			}, {
				field : 'whether',
				title : '合包状态',

			}, {
				field : 'unloading',
				edit : 'text',
				title : '卸货人',
			},{
				field : 'right',
				title : '操作',
				toolbar : '#barDemo',
			} ] ],
			page : true
		});
		//监听行工具事件
		table.on('toolbar(distribute)', function(obj) {
			var checkStatus = table.checkStatus(obj.config.id),data = checkStatus.data,ids="";
			if (obj.event === 'insert') {
				layer.open({
					type : 1,
					title : '新增',
					anim : 3,
					content : $("#senderPnal"),
					area : [ '400px', '650px' ],
					cancel : function() {
						$("#senderPnal").css({
							"display" : "none"
						});
					}
				});
			}else if(obj.event === "comPackage"){
				if(data.length>0){
					for (var i in data) {
						if(data[i].whether=="未合包"){
							if(i==0){
								ids=data[i].packageId;
							}else{
								ids=ids+"-"+data[i].packageId;
							}
						}
					}
					$.post('comPackage.action','ids='+ids,function(msg){
						if(msg=="合包成功"){
							alert("修改合包状态");
						}
					})
				}else{
					layer.msg("请选择包裹");
				}
			}
		})
	
		table.on('edit(distribute)', function(objs) {
			layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
		});
		//修改信息
	table.on('tool(distribute)', function(obj) {
			var data = obj.data;
			if (obj.event === 'edit') {
				layer.msg("编辑成功！");
				$.post("updateSenders.action", data);
				layer.msg("编辑成功！");
				//删除信息
			} else if (obj.event === 'del') {
				$.post("deletedistribute.action", data, function(msg) {
					layer.msg(msg);
					window.location.href = "stoWarehouse.jsp";
				});
			   layer.msg("删除成功！");
			}
		});
	});
</script>