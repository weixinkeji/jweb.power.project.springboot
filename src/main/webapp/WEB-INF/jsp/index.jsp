<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h1>现在登陆的用户：${userSession.userName}</h1>

<h2>点我假设用户1登陆</h2>
<form action="/user/1/login" method="post">
	权限等级：<input type="text"  value="g1,g2" name="sysGrades" /><br>
	权限编号：<input type="text"  value="c1,c2" name="sysCodes"/><br>
	<input type="submit" value="用户1登陆"/><br>
</form>
<hr>


<h2>点我假设用户2登陆</h2>
<form action="/user/2/login"  method="post">
	权限等级：<input type="text"  value="g1" name="sysGrades" /><br>
	权限编号：<input type="text"  value="c3,c4" name="sysCodes"/><br>
	<input type="submit" value="用户2登陆"/><br>
</form>
<hr>

</body>
</html>
