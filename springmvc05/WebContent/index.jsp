<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upload" enctype="multipart/form-data" method="post"> <!--文件上传必须使用POST -->
	<!-- POST 最大2GB,GET最大2KB,POST上传字节流,GET上传字符流-->
	姓名:<input type="text" name="name"/><br/>
	文件:<input type="file" name="file"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>