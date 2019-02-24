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
<script type="text/javascript">
function subb() {  
	 $.ajax({   
         cache: true,  
         type: "POST",  
         url:"AddShop",  
         data:$('#AddShop').serialize(),// 你的formid  
         async: false,  
         error:function(request) {  
             alert("Connection error:"+request.error);  
         },  
         success: function(data) {  
         	if(data=="1")
         	{
         		alert("添加成功");
                 window.location.href="shop.jsp";
         	}
         	else
         	{
         		alert("只能开一家商店");
                 window.location.href="shop.jsp";
        		}
             
         }  
     });  
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"AddShop",  
            data:$('#AddShop').serialize(),// 你的formid  
            async: false,  
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	if(data=="1")
            	{
            		alert("添加成功");
                    window.location.href="shop.jsp";
            	}
            	else
            	{
            		alert("只能开一家商店");
                    window.location.href="shop.jsp";
           		}
                
            }  
        });  
}  
function load()
{
	$.ajax({    
        type: "POST",  
        url:"UserMsg",   
        async: false,  
        error:function(request) {  
            alert("Connection error:"+request.error);  
        },  
        success: function(data) {  

        	var json=JSON.parse(data);
        	if(json[1]=="1")
        	{
        		alert("请以卖家身份重新登录");
        		window.location.href="login.jsp";
        	}
        }  
    }); 
}
</script>  
</head>
<body onload="load();">
<div class="container">
    <h1>添加商店</h1>
    <form action="AddShop" method="post" class="form" id="AddShop" onsubmit="return subb();">
        商店名称：<input type="text" name="shop_name"><br><br>
         <input id="sub" type="button" name="sub" value="提交" onclick="subb()"><br>
    </form>
</div>
</body>
</html>