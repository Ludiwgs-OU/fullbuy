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
			url:"/sys/navi",
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
                    alert("亲您已退出，再见~");
                    window.location.href = "home.html";
				},
				error:function(result){
					alert("获取数据失败！");
				},
			});
   		}
   	}
})

new Vue({
	el: '#commList',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"/comment/displayCommentByUserId",
			async:true,
			dataType:"json",
			success:function(inf){
				self.sites = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   	}
})