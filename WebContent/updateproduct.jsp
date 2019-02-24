<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/addproduct.css">
</head>
<body>
<div class="container">
    <h1>添加商品</h1>
    <form action="" method="post" class="form">
        商品名称：<input type="text" name="name"><br>
        商品详情：<br><br><textarea name="content" rows="20" cols="135"></textarea><br><br>
        上传图片1：<br><br>
        上传图片2：<br><br>
        上传图片3：<br><br>
        商品种类：<input type="text" name="kind"><br><br>
        商品价格：<input type="text" name="price"><br><br>
        <input id="sub" type="submit" name="sun" value="提交"><br><br>
    </form>
</div>
</body>
</html>