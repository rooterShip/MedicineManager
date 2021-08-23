$(function(){
	/* 非空校验 */
	$("#submit").click(function(){
		var cno=$("#cno").val();
		var cname=$("#cname").val();
		var cprice=$("#cprice").val();
		var cnum=$("#cnum").val();
		var cdate=$("#cdate").val();
		var cfac=$("#cfac").val();
		if($.trim(cno)==null || $.trim(cno)==""){
			$("#message0").empty().html("请输入药品编号");
			return false;
		}
		else{
			$("#message0").empty();
		}
		
		if($.trim(cname)==null || $.trim(cname)==""){
			$("#message1").empty().html("请输入药品名称");
			return false;
		}
		else{
			$("#message1").empty();
		}
		
		if($.trim(cprice)==null || $.trim(cprice)==""){
			$("#message2").empty().html("请输入药品单价");
			return false;
		}
		else{
			$("#message2").empty();
		}
		
		if($.trim(cnum)==null || $.trim(cnum)==""){
			$("#message3").empty().html("请输入库存数量");
			return false;
		}
		else{
			$("#message3").empty();
		}
		
		if($.trim(cdate)==null || $.trim(cdate)==""){
			$("#message4").empty().html("请输入生产日期");
			return false;
		}
		else{
			$("#message4").empty();
		}
		
		if($.trim(cfac)==null || $.trim(cfac)==""){
			$("#message5").empty().html("请输入生产厂商");
			return false;
		}
		else{
			$("#message5").empty();
		}
	})

	/* 在类别名称输入完成的时候校验它是否超长 */
	$("#cno").change(function(){
		var cno = $(this).val();
		if($.trim(cno).length>15){
			$("#message0").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message0").empty();
			$("#submit").prop("disabled",false);
		}
	})

	$("#cname").change(function(){
		var cname = $(this).val();
		if($.trim(cname).length>15){
			$("#message1").empty().html("类别描述长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message1").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#cprice").change(function(){
		var cprice = $(this).val();
		if($.trim(cprice).length>15){
			$("#message2").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message2").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#cnum").change(function(){
		var cnum = $(this).val();
		if($.trim(cnum).length>15){
			$("#message3").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message3").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#cdate").change(function(){
		var cdate = $(this).val();
		if($.trim(cdate).length>15){
			$("#message4").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message4").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#cfac").change(function(){
		var cfac = $(this).val();
		if($.trim(cfac).length>15){
			$("#message5").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message5").empty();
			$("#submit").prop("disabled",false);
		}
	})

})