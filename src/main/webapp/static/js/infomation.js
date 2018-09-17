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
	    var reader = new FileReader();
	    reader.readAsDataURL(profile);
		
		$.ajax({
            type: "post",
            url: "#",
            contentType: false,
            processData: false,
            data: profile,
            success: function(result){
            	alert("头像修改成功");
            	reader.onload=function(e){
	        		document.getElementById("profileImg").src = this.result;
	    		}
            },
            error: function(result){
            	alert("头像修改失败！");
            }
        });
	})
	
})
