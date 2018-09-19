function getObjectURL(file) {  
    var url = null;  
    if (window.createObjcectURL != undefined) {
        url = window.createOjcectURL(file);
    } else if (window.URL != undefined) {
        url = window.URL.createObjectURL(file);  
    } else if (window.webkitURL != undefined) {
        url = window.webkitURL.createObjectURL(file);
    }
    return url;  
}

$(document).ready(()=>{
	
	$("#profile").change(()=>{
		var profile = document.getElementById("profile").files[0];
		var imgUrl = getObjectURL(profile);
		document.getElementById("profileImg").src = imgUrl;
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
	el: '#orderList',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
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
					alert("已申请退款！");
				},
				error:function(inf){
					alert("申请退款失败！");
				},
			});
   		},
   		returned: function(id){
   			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert("已申请退款/退货！");
				},
				error:function(inf){
					alert("申请退款/退货失败！");
				},
			});
   		},
   		remind: function(){
   			alert("已提醒商家发货！");
   		},
   		receipt: function(id){
   			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert("确认收货成功！");
				},
				error:function(inf){
					alert("确认收货失败！");
				},
			});
   		},
   		dele: function(id){
   			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert("删除订单成功！");
				},
				error:function(inf){
					alert("删除订单失败！");
				},
			});
   		},
   		eval: function(id){
   			$(document.body).css("overflow","hidden");
			$('#eval'+id).slideDown(200);
   		},
   		hide: function(id){
   			$(document.body).css("overflow","visible");
   			$('#eval'+id).slideUp(200);
   		},
   		sub: function(pid,oid){
   			var eval = $('#evalu'+pid).val();
   			var profile = document.getElementById("profile").files[0];
			var imgUrl;
			if(profile != null){
				imgUrl = getObjectURL(profile);
			}else{
				imgUrl = "";
			}
			
   			var evaluation = {
   				"commentDetail": eval,
   				"productId": pid,
   				"orderId": oid,
   				"commentImgPath": imgUrl
   			}
   			$.ajax({
				type:"post",
				url:"#",
				async:true,
				dataType:"json",
				data: evaluation,
				success:function(inf){
					alert("评价成功！");
				},
				error:function(inf){
					alert("评价失败！");
				},
			});
   		}
   	}
})