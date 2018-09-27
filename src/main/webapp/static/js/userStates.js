new Vue({
	el:'#userStates',
	data(){
		return{
			sites:""
		}
	},
	created(){
		var self=this;
		$.ajax({
			type:"get",
			url:"/user/allLoginDetail",
			async:true,
			dataType:"json",
			success:function(info){
				self.sites=info;
			},
			error:function(info){
				alert("获取数据失败！！！！");
			}
		});
	},	
	methods:{
		//删除很久未登录的用户的方法
		del:function(id)
		{
			$.ajax({
				type:"post",
				url:"/user/deleteUser",
				async:true,
				dataType:"json",
				data:{
					"userId":id					
				},
				success: function(result){
				alert(result);
				window.location.href = "userLoginStates.html";
  				},
				error: function(result){
				alert(result);
				}
			});
		},
		search:function(){
			var phone= $("#phone").val();
			var pattern = /^\d{11}$/;
			if(!pattern.test(phone)){
				alert("请输入正确的手机号码！");
			}
			else{
				var self=this;
				$.ajax({
					type:"post",
					url:"/user/loginDetail",
					async:true,
					dataType:"json",
					data:{
						"userPhone":phone
					},
					success:function(result){
						self.sites=result;
					},
					error:function(result){
						alert("查询出错！");
					}
				});
			}
	  }
	}
})
