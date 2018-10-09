/*
 * 获取路径参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null; 
}

function showImg(img,showimg){
	var fr = new FileReader();
    fr.onload = function () {
        showimg.src = fr.result;
    };
    fr.readAsDataURL(img);
}

$(document).ready(()=>{
	
	$("#detailImg1").change(()=>{
		var img = $('#detailImg1')[0].files[0];
		var showimg = document.getElementById("forDetail1");
		showImg(img,showimg);
	})
	
	$("#detailImg2").change(()=>{
		var img = $('#detailImg2')[0].files[0];
		var showimg = document.getElementById("forDetail2");
		showImg(img,showimg);
	})
	
	$("#searchImg").change(()=>{
		var img = $('#searchImg')[0].files[0];
		var showimg = document.getElementById("forSearchImg");
		showImg(img,showimg);
	})
	
	$("#showImg1").change(()=>{
		var img = $('#showImg1')[0].files[0];
		var showimg = document.getElementById("forShowImg1");
		showImg(img,showimg);
	})
	
	$("#showImg2").change(()=>{
		var img = $('#showImg2')[0].files[0];
		var showimg = document.getElementById("forShowImg2");
		showImg(img,showimg);
	})
	
	$("#additem1").click(()=>{
		$("#secitem1").append("<div class='am-form-content seconditem' style='width: 20%;'><input name='secItem1' type='text'></div>");
	})
	
	$("#additem2").click(()=>{
		$("#secitem2").append("<div class='am-form-content seconditem' style='width: 20%;'><input name='secItem2' type='text' style='margin-top: 20px;'></div>");
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
			url:"/sales/displaySalesDetail",
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
					window.open("home.html");
				},
				error:function(result){
					alert("获取数据失败！");
				},
			});
   		}
   	}
})

new Vue({
	el: "#changeProduct",
	data(){
		return{
			site: "",
			secsites: ""
		}
	},
	created(){
		var self = this;
		var id = getUrlParam('pid');
		$.ajax({
			type:"get",
			url:"/product/displayProductDetailWithSku",
			async:true,
			dataType:"json",
			data: {
				"productId": id
			},
			success:function(result){
				self.site = result;
				self.secsites = result.secondCategoryList;
			},
			error:function(result){
				alert("获取数据失败！");
			},
		});
	},
	methods: {
		getSecond: function(){
   			var self = this;
   			var category = $("#category option:selected").val();
   			//alert(category);
   			$.ajax({
				type:"get",
				url:"/product/displaySecondCategory",
				async:true,
				dataType:"json",
				data: {
					"categoryId": category
				},
				success:function(inf){
					self.secsites = inf;
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
   		},
   		changeInfo: function(){
   			var name = $("#productName").val();
   			var detail = $("#productDetail").val();
   			var postfee = $("#postfee").val();
   			var category = $("#category option:selected").val();
   			var category2 = $("#secondCategory option:selected").val();
   			var seconditem1 = $("input[name='secItem1']");
   			var skuList = Array();
   			var skuObj = new Object();
   			var price = $("input[name='itemPrice']");
   			var sku = $("input[name='skuId']");
   			var gbprice = $("input[name='itemgbPrice']");
   			var quan = $("input[name='itemQuan']");
   			for(var i=0;i<price.length;i++){
   				skuObj.skuId = sku[i];
   				skuObj.price = price[i];
   				skuObj.gbPrice = gbprice[i];
   				skuObj.quantity = quan[i];
   				skuList[i] = skuObj;
   				//alert(skuList[i].skuId.value+" "+skuList[i].price.value+" "+skuList[i].gbPrice.value+" "+skuList[i].quantity.value);
   			}
   			
   			var pro = {
   				"productName": name,
   				"productDetail": detail,
   				"category_Id": category,
   				"secondCategoryId": category2,
   				"item1": item1,
   				"item2": item2,
   				"postfee": postfee
   			}
   			
   			var Product = new FormData();
   			product.append('product',pro);
			Product.append('searchImgPath', $('#searchImg')[0].files[0]);
			Product.append('bImgPath1', $('#showImg1')[0].files[0]);
			Product.append('bImgPath2', $('#showImg2')[0].files[0]);
			Product.append('detailImgPath1', $('#detailImg1')[0].files[0]);
			Product.append('detailImgPath2', $('#detailImg2')[0].files[0]);
			Product.append('SkuList', skuList);
			
			$.ajax({
				type:"post",
				url:"/product/addProduct",
				async:true,
				contentType: false,
	            processData: false,
	            cache: false,
	            data: product,
				success:function(inf){
					alert(inf);
				},
				error:function(inf){
					alert("修改失败！");
				},
			});
   		}
	}
})