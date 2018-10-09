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
			url:"/product/displaySalesProducts",
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
				url:"/product/serachByKeyword",
				async:true,
				dataType:"json",
				data: {
					"keyword": searchInfo
				},
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
				url:"/product/deleteProduct",
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
		},
		eval: function(id){
			$('#gb'+id).slideToggle(200);
   		},
   		hide: function(id){
   			$('#gb'+id).slideUp(200);
   		},
   		gb: function(id){
   			var min = $("#min"+id).val();
   			var max = $("#max"+id).val();
   			var start = $("#start"+id).val();
   			var end = $("#end"+id).val();
   			
   			//alert(min+" "+max+" "+start+" "+end);
   			
   			var Groudbuy = {
   				"productId": id,
   				"minPeople": min,
   				"maxPeople": max,
   				"beginTime": start,
   				"endTime": end
   			}
   			
   			$.ajax({
				type:"post",
				url:"/groudbuy/addGroudbuy",
				async:true,
				dataType:"json",
				data: Groudbuy,
				success:function(inf){
					alert("发起团购成功！");
				},
				error:function(inf){
					alert("发起团购失败！");
				},
			});
   		}
	}
})