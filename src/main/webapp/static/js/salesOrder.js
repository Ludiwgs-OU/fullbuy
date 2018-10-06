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
			url:"../static/json/login.json",
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
					window.reload();
				},
				error:function(result){
					alert("获取数据失败！");
				},
			});
   		}
   	}
})

new Vue({
	el: "#sorderList",
	data(){
		return{
			sites: ""
		}
	},
	created(){
		var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/orderlist.json",
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
		send: function(id){
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert(inf);
					location.reload();
				},
				error:function(inf){
					alert("发货失败！");
				},
			});
		},
		refund: function(id){
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert(inf);
					location.reload();
				},
				error:function(inf){
					alert("申请退款失败！");
				},
			});
		}
	}
})