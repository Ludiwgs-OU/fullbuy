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
        	activeName: 'second'
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

$(document).ready(function(){
	
	/*
	 * 密码登录
	 */
	$("#login_pass").click(function(){
		var phone = document.getElementById("phone_pass").value;
		var pass = document.getElementById("password").value;
		var type = getUrlParam('type');
		
		$.ajax({
			type:"post",
			url:"",
			async:true,
			dataType:"json",
			data:{
				"loginName": phone,
				"loginPwd": pass,
				"type": type
			},
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
	 * 验证登录
	 */
	$("#login_code").click(function(){
		var phone = document.getElementById("phone_code").value;
		var code = document.getElementById("code").value;
		var type = getUrlParam('type');
		
		var pattern = /^\d{11}$/;
		if(!pattern.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else{
			alert(type);
			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType:"json",
				data:{
					"loginName": phone,
					"loginPwd": pass,
					"type": type
				},
				success:function(result){
					alert("登录成功！");
					window.location.href = "#";
				},
				error:function(result){
					alert("登录出错！");
				}
			});
		}
	});
	
})
