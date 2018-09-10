new Vue({
    el: '#slides',
    data() {
        return {
        	sites: ""
        }
    },
    created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/banner.json",
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

new Vue({
	el: '#today',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
  	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/today.json",
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

new Vue({
	el: '#sales',
	data:function(){
   		return {
   			sites: ""
   	 	}
 	},
  	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/sales.json",
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

new Vue({
	el: '#explosion',
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