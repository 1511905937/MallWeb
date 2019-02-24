<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/productdetail.css">
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
	var pro_id=getQueryString("pro_id");
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"Pro_detail",   
            async: false,  
            data:{"pro_id":pro_id},
            error:function(request) {  
                alert("Connection error:"+request.error);  
            },  
            success: function(data) {  
            	//ScriptDiv.insertAdjacentHTML("afterBegin",sHTML + sScript); 
        		var json=JSON.parse(data); 
        		if(json.length>0)
        		{
        			for(var i=0,j=2,l=json.length;i<l;i++,j++)
            		{
        				var innerText='<img src="';
        				innerText+=json[i]["pro_picture1"];
        				innerText+='"><br><br><p>';
        				innerText+=json[i]["pro_name"];
        				innerText+='</p>';
        				$("#pic").append(innerText);//document.getElementById("ok").innerHTML(innerText);
        				
        				innerText="";
        				innerText+='<h3>';
        				innerText+=json[i]["pro_content"];
        				innerText+='</h3>';
        				innerText+='<img src="';
        				innerText+=json[i]["pro_picture1"];
        				innerText+='"><br><br>';
        				innerText+='<img src="';
        				innerText+=json[i]["pro_picture2"];
        				innerText+='"><br><br>';
        				innerText+='<img src="';
        				innerText+=json[i]["pro_picture3"];
        				innerText+='"><br><br>';
        				$("#content").append(innerText);
    				} 
        		}
            }  
        }); 
    $.ajax({   
        cache: true,  
        type: "POST",  
        url:"Evaluate",   
        async: false,  
        data:{"pro_id":pro_id},
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
    				
    				var innerText='<p>';
    				innerText+=json[i]["user_name"];
    				innerText+=':<p><p>';
    				innerText+=json[i]["evaluate_content"];
    				innerText+='</p>';
    				$("#eva").append(innerText);//document.getElementById("ok").innerHTML(innerText);
    				
				} 
    		}
        }  
    }); 
    
    
}  
function subb()
{
	var pro_id=getQueryString("pro_id");
	 $.ajax({   
         cache: true,  
         type: "POST",  
         url:"AddCar",  
         data:{"pro_id":pro_id},// 你的formid  
         async: false,  
         error:function(request) {  
             alert("Connection error:"+request.error);  
         },  
         success: function(data) {  
         	if(data=="1")
         	{
         		alert("加入购物车成功");
              
         	}
         	else
         	{
         		alert("加入购物车失败");
               
        		}
             
         }  
     });  
}
</script>
</head>
<body onload="load();">
<div class="container" >
    <div class="product_picture">
        <div class="picture" id="pic">
            
        </div>
       
    </div>
   
    <div class="product_content" id="content">
    <form action="AddCar" id="AddCar" method="post" >
		<input id="sub" type="button" name="sub" value="加入购物车" onclick="subb();"><br>
    </form>
    </div>
    <div class="product_evaluate" id="eva">

    </div>
</div>
</body>
</html>