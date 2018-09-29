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
			"phone": phone,
			"password": pass,
			"type": type
		}
		
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			$.ajax({
				type:"post",
				url:"/sys/login",
				async:true,
				dataType:"json",
				data: passLogin,
				success:function(result){
					if(result == 1){
                        alert("登录成功，欢迎回来~");
                        window.location.href = "home.html";
					}
					else if(result == 2){
                        alert("密码错误，请亲您重新填写");
                        location.reload();
					}
                    else if(result == 3){
                        alert("亲，您处于我们的黑名单当中哦，请联系我们解决");
                        location.reload();
                    }
                    else {
                        alert("输入的账号好像不存在哦，请亲检查");
                        location.reload();
                    }
                
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
