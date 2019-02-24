<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/addproduct.css">
 <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script>   
function subb() {  
     var form = document.getElementById("addproduct");
     
     var formData=new FormData(form);
    // formData=document.getElementById("addproduct");
    // alert("1");
     var pro_name=formData.get("pro_name");
     var pro_content=formData.get("pro_content");
     var pro_shop=formData.get("pro_shop");
     var pro_kind=formData.get("pro_kind");
     var pro_price=formData.get("pro_price");
     var formFile = new FormData();
     formFile.append("pro_name", pro_name);
     formFile.append("pro_content", pro_content);
	 var fileObj1 = document.getElementById("file1").files[0];
	 
     if (typeof (fileObj1) == "undefined" || fileObj1.size <= 0) {
    	 formFile.append("pro_picture1", fileObj1); 
         alert("请选择图片1");
         
     }
     var fileObj2 = document.getElementById("file2").files[0];
     if (typeof (fileObj2) == "undefined" || fileObj2.size <= 0) {
    	 formFile.append("pro_picture2", fileObj2);
         alert("请选择图片2");
        
     }
     var fileObj3 = document.getElementById("file3").files[0];
     if (typeof (fileObj3) == "undefined" || fileObj3.size <= 0) {
    	 formFile.append("pro_picture3", fileObj3);
         alert("请选择图片3");
        
     }
     formFile.append("pro_shop", pro_shop);
     formFile.append("pro_kind", pro_kind);
     formFile.append("pro_price", pro_price);
    $.ajax({   
            cache: false,  
            type: "POST",  
            url:"AddPro",  
            data:$('#addproduct').serialize(),// 你的formid  //formFile,
            async: false,  
            contentType: false,
            processData: false,
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	if(data=="1")
            	{
            		alert("添加成功成功");
                    window.location.href="index.jsp";
            	}
            	else
            	{
            		alert("添加失败");
            		alert(data);
                    window.location.href="addproduct.jsp";
            	}
            }  
        });  
}  
</script>  
</head> 
<body>
<div class="container">
    <h1>添加商品</h1>
    <form action="AddPro" method="post" class="form" id="addproduct" enctype="multipart/form-data">
        商品名称：<input type="text" name="pro_name"><br>
        商品详情：<br><br><textarea name="pro_content" rows="20" cols="135"></textarea><br><br>
        上传图片1：<input id="file1" type="file" name="pro_picture1"><br><br>
        上传图片2：<input id="file2" type="file" name="pro_picture2"><br><br>
        上传图片3：<input id="file3" type="file" name="pro_picture3"><br><br>
        商品种类：<input type="text" name="pro_kind"><br><br>
        商品价格：<input type="text" name="pro_price"><br><br>
        <input id="sub" type="submit" name="sun" value="提交" ><br><br>
    </form>
</div>
</body>
</html>