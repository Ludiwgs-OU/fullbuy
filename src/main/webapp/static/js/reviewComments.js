new Vue({
	el: '#review',
	data(){
		return{
			sites: "",
			inf: ""
		}
	},
	/*获取评论数据*/
	created(){
		var self = this;
		$.ajax({
			type:"get",
			url:"/comment/showProductList",
			async:true,
			dataType: "json",
			success: function(info){
				self.sites = info;
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
		});
	},
	/*详情页、删除评论的方法*/
	methods:{
		del:function(id){
			$.ajax({
				type:"post",
				url:"/comment/deleteComment",
				async:true,
				dataType: "json",
				data:{
					"commentId":id               	  
				},
				success: function(result){
					if(result==1)
					{
						alert("删除成功!!!");
						window.location.href = "reviewComment.html";
					}
					else 
					 	alert("审核失败!!!");
					
  			}				
		});
		},
		check: function(id){
			var self = this;
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType: "json",
				data:{
					"commentId":id					
				},
				success: function(result){
					self.inf = result;
				},
				error: function(result){
					alert("获取数据失败!!!");
				}
			});
		}
	}	
})
