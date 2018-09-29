$(document).ready(()=>{
	/*
	 * 搜索
	 */
	$("#ai-topsearch").click(()=>{
		var info = $("#searchInput").val();
		window.open("search.html?info=" + info);
	})
})

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
			url:"/user/displayFavor",
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
				url:"/user/deleteSingleFavor",
				async:true,
				dataType:"json",
				data: {
					"favorId": id
				},
				success:function(result){
                    if(result == 1){
                        alert("已为亲取消收藏商品");
                        location.reload();
                    }
                    else {
                        alert("很抱歉，不能帮亲取消收藏商品");
                        location.reload();
                    }
				},
				error:function(result){
					alert("取消收藏失败！");
				},
			});
   		}
   	}
})