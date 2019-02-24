<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script>  
function subbb() {  
     
    $("#login").ajaxSubmit(function(message) {   
    	alert("SUCCESS!");  
     
    });   

    return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转   
}  
function subb() {  
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"Login",  
            data:$('#login').serialize(),// 你的formid  
            async: false,  
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	if(data=="1")
            	{
            		alert("登录成功");
                    window.location.href="index.jsp";
            	}
            	else
            	{
            		alert("登录失败");
                    window.location.href="login.jsp";
           		}
                
            }  
        });  
}  
</script>  
</head>
<body>
<div class="container">
    <div class="picture">
        <img src="image/login.jpg" >
    </div>
    <div class="divi">
        <div class="massage">
            <h1>登录</h1>
            <form action="Login" id="login" method="post" onsubmit="return subb();">
				<input style="height:20px;width:20px;s" type="radio" value="1" name="power">普通用户 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input style="height:20px;width:20px;" type="radio" value="2" name="power">卖家<br><br>
               	 用户名：<input type="text" name="username"><br><br>
           	               密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"><br><br>
                <input id="sub" type="button" name="sub" value="登录" onclick="subb()"><br>
            </form>
        </div>
    </div>
</div>
</body>
</html>