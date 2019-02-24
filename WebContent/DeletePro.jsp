<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script>  
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return decodeURI(r[2]); 
    return null; 
} 
function subb() {
	var pro_id=getQueryString("pro_id");
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"DeletePro",  
            data:{"pro_id":pro_id},
            async: false,  
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	if(data=="1")
            	{
            		alert("删除成功");
                    window.location.href="shop.jsp";
            	}
            	else
            	{
            		alert("删除失败");
                    window.location.href="shop.jsp";
           		}
                
            }  
        });  
}  
</script>  
</head>
<body onload="subb();">

</body>
</html>