new Vue({
	el:'#userTable',
	data(){
		return{
			sites:""
		}
	},
	created(){
	   var self = this;
	   $.ajax({
	   	type:"get",
	   	url:"",
	   	async:true,
	   	dataType:"json",
	   	success: function(info){
				self.sites = info;
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
	   });
	},
	//设置黑名单的方法
	methods:{
		set:function(id){			
			$.ajax({
			type:"post",
			url:"/user/setUsersBlack",
			async:true,
			dataType: "json",
			data:{
				"userId":id   
			},
			success: function(result){
				alert(result);
				window.location.href = "setUserBlack.html";
  		},
			error: function(result){
				alert(result);
			}
		});
		}
	}
})
