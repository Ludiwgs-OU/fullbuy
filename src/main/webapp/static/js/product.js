/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

$(document).ready(function() {
	
	$(function(){
		/*
		 * 单选框初始化
		 */
		$(':input').labelauty();
		
		/*
		 * 搜索
		 */
		$("#ai-topsearch").click(()=>{
			var info = $("#searchInput").val();
			window.open("search.html?info=" + info);
		})
		
		/*
		 * 动态显示价格
		 */
		$(".initem").click(()=>{
			var item1 = $("input[name='item1']:checked").val();
			var item2 = $("input[name='item2']:checked").val();
			var pid = getUrlParam('pid');
			
			var item = {
				"productId": pid,
				"itemId": item1,
				"secondItemId": item2,
				"type": 0
			}
			
			if(item1 && item2){
				$.ajax({
					type:"post",
					url:"../static/json/price.json",
					async:true,
					dataType:"json",
					data: item,
					success:function(result){
						document.getElementById("price").innerHTML = result.price;
						document.getElementById("stock").innerHTML = result.quantity;
						document.getElementById("skuId").innerHTML = result.skuId;
					},
					error:function(result){
						alert("获取数据失败！");
					},
				});
			}
		})
		
		$(".gbitem").click(()=>{
			var item1 = $("input[name='item1']:checked").val();
			var item2 = $("input[name='item2']:checked").val();
			var pid = getUrlParam('pid');
			
			var item = {
				"productId": pid,
				"itemId": item1,
				"secondItemId": item2,
				"type": 1
			}
			
			if(item1 && item2){
				$.ajax({
					type:"post",
					url:"../static/json/price.json",
					async:true,
					dataType:"json",
					data: item,
					success:function(result){
						document.getElementById("price").innerHTML = result.price;
						document.getElementById("stock").innerHTML = result.quantity;
						document.getElementById("skuId").innerHTML = result.skuId;
					},
					error:function(result){
						alert("获取数据失败！");
					},
				});
			}
		})
	});
	/*
	 * 放大镜初始化
	 */
	$(".jqzoom").imagezoom();
	$("#thumblist li a").click(function() {
		$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
		$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
		$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
	});
	
	/*
	 * 团购页面跳转
	 */
	$("#LikBuy").click(()=>{
		var pid = getUrlParam('pid');
		window.open("groupbuy.html?pid=" + pid);
	})
	
	/*
	 * 原价购买
	 */
	$('#LikBasket').click(()=>{
		var sku = $("#skuId").text();
		var num = $("#text_box").val();
		var user = $("#userName").text();
		var price1 = $("#price").text();
		
		if(!sku){
			alert("请选择规格！");
		}
		else if(!user){
			alert("请先登录！");
		}
		else{
			$.ajax({
				type:"post",
				url:"/order/checkOrder",
				async:true,
				dataType:"json",
				data: {
					"skuId": sku,
					"num": num,
					"price": price1
				},
				success:function(result){
					window.location.href = "pay.html?oid="+result+"&type=1";
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
		}
	})
	
	/*
	 * 团购
	 */
	$('#groupBuy').click(()=>{
		var sku = $("#skuId").text();
		var gid = getUrlParam('gid');
		var user = $("#userName").text();
		
		if(!sku){
			alert("请选择规格！");
		}
		else if(!user){
			alert("请先登录！");
		}
		else{
			var buy = {
				"skuId": sku,
				"groupbuyId": gid
			}
		
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: buy,
				success:function(result){
					window.location.href = "pay.html?oid="+result+"&type=2";
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
		}
	})
	
	/*
	 * 加入收藏夹
	 */
	
	$("#collAdd").click(()=>{
		var pid = getUrlParam('pid');
		var user = $("#userName").text();
		
		if(!user){
			alert("请先登录！");
		}
		else{
			$.ajax({
				type:"post",
				url:"/user/addFavor",
				async:true,
				dataType:"json",
				data: {
					"productId": pid
				},
				success:function(result){
					alert(result);
				},
				error:function(inf){
					alert("加入收藏夹失败！");
				},
			});
		}
	})
	
	/*
	 * 注销
	 */
	$("#logout").click(()=>{
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
	})
	
});

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
 * 商品详情获取
 */

new Vue({
	el: '#productinfo',
	data: function(){
   		return {
   			site: ""
   	 	}
 	},
	created: function(){
		var pid = getUrlParam('pid');
    	var self = this;
   		$.ajax({
			type:"post",
			url:"/product/displayProductDetailWithSku",
			async:true,
			dataType:"json",
			data: {
				"productId": pid
			},
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
 * 看了又看
 */

new Vue({
	el: '#like',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/explosion.json",
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

/*
 * 介绍图片
 */
new Vue({
	el: '#introductionImg',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
    	var self = this;
    	var pid = getUrlParam('pid');
   		$.ajax({
			type:"get",
			url:"../static/json/introductionImg.json",
			async:true,
			dataType:"json",
			data: {
				"productId": pid
			},
			success:function(inf){
				self.sites = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			}
		});
   	}
})

/*
 * 评论获取
 */
new Vue({
	el: '#commentDetail',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
		var pid = getUrlParam('pid');
    	var self = this;
   		$.ajax({
			type:"post",
			url:"../static/json/comment.json",
			async:true,
			dataType:"json",
			data: {
				"productId": pid
			},
			success:function(inf){
				self.sites = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			}
		});
   	},
   	methods: {
   		lastPage: function(){
   			var pid = getUrlParam('pid');
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

/*
 * 团购详情
 */
new Vue({
	el: '#groupbuyInfo',
	data:function(){
   		return {
   			site: ""
   	 	}
 	},
	created: function(){
		var pid = getUrlParam('pid');
    	var self = this;
   		$.ajax({
			type:"post",
			url:"../static/json/groupbuy.json",
			async:true,
			dataType:"json",
			data: {
				"productId": pid
			},
			success:function(inf){
				self.site = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   	}
})