new Vue({
	el: '#headerNav',
	data:function(){
   		return {
   			site: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/saleInfo.json",
			async:true,
			dataType:"json",
			success:function(inf){
				self.site = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   	},
   	methods: {
   		logout: function(){
   			$.ajax({
				type:"get",
				url:"/sys/logout",
				async:true,
				dataType:"json",
				success:function(result){
					alert(result);
					window.open("home.html");
				},
				error:function(result){
					alert("获取数据失败！");
				},
			});
   		}
   	}
})

new Vue({
	el: '#sales-info',
	data:function(){
   		return {
   			site: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/saleInfo.json",
			async:true,
			dataType:"json",
			success:function(inf){
				self.site = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   	},
   	methods: {
   		changInfo: function(){
   			var name = $("#salesName").val();
   			var phone = $("#salesPhone").val();
   			var detail = $("#salesDetail").val();
   			var address = $("#salesAddress").val();
   			var email = $("#salesEmail").val();
   			
   			var sales = {
   				"salesName": name,
   				"salesAddress": address,
   				"salesDetail": detail,
   				"salesPhone": phone,
   				"salesEmail": email
   			}
   			
   			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType:"json",
				data: sales,
				success:function(inf){
					alert("修改成功！");
					window.reload();
				},
				error:function(inf){
					alert("修改失败！");
				},
			});
   		}
   	}
})

$("document").ready(()=>{
	
	$("#changePwd").click(()=>{
		var oldpwd = $("#user-old-password").val();
		var newPwd = $("#user-new-password").val();
		var rePwd = $("#user-confirm-password").val();
		
		var pwd = {
			"oldPaaword": oldpwd,
			"newPaaword": newPwd
		}
		
		if(newPwd != rePwd){
			alert("两次密码输入不正确！");
		}
		else{
			$.ajax({
	            type:"post",
				url:"/user/modifyPassword",
				async:true,
				dataType:"json",
				data: pwd,
				success:function(inf){
					alert(inf);
					window.reload();
				},
				error:function(inf){
					alert("修改失败！");
				}
	        });
		}
	})
	
})