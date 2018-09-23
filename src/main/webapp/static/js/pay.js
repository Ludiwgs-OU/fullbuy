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
			url:"../static/json/address.json",
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
				url:"#",
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
				url:"#",
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
			
			var addressInfo = {
				"addressId": id,
				"name": name,
				"phone": phone,
				"postCode": code,
				"province": province,
				"city": city,
				"area": area,
				"address": address
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
					url:"#",
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

new Vue({
	el: '#order-info',
	data:function(){
   		return {
   			site: "",
   			type: getUrlParam('type')
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/order.json",
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
   		min: function(){
   			var one = $("#onePrice").text();
   			var num = Number($("#number").val())-1;
   			var price = Number(one*num);
   			var postage = Number($("#postage").text());
   			var price1 = price.toFixed(2);
   			var sum = Number(price+postage).toFixed(2);
   			if(price1<=0){
   				price1 = 0;
   				sum = 0;
   			}
   		
   			document.getElementById("allPrice").innerHTML = price1;
   			document.getElementById("sum").innerHTML = sum;
   			document.getElementById("J_ActualFee").innerHTML = sum;
   		},
   		add: function(){
   			var one = $("#onePrice").text();
   			var num = Number($("#number").val())+1;
   			var price = Number(one*num);
   			var postage = Number($("#postage").text());
   			var price1 = price.toFixed(2);
   			var sum = Number(price+postage).toFixed(2);
   			
   			document.getElementById("allPrice").innerHTML = price1;
   			document.getElementById("sum").innerHTML = sum;
   			document.getElementById("J_ActualFee").innerHTML = sum;
   		}
   	}
})

$(document).ready(function(){
    $(function(){
        $(".add").click(function(){
        	var t=$(this).parent().find('input[class*=text_box]');
         	t.val(parseInt(t.val())+1)
        })
      	$(".min").click(function(){
       		var t=$(this).parent().find('input[class*=text_box]');
         	t.val(parseInt(t.val())-1)
         	if(parseInt(t.val())<0){
          		t.val(0);
          	}
       })
      	
      	var price = Number($("#onePrice").text());
   		var postage = Number($("#postage").text());
   		var sum = Number(price+postage).toFixed(2);
   		document.getElementById("sum").innerHTML = sum;
   		document.getElementById("J_ActualFee").innerHTML = sum;
   		
    }) 

	
	<!--兼容IE浏览器 -->
	if (!document.getElementsByClassName) {
        document.getElementsByClassName = function (cls) {
            var ret = [];
            var els = document.getElementsByTagName('*');
            for (var i = 0, len = els.length; i < len; i++) {
                if (els[i].className.indexOf(cls + ' ') >=0 || els[i].className.indexOf(' ' + cls + ' ') >=0 || els[i].className.indexOf(' ' + cls) >=0) {
                    ret.push(els[i]);
                }
            }
            return ret;
        }
    }
 
 
	//地址选择
	$(function() {
		$(".user-addresslist").click(function() {
			$(this).addClass("defaultAddr").siblings().removeClass("defaultAddr");
			$(this).find(".buy-user").attr("id","checkBuyer");
			$(this).siblings().find(".buy-user").removeAttr("id");
			$(this).find(".buy-phone").attr("id","checkPhone");
			$(this).siblings().find(".buy-phone").removeAttr("id");
			$(this).find(".buy-province").attr("id","checkProvince");
			$(this).siblings().find(".buy-province").removeAttr("id");
			$(this).find(".buy-city").attr("id","checkCity");
			$(this).siblings().find(".buy-city").removeAttr("id");
			$(this).find(".buy-area").attr("id","checkArea");
			$(this).siblings().find(".buy-area").removeAttr("id");
			$(this).find(".buy-address").attr("id","checkAddress");
			$(this).siblings().find(".buy-address").removeAttr("id");
			$(this).find(".buy-addressid").attr("id","checkAddressid");
			$(this).siblings().find(".buy-addressid").removeAttr("id");
			
			document.getElementById("buyer-name").innerHTML = $("#checkBuyer").text();
      		document.getElementById("buyer-phone").innerHTML = $("#checkPhone").text();
      		document.getElementById("buyer-province").innerHTML = $("#checkProvince").text();
      		document.getElementById("buyer-city").innerHTML = $("#checkCity").text();
      		document.getElementById("buyer-area").innerHTML = $("#checkArea").text();
      		document.getElementById("buyer-address").innerHTML = $("#checkAddress").text();
      		document.getElementById("buyer-addressid").innerHTML = $("#checkAddressid").text();
		});
		$(".logistics").each(function() {
			var i = $(this);
			var p = i.find("ul>li");
			p.click(function() {
				if (!!$(this).hasClass("selected")) {
					$(this).removeClass("selected");
				} 
				else {
					$(this).addClass("selected").siblings("li").removeClass("selected");
				}
			})
		})
	});
	
	$("#add-btn").click(()=>{
		var name = $("#a-name").val();
		var phone = $("#a-phone").val();
		var code = $("#a-code").val();
		var province = $("#u-province").val();
		var city = $("#u-city").val();
		var area = $("#u-area").val();
		var address = $("#u-address").val();
		
		var addressInfo = {
			"name": name,
			"phone": phone,
			"postCode": code,
			"province": province,
			"city": city,
			"area": area,
			"address": address
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
				url:"#",
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
	
	$("#J_Go").click(()=>{
		var num = $("#number").val();
		if(num == 0){
			alert("请选择数量！");
		}
		else{
			$(document.body).css("overflow","hidden");
			$('#pay-part').slideDown(200);
		}
		
	})
	
	
	/*
	 * 支付
	 */
	$("#pay-btn").click(()=>{
		var type = getUrlParam('type');
		var sku = $("#skuId").text();
		var address = $("#buyer-addressid").text();
		var price = $("#sum").text();
		var num = type == 1? $("#number").val() : 1;
		var status = 2;
		var oneprice = $("#onePrice").text();
		var postage = $("#postage").text();
		
		var Order = {
			"skuId": sku,
			"totalPrice": price,
			"addressId": address,
			"num": num,
			"orderStatus": status,
			"price": oneprice,
			"postfee": postage
		}
		
		$.ajax({
			type:"post",
			url:"/order/addOrder",
			async:true,
			dataType:"json",
			data: orderInfo,
			success:function(inf){
				alert(inf);
				window.location.href = "orderinfo.html?oid="+inf;
			},
			error:function(inf){
				alert("支付失败！");
			},
		});
	})
	
	/*
	 * 未支付
	 */
	$("#cal-btn").click(()=>{
		var type = getUrlParam('type');
		var sku = $("#skuId").text();
		var address = $("#buyer-addressid").text();
		var price = $("#sum").text();
		var num = type == 1? $("#number").val() : 1;
		var status = 1;
		var oneprice = $("#onePrice").text();
		var postage = $("#postage").text();
		
		var orderInfo = {
			"skuId": sku,
			"totalPrice": price,
			"addressId": address,
			"num": num,
			"orderStatus": status,
			"price": oneprice,
			"postfee": postage
		}
		
		$.ajax({
			type:"post",
			url:"/order/addOrder",
			async:true,
			dataType:"json",
			data: orderInfo,
			success:function(inf){
				window.location.href = "orderinfo.html?oid="+inf;
			},
			error:function(inf){
				alert("生成订单失败！");
			},
		});
	})
})
 
// 弹出地址选择
 
$(document).ready(function($) {
	var $ww = $(window).width();
	$('.theme-login').click(function() {
		//禁止遮罩层下面的内容滚动
		$(document.body).css("overflow","hidden");
		$('#add-part').slideDown(200);
	})
	
	$('.theme-poptit .close').click(function() {
		$(document.body).css("overflow","visible");
		$('#add-part').slideUp(200);
		$('#update-part').slideUp(200);
	})
	
}); 

