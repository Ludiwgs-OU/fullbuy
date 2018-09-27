new Vue({
	el:"#userBlackTable",
	data(){
		return{
			sites:""
		}
	},
	created(){
		var self=this;
		$.ajax({
			type:"get",
			url:"../static/json/setUserBlack.json",
			async:true,
			dataType:"json",
			success:function(info){
				self.sites=info;
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
		});
	},
   //恢复用户身份的方法
	methods:{
		back:function(id){
			$.ajax({
				type:"post",
				url:"/user/setUserWhite",
				async:true,
				dataType:"json",
				data:{
					"userId":id
				},
				success: function(result){
				if(result==1)
				{
					alert("恢复成功!!!");
				window.location.href = "findUserBlack.html";
				}
				else 
				 	alert("恢复失败!!!");
				
  				}
			});
		}
	}
})
