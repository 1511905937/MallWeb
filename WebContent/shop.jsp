<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mymall shop show</title>
    <link rel="stylesheet" href="css/shop.css">
    <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script>   
function load() {  
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"SeletePro",   
            async: false,  
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	//alert(data);
            	//ScriptDiv.insertAdjacentHTML("afterBegin",sHTML + sScript); 
        		var json=JSON.parse(data); 
        		if(json.length>0)
        		{
        			for(var i=0,j=2,l=json.length;i<l;i++,j++)
            		{
        				var id=i+1;
        				var innerText='<a href="product_detail.jsp?pro_id=';
        				innerText+=json[i]["pro_id"];
        				innerText+='"><div class="product"';
        				innerText+='id="';
        				innerText+=j;
        				innerText+='" ><div class="picture"><img src="';
        				innerText+=json[i]["pro_picture1"];
        				innerText+='" ></div><p>';
        				innerText+=json[i]["pro_name"];
        				innerText+='</p></a><p><a href="DeletePro.jsp?pro_id='+json[i]["pro_id"]+'" >删除</a></p>';
        				
        				$("#ok").append(innerText);//document.getElementById("ok").innerHTML(innerText);

    					/*for(var key in json[i])
    					{

    						alert(key+':'+json[i][key]);

            			}*/
    				} 
        		}
            }  
        });  
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
<div class="container" id="ok">
    <h1>Shop Manage</h1>
    <a href="addproduct.jsp" class="add" >添加</a>

</div>
</body>
</html>