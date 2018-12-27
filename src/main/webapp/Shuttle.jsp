<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>班车管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/layui.all.js"></script>
<style type="text/css">
        .layui-table-cell {
            height: 40px;
        }
       .layui-form-select dl {
		position: fixed;
		top: initial;
		left: initial;
		min-width: 185px;
		}
        
    </style>
</head>
<body>

	<!-- 新增表单 -->
	<div class="layui-row" id="insert" style="display: none;margin-top: 25px">
		<div class="layui-col-md10">
			<form action="insComPackage.action" class="layui-form" id="addComPackage">
			<div class="layui-form-item">
					<label class="layui-form-label">车牌号</label>
					<div class="layui-input-block">
						<input type="text" name="goodsNo" autocomplete="off"
							class="layui-input" lay-verify="goodsNo" placeholder="请输入车牌号">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">路线</label>
					<div class="layui-input-block">
						<input type="text" name="stand" autocomplete="off"
							class="layui-input" lay-verify="stand" placeholder="请输入路线">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">班车状态</label>
					<div class="layui-input-block">
						<input type="text" name="shuttleState" autocomplete="off"
							class="layui-input" lay-verify="shuttleState" placeholder="请输入班车状态">
					</div>
				</div>
				<div class="layui-form-item" style="margin-left: 50px;margin-top: 38px;">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" lay-submit=""
							lay-filter="inserts">保存</button>
						<button type="button" class="layui-btn layui-layer-close">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
<%-- <c:forEach begin="0" end=".length" var="ss"> </c:forEach> --%>
	<table class="layui-hide" id="Shuttle" lay-filter="Shuttle"></table>
	<!-- 获取选中行数据 -->
	<script type="text/html" id="toolbarDemo">
  		<div class="layui-btn-container">
   		 	<button class="layui-btn layui-btn-sm" lay-event="getCheckData">批量删除</button>
			<button class="layui-btn layui-btn-sm" lay-event="btnInsert">新增</button>
 			<button class="layui-btn layui-btn-sm" lay-event="depart">发车</button>
		</div>
	</script>
	<!-- 行按钮 -->
	<script type="text/html" id="barDemo">
  		<!-- <a class="layui-btn layui-btn-xs" lay-event="edit">确认编辑</a>-->
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<!-- 当前现站 <div>{{d.stationList.length}}</div>-->
	<script type="text/html" id="ShueRoute">
		<div class="layui-inline">
	      <div class="layui-input-inline" lay-filter="ShueRoute"  lay-event="selects">
	        <select name="quiz{{d.shuttleId}}" lay-filter="quiz" id="quiz">
				<c:forEach begin="0" end="3" varStatus="stat">
					<option {{d.stationList[${stat.index}]==""+d.standList[${stat.index}]+":已过站"?'disabled':''}} value="{{d.shuttleId}}${stat.index}">{{d.stationList[${stat.index}]}}</option>
				</c:forEach>
	        </select>
	      </div>
	    </div>
		<div class="layui-inline" style="display: none;">
	      <div class="layui-input-inline" lay-filter="ShueRoute"  lay-event="selects">
	        <select name="squiz{{d.shuttleId}}" lay-filter="quiz" id="squiz{{d.shuttleId}}">
				<c:forEach begin="0" end="3" varStatus="stat">
					<option {{d.stationList[${stat.index}]==""+d.standList[${stat.index}]+":已过站"?'disabled':''}} value="s{{d.shuttleId}}${stat.index}">{{d.stationList[${stat.index}]}}</option>
				</c:forEach>
	        </select>
	      </div>
	    </div>
	</script>
	<script>
	layui.use(['table','form','layer'], function(){
	  var table = layui.table,form=layui.form
	  layer=layui.layer;
	  table.render({
	    elem: '#Shuttle'
	    ,url:'pageShuttle.action'
	    ,toolbar: '#toolbarDemo'
	    ,page: true //开启分页
	    ,cols: [[
	       {type: 'checkbox', fixed: 'left'}
	      ,{field:'goodsNo',  title: '班车编号', sort: true}
	      ,{field:'right',title: '现站',toolbar:'#ShueRoute'}
	      ,{field:'shuttleState',  title: '班车状态', sort: true}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
	    ]]
	  });
	  //下拉列表的点击事件
	  form.render('select');
	  form.on('select(quiz)', function(data){
		  var value=data.value-1;
		  var values=value-1;
		  var res=$("#"+values+"").attr("class")=="";
		  var resu=$("#"+values+"").attr("class")=="";
		  var resul=$("#"+data.value+"").text();
		  if($('#squiz'+parseInt(data.value/10)+' option:selected').val().substring(1,3)==data.value){
			  layer.msg("警告！不可重复点击！");
		  }else{
		  if(res==false&&data.value%10!=0){
			  if(resul=="未发车"){
				  layer.msg("对不起，未发车！");
			  }else{
			  $("#"+value+"").attr("class"," layui-disabled");
				 $.post(
					 'nextStie.action',
					 'shuttleId='+parseInt(value/10)+'&station='+$("#"+value+"").text()+"&index="+(data.value%10),
					 function(msg){
						if(msg=="ok"){
							window.location.href="Shuttle.jsp";
						} 
					 }
				 );
			  }
		  }else{
			  if(data.value%10!=0){
				  if(resul=="未发车"){
					  layer.msg("对不起，未发车！");
				  }else{
					  layer.msg("对不起，不可越站！"); 
					  var val=$('#squiz'+parseInt(value/10)+' option:selected').val().substring(1,3);
					 $("select[name='quiz"+parseInt(value/10)+"']").val(val);
					  form.render('select');
				}
			  }
		  } 
		  }
	  });
	//监听表格复选框选择
	  table.on('checkbox(demo)', function(obj){
	    console.log(obj);
	  });
	  //头工具栏事件
	  table.on('toolbar(Shuttle)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id),data = checkStatus.data,ids="";
	    switch(obj.event){
	      case 'getCheckData':
	    	  //批量删除
	         for (var i in data){
	        	  if(i==0){
	        		  ids=ids+data[i].shuttleId;
	        	  }else{
	        		  ids=ids+"-"+data[i].shuttleId;
	        	  }
	        	  layer.close(i);
	         }
		     layer.confirm('真的删除行么', function(index){
		    		 $.post('delShuttle.action','shuttleId='+ids,function(msg){window.location.href="Shuttle.jsp";});
			      });
	      break;
	      case 'btnInsert':
	    	  //新增
	    	  layer.open({
	    		 type :1,
				 title :'新增',
				 anim:6,
				 content :$("#insert"),
				 area: ['430px', '400px'],
				 cancel:function(){
						$("#insert").css({"display":"none"});
					}
	    		}); 
	      break;
	    	case 'depart': //发车监听事件
	    		if(data.length === 0){
	    			layer.msg("您未选中！");
	    		}else{
	    			var array=new Array();
	    			var res=true;
					for (var i = 0; i < data.length; i++) {
						array[i]=data[i].shuttleId;
						if(data[i].shuttleState=="已发车"){
							res=false
						}
					}
					if(res){
						$.post(
							"depart.action",
							{"shuttleId":array},
							function(msg){
								if(msg=="ok"){
									window.location.href="Shuttle.jsp";
								}
							}
						);
					}else{
						layer.msg("对不起，您选择的车辆已发车");
					}
	    		}
	    	break;
	    };
	  });
	//form表单提交监听事件
		form.on('submit(inserts)',function(data){
			$.post('insShuttle.action',data.field,function(msg){window.location.href="Shuttle.jsp";});
			
		});
	  //监听行工具事件
		  table.on('tool(Shuttle)', function(obj){
		    var data = obj.data;
		     if(obj.event === 'del'){
		      layer.confirm('真的删除行么', function(index){
		        obj.del();
		        layer.close(index);
		        $.post('delShuttle.action','shuttleId='+data.shuttleId);
		      });
		    } else if(obj.event === 'edit'){
		      $.post('upShuttle.action',data);
		      layer.msg("已保存");
		    }
		  });
	  
		//监听单元格编辑
	  table.on('edit(Shuttle)', function(obj){
	    var value = obj.value //得到修改后的值
	    ,data = obj.data //得到所在行所有键值
	    ,field = obj.field; //得到字段
	    layer.msg("请点击右侧确定编辑");
	  });
	});
	
</script>
</body>
</html>