<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/shopcar.css">
 <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script>  
function load() {  
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"Shopcar",    
            async: false,  
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	var json=JSON.parse(data); 
        		if(json.length>0)
        		{
        			for(var i=0,j=2,l=json.length;i<l;i++,j++)
            		{

        				var innerText='<input type="checkbox" /> ';
        				innerText+=json[i]["pro_name"]+'<br><br>';
        				
        				$("#car").append(innerText);//document.getElementById("ok").innerHTML(innerText);

    					/*for(var key in json[i])
    					{

    						alert(key+':'+json[i][key]);

            			}*/
    				} 
        		}
            }  
        });  
}  
function sum()
{
	alert('请给张以恒转大钞');
	}
</script>  
</head>
<body onload="load();">
<div id="con">
<form>
<div id="car">
</div>
<input type="button" value="结算" onclick="sum();">
</form>
</div>
</body>
</html>