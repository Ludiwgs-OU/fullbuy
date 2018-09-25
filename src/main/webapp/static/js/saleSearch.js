/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

$(document).ready(()=>{
	
	$(function(){
		$('.radio1').labelauty();
	});
	
	/*
	 * 注销
	 */
	$("#logout").click(()=>{
		$.ajax({
			type:"post",
			url:"#",
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
	})
})

/*
 * 导航栏数据
 */

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

/*
 * 菜单栏数据
 */

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

/*
 * 搜索详情
 */

new Vue({
	el: '#search',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/searchpro.json",
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
   		zhSort: function(id){
   			$(".sortLi").removeClass("first");
   			$("#sort"+id).addClass("first");
   			var self = this;
   			$.ajax({
				type:"get",
				url:"../static/json/searchpro.json",
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
   		xlSort: function(id){
   			$(".sortLi").removeClass("first");
   			$("#sort"+id).addClass("first");
   			var self = this;
   			$.ajax({
				type:"get",
				url:"../static/json/sortpro.json",
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
   		jgSort: function(id){
   			$(".sortLi").removeClass("first");
   			$("#sort"+id).addClass("first");
   			var self = this;
   			$.ajax({
				type:"get",
				url:"../static/json/sortpro.json",
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
   		pjSort: function(id){
   			$(".sortLi").removeClass("first");
   			$("#sort"+id).addClass("first");
   			var self = this;
   			$.ajax({
				type:"get",
				url:"../static/json/sortpro.json",
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
   	}
})
