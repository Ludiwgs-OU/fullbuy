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
			url:"../static/json/userinfo.json",
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

$(document).ready(()=>{
	
	$("#changeInfo").click(()=>{
		var name = $("#user-name2").val();
		var sex = $("input[name='radio']:checked").val();
		var phone = $("#user-phone").val();
		var email = $("#user-email").val();
		
		var info = {
			"userName": name,
			"Sex": sex,
			"userPhone": phone,
			"userEmail": email
		}
		//alert(name+" "+sex+" "+phone+" "+email);
		
		$.ajax({
			type:"post",
			url:"#",
			async:true,
			dataType:"json",
			data: info,
			success:function(inf){
				alert("修改成功！");
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
            url: "#",
            contentType: false,
            processData: false,
            data: {
            	"userprofile": imgUrl
            },
            success: function(result){
            	alert("头像修改成功");
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
			"oldPwd": oldpwd,
			"newPwd": newPwd
		}
		
		if(newPwd != rePwd){
			alert("两次密码输入不正确！");
		}
		else{
			$.ajax({
	            type:"post",
				url:"#",
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
