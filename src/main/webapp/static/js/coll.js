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
   	}
})

new Vue({
	el: '#coll-list',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/coll.json",
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
   		calColl: function(id){
   			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: {
					"favorId": id
				},
				success:function(inf){
					alert(inf);
					window.reload();
				},
				error:function(inf){
					alert("取消收藏失败！");
				},
			});
   		}
   	}
})