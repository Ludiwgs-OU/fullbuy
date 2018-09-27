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
			url:"../static/json/coll.json",
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
		var day = nowdate.getDay();
		var x;
		switch(day){
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
		
		document.getElementById("day").innerHTML = "星期" + x;
		document.getElementById("ym").innerHTML = year + "." + month;
	})
	
})
