<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var mod_menu=$(".mod-menu");//导航模块区
	var menu=function(){
		var menuItem=$(".menu-item li");//选择导航列表 
		menuItem.each(function(){
			var _index=$(this).index();//获取当前选择菜单列表的索引
			$(this).mouseenter(function(){
				var y = $(this).position().top+1;//获取当前鼠标滑过的列表的顶部坐标
				$(".menu-cont").show();
				$(".menu-cont").css("top",y);//需要显示的对应索引内容
				$(this).addClass("mouse-bg").siblings().removeClass("mouse-bg");
				$(".menu-cont>div").eq(_index).show().siblings().hide();
			});
		});/*导航菜单菜单*/
		$(".mod-menu").mouseleave(function(){
			$(".menu-cont").hide();
			menuItem.removeClass("mouse-bg");
		})
	}//展开二级菜单	
	menu();//执行展开二级菜单函
});
function load() {  
    $.ajax({   
            cache: true,  
            type: "POST",  
            url:"Index",   
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
        				
        				$("#product").append(innerText);//document.getElementById("ok").innerHTML(innerText);

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
			//alert(data);
        	var text="";
        	if(data=="-1")
        	{
        		text='<p style="text-align:left;"><a href="login.jsp" >登录</a>|<a href="register.jsp" >注册</a></p>';
        		$("#contain").append(text);
       		}
        	else
        	{
        		var json=JSON.parse(data);
        		text="<p style='text-align:left;'>WelCome "+json[0]+"<a href='shopcar.jsp'>&nbsp;&nbsp;&nbsp;购物车</a></p><a href='add_shop.jsp' >&nbsp;&nbsp;&nbsp;我想开家店</a><a href='CancelSession.jsp'>&nbsp;&nbsp;&nbsp;注销</a><a href='shop.jsp'>&nbsp;&nbsp;&nbsp;管理店铺</a></p>";
        		$("#contain").append(text);
        	}
        	
        }  
    });  
    
    var a=[['上衣','牛仔裤','连衣裙','套装'],['洗面奶','水乳套盒','精华液','面膜','唇膏','口红'],['墨镜','运动裤','防晒衣'],['饮料','零食'],['皮鞋','帆布鞋','靴子','高跟鞋','双肩包'],['沙发','书柜','床','鞋架'],['牛仔裤','上衣'],['鼠标','键盘','U盘'],['电蚊香','花露水']];
    for(var i=0;i<9;i++)
    {
    	var cotegory='<div class="menu-cont-list" style="display:none;"><ul>';
   		for(var j=0;j<a[i].length;j++)
   		{
   			cotegory+='<li><a href="cotegory.jsp?kind=';
   			cotegory+=a[i][j];
   			cotegory+='">';  
   			cotegory+=a[i][j];
   			cotegory+='</a></li>';
   		}
   		cotegory+='</ul></div>';
   		$("#kinds").append(cotegory);
   	}
}   
</script>
</head>
<body onload="load();">

<div id="contain">
</div>
<h1>My Mall</h1>
<div class="mod-menu">

	<ul class="menu-item">
		<li><a href="">女装</a></li>
		<li><a href="">美妆</a></li>
		<li><a href="">运动</a></li>
		<li><a href="">食品</a></li>
		<li><a href="">鞋包</a></li>
		<li><a href="">家具</a></li>
		<li><a href="">男装</a></li>
		<li><a href="">电子</a></li>
		<li><a href="">生活用品</a></li>
	</ul>
	<div class="menu-cont" style="display:none;top:241px;" id="kinds">
	</div>	 
</div>
<div class="pic">
<img src="image/index.jpg" >
</div>
<div id="product" class="container">

</div>

</body>
</html>
