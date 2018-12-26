<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工权限菜单</title>
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
	<table class="layui-hide" id="stoMenu" lay-filter="stoMenu"></table>
	<!-- 新增，批量删除 ，选择收件员-->
	<script type="text/html" id="menuAdd">
		<div class="layui-btn-container">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="insert"><i class="layui-icon">&#xe608;</i>新增</button>
			<button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="deletep"><i class="layui-icon">&#xe640;</i>批量删除</button>
		</div>
		<form class="layui-form" action="" style="width: 371px;position: absolute;left: 200px;bottom: -9px;">
			<div class="layui-form-item">
				<label style="width: 100px;" class="layui-form-label">选择收件员</label>
				<div class="layui-input-inline">
				<select name="interest">
				</select>
				<button type="button" lay-submit=""
				class="layui-btn layui-btn-danger 
				layui-btn-sm" style="position: absolute;bottom: 4px;left: 196px;">发送</button>
    			</div>
  			</div>
		</form>
	</script>
	<!-- 删除 -->
	<script type="text/html" id="barMenu">
  		<a class="layui-btn layui-btn-xs"lay-event="editMenu"><i class="layui-icon">&#xe642;</i>确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
	<!-- 需要弹出的添加菜单功能界面  -->
	<div class="layui-row" id="pnal" style="display: none; margin-top: 10px">
		<div class="layui-col-md10">
			<form class="layui-form" id="addPositions">
				<div class="layui-form-item">
					<label class="layui-form-label">菜单ID：</label>
					<div class="layui-input-block">
						<input  lay-verify="res" type="text" name="menuId" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">标题：</label>
					<div class="layui-input-block">
						<input  lay-verify="res" type="text" name="title" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址：</label>
					<div class="layui-input-block">
						<input  lay-verify="res" type="text" name="url" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">父级ID：</label>
					<div class="layui-input-block">
						<input  lay-verify="res" type="text" name="pid" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 50px">
					<div class="layui-input-block">
						<button type="button" lay-submit=""
							class="layui-btn layui-btn-danger layui-btn-sm"  lay-filter="saveMenu">保存</button>
						<button type="button"
							class="layui-btn layui-btn-sm layui-btn-warm layui-layer-close layui-layer-close1">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--js代码  -->
	<script type="text/javascript">
		var limitcount = 8;
	    var curnum = 1;
	function productsearch(curnum,limitcount) {
		layui.use(['table','laypage'], function() {//填充数据
			var table = layui.table;
			var laypage = layui.laypage;
			table.render({
				elem : '#stoMenu',
				toolbar : '#menuAdd',
				url : 'selectMenuAll.action?page='+curnum+'&row='+limitcount,
				cellMinWidth : 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
				cols : [ [{
					type : 'numbers'
				}, {
					type : 'checkbox'
				},{
					field : 'menuId',
					width : 180,
					templet:'#root',
					title : '菜单ID'
				}, {
					field : 'title',
					edit : 'text',
					width : 180,
					title : '菜单标题'
				}, {
					field : 'url',
					edit : 'text',
					width : 180,
					title : '地址'
				},{
					field : 'pid',
					edit : 'text',
					width : 180,
					title : '父级id'
				},{
					fixed : 'right',
					title : '操作',
					toolbar :'#barMenu',
					width : 300,
					edit : 'text',
					event : "test"
				}
				] ],
				page : true
				,done: function(res, curr, count){
				laypage.render({
					elem:'table-page' //注意，这里的 test1 是 ID，不用加 # 号
				    ,count: count //数据总数，从服务端得到
				    ,limit:limitcount
                    ,curr:curnum
                    ,layout: ['prev', 'page', 'next', 'skip','count','limit']
				    ,jump:function(obj,first){
						if(!first){
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
productsearch(curnum, limitcount);
		//对表格进行操作
		layui.use(['form','element','laypage','table','layedit','jquery','layer'],function(){
			var form=layui.form,
			layer = layui.layer,
			element=layui.element,
			table = layui.table,
			$=layui.jquery;
			//监听单元格编辑
			table.on('edit(stoMenu)', function() {
				layer.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
			});
			//表格右侧操作按钮监听事件
			table.on('tool(stoMenu)', function(obj) {
				var data = obj.data;
				if(obj.event === 'del'){
					layer.confirm('真的删除行么', function(index) {//确认删除
						obj.del();
						$.post("deleteMenuById.action", {
							"menuId" : data.menuId
						});
						layer.close(index);
					});
				}else if(obj.event === 'editMenu'){//修改
					//window.location.href="stoMenu.jsp";
					$.post('updateMenuById.action',data);
					layer.msg("编辑成功！");
				}
			});
			//表格上方的按钮
			table.on('toolbar(stoMenu)', function(obj) {//新增
				var data = obj.data;
				var checkStatus = table.checkStatus(obj.config.id);
				if (obj.event === 'insert') {
					layer.open({
						type:1,
						anim:1,
						area:['400px','330px'],
						title:'新增菜单',
						maxmin: true,
						content:$("#pnal"),
						cancel:function(){
							$("#pnal").css({"display":"none"});
						}
					});
				}else if (obj.event === 'deletep') {//批量删除
					var data = checkStatus.data;
					//判断未选中
					if (data.length === 0) {
						layer.msg("您未选中！");
					} else {
						layer.confirm('真的删除选中行么', function(index) {
							var data = checkStatus.data;
							var array=new Array();
							for (var i = 0; i < data.length; i++) {
								array[i]=data[i].menuId;
							}
							$.post(
								"deleteMenuByIdBatch.action",
								{"menuId":array}
							); 
							$(".layer-from-checked").not('.header').parents('tr').remove();
							location.reload(true);
						});
					}
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
			form.on('submit(saveMenu)',function(data){
				alert(123);
				$.ajax({
					type:'post',
					url:'insertMneu.action',
					data:data.field,
					success:function(msg){
						if(msg=='ok'){
						 window.location.href="stoMenu.jsp";
						}
					}
				});
				return true;
			});
		});
	</script>
	
	
	
	
	<!-- 设置单元格样式 -->
	<script type="text/html" id="root">
		{{#  if(d.menuId.length === 3){ }}
    		<span style="color: #F69A11;">{{ d.menuId }}</span>
  		{{#  } else { }}
    		{{ d.menuId }}
  		{{#  } }}
	</script>
</body>
</html>