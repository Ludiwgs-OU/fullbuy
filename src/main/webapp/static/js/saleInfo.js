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
			url:"/sales/displaySalesDetail",
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
			url:"/sales/displaySalesDetail",
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
   			
   			var Sales = {
   				"salesName": name,
   				"salesAddress": address,
   				"salesDetail": detail,
   				"salesPhone": phone,
   				"salesEmail": email
   			}
   			
   			$.ajax({
				type:"post",
				url:"/sales/modifySales",
				async:true,
				dataType:"json",
				data: Sales,
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

		
		if(newPwd != rePwd){
			alert("两次密码输入不正确！");
		}
		else{
			$.ajax({
	            type:"post",
				url:"/sys/modifyPassword",
				async:true,
				dataType:"json",
				data: {
					"oldPassword": oldpwd,
					"newPassword": newPwd
				},
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