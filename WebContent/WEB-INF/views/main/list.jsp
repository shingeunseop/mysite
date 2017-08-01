<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href="/mysite/assets/css/main.css" rel="stylesheet" type="text/css">
<title>Mysite</title>
</head>
<body>
    <form action="add.jsp" method="post">
	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		
		

		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
				
					<form action="add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td>
			<td><input type="text" name="ln" value=""></td>
			<td>비밀번호</td>
			<td><input type="password" name="ps" value=""></td>
		</tr>
		<tr>
			<td colspan=4><textarea type="content" name="co" value="" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			
		</tr>
	</table>
	</form>
	<br/>
	
<c:forEach items="${list}" var="vo" varStatus="status">
	<table width=510 border=1>
		<tr>
			<td>"${vo.no}"</td>
			<td>"${vo.name}"</td>
			<td>"${vo.reg_date}"</td>
			<td><a href="deleteform.jsp">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4>"${vo.content}"</td>
		</tr>
	</table>
	</c:forEach>
        <br/>
        
        <br/>
				</div>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div>
</body>
</html>