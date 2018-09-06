$(document).ready(()=>{
	
	$(function() {
		$('#doc-my-tabs').tabs();
	})
	/*
	 * 获取验证码
	 */
	$("#member_btn").click(()=>{
		var phone = $("#member_phone").val();
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType:"json",
				data: {
					"phone": phone
				},
				success:function(result){
					alert("已发送验证码，请注意查收！");
				},
				error:function(result){
					alert("验证码发送失败！");
				}
			});
		}
	})
	$("#merchant_btn").click(()=>{
		var phone = $("#merchant_phone").val();
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType:"json",
				data: {
					"phone": phone
				},
				success:function(result){
					alert("已发送验证码，请注意查收！");
				},
				error:function(result){
					alert("验证码发送失败！");
				}
			});
		}
	})
	
	/*
	 * 会员注册
	 */
	$("#member_reg").click(()=>{
		var phone = $("#member_phone").val();
		var code = $("#member_code").val();
		var pwd = $("#member_pwd").val();
		var repwd = $("#member_repwd").val();
		
		var User = {
			"loginName": phone,
			"code": code,
			"password": pwd
		};
		
		if(pwd != repwd){
			alert("两次密码不一致!");
		}
		else{
			$.ajax({
				type:"post",
				url:"/userRegister",
				async:true,
				dataType:"json",
				data: User,
				success:function(result){
					alert("注册成功！");
					window.location.href = "login.html?type=1";
				},
				error:function(result){
					alert("注册失败！");
				}
			});
		}
	})
	
	/*
	 * 商家注册
	 */
	$("#merchant_reg").click(()=>{
		var phone = $("#merchant_phone").val();
		var code = $("#merchant_code").val();
		var pwd = $("#merchant_pwd").val();
		var repwd = $("#merchant_repwd").val();
		var name = $("#merchant_name").val();
		var address = $("#merchant_address").val();
		
		var Sales = {
			"salesName": name,
			"selesPhone": phone,
			"salesAddress": address,
			"salesPwd": pwd,
			"code": code
		};
		
		if(pwd != repwd){
			alert("两次密码不一致");
		}
		else if(name == "" || address == "" || phone == "" ||
			pwd == "" || repwd == "" || code == ""){
			alert("请填写完整的资料");
		}
		else{
			alert("注册成功！");
			window.location.href = "login.html?type=2";
//			$.ajax({
//				type:"post",
//				url:"/salesRegister",
//				async:true,
//				dataType:"json",
//				data: Sales,
//				success:function(result){
//					alert("注册成功！");
//					window.location.href = "login.html?type=2";
//				},
//				error:function(result){
//					alert("注册失败！");
//				}
//			});
		}
	})
	
})
