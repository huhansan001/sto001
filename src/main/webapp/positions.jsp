<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>职位信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>
<script src="layui-xtree/layui-xtree.js"></script>
</head>
<body>
	<table class="layui-hide" id="positions" lay-filter="positions"></table>
	
	<!-- 确认修改，删除，查看功能 -->
	<script type="text/html" id="positionBarDemo">
  		<a class="layui-btn layui-btn-xs layui-btn-warm"lay-event="lookPosiName"><i class="layui-icon">&#xe642;</i>查看角色功能</a>
  		<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
	<!-- 新增，批量删除 -->
	<script type="text/html" id="insertAndDeletes">
		<div class="layui-btn-container">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="insert"><i class="layui-icon">&#xe608;</i>新增</button>
		</div>
	</script>
	
	<!-- 需要弹出的添加职位界面  -->
	<div class="layui-row" id="pnal" style="display: none; margin-top: 10px">
		<div class="layui-col-md10">
			<form class="layui-form" id="addPositions">
				<div class="layui-form-item">
					<label class="layui-form-label">职位名：</label>
					<div class="layui-input-block">
						<input  lay-verify="res" type="text" name="posiName" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">薪水：</label>
					<div class="layui-input-block">
						<input  lay-verify="res" type="text" name="salary" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 50px">
					<div class="layui-input-block">
						<button type="button" lay-submit=""
							class="layui-btn layui-btn-danger layui-btn-sm"  lay-filter="savePositions">保存</button>
						<button type="button"
							class="layui-btn layui-btn-sm layui-btn-warm layui-layer-close layui-layer-close1">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- 查看功能菜单 （可删除）-->
	<div class="layui-row" id="menuFrom" style="display: none; margin-top: 10px">
		<div class="layui-col-md10">
			<form class="layui-form">
				<div class="layui-form-item">
					<div id="xtree1" class="xtree_contianer"></div>
				</div>
				<style>
					#oone>button{
						margin-left: 14px;
						margin-top: 3px;
					}
				</style>
				<div class="layui-form-item">
					<div class="layui-input-block" id="oone" style="margin-left:10px;">
						<button type="button" id="addPostions"
							class="layui-btn layui-btn-sm layui-btn-normal"><i class="layui-icon">&#xe608;</i>去新增权限</button>
						<button type="button" id="deletePostions" 
							class="layui-btn layui-btn-danger layui-btn-sm"><i class="layui-icon">&#xe640;</i>删除</button>
						<button type="button"
							class="layui-btn layui-btn-sm layui-btn-warm layui-layer-close layui-layer-close1"><i class="layui-icon">&#x1006;</i>取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- 添加功能菜单 -->
	<div class="layui-row" id="addMenuFrom" style="display: none; margin-top: 10px">
		<div class="layui-col-md10">
			<form class="layui-form">
				<div class="layui-form-item">
					<div id="xtree2" class="xtree_contianer"></div>
				</div>
				<div class="layui-form-item" style="width: 287px;margin-left: -14px;">
					<div class="layui-input-block">
						<button type="button" id="savePostions" 
							class="layui-btn layui-btn-sm layui-btn-normal"><i class="layui-icon">&#xe608;</i>新增</button>
						<button type="button"
							class="layui-btn layui-btn-sm layui-btn-warm layui-layer-close layui-layer-close1"><i class="layui-icon">&#x1006;</i>取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- js代码 -->
	<script>
	var limitcount = 8;
    var curnum = 1;
	//表格填充数据
	function productsearch(curnum,limitcount) {
		layui.use(['table','laypage'], function() {
			var table = layui.table;
			var laypage=layui.laypage;
			table.render({
				elem : '#positions',
				toolbar : '#insertAndDeletes',
				url : 'selectPositionsAlljsp.action?page='+curnum+'&row='+limitcount,
				cellMinWidth : 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
				cols : [ [{
					type : 'numbers'
				}, {
					type : 'checkbox'
				},{
					field : 'posiId',
					width : 180,
					title : '职位ID',
					sort : true
				}, {
					field : 'posiName',
					edit : 'text',
					width : 180,
					title : '职位名'
				}, {
					field : 'salary',
					edit : 'text',
					width : 180,
					title : '薪水',
					sort : true
				},{
					fixed : 'right',
					title : '操作',
					toolbar : '#positionBarDemo',
					width : 300,
					edit : 'text',
					event : "test"
				}
				] ],
				page : true,
				done: function(res, curr, count){
					laypage.render({
						elem: 'table-page' //注意，这里的  是 ID，不用加 # 号
					    ,count: count //数据总数，从服务端得到
					    ,limit:limitcount
	                    ,curr:curnum
	                    ,layout: ['prev', 'page', 'next', 'skip','count','limit']
					    ,jump:function(obj,first){
							if(!first){//判断不是首页
								curnum = obj.curr;
	                            limitcount = obj.limit;
					        	productsearch(curnum,limitcount);
							}
						}
					});
				}
			});
		});
	}
	productsearch(curnum, limitcount);//分页
		//对表格进行操作
		layui.use(['form','element','table','layedit','jquery','layer'],function(){
			var form=layui.form,
			layer = layui.layer,
			element=layui.element,
			table = layui.table,
			$=layui.jquery;
			//监听单元格编辑
			table.on('edit(positions)', function() {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
			});
			//表格右侧操作按钮监听事件
				var posiIda="";
			table.on('tool(positions)', function(obj) {
				var data = obj.data;
				if(obj.event === 'edit'){//确认修改
					$.post('updatePositions.action',data);
					layer.msg("编辑成功！");
				}else if(obj.event === 'del'){//删除
					layer.confirm('真的删除行么', function(index) {
						obj.del();
						$.post("deletePositionById.action", {
							"posiId" : data.posiId
						});
						layer.close(index);
					});
				}else if(obj.event === 'lookPosiName'){//查看职位对应的权限（可修改）
					var xtree1 = new layuiXtree({
						 elem: 'xtree1',
				         form: form ,
				         isopen: false,
				         data: 'selectMenuIdByPosiId.action?posiId='+data.posiId
					 });
					posiIda=data.posiId;
					 layer.open({
						type:1,
						anim:1,
						area:['330px','450px'],
						title:'职位：'+data.posiName+'---(可删除选中的权限)',
						content:$("#menuFrom"),
						cancel:function(){
							$("#menuFrom").css({"display":"none"});
						}
					 });
					 $("#deletePostions").click(function(){//删除选中的权限
						var oCks = xtree1.GetChecked();
						var array=new Array();
						for(var i = 0; i < oCks.length; i++) {
							array[i]=oCks[i].value;
						}
						if(array.length==0){
							layer.msg("您未选中！");
						}else{
							var result=true;
							for (var i = 0; i < array.length; i++) {
								if(array[i].length==3){
									result=false;
								}
							}
							if(result==true){
								$.post(
									'deleteMenuinfoByPidAndMid.action',
									{'posiId':data.posiId,'array':array},
									function(msg){
										if(msg=='ok'){
											window.location.href="positions.jsp";
											return false;
											}
										}
									);
								}else{
									layer.msg("无法删除一级菜单！");
								}
							
							}
						});
					}
				});
			$("#addPostions").click(function(){//新增权限
				layer.closeAll();
				$("#menuFrom").css({"display":"none"});
				 var xtree2 = new layuiXtree({
					 elem: 'xtree2',
			         form: form ,
			         isopen: false,
			         data: 'selectMenuIdAll.action?posiId='+posiIda
				 });
				 layer.open({
					type:1,
					anim:1,
					area:['330px','450px'],
					title:'新增权限---(可新增选中的权限)',
					content:$("#addMenuFrom"),
					cancel:function(){
						$("#addMenuFrom").css({"display":"none"});
					}
				 });
					var count=0;
				 $("#savePostions").off('click').click(function(){//保存新增的数据
					var oCks = xtree2.GetChecked();
					var addArray=new Array();
					for(var i = 0; i < oCks.length; i++) {
						addArray[i]=oCks[i].value;
					}
					if(addArray.length==0){
						layer.msg("您未选中！");
					}else{
						var result=true;
						for (var i = 0; i < addArray.length; i++) {
							if(addArray[i].length==3){
								result=false;
							}
						}
						if(result==true){
						$.post(
							'insertMenuinfoByPidAndMid.action',
							{'posiId':posiIda,'addArray':addArray},
							function(msg){
								if(msg=='ok'){
									window.location.href="positions.jsp";
									return false;
									}
								}
							);
						}else{
							layer.msg("无法添加一级菜单！");
						}
					}
				 });
			 });
			//表格上方的按钮
			table.on('toolbar(positions)', function(obj) {//新增
				var data = obj.data;
				var checkStatus = table.checkStatus(obj.config.id);
				if (obj.event === 'insert') {
					layer.open({
						type:1,
						anim:1,
						area:['400px','200px'],
						title:'新增职位',
						maxmin: true,
						content:$("#pnal"),
						cancel:function(){
							$("#pnal").css({"display":"none"});
						}
					});
				}
			});
			//表单验证
			form.verify({
				res:function(value){
					if(value.length<1){
						return'必填项不能为空';
					}
				}
			});
			//提交新增职位的表单
			form.on('submit(savePositions)',function(data){
				$.ajax({
					type:'post',
					url:'insertPositions.action',
					data:data.field,
					success:function(msg){
						if(msg=='ok'){
						 window.location.href="positions.jsp";
						}
					}
				});
				return true;
			});
		});
	</script>
</body>
</html>