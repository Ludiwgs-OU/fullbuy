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
	el: '#user-info',
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
				console.log(inf);
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   	}
})

$(document).ready(()=>{
	
	/*
	 * 搜索
	 */
	$("#ai-topsearch").click(()=>{
		var info = $("#searchInput").val();
		window.open("search.html?info=" + info);
	})
	
	$("#changeInfo").click(()=>{
		var name = $("#user-name2").val();
		var sex = $("input[name='radio']:checked").val();
		var phone = $("#user-phone").val();
		var email = $("#user-email").val();
		
		var info = {
			"userName": name,
			"sex": sex,
			"userPhone": phone,
			"userEmail": email
		}
		//alert(name+" "+sex+" "+phone+" "+email);
		
		$.ajax({
			type:"post",
			url:"/user/modifyUser",
			async:true,
			dataType:"json",
			data: info,
			success:function(inf){
				alert(inf);
				window.reload();
			},
			error:function(inf){
				alert("修改失败！");
			},
		});
	})
	
	$("#profile").change(()=>{
		
		var profile = document.getElementById("profile").files[0];
		var imgUrl = getObjectURL(profile);
	    
		$.ajax({
            type: "post",
            url: "/user/modifyUserProfile",
            contentType: false,
            processData: false,
            data: {
            	"userProfile": imgUrl
            },
            success: function(result){
            	alert(result);
            	document.getElementById("profileImg").src = imgUrl;
            },
            error: function(result){
            	alert("头像修改失败！");
            }
        });
	})
	
	$("#changePwd").click(()=>{
		var oldpwd = $("#user-old-password").val();
		var newPwd = $("#user-new-password").val();
		var rePwd = $("#user-confirm-password").val();
		
		var pwd = {
			"oldPaaword": oldpwd,
			"newPaaword": newPwd
		}
		
		if(newPwd != rePwd){
			alert("两次密码输入不正确！");
		}
		else{
			$.ajax({
	            type:"post",
				url:"/user/modifyPassword",
				async:true,
				dataType:"json",
				data: pwd,
				success:function(inf){
					alert(inf);
					window.reload();
				},
				error:function(inf){
					alert("修改失败！");
				}
	        });
		}
	})
	
})
