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
					alert("注销失败！");
				},
			});
   		}
   	}
})

new Vue({
	el: '#productList',
	data(){
		return{
			sites: ""
		}
	},
	created(){
		var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/salesPro.json",
			async:true,
			dataType:"json",
			success:function(inf){
				self.sites = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
	},
	methods: {
		search: function(){
			var searchInfo = $("#sales-searchPro").val();
			//alert(searchInfo);
			var self = this;
	   		$.ajax({
				type:"get",
				url:"../static/json/seasales.json",
				async:true,
				dataType:"json",
				success:function(inf){
					self.sites = inf;
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
		},
		sele: function(id){
			window.location.href = "saleChangPro.html?pid="+id;
		},
		dele: function(id){
			//alert(id);
			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType:"json",
				data: {
					"productId": id
				},
				success:function(inf){
					alert("删除成功！");
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
		}
	}
})