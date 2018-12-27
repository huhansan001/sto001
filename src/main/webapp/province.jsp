<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>省网点管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="./layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/jquery.min.js"></script>
</head>
<body>
	<table class="layui-hide" id="Province" lay-filter="Province"></table>

	<!-- 获取选中行数据 -->
	<script type="text/html" id="toolbarDemo">
  		<div class="layui-btn-container">
   		 	<button class="layui-btn layui-btn-sm" lay-event="getCheckData">批量删除</button>
			<button class="layui-btn layui-btn-sm" lay-event="btnInsert">新增</button>
 		</div>
	</script>
	<!-- 行按钮 -->
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">确认编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<!-- 新增表单 -->
	<div class="layui-row" id="insert" style="display: none;margin-top: 40px">
		<div class="layui-col-md10">
			<form action="provinceAdd.action" class="layui-form" id="province">
				<div class="layui-form-item">
					<label class="layui-form-label">省级名称</label>
					<div class="layui-input-block">
						<input type="text" name="provinceName" autocomplete="off"
							class="layui-input"  lay-verify="provinceName" placeholder="请输入省级名称">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">网点数量</label>
					<div class="layui-input-block">
						<input type="text" name="proNumber" autocomplete="off"
							class="layui-input"  lay-verify="proNumber" placeholder="请输入网点数量">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">市级Id</label>
					<div class="layui-input-block">
						<input type="text" name="cityId" autocomplete="off"
							class="layui-input"  lay-verify="cityId" placeholder="请输入市级Id">
					</div>
				</div>
				
				<div class="layui-form-item" style="margin-left: 50px;margin-top: 30px">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" lay-submit=""
							lay-filter="inserts">保存</button>
						<button type="button" class="layui-btn layui-layer-close">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="./layui/layui.all.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
	layui.use(['table','form'], function(){
	  var table = layui.table,form=layui.form;
	  table.render({
	    elem: '#Province'
	    ,url:'pageProvince.action'
	    ,toolbar: '#toolbarDemo'
	    ,cols: [[
	       {type: 'checkbox', fixed: 'left'}
	      ,{field:'proId',  title: '省级Id', sort: true}
	      ,{field:'provinceName', title: '省级名称',edit: 'text'}
	      ,{field:'proNumber',  title: '省级网点数量',edit: 'text', sort: true}
	      ,{field:'cityId',  title: '市级ID',edit: 'text'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
	    ]]
	    ,page: true
	  });
	//监听表格复选框选择
	  table.on('checkbox(demo)', function(obj){
	    console.log(obj);
	  });
	  //头工具栏事件
	  table.on('toolbar(Province)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id),data = checkStatus.data,ids="";
	    switch(obj.event){
	      case 'getCheckData':
	    	  //批量删除
	        //layer.alert(JSON.stringify(data));
	         for (var i in data){
	        	  if(i==0){
	        		  ids=ids+data[i].proId;
	        	  }else{
	        		  ids=ids+"-"+data[i].proId;
	        	  }
	        	  layer.close(i);
	         }
		     layer.confirm('真的删除行么', function(index){
		    		 $.post('delProvince.action','proId='+ids,function(msg){window.location.href="province.jsp";});
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
	    };
	  });
	//form表单提交监听事件
		form.on('submit(inserts)',function(data){
			//layer.alert(JSON.stringify(data.field));
			$.post('insProvince.action',data.field,function(msg){window.location.href="province.jsp";});
		});
	  //监听行工具事件
		  table.on('tool(Province)', function(obj){
		    var data = obj.data;
		     if(obj.event === 'del'){
		      layer.confirm('真的删除行么', function(index){
		        obj.del();
		       // layer.close(index);
		        $.post('delProvince.action','proId='+data.proId,function(msg){window.location.href="province.jsp";});
		      });
		    } else if(obj.event === 'edit'){
		     // layer.alert('编辑行：<br>'+ JSON.stringify(data));
		      $.post('upProvince.action',data);
		      layer.msg("已保存");
		    }
		  });
	  
		//监听单元格编辑
	  table.on('edit(Province)', function(obj){
	    var value = obj.value //得到修改后的值
	    ,data = obj.data //得到所在行所有键值
	    ,field = obj.field; //得到字段
	    layer.msg("请点击右侧确定编辑");
	  });
	//自定义验证规则
	  form.verify({
		  provinceName: function(value){
	      if(value.length < 1){
	        return '请输入省级名称';
	      }
	    }
	    ,proNumber: function(value){
		  if(value.length < 1){
			return '请输入省级网点数量';
		  }
		}
	    ,cityId: function(value){
	      if(value.length < 1){
			return '请输入市级ID';
		  }
	    }
	  });
	});
</script>


</body>
</html>