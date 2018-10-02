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
		
		var User = {
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
            contentType:"application/json",
            data:JSON.stringify(User),
			success:function(result){
                if(result == 1){
                    alert("已为亲更新个人信息");
                    location.reload();
                }
                else {
                    alert("很抱歉，不能帮亲更改个人信息");
                    location.reload();
                }
           	},
			error:function(result){
				alert("修改失败！");
			}
		});
	})
	
	$("#profile").change(()=>{
		
		var profile = document.getElementById("profile").files[0];
		var imgUrl = getObjectURL(profile);
		
		var formData = new FormData();
		formData.append('userProfile', $('#profile')[0].files[0]);
	    
		$.ajax({
            type: "post",
            url: "/user/modifyUserProfile",
            contentType: false,
            processData: false,
            cache: false,
	        data: formData,
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
		
		if(newPwd != rePwd){
			alert("两次密码输入不正确！");
		}
		else{
			$.ajax({
	            type:"post",
				url:"/user/modifyPassword",
				async:true,
				dataType:"json",
				data: {
                    "oldPassword": oldPwd,
                    "newPassword": newPwd
                },
				success:function(result){
                    if(result == 1){
                        alert("已为亲修改密码，记得保存好哦");
                        location.reload();
                    }
                    else if(result == 2){
                        alert("亲输入的旧密码有误哦");
                        location.reload();
                    }
                    else {
                        alert("很抱歉，不能帮亲修改密码");
                        location.reload();
                    }
				},
				error:function(result){
					alert("修改失败！");
				}
	        });
		}
	})
	
})
