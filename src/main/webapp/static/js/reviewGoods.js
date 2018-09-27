new Vue({
	el: '#review',
	data(){
		return{
			sites: "",
			inf: ""
		}
	},
	/*获取商品数据*/
	created(){
		var self = this;
		$.ajax({
			type:"get",
			url:"/product/productList",
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
	/*详情页、审核通过与否的方法*/
	methods:{
		pass:function(id){
			$.ajax({
			type:"post",
			url:"/product/allowProduct",
			async:true,
			dataType: "json",
			data:{
				"productId":id,
                "value":1    
			},
			success: function(result){
				alert("审核成功!!!");
				window.location.href = "reviewGoods.html";
  			},
			error: function(result){
				alert("审核失败!!!");
			}
		});
		},
		nopass:function(id){
			$.ajax({
			type:"post",
			url:"",
			async:true,
			dataType: "json",
			data:{
				"productId":id,
                "value":3   
			},
			success: function(result){
				alert("审核成功!!!");
				window.location.href = "reviewGoods.html";
  			},
			error: function(result){
				alert("审核失败!!!");
			}	
			});
		},
		check: function(id){
			var self = this;
			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType: "json",
				data:{
					"productId":id					
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
