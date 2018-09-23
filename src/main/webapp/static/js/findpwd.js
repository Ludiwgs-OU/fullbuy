/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

$(document).ready(()=>{
	
	/*
	 * 获取验证码
	 */
	$("#find_btn").click(()=>{
		var phone = $("#find_phone").val();
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: {
					"phone": phone
				},
				success:function(result){
					alert(result);
				},
				error:function(result){
					alert("验证码发送失败！");
				}
			});
		}
	})
	
	/*
	 * 找回密码
	 */
	$("#find_submit").click(()=>{
		var phone = $("#find_phone").val();
		var code = $("#find_code").val();
		var pwd = $("#find_pwd").val();
		var repwd = $("#find_repwd").val();
		var type = getUrlParam('type');
		
		var User = {
			"phone": phone,
			"verificationCode": code,
			"password": pwd,
			"type": type
		};
		
		if(pwd != repwd){
			alert("两次密码不一致!");
		}
		else{
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: User,
				success:function(result){
					alert(result);
					window.location.href = "login.html?type=" + type;
				},
				error:function(result){
					alert("修改失败！");
				}
			});
		}
	})
	
})
