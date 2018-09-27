new Vue({
	el:'#audit',
	data(){
		return{
			sites:"",
			inf:""
		}
	},
	/*获取待审核商家数据*/
	created(){
		var self=this;
		$.ajax({
			type:"get",
			url:"/sales/showAuditingsList",
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
	methods:{
		/*通过审核商家*/
		pass:function(id){
			$.ajax({
			type:"post",
			url:"/sales/auditingSales",
			async:true,
			dataType: "json",
			data:{
				"salesId":id,
                "value":1    
			},
			success: function(result){
				alert("审核成功!!!");
				window.location.href = "auditMerchant.html";
  		},
			error: function(result){
				alert("审核失败!!!");
			}
		});
		},
		/*未通过审核商家*/
		nopass:function(id){
			$.ajax({
			type:"post",
			url:"/sales/auditingSales",
			async:true,
			dataType: "json",
			data:{
				"salesId":id,
                "value":0    
			},
			success: function(result){
				alert("审核成功!!!");
				window.location.href = "auditMerchant.html";
  		},
			error: function(result){
				alert("审核失败!!!");
			}	
			});
		},
		/*查看商家详情*/
		check: function(id){
			var self = this;
			$.ajax({
				type:"post",
				url:"/sales/selectByPrimaryKey ",
				async:true,
				dataType: "json",
				data:{
					"salesid":id					
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
