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
	el:'#review',
	data(){
		return{
			sites:'',
			inf:''
		}
	},
	created(){
		var self=this;
		$.ajax({
			type:"get",
			url:"/news/showNews",
			async:true,
			dataTyepe:'json',
	        success:function(info){
	        	self.sites=info;
	        },
	        error:function(info){
	        	alert("获取数据失败！");
	        }
		});
	},
	methods:{
		check:function(id){
			var self = this;
			$.ajax({
				type:"post",
				url:"/news/showNewsDetail",
				async:true,
				dataType: "json",
				data:{
					"newsId":id					
				},
				success: function(result){
					self.inf = result;
				},
				error: function(result){
					alert("获取数据失败!!!");
				}
			});
		},
		del:function(id){
			$.ajax({
			type:"post",
			url:"/news/deleteNews",
			async:true,
			dataType: "json",
			data:{
				"newsId":id,             
			},
			success: function(result){
				if(result==1){
					alert("删除成功!!!");
					window.location.href = "newsList.html";
				}
				else
					alert("删除失败!!!");
  			},				
			});
		},
		issue:function(id){
			$.ajax({
			type:"post",
			url:"/news/releaseNews",
			async:true,
			dataType: "json",
			data:{
				"newsId":id,
				"value":1
			},
			success: function(result){
				if(result==1){
					alert("发布成功!!!");
					window.location.href = "newsList.html";
				}
				else
				alert("发布失败!!!");				
  			},			
			});
		},
		remove:function(id){
			$.ajax({
				type:"post",
				url:"/news/shelvesNews",
				async:true,
				dataType:'json',
				data:{
					"newsId":id
				},
				success:function(result){
					if(result==1){
						alert("下架成功！！");
						window.location.herf='newsList.html';
					}
					else
					alert("下架出错！");
				}
			});
		},
		renew:function(id){
			var profile = document.getElementById("profile").files[0];
			var imgUrl = getObjectURL(profile);
			var productId = $("#id").val();
			$.ajax({
				type:"post",
				url:"/news/modifyNews",
				async:true,
				dataType:'json',
				data:{
					"newsId":id,
					"productId":productId,
					"photo":imgUrl
				},
				success:function(result){
					if(result==1){
						alert("更新成功！！");
						window.location.herf='newsList.html';
					}
					else
					alert("更新出错！");
				}
			});
		}
	}
})
