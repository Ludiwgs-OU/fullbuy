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
		 * 动态显示价格
		 */
		$("input:radio").click(()=>{
			var item1 = $("input[name='item1']:checked").val();
			var item2 = $("input[name='item2']:checked").val();
			
			var item = {
				"item1": item1,
				"item2": item2
			}
			
			if(item1 && item2){
				$.ajax({
					type:"post",
					url:"#",
					async:true,
					dataType:"json",
					data: item,
					success:function(result){
						document.getElementById("price").innerHTML = result.price;
						document.getElementById("stock").innerHTML = result.stock;
						document.getElementById("skuId").innerHTML = result.skuId;
					},
					error:function(inf){
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
		window.open("#.html?pid=" + pid);
	})
	
	/*
	 * 原价购买
	 */
	$('#LikBasket').click(()=>{
		var sku = $("#skuId").text();
		var num = $("#text_box").val();
		
		if(!sku){
			alert("请选择规格！");
		}
		else{
			var buy = {
				"skuId": sku,
				"num": num
			}
		
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: buy,
				success:function(result){
					window.location.href = "#";
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
		$.ajax({
			type:"post",
			url:"#",
			async:true,
			dataType:"json",
			data: {
				"productId": pid
			},
			success:function(result){
				alert("加入收藏夹成功！");
			},
			error:function(inf){
				alert("加入收藏夹失败！");
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
	data:function(){
   		return {
   			site: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/product.json",
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
   		$.ajax({
			type:"get",
			url:"../static/json/introductionImg.json",
			async:true,
			dataType:"json",
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
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/comment.json",
			async:true,
			dataType:"json",
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
   			var page = document.getElementById("nowPage").innerText;
   			if(page == 1){
   				alert("已经是首页了");
   			}
   			else{
   				var self = this;
   				$.ajax({
					type:"post",
					url:"#",
					async:true,
					dataType:"json",
					data:{
						"page": page
					},
					success:function(inf){
						self.sites = inf;
						document.getElementById("nowPage").innerHTML = page - 1;
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
   				var self = this;
   				$.ajax({
					type:"post",
					url:"#",
					async:true,
					dataType:"json",
					data:{
						"page": page
					},
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