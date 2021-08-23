$(function(){
	$("#submit").click(function(){
		var username = $("#username").val();
		var forepassword = $("#forepassword").val();
		var newpassword = $("#newpassword").val();
		var rpassword = $("#rpassword").val();
		if($.trim(username)==null || $.trim(username)==""){
			$("#message0").empty().html("请输入用户名")
			$("#submit").prop("disabled",true);
		}else{
			$("#message0").empty()
			$("#submit").prop("disabled",false);
		}
		
		if($.trim(forepassword)==null || $.trim(forepassword)==""){
			$("#message1").empty().html("请输入旧密码")
			$("#submit").prop("disabled",true);
		}else{
			$("#message1").empty()
			$("#submit").prop("disabled",false);
		}
		
		if($.trim(newpassword)==null || $.trim(newpassword)==""){
			$("#message2").empty().html("请输入新密码")
			$("#submit").prop("disabled",true);
		}else{
			$("#message2").empty()
			$("#submit").prop("disabled",false);
		}
		
		if($.trim(rpassword)==null || $.trim(rpassword)==""){
			$("#message3").empty().html("请重复输入密码")
			$("#submit").prop("disabled",true);
		}else{
			$("#message3").empty()
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#username").change(function(){
		var username = $(this).val();
		if($.trim(username).length>15){
			$("#message0").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message0").empty();
			$("#submit").prop("disabled",false);
		}
	})

	$("#forepassword").change(function(){
		var forepassword = $(this).val();
		if($.trim(forepassword).length>15){
			$("#message1").empty().html("类别描述长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message1").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#newpassword").change(function(){
		var newpassword = $(this).val();
		if($.trim(newpassword).length>15){
			$("#message2").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message2").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#rpassword").change(function(){
		var rpassword = $(this).val();
		if($.trim(rpassword).length>15){
			$("#message3").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message3").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$(":input[name='rpassword']").change(function(){
		var rpassword = $(this).val();
		rpassword = $.trim(rpassword);
		var newpassword = $(":input[name='newpassword']").val();
		newpassword = $.trim(newpassword);
		if(newpassword != rpassword){
			$("#message3").empty().html("对不起, 两次密码输入不一致").css("color","red");
			$(":input[name='submit']").attr("disabled",true);
		}else{
			$("#message3").empty();
			$(":input[name='submit']").attr("disabled",false);
		}
	})
})