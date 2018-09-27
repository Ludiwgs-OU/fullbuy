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
   			sites: "",
   			items: "",
   			secItems: "",
   			oneId: "",
   			twoId: ""
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
		$.ajax({
			type:"get",
			url:"../static/json/searchItem.json",
			async:true,
			dataType:"json",
			success:function(inf){
				self.items = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   },
   	methods: {
   		getItem: function(id){
   			var self = this;
   			self.oneId = id;
   			self.secItems = "";
   			$.ajax({
				type:"get",
				url:"../static/json/secItem.json",
				async:true,
				dataType:"json",
				success:function(inf){
					$(".itemli").remove();
					self.secItems = inf;
					$(function(){
						$('.radio2').labelauty();
					});
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
   		},
   		getInfo: function(id){
   			var self = this;
   			self.twoId = id;
   			alert(self.oneId+" "+self.twoId);
// 			$.ajax({
//				type:"get",
//				url:"../static/json/testItem.json",
//				async:true,
//				dataType:"json",
//				success:function(inf){
//					
//				},
//				error:function(inf){
//					alert("获取数据失败！");
//				},
//			});
   		},
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
   		},
   		lastPage: function(){
   			var page = document.getElementById("nowPage").innerText;
   			if(page == 1){
   				alert("已经是首页了");
   			}
   			else{
   				page = page - 1;
	   			var lastpage = {
	   				"productId": pid,
	   				"page": page
	   			}
   				var self = this;
   				$.ajax({
					type:"post",
					url:"#",
					async:true,
					dataType:"json",
					data: lastpage,
					success:function(inf){
						self.sites = inf;
						document.getElementById("nowPage").innerHTML = page;
					},
					error:function(inf){
						alert("获取数据失败！");
					}
				});
   			}
   		},
   		nextPage: function(){
   			var page = Number(document.getElementById("nowPage").innerText);
   			var allpage = Number(document.getElementById("pageNum").innerText);
   			if(page == allpage){
   				alert("已经是末页了");
   			}
   			else{
   				page = page + 1;
	   			var nextpage = {
	   				"productId": pid,
	   				"page": page
	   			}
   				var self = this;
   				$.ajax({
					type:"post",
					url:"#",
					async:true,
					dataType:"json",
					data: nextpage,
					success:function(inf){
						self.sites = inf;
						document.getElementById("nowPage").innerHTML = Number(page + 1);
					},
					error:function(inf){
						alert("获取数据失败！");
					}
				});
   			}
   		}
   	}
})

