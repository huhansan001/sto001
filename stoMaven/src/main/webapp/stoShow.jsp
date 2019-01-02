<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申通后台管理系统</title>
<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="layui/css/layui.css" media="all">
		<script type="text/javascript" src="layui/jquery.min.js"></script>
		<script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
	</head>
	<style>
		a {
			cursor: pointer;
		}
		iframe{
			margin: -10px;
			margin-top: -19px;
			
		}
	</style>

	<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<img src="imgs/sto_logo.png" />
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">
						<a href="javascript:;">
							<img src="imgs/${empName}.jpg" class="layui-nav-img">${empName}
						</a>
					</li>
					<li class="layui-nav-item">
						<a href="stoLogin.jsp">退出</a>
					</li>
				</ul>
			</div>
			<!--
            	作者：2496433105@qq.com
            	时间：2018-12-04
            	描述：左侧菜单栏
            -->
			<div class="layui-side layui-bg-black">
				<div class="layui-side-scroll">
					<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
					<ul class="layui-nav layui-nav-tree" lay-filter="test">
						<li class="layui-nav-item layui-nav-itemed">
							<c:forEach var="p" items="${menuList}">
								<a class="" href="javascript:;">${p.title}</a>
								<dl class="layui-nav-child">
									<c:forEach var="l"  items="${p.menuList}" varStatus="k">
										<dd>
											<a class="site-demo-active" id="${l.url}" name="${k.index}" data-type="tabAdd">${l.title}</a>
										</dd>
									</c:forEach>
								</dl>
							</c:forEach>
						</li>
					</ul>
				</div>
			</div>
			<!--
            	作者：2496433105@qq.com
            	时间：2018-12-04
            	描述：内容主体区域 
            -->
			<div class="layui-body">
				<div class="layui-tab layui-tab-card" style="margin-top:0px;" lay-filter="demo">
					<!--
                    	作者：2496433105@qq.com
                    	时间：2018-12-04
                    	描述：选项卡
                    -->
					<ul class="layui-tab-title">
						<li class="layui-this">首页</li>
					</ul>
					<!--<ul class="rightmenu" style="border: 1px solid grey; width:60px; display: none;">
						<li data-type="closethis" style="cursor: pointer;">关闭当前</li>
						<li data-type="closeall" style="cursor: pointer;">关闭所有</li>
					</ul>-->
					<ul class="rightmenu" style="display: none;position: absolute; border:1px solid darkgray;background-color: gainsboro;">
						<li data-type="closethis" style="cursor: pointer;">关闭当前</li>
						<li data-type="closeall" style="cursor: pointer;">关闭所有</li>
					</ul>
					<!-- 内容区域-->
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show" style="height:450px;">
							<h1>欢迎来到申通管理系统</h1>
						</div>
					</div>
				</div>
			</div>
			<div class="layui-footer ">
				<!-- 底部固定区域 -->
				© 2017.All RIGHT RESERVED.申通快递有限公司 版权所有
			</div>
		</div>

		<script>
			layui.use('element', function() {
				var $ = layui.jquery,
					element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

				//触发事件
				var active = {
					tabAdd: function() {
						var urls = $(this).attr("id");
						var name = $(this).text();
						var id = $(this).attr("name");
						var lay_arr = new Array();
						var has_id = 0;
						$(".layui-tab-title li").each(function() {
							lay_arr.push($(this).attr('lay-id'));
							for(var i in lay_arr) { //判断变量id值是否在其中
								if(lay_arr[i] == id) {
									has_id = 1;
								}
							}
						});
						if(has_id == 1) { //判断重复添加选项卡
							element.tabChange('demo', id); //将焦点放在新建的选项卡中
						} else {
							//新增一个Tab项
							//<iframe frameborder="0" src="'+urls+'.html" style="width:102%;height:480px;"></iframe>
							element.tabAdd('demo', {
								title: name,
								content: '<iframe frameborder="0" src="'+urls+'" style="width:102%;height:480px;"></iframe>',
								id: id //实际使用一般是规定好的id，这里以时间戳模拟下
							});
							element.tabChange('demo', id);
						}
						CustomRightClick(id); //给tab绑定右击事件
					},
				};
				$('.site-demo-active').on('click', function() {
					var othis = $(this),
						type = othis.data('type');
					active[type] ? active[type].call(this, othis) : '';
				});
				//选项卡的右击事件
				function CustomRightClick(id) {
					//取消右键  rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
					$('.layui-tab-title li').on('contextmenu', function() {
						return false;
					})
					$('.layui-tab-title,.layui-tab-title li').click(function() {
						$('.rightmenu').hide();
					});
					//桌面点击右击 
					$('.layui-tab-title li').on('contextmenu', function(e) {
						var popupmenu = $(".rightmenu");
						popupmenu.find("li").attr("data-id", id); //在右键菜单中的标签绑定id属性
						//判断右侧菜单的位置 
						popupmenu.css({
							left: e.clientX - 200,
							top: e.clientY - popupmenu.height()
						}).show(); //进行绝对定位
						//alert("右键菜单")
						return false;
					});
				}

				$(".rightmenu li").click(function() {
					//右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
					if($(this).attr("data-type") == "closethis") {
						//如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
						element.tabDelete('demo',$(this).attr("data-id"))
					} else if($(this).attr("data-type") == "closeall") {
						var tabtitle = $(".layui-tab-title li");
						var ids = new Array();
						$.each(tabtitle, function(i) {
							//ids[i] = $(this).attr("lay-id");
							element.tabDelete('demo',$(this).attr("lay-id"));
						})
					}
					$('.rightmenu').hide(); //最后再隐藏右键菜单
				});
				$(document).click(function(){
					$('.rightmenu').hide();
				})
			});
		</script>
	</body>

</html>