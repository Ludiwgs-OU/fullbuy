$(document).ready(function() {							
	$(".new-option-r").click(function() {
		$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
	});
	
	var $ww = $(window).width();
	if($ww>640) {
		$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
	}
	
	/*
	 * 搜索
	 */
	$("#ai-topsearch").click(()=>{
		var info = $("#searchInput").val();
		window.open("search.html?info=" + info);
	})
	
	var $ww = $(window).width();
	$('.theme-poptit .close').click(function() {
		$(document.body).css("overflow","visible");
		$('#add-part').slideUp(200);
		$('#update-part').slideUp(200);
	})
	
	$("#add-btn").click(()=>{
		var name = $("#user-name").val();
		var phone = $("#user-phone").val();
		var code = $("#user-code").val();
		var province = $("#user-province").val();
		var city = $("#user-city").val();
		var area = $("#user-area").val();
		var address = $("#user-address").val();
		
		var Address = {
			"name": name,
			"phone": phone,
			"postCode": code,
			"province": province,
			"city": city,
			"street": area,
			"addressDetail": address
		}
		
		var pattern1 = /^\d{6}$/;
		var pattern2 = /^\d{11}$/;
		
		if(name == ""){
			alert("请输入收件人姓名！");
		}
		else if(!pattern2.test(phone)){
			alert("请输入正确的手机号码！");
		}
		else if(!pattern1.test(code)){
			alert("请输入正确的邮政编码！");
		}
		else if($("#a-address").val() == ""){
			alert("请输入详细地址！");
		}
		else{
			$.ajax({
				type:"post",
				url:"/user/addAddress",
				async:true,
				dataType:"json",
				data: addressInfo,
				success:function(inf){
					alert(inf);
					window.reload();
				},
				error:function(inf){
					alert("添加失败！");
				},
			});
		}
	})
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
	el: '#address',
	data:function(){
   		return {
   			sites: "",
   			info: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"/user/displayAddress",
			async:true,
			dataType:"json",
			success:function(inf){
				self.sites = inf;
			},
			error:function(inf){
				alert("获取数据失败！");
			},
		});
   	},
   	methods: {
   		upd: function(id){
			var self = this;
			$.ajax({
				type:"post",
				url:"/user/displayAddressDetail",
				async:true,
				dataType:"json",
				data: {
					"addressId": id
				},
				success:function(inf){
					self.info = inf;
					$(document.body).css("overflow","hidden");
					$('#update-part').slideDown(200);
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
   		},
   		del: function(id){
   			$.ajax({
				type:"post",
				url:"/user/deleteAddress",
				async:true,
				dataType:"json",
				data: {
					"addressId": id
				},
				success:function(inf){
					alert(inf);
					window.reload();
				},
				error:function(inf){
					alert("删除失败！");
				},
			});
   		},
   		upda: function(id){
   			var name = $("#u-name").val();
			var phone = $("#u-phone").val();
			var code = $("#u-code").val();
			var province = $("#u-province").val();
			var city = $("#u-city").val();
			var area = $("#u-area").val();
			var address = $("#u-address").val();
			
			var Address = {
				"addressId": id,
				"name": name,
				"phone": phone,
				"postCode": code,
				"province": province,
				"city": city,
				"street": area,
				"addressDetail": address
			};
			
			var pattern1 = /^\d{6}$/;
			var pattern2 = /^\d{11}$/;
			if(name == ""){
				alert("请输入收件人姓名！");
			}
			else if(!pattern2.test(phone)){
				alert("请输入正确的手机号码！");
			}
			else if(!pattern1.test(code)){
				alert("请输入正确的邮政编码！");
			}
			else if($("#a-address").val() == ""){
				alert("请输入详细地址！");
			}
			else{
				$.ajax({
					type:"post",
					url:"/user/modifyAddress",
					async:true,
					dataType:"json",
					data: addressInfo,
					success:function(inf){
						alert(inf);
						window.reload();
					},
					error:function(inf){
						alert("修改失败！");
					},
				});
			}
   		}
   	}
})