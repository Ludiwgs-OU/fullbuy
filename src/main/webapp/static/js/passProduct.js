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
			url:"/product/passProduct",
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
			url:"/product/failProduct",
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
