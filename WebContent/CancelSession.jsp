<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script type="text/javascript">
function subb() {  
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"CancelSession",  
            async: false,  
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	
            		alert("注销成功");
                    window.location.href="index.jsp";
            	
                
            }  
        });  
}  
</script> 
</head>
<body onload="subb();">

</body>
</html>