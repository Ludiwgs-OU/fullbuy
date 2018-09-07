/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

$(document).ready(()=>{
	
	$(()=>{
		var type = getUrlParam('type');
		if(type == 1){
			document.getElementById("title").innerHTML = "会员登录";
		}
		else if(type == 2){
			document.getElementById("title").innerHTML = "商家登录";
		}
		else{
			document.getElementById("title").innerHTML = "登录商城";
		}
	})
	
	/*
	 * 登录
	 */
	$("#login").click(()=>{
		var phone = $("#user").val();
		var pass = $("#password").val();
		var type = getUrlParam('type');
		var passLogin = {
			"loginName": phone,
			"loginPwd": pass,
			"type": type
		}
		
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			$.ajax({
				type:"post",
				url:"/userLogin",
				async:true,
				dataType:"json",
				data: passLogin,
				success:function(result){
					alert("登录成功！");
					window.location.href = "home.html";
				},
				error:function(result){
					alert("登录出错！");
				}
			});
		}
	});
	
	/*
	 * 找回密码
	 */
	$("#forgetPwd").click(()=>{
		var type = getUrlParam('type');
		if(type == 1){
			window.location.href = "findpwd.html?type=1";
		}
		else if(type == 2){
			window.location.href = "findpwd.html?type=2";
		}
	})
})
