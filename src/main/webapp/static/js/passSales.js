new Vue({
	el:'#pass',
	data(){
		return{
			sites:""
		}
	},
	created(){
		var self = this;
		$.ajax({
			type:"get",
			url:"/sales/showSalesList",
			async:true,
			dataType: "json",
			success: function(info){
				self.sites = info;
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
		});
	},
	methods:{
		cancel:function(id){
			var saleId=id;
			$.ajax({
				type:"post",
				url:"/sales/deleteSales",
				async:true,
				dataType:"json",
				data:{
					"salesId":id
				},
				success:function(result){
					alert("注销成功!!!");
					window.location.herf="passSales.html";
				},
				error:function(result){
					alert("注销失败!!!");
				}
			});
		}
	}
})
new Vue({
	el:'#nopass',
	data(){
		return{
			sites:""
		}
		
	},
	created(){
		var self = this;
		$.ajax({
			type:"get",
			url:"/sales/failList",
			async:true,
			dataType: "json",
			success: function(info){
				self.sites = info;
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
		});
	}
})
