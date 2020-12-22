<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Title here</title>
</head>
<body>
request:${requestScope.req }<br/>
session:${sessionScope.session }<br/>
sessionParam:${sessionScope.sessionParam } <br/>
application:${applicationScope.application}
<hr/>
map:${map } <br/> <!--两个输出相同，说明map属性绑定在 requestScope 下->
map:${requestScope.map } <!--两个输出相同，说明map属性绑定在 requestScope 下-->
<hr/>
model:${model } <br/>
model:${requestScope.model }  <!--两个输出相同，说明map属性绑定在 requestScope 下-->
<hr/>
mav:${requestScope.mav }
</body>
</html>