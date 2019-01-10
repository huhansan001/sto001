<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>地址中心寄件表</title>
<link rel="stylesheet" href="css/pick-pcc.min.1.0.1.css">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/pick-pcc.min.1.0.1.js"></script> 
<script type="text/javascript" src="layui/layui.all.js" charset="utf-8"></script>

</head>
<body>

	<table class="layui-hide" id="SeviceTable_xwc"
		lay-filter="SeviceTable_xwc"></table>

	<!-- 新增所有的表单  -->
	<div class="layui-row" id="SeviceTable_xwcPnal" style="display: none;">
		<div class="layui-col-md10">
			<form action="insertServiceTable.action" class="layui-form"
				id="addSeviceTable_xwc">

				<div class="layui-form-item">
					<label class="layui-form-label">姓名：</label>
					<div class="layui-input-block">
						<input type="text" id="senderName" name="senderName" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号码：</label>
					<div class="layui-input-block">
						<input type="text" id="senderMobile" name="senderMobile" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">座机：</label>
					<div class="layui-input-block">
						<input type="text" id="senderPhone" name="senderPhone" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">寄件地址：</label>
					<div class="layui-input-block">
						<a href="javascript:void(0)" class="pick-area pick-area4"></a>
						<input type="hidden"  id="senderAddress" name="senderAddress" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">详细地址：</label>
					<div class="layui-input-block">
						<input type="text" id="senderDetailed" name="senderDetailed" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">类别：</label>
					<div class="layui-input-block">
						<select id="senderType" name="senderType" lay-filter="aihao">
							<option value=""></option>
							<option value="寄件人">寄件人</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">用户手机号：</label>
					<div class="layui-input-block">
						<input type="text" id="userInfoPhone" name="userInfoPhone" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 50px">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" lay-submit=""
							lay-filter="saveSeviceTable_xwc" id="save">保存</button>
						<button type="button" class="layui-btn layui-layer-close">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
<!-- 添加一个新增按钮 -->
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="insert"><i class="layui-icon">&#xe654;</i>新增</button>
</div>
	</script>
<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs"lay-event="edit"><i class="layui-icon">&#xe642;</i>确认编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	  
	</script>
<script>
	layui.use([ 'form', 'table', 'element', 'layedit', 'jquery', 'layer' ],
				function() {
				//得到所有组件
				var form = layui.form, layer = layui.layer, element = layui.element, table = layui.table, $ = layui.jquery;
				$("#save").click(function(){
					var senderName = "senderName="+$("#senderName").val();
					var senderMobile = "senderMobile="+$("#senderMobile").val();
					var senderPhone = "senderPhone="+$("#senderPhone").val();
					var senderAddress = "senderAddress="+$("#senderAddress").val();
					var senderDetailed = "senderDetailed="+$("#senderDetailed").val();
					var senderType = "senderType="+$("#senderType").val();
					var userInfoPhone = "userInfoPhone="+$("#userInfoPhone").val();
					$.ajax({
						type:"post",
						url:"http://localhost:8080/stoMaven/insertUserSender.action",
						data:senderName+"&"+senderMobile+"&"+senderPhone+"&"+senderAddress+"&"+senderDetailed+"&"+senderType+"&"+userInfoPhone,
						dataType:"text",
						success : function(msg){
							window.location.href = "UserSenderBakground.jsp";
						}
					});
				})
						form.render('select');
						form.on('select(interest)',
								function(data) {
								var select = $("select option[value='"+ data.value + "']").text();
									layui.use([ 'form', 'table','jquery','layer' ],
										function() {
											var form = layui.form, layer = layui.layer, table = layui.table, $ = layui.jquery;
											var demoReload = $('#demoReload');
									table.reload('testReload',{
											page : {
											curr : 1
											//重新从第 1 页开始
											},
									where : {
											select : select
											}
											});
										});
									});

						//表格数据填充	
						layui
								.use(
										'table',
										function() {
											var table = layui.table;
											table
													.render({
														elem : '#SeviceTable_xwc',
														url : 'selectUserSenderAllpage.action',
														toolbar : '#toolbarDemo',
														title : '地址中心寄件表',
														cols : [ [
																{
																	type : 'numbers'
																},
																{
																	type : 'checkbox'
																},
																{
																	field : 'senderName',
																	title : '姓名'
																},
																{
																	field : 'senderMobile',
																	edit : 'text',
																	title : '手机号码'
																},
																{
																	field : 'senderPhone',
																	edit : 'text',
																	title : '座机'
																},
																{
																	field : 'senderAddress',
																	edit : 'text',
																	title : '寄件人发件地址'
																},
																{
																	field : 'senderDetailed',
																	edit : 'text',
																	title : '详细地址'
																},
																{
																	field : 'senderType',
																	edit : 'text',
																	title : '类别'
																},
																{
																	field : 'userInfoPhone',
																	edit : 'text',
																	title : '用户的手机号'
																},
																{
																	fixed : 'right',
																	title : '操作',
																	width : 200,
																	toolbar : '#barDemo',
																	event : "test"
																} ] ],
														page : true,
														id : 'testReload',
													});

											/////////////////////////////////////////////////////////////////

											$('.demoTable .layui-btn')
													.on(
															'click',
															function() {
																layui
																		.use(
																				[
																						'form',
																						'table',
																						'jquery',
																						'layer' ],
																				function() {
																					var form = layui.form, layer = layui.layer, table = layui.table, $ = layui.jquery;
																					var demoReload = $('#demoReload');
																					table
																							.reload(
																									'testReload',
																									{
																										page : {
																											curr : 1
																										//重新从第 1 页开始
																										},
																										where : {
																											id : demoReload
																													.val()
																										}
																									});
																				});
															})
											/////////////////////////////////////////////////////////////
											//监听行工具事件
											table
													.on(
															'toolbar(SeviceTable_xwc)',
															function(obj) {
																var data = obj.data;
																if (obj.event === 'insert') {
																	layer
																			.open({
																				type : 1,
																				title : '新增',
																				anim : 6,
																				content : $("#SeviceTable_xwcPnal"),
																				area : [
																						'480px',
																						'500px' ],
																				cancel : function() {
																					$(
																							"#SeviceTable_xwcPnal")
																							.css(
																									{
																										"display" : "none"
																									});
																				}
																			});
																}
															})
											table
													.on(
															'edit(SeviceTable_xwc)',
															function(objs) {
																layer
																		.msg("编辑一行完毕后，请点击 右侧的 确认编辑");
															});
											table
													.on(
															'tool(SeviceTable_xwc)',
															function(obj) {
																var data = obj.data;
																if (obj.event === 'edit') {
																	$
																			.post(
																					"updateUserSender.action",
																					data);
																	layer
																			.msg("修改成功！");
																} else if (obj.event === 'del') {
																	$
																			.post(
																					"deleteUserSender.action",
																					data,
																					function(
																							msg) {
																						window.location.href = "UserSenderBakground.jsp";
																					});
																	layer
																			.msg("删除成功！");
																}
															});
										});

					});
</script>
<script >
	$(function() {
		/*联动地址*/
		$(".pick-area4").pickArea({
			"format": "province/city/county", //格式
			"width": "260", //设置“省市县”文本边框的宽度
			"height": "40", //设置“省市县”文本边框的高度
			"borderColor": "#ededed;", //设置“省市县”文本边框的色值
			"arrowColor": "#ededed;", //设置下拉箭头颜色
			"listBdColor": "#ededed;", //设置下拉框父元素ul的border色值
			"color": "#ededed;", //设置“省市县”字体颜色
			"fontSize": "13px", //设置字体大小
			"hoverColor": "#435abd",
			"paddingLeft": "8px", //设置“省”位置处的span相较于边框的距离
			"arrowRight": "10px", //设置下拉箭头距离边框右侧的距离
			"maxHeight": "300px",
			"background": "#000",
			//"preSet":"",//数据初始化 ；这里的数据初始化有两种方式，第一种是用preSet属性设置，第二种是在a标签里使用name属性设置
			"getVal": function() { //这个方法是每次选中一个省、市或者县之后，执行的方法
				var thisdom = $("." + $(".pick-area-dom").val()); //返回的是调用这个插件的元素pick-area，$(".pick-area-dom").val()的值是该元素的另一个class名，这个class名在dom结构中是唯一的，不会有重复，可以通过这个class名来识别这个pick-area
				thisdom.next().val($(".pick-area-hidden").val()); //$(".pick-area-hidden").val()是页面中隐藏域的值，存放着每次选中一个省、市或者县的时候，当前文本存放的省市县的最新值，每点击一次下拉框里的li，这个值就会立即更新
			}
		});
	});
	</script> 
</html>