<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>派件人工单表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>
</head>

<body>
	<table class="layui-hide" id="workOrder" lay-filter="workOrder"></table>
	
	
<!-- 派件按钮 -->
	<script type="text/html" id="toolbarDemo">
  		<div class="layui-btn-container" >
    	<button type="button" lay-submit=""
		class="layui-btn layui-btn-radius
		layui-btn-stm" lay-event="sendPage" style="margin-left: 25px;">一键派件</button>
  <button class="layui-btn layui-btn-sm" lay-event="insert" style="margin-left: 100px;"><i class="layui-icon">&#xe654;</i>新增</button>  		
</div>

	</script>
	
	
<!-- 表格内的按钮 -->
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>

</script>

<!-- 新增的面板 -->

<div class="layui-row" id="certificationPnal" style="display: none;">
		<div class="layui-col-md10">
			<form action="empAdd.action" class="layui-form" id="addEmp">
				 
				  <div class="layui-form-item">
				    <label class="layui-form-label">包裹id</label>
				    <div class="layui-input-block">
				      <input type="text" name="packageId" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">员工编号</label>
				    <div class="layui-input-block">
				      <input type="text" name="empNo" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">派发时间</label>
				    <div class="layui-input-block">
				      <input type="text" name="sendTime" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">工作状态</label>
				    <div class="layui-input-block">
				      <input type="text" name="worksheet" autocomplete="off" class="layui-input">
				    </div>
		
				  
				  
				<div class="layui-form-item" style="margin-left: 50px; margin-top: 20px">
				    <div class="layui-input-block">
				      <button type="button" class="layui-btn" lay-submit="" lay-filter="saveCertification">保存</button>
				      <button type="button" class="layui-btn layui-layer-close">取消</button>
				    </div>
				  </div>
			</form>
		</div>
	</div>




<!-- js代码 -->
	<script>
	
	layui.use(['form','element','layedit','jquery','layer'], function(){
		//得到所有组件
		var form=layui.form,
		layer = layui.layer,
		element=layui.element,
		table = layui.table,
		$=layui.jquery;
		
		 //头工具栏事件
		  table.on('toolbar(workOrder)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id);
		    switch(obj.event){
		      case 'sendPage':
		        var data = checkStatus.data;
		       // layer.alert(JSON.stringify(data));
		       layer.msg('选中了：'+ data.length + ' 个');
		      break;
		     /*  case 'getCheckLength':
			        var data = checkStatus.data;
			        layer.msg('选中了：'+ data.length + ' 个');
			     	break;
		     	 case 'isAll':
		        	layer.msg(checkStatus.isAll ? '全选': '未全选');
		     		 break; */
		    };
		  });
		
			
		/*
		//新增监听事件
				table.on('toolbar(workOrder)', function(obj) {
					var data=obj.data;
					 if (obj.event === 'insert') {
						 layer.open({
							 type :1,
							 title :'新增',
							 anim:6,
							 content :$("#certificationPnal"),
							 area: ['430px', '500px'],
							 cancel:function(){
								$("#certificationPnal").css({"display":"none"});
							}
						});
					 }
				}) */
			 
		 
		 
		 table.on('edit(workOrder)', function(objs) {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
			});
			//监听行工具事件	
		  	table.on('tool(workOrder)', function(obj) {
				var data = obj.data;
				if (obj.event === 'edit') {
					$.post("updateWork.action", data);
					layer.msg("修改成功！");
				} else if (obj.event === 'del') {
					 $.post("deleteWork.action", data, function(msg) {
						layer.msg(msg);
						window.location.href = "workOrder.jsp";
					}); 
					layer.msg("删除成功！");
				}
			});
			
	})
	
	
	var limitcount=10;
	var curnum=1;
	function productsearch(curnum,limitcount){//分页的方法
		//表格数据填充	
		layui.use(['table','laypage'], function() {
			
			var table = layui.table;
			var laypage=layui.laypage;
			table.render({
				elem : '#workOrder',
				url : 'selectWorkOrderAll.action?page='+curnum+'&row='+limitcount,//地址从哪来 （WorkOrderAction中来）
				toolbar : '#toolbarDemo', //绑定的一个按钮
				title : '工单表信息表',
				cellMinWidth:80,//全局定义常规单元格的最小宽度, layui 2.2.1 新增
				cols : [ [ {
					type : 'numbers'      //数字序列
				}, {
					type : 'checkbox'     //复选框
				 }, {     //一个字段
					field : 'packageId',//字段名
					
					title : '包裹id',
					sort:true    //升序 降序
				} , {
					field : 'empNo',
					edit: 'text',
					title : '员工编号'
					
				}, {
					field : 'sendTime',
					edit: 'text',
					title : '派发时间',
					sort:true    //升序 降序
				}, {
					field : 'worksheet',
					edit: 'text',
					title : '工单状态'
					
				},{
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 200,
					event : "test"
				}] ],
				page : true,//开启分页
				
				done:function(res,curr,count){//回调的一个信息，页码数，统计当前页面行数
					
					laypage.render({
						    elem: 'table-page' //分页容器的id
						    ,count: count //数据总数 从服务端得到（总页数）
						    ,limit:limitcount//当页总数
						    ,curr:curnum//页码数
						    ,layout:['prev','page','next','skip','count','limit'] 
						    ,jump: function(obj, first){//点击事件  (obj获取当页的对象)
						      if(!first){//判断不是首页
						    	  curnum=obj.curr;
						    	  limitcount=obj.limit;
						    	  productsearch(curnum,limitcount);
						      }
						    }
						 });
					}
			   });
		});
	}
	  productsearch(curnum,limitcount);

		
	</script>
</body>
</html>