<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>
    <link rel="stylesheet" href="css/shop.css">
    <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
<script>   
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return decodeURI(r[2]); 
    return null; 
} 
function load() {  
	var url = location.search; //获取url中"?"符后的字串
	var kind=getQueryString("kind");
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"Kind",   
            async: false,  
            data:{"kind":kind},
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
        				
        				var innerText='<a href="product_detail.jsp?pro_id=';
        				innerText+=json[i]["pro_id"];
        				innerText+='"><div class="product"';
        				innerText+='id="';
        				innerText+=j;
        				innerText+='" ><div class="picture"><img src="';
        				innerText+=json[i]["pro_picture1"];
        				innerText+='" ></div><p>';
        				innerText+=json[i]["pro_name"];
        				innerText+='</p></a>';
        				
        				$("#ok").append(innerText);//document.getElementById("ok").innerHTML(innerText);


    					/*for(var key in json[i])
    					{

    						alert(key+':'+json[i][key]);

            			}*/
    				} 
        		}
            }  
        });  
}  
</script>  
</head>
<body onload="load();">
<div class="container" id="ok">
    <h1>Product</h1>

</div>
</body>
</html>