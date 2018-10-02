/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

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
	el: '#orderInfo',
	data:function(){
   		return {
   			site: ""
   	 	}
 	},
	created: function(){
		var oid = getUrlParam('oid');
    	var self = this;
   		$.ajax({
			type:"post",
			url:"/order/displayOrderDetail",
			async:true,
			dataType:"json",
			data: {
				"orderId": oid
			},
			success:function(inf){
				self.site = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   	},
   	methods:{
   		refund: function(id){
   			$.ajax({
				type:"post",
				url:"/order/refund",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert(inf);
				},
				error:function(inf){
					alert("申请退款失败！");
				},
			});
   		},
   		returned: function(id){
   			$.ajax({
				type:"post",
				url:"/order/refund",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert(inf);
				},
				error:function(inf){
					alert("申请退款/退货失败！");
				},
			});
   		},
   		pay: function(id){
   			$.ajax({
				type:"post",
				url:"/order/pay",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert(inf);
				},
				error:function(inf){
					alert("确认收货失败！");
				},
			});
   		},
   		remind: function(){
   			alert("已提醒商家发货！");
   		},
   		receipt: function(id){
   			$.ajax({
				type:"post",
				url:"/order/confirm",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert(inf);
				},
				error:function(inf){
					alert("确认收货失败！");
				},
			});
   		},
   		dele: function(id){
   			$.ajax({
				type:"post",
				url:"/order/deleteOrder",
				async:true,
				dataType:"json",
				data: {
					"orderId": id
				},
				success:function(inf){
					alert(inf);
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
			
   			var formData = new FormData();
			formData.append('commentImgPath', $('#profile')[0].files[0]);
			formData.append('commentDetail',eval);
			formData.append('productId',pid);
			formData.append('orderId',oid);
			
   			$.ajax({
				type:"post",
				url:"/comment/addComment",
				async:true,
				contentType: false,
	            processData: false,
	            cache: false,
	            data: formData,
				success:function(inf){
					alert(inf);
				},
				error:function(inf){
					alert("评价失败！");
				},
			});
   		}
   	}
})