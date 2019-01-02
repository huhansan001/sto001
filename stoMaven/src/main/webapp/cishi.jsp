<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>测试页面</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
</head>
<body>
	<!-- 创建数据表格 -->
	<table class="layui-hide" id="ReceiptWorkorder_czq" lay-filter="ReceiptWorkorder_czq"></table>
	
	<!-- 添加新增按钮 -->
	<script type="text/html" id="insert">
		<div class="layui-btn-container">
			<button class="layui-btn layui-btn-sm" lay-event="insert">新增</button>
		</div>
	</script>
	
	<!-- 添加表内按钮 -->
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="updateReceiptWorkorder_czq">编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="deleteReceiptWorkorder_czq">删除</a>
	</script>
	
	<!-- 开关按钮 -->
	<script type="text/html" id="switchTpl">
	  <!-- 这里的 checked 的状态只是演示 -->
 	  <input type="checkbox" name="reClosePackage" value="{{d.reClosePackage+d.receiptId}}" lay-skin="switch" lay-text="已合包|未合包" lay-filter="sexDemo" {{ d.reClosePackage == '未和包' ? ' ' : 'checked' }}>
	</script>
	
	<!-- 弹出添加员工的界面  Style="display:none"-->
	<div class="layui-row" id="insertWin" Style="display:none">
		<div class="layui-col-md10">
			<form class="layui-form" action="" id="">
			  <div class="layui-form-item">
			    <label class="layui-form-label">员工编号</label>
			    <div class="layui-input-block">
			      <input type="text" name="empNo" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">订单号</label>
			    <div class="layui-input-block">
			      <input type="text" name="orderNumber" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">区县id</label>
			    <div class="layui-input-block">
			      <input type="text" name="locals" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">送货区域id</label>
			    <div class="layui-input-block">
			      <input type="text" name="deliveryArea" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-inline" style="margin-bottom: 10px">
			    <label class="layui-form-label">收件日期</label>
			    <div class="layui-input-inline">
			      <input type="text" name="reTime" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">合包状态</label>
			    <div class="layui-input-block">
			      <input type="text" name="reClosePackage" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <!-- 表单里面的按钮 -->
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button type="button" class="layui-btn" lay-submit="" lay-filter="ReceiptWorkorder_czqButton">提交</button>
			      <button type="button" class="layui-btn layui-layer-close" lay-filter="close" >取消</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
	
	
	<script>
	//表格数据填充
	layui.use('table', function(){
		var table = layui.table;
		 table.render({
			    elem: '#ReceiptWorkorder_cjzq',
			    url:'selectReceiptWorkorder_czqAll.action',
			    toolbar:'#insert',
			    title:'收件员工单表',
				cols : [ [ {
							type : 'numbers'
						}, {
							type : 'checkbox'
						}, {
							field : 'receiptId',
							title : '收件员id',
							sort : true
						}, {
							field : 'empNo',
							title : '员工编号',
							edit : 'text',
							sort : true
						}
						, {
							field : 'orderNumber',
							title : '订单号',
							edit : 'text',
							sort : true
						}
						, {
							field : 'locals',
							title : '区县id',
							edit : 'text',
							sort : true
						}
						, {
							field : 'deliveryArea',
							title : '送货区域id',
							edit : 'text',
							sort : true
						}
						, {
							field : 'reTime',
							title : '收件时间',
							edit : 'text',
							sort : true
						}
						, {
							field : 'reClosePackage',
							title : '是否合包',
							templet: '#switchTpl',
							unresize: true,
							sort : true
						},{
							fixed: 'right', 
							title:'操作', 
							toolbar: '#barDemo'
							}
						] ],
				page : true
			});
		 /* 工具监听事件 */
		 table.on('toolbar(ReceiptWorkorder_czq)',function(obj) {
			 var data = obj.data;
			 /* var checkStatus = table.checkStatus(obj.config.id); */
			 if(obj.event === 'insert'){
				layer.open({
					 type : 1,
					 anim : 6,
					 area : ['400px', '430px'],
					 title : '新增',
					 maxmin : true,
					 content : $("#insertWin"),
					 cancel:function(){
						 $("#insertWin").css({"display":"none"});
					 }
				 })
			 }
		 });
		 
		//数据表格内按钮的监听事件
		table.on('edit(ReceiptWorkorder_czq)', function(objs) {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
		});
		table.on('tool(ReceiptWorkorder_czq)', function(obj){
			var data = obj.data;
			//判断是否点击了修改按钮
			if(obj.event === 'updateReceiptWorkorder_czq'){
				$.post("updateReceiptWorkorder_czq.action", data);
				layer.msg("修改成功！"); 
				//判断是否点击了删除按钮
			}else if(obj.event === 'deleteReceiptWorkorder_czq'){
				layer.confirm('真的删除行么', function(index){
			       obj.del();
			       $.post("deleteReceiptWorkorder_czq.action",
					data,
					function(msg){
						if(msg=="ok"){
							layer.msg("删除成功！"); 
						}else if(msg=="no"){
							layer.msg("删除失败！"); 
						}
						}
					);
			       layer.close(index);
			    });
				
			}
		});
		 
		});
	
	//全局监听事件
	layui.use(['form','element','layedit','jquery','layer','laydate'],function(){
		//得到所有组件
		var form=layui.form,
		element=layui.element,
		layedit=layui.layedit,
		$=layui.jquery,
		layer=layui.layer;
		laydate=layui.laydate;
		//日期
		  laydate.render({
		    elem: '#date'
		  });
		  laydate.render({
		    elem: '#date1'
		  });
		//form表单提交监听事件
		form.on('submit(ReceiptWorkorder_czqButton)',function(data){
			$.post(
					'insertReceiptWorkorder_czq.action',
					data.field,
					function(msg){
						layer.msg(msg);
						if(msg=="ok"){
							window.location.href="cishi.jsp";
						}else if(msg=="no"){
							layer.msg("新增失败！");
						}
					}
			);
		});
		
		//监听是否合包操作
		form.on('switch(sexDemo)', function(obj){
		  /* layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis); */
		  layer.msg(this.name+"===="+this.value+"===="+obj.othis+"===="+obj.elem.checked);
		  $.post('updateReceiptWorkorder_czq_reClosePackage.action', this.value);
		});
		
	});
	</script>

</body>
</html>


<!--   <button type="button" lay-submit=""
 class="layui-btn layui-btn-danger
 layui--btn-sm" style="position: absolute;bottom: 14px;left: 300px;">发送</button>
<div>
  <button type="button" lay-submit=""
 class="layui-btn layui-btn-danger
 layui--btn-sm" style="position: absolute;bottom: 14px;left: 380px;">合包</button>
<div> -->