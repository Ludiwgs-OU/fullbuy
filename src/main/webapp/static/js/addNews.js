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
	el:'#addnew',
	methods:{
		adds:function(){
			var profile = document.getElementById("profile").files[0];
			var imgUrl = getObjectURL(profile);
			var productId = $("#id").val();			
			alert(productId);
			alert(imgUrl);
			$.ajax({
				type:"post",
				url:"/news/addNews",
				async:true,
				dataType:'json',
				data:{
					"productId":productId,
					"file":imgUrl
				},
				success:function(result){
					if(result==1){
						alert("新增成功！！");
						window.location.herf='addNew.html';
					}
					else
						alert("新增公告出错！");
				}				
			});
		}					
	}
})
