/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

/*
 * 获取活动内容
 */
new Vue({
    el: '#left',
    data() {
        return {
        	sites: ""
        }
    },
    created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/activity.json",
			async:true,
			dataType:"json",
			success:function(inf){
				self.sites = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
 	}
});

/*
 * 登录切换
 */
var right = {
    data() {
      	return {
        	activeName: 'first'
      	};
    },
    methods: {
      	handleClick(tab, event) {
        	console.log(tab, event);
      	}
    }
};
var Ctor = Vue.extend(right);
new Ctor().$mount('#right');

$(document).ready(()=>{
	
	/*
	 * 密码登录
	 */
	$("#login_pass").click(()=>{
		var phone = $("#phone_pass").val();
		var pass = $("#password").val();
		var type = getUrlParam('type');
		var passLogin = {
			"loginName": phone,
			"loginPwd": pass,
			"type": type
		}
		
		$.ajax({
			type:"post",
			url:"",
			async:true,
			dataType:"json",
			data: passLogin,
			success:function(result){
				alert("登录成功！");
				window.location.href = "#";
			},
			error:function(result){
				alert("登录出错！");
			}
		});
	});
	
	/*
	 * 获取验证码
	 */
	$("#code_btn").click(()=>{
		var phone = $("#phone_code").val();
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			alert(phone);
		}
	})
	
	/*
	 * 验证登录
	 */
	$("#login_code").click(()=>{
		var phone = $("#phone_code").val();
		var code = $("#code").val();
		var type = getUrlParam('type');
		var codeLogin = {
			"loginName": phone,
			"loginPwd": pass,
			"type": type
		}
		
		$.ajax({
			type:"post",
			url:"",
			async:true,
			dataType:"json",
			data: codeLogin,
			success:function(result){
				alert("登录成功！");
				window.location.href = "#";
			},
			error:function(result){
				alert("登录出错！");
			}
		});
	});
	
})
