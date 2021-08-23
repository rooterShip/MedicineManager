$(function(){
	$("#submit").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var rpassword = $("#rpassword").val();
		var nickname = $("#nickname").val();
		var mobile = $("#mobile").val();
		if($.trim(username)==null || $.trim(username)==""){
			$("#message0").empty().html("请输入用户名")
			$("#submit").prop("disabled",true);
		}else{
			$("#message0").empty()
			$("#submit").prop("disabled",false);
		}
		
		if($.trim(password)==null || $.trim(password)==""){
			$("#message1").empty().html("请输入密码")
			$("#submit").prop("disabled",true);
		}else{
			$("#message1").empty()
			$("#submit").prop("disabled",false);
		}
		
		if($.trim(rpassword)==null || $.trim(rpassword)==""){
			$("#message2").empty().html("请重复输入密码")
			$("#submit").prop("disabled",true);
		}else{
			$("#message2").empty()
			$("#submit").prop("disabled",false);
		}
		
		if($.trim(nickname)==null || $.trim(nickname)==""){
			$("#message3").empty().html("请输入用户昵称")
			$("#submit").prop("disabled",true);
		}else{
			$("#message3").empty()
			$("#submit").prop("disabled",false);
		}
		
		if($.trim(mobile)==null || $.trim(mobile)==""){
			$("#message4").empty().html("请输入联系方式")
			$("#submit").prop("disabled",true);
		}else{
			$("#message4").empty()
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

	$("#password").change(function(){
		var password = $(this).val();
		if($.trim(password).length>15){
			$("#message1").empty().html("类别描述长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message1").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#rpassword").change(function(){
		var rpassword = $(this).val();
		if($.trim(rpassword).length>15){
			$("#message2").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message2").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#nickname").change(function(){
		var nickname = $(this).val();
		if($.trim(nickname).length>15){
			$("#message3").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message3").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$("#mobile").change(function(){
		var mobile = $(this).val();
		if($.trim(mobile).length>15){
			$("#message4").empty().html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message4").empty();
			$("#submit").prop("disabled",false);
		}
	})
	
	$(":input[name='rpassword']").change(function(){
		var rpassword = $(this).val();
		rpassword = $.trim(rpassword);
		var password = $(":input[name='password']").val();
		password = $.trim(password);
		if(password != rpassword){
			$("#message2").empty().html("对不起, 两次密码输入不一致").css("color","red");
			$(":input[name='submit']").attr("disabled",true);
		}else{
			$("#message2").empty();
			$(":input[name='submit']").attr("disabled",false);
		}
	})
})