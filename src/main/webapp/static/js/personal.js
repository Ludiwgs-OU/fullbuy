/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

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
                    alert("亲您已退出，再见~");
                    window.location.href = "home.html";
				},
				error:function(result){
					alert("获取数据失败！");
				},
			});
   		}
   	}
})

new Vue({
	el: '#userinfo',
	data:function(){
   		return {
   			site: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"/user/displayUserDetail",
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
	el: '#item-wrap',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"/comment/displayCommentByUserId",
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

$(document).ready(()=>{
	
	$(()=>{
		var nowdate = new Date();
		var year = nowdate.getFullYear();
		var month = nowdate.getMonth()+1;
		var day1 = nowdate.getDate();
		var day2 = nowdate.getDay();
		var x;
		switch(day2){
			case 0:
			 	x="日";
			  	break;
			case 1:
				x="一";
				break;
			case 2:
				x="二";
				break;
			case 3:
				x="三";
				break;
			case 4:
				x="四";
				break;
			case 5:
				x="五";
				break;
			case 6:
				x="六";
				break;
		}
		
		document.getElementById("day1").innerHTML = day1;
		document.getElementById("day2").innerHTML = "星期" + x;
		document.getElementById("ym").innerHTML = year + "." + month;
	})
	
})
