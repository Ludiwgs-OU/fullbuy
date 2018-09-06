/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

$(document).ready(()=>{
	
	$(function(){
		var type = getUrlParam('type');
		if(type == 1){
			$("#member").show();
		}
		else if(type == 2){
			$("#merchant").show();
		}
		else if(type == 3){
			$("#pwd").show();
		}
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
			alert(phone);
		}
	})
	$("#merchant_btn").click(()=>{
		var phone = $("#merchant_mphone").val();
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			alert(phone);
		}
	})
	$("#pwd_btn").click(()=>{
		var phone = $("#pwd_phone").val();
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			alert(phone);
		}
	})
	
	/*
	 * 会员注册
	 */
	$("#member_register").click(()=>{
		var phone = $("#member_phone").val();
		var code = $("#member_code").val();
		var memberReg = {
			"loginName": phone,
			"code": code
		};
		
		$.ajax({
			type:"post",
			url:"",
			async:true,
			dataType:"json",
			data: memberReg,
			success:function(result){
				alert("注册成功！");
				history.go(-1);
			},
			error:function(result){
				alert("注册失败！");
			}
		});
	})
	
	/*
	 * 商家注册
	 */
	$("#merchat_register").click(()=>{
		var username = $("#merchant_mphone").val();
		var name = $("#merchant_name").val();
		var address = $("#merchant_address").val();
		var phone = $("#merchant_phone").val();
		var pass = $("#merchant_pass").val();
		var repass = $("#repass").val();
		var des = $("#merchant_des").val();
		var code = $("#merchant_code").val();
		
		var merchantReg = {
			"username": username,
			"salesName": name,
			"selesPhone": phone,
			"salesAddress": address,
			"salesDetail": des,
			"salesPwd": pass,
			"code": code
		};
		
		if(pass != repass){
			alert("两次密码不一致");
		}
		else if(username == "" || name == "" || address == "" || phone == "" ||
			pass == "" || repass == "" || des == "" || code == ""){
			alert("请填写完整的资料");
		}
		else{
			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType:"json",
				data: merchantReg,
				success:function(result){
					alert("注册成功！");
					history.go(-1);
				},
				error:function(result){
					alert("注册失败！");
				}
			});
		}
	})
	
	/*
	 * 忘记密码
	 */
	$("#change_pwd").click(()=>{
		var phone = $("#pwd_phone").val();
		var code = $("#pwd_code").val();
		var pass = $("#pwd_pass").val();
		var repass = $("#pwd_repass").val();
		
		var changPwd = {
			"username": phone,
			"code": code,
			"salesPwd": pass
		};
		
		if(pass != repass){
			alert("两次密码不一致！");
		}
		else{
			$.ajax({
				type:"post",
				url:"",
				async:true,
					dataType:"json",
				data: memberReg,
				success:function(result){
					alert("修改成功！");
					history.go(-1);
				},
				error:function(result){
					alert("修改失败！");
				}
			});
		}
	})
	
})
