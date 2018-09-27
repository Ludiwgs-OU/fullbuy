new Vue({
    el: '#slides',
    data() {
        return {
        	sites: ""
        }
    },
    created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/banner.json",
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

new Vue({
	el: '#today',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
  	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"/product/displayByPosttime",
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

new Vue({
	el: '#sales',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
  	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"/sales/displayRecommend",
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

new Vue({
	el: '#explosion',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
  	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"/product/displayBySalesnum",
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
	el: '#prof',
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
   	}
})

$(document).ready(()=>{
	/*
	 * 搜索
	 */
	$("#ai-topsearch").click(()=>{
		var info = $("#searchInput").val();
		window.open("search.html?info=" + info);
	})
})
