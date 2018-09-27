new Vue({
	el:'#salesTable',
	data(){
		return{
			sites :""
		}
	},
	created(){
		var self = this;
	   	$.ajax({
	   		type:"get",
	   		url:"/sales/showSalesList",
	   		async:true,
	   		dataType:"json",
	   		success: function(info){
				self.sites = info;
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
	   });
	},
	methods:{
		set:function(id){			
			$.ajax({
			type:"post",
			url:"/sales/setSalesBlack",
			async:true,
			dataType: "json",
			data:{
				"salesId":id   
			},
			success: function(result){
				alert("设置成功!!!");
				window.location.href = "setSalesBlack.html";
  		},
			error: function(result){
				alert("设置失败!!!");
			}
		});
		}
	}
})
new Vue({
	el:"#salesblack",
	data(){
		return{
			sites:""
		}
	},
	created(){
		var self = this;
	   	$.ajax({
	   		type:"get",
	   		url:"/sales/showBlackList",
	   		async:true,
	   		dataType:"json",
	   		success: function(info){
				self.sites = info;
			},
			error: function(info){
				alert("获取数据失败!!!");
			}
	   });
	},
	methods:{
		back:function(id){
			$.ajax({
				type:"post",
				url:"/sales/setSalesWhite",
				async:true,
				dataType:"json",
				data:{
					"salesId":id
				},
				success: function(result){
					alert("恢复成功!!!");
					window.location.href = "findSalesBlack.html";
  				},
				error: function(result){
					alert("恢复失败!!!");
				}
			});
		}
	}
})
