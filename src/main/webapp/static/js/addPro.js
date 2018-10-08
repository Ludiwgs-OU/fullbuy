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
	el: '#product-info',
	data:function(){
   		return {
   			sites: "",
   			secsites: ""
   	 	}
 	},
	created: function(){
    	var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/category.json",
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
   		getSecond: function(){
   			var self = this;
   			var category = $("#category option:selected").val();
   			//alert(category);
   			$.ajax({
				type:"get",
				url:"../static/json/categorysec.json",
				async:true,
				dataType:"json",
				//data: category,
				success:function(inf){
					self.secsites = inf;
				},
				error:function(inf){
					alert("获取数据失败！");
				},
			});
   		},
   		addPro: function(){
   			var name = $("#productName").val();
   			var detail = $("#productDetail").val();
   			var category = $("#category option:selected").val();
   			var category2 = $("#secondCategory option:selected").val();
   			var item1 = $("#item1").val();
   			var item2 = $("#item2").val();
   			var seconditem1 = $("input[name='secItem1']");
   			var secitem1 = Array();
   			for(var i =0;i<seconditem1.length;i++){
   				secitem1[i] = seconditem1[i];
   				//alert(secitem1[i].value);
   			}
   			var seconditem2 = $("input[name='secItem2']");
   			var secitem2 = Array();
   			for(var i =0;i<seconditem2.length;i++){
   				secitem2[i] = seconditem2[i];
   				//alert(secitem2[i].value);
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
			formData.append('item1',item1);
			formData.append('item2',item2);
			formData.append('secondItem1Array',secitem1);
			formData.append('secondItem2Array',secitem2);
			
			$.ajax({
				type:"post",
				url:"#",
				async:true,
				contentType: false,
	            processData: false,
	            cache: false,
	            data: formData,
				success:function(inf){
					alert("新增成功，前往添加价格的页面....");
					window.location.href="src/main/webapp/views/saleAddSku.html?pid="+inf;
				},
				error:function(inf){
					alert("新增失败！");
				},
			});
   		}
   	}
})

new Vue({
	el: "#sku-info",
	data(){
		return{
			site: ""
		}
	},
	created(){
		var self = this;
   		$.ajax({
			type:"get",
			url:"../static/json/sku.json",
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
		addProSku: function(){
			var itemId = Array();
			var secondItemId = Array();
			var price = Array();
			var gbPrice = Array();
			var quan = Array();
			
			var itemid = $("input[name='itemId']");
			var secondid = $("input[name='secondItemId']");
			var yprice = $("input[name='itemPrice']");
			var gbprice = $("input[name='itemgbPrice']");
			var quant = $("input[name='itemQuan']");
			
			var checkPrice = /^[0-9]+(\.[0-9]{1,2})?$/;
			var checkQuan = /^(0|[1-9][0-9]*)$/;
			
			for(var i =0;i<itemid.length;i++){
				if(!checkPrice.test(yprice[i].value) || !checkPrice.test(gbprice[i].value)){
					alert("价格输入错误！"+" "+yprice[i].value+" "+gbprice[i].value);
					break;
				}
				else if(!checkQuan.test(quant[i].value)){
					alert("库存量输入错误！"+" "+quant[i].value);
					break;
				}
				else{
					itemId[i] = itemid[i];
	   				secondItemId[i] = secondid[i];
	   				price[i] = yprice[i];
	   				gbPrice[i] = gbprice[i];
	   				quan[i] = quant[i];
	   				//alert(itemId[i].value+" "+secondItemId[i].value+" "+price[i].value+" "+gbPrice[i].value+" "+quan[i].value);
				}
   			}
			
			var sku = {
				"itemId": itemId,
				"secondItemId": secondItemId,
				"price": price,
				"gbPrice": gbPrice,
				"quantity": quan
			}
			
			$.ajax({
				type:"post",
				url:"#",
				async:true,
	            data: sku,
				success:function(inf){
					alert(inf);
				},
				error:function(inf){
					alert("添加失败！");
				},
			});
		}
	}
})