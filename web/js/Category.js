$(function(){
	/* 非空校验 */
	$("#submit").click(function(){
		var cname=$("#cname").val();
		var description=$("#description").val();
		if($.trim(cname)==null || $.trim(cname)==""){
			$("#message0").empty().html("请输入类别名称");
			return false;
		}
		else{
			$("#message0").empty();
		}
		
		if($.trim(description)==null || $.trim(description)==""){
			$("#message1").empty().html("请输入类别描述");
			return false;
		}
		else{
			$("#message1").empty();
		}
	})

	/* 在类别名称输入完成的时候校验它是否超长 */
	$("#cname").change(function(){
		var cname = $("#cname").val();
		if($.trim(cname).length>15){
			$("#message0").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message0").empty();
			$("#submit").prop("disabled",false);
		}
	})

	$("#description").change(function(){
		var description = $(this).val();
		if($.trim(description).length>25){
			$("#message1").empty().html("类别描述长度不能超过25字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message1").empty();
			$("#submit").prop("disabled",false);
		}
	})

})