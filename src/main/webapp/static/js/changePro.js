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
			url:"../static/json/saleInfo.json",
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
		$.ajax({
			type:"get",
			url:"../static/json/changePro.json",
			async:true,
			dataType:"json",
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
				url:"../static/json/categorysec.json",
				async:true,
				dataType:"json",
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
   			
   			var formData = new FormData();
   			formData.append('productName', name);
			formData.append('productDetail',detail);
			formData.append('categoryName',category);
			formData.append('secondCategoryName',category2);
			formData.append('searchImgPath', $('#searchImg')[0].files[0]);
			formData.append('bImgPath1', $('#showImg1')[0].files[0]);
			formData.append('bImgPath2', $('#showImg2')[0].files[0]);
			formData.append('detailImgPath1', $('#detailImg1')[0].files[0]);
			formData.append('detailImgPath2', $('#detailImg2')[0].files[0]);
			formData.append('skuList', skuList);
			
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				contentType: false,
	            processData: false,
	            cache: false,
	            data: formData,
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