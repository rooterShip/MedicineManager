$(function(){
	$("#submit").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if($.trim(username)==null || $.trim(username)==""){
			alert("请输入用户名");
			return false;//阻止默认行为
		}
		if($.trim(password)==null || $.trim(password)==""){
			alert("请输入用户密码");
			return false;
		}
	})
})