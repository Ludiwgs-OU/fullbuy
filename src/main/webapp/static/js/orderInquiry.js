new Vue({
	el:'#down',
	data(){
		return{
			sites:""
		}
	},
	created(){
		var self = this;
		$.ajax({
			type:"get",
			url:"/order/yearList",
			async:true,
			dataType: "json",
			success: function(info){			
				 for (var i=0;i<info.length; i++) {
       			 $("#years").append("<option value='" + info[i].year + "'>" + info[i].year + "</option>");
    					}
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
		});
	},
	methods:{
		/*查找某年的订单*/
		search:function(){
			var year = $("#years option:selected").text();
			var self=this;
//			alert(year);
			$.ajax({
				type:"post",
				url:"/order/orderListByYear",
				async:true,
				dataType:"json",
				data:{
					"year":year
				},
				success:function(info){
					self.sites=info;
				},
				error:function(info){
					alert("查询出错！");
				}
			});
		},
		/*删除某年的订单*/
		delAll:function(){
			var year = $("#years option:selected").text();
			var self=this;
//			alert(year);
			$.ajax({
				type:"post",
				url:"/order/deleteOverTime",
				async:true,
				dataType:"json",
				data:{
					"year":year
				},
				success:function(result){
					alert("删除成功！");
					window.location.href = "orderInquiry.html";
				},
				error:function(info){
					alert("删除出错！");
				}
			});
		},
		/*删除某年里的某一的订单*/
		del:function(id){
			var orderId=id;
			$.ajax({
				type:"post",
				url:"",
				async:true,
				dataType:"json",
				data:{
					"orderId":orderId
				},
				success:function(result){
					alert("删除成功！");
					window.location.href =  window.location.href;
				},
				error:function(result){
					alert("删除出错！");
				}
			});
		}
	}
})
