<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.UserVo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
     UserVo uservo=(UserVo)request.getAttribute("uservo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
	<title>Insert title here</title>
</head>
<body>

	<div id="container">
		
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		
		<div id="wrapper">
			<div id="content">
				<div id="user">
	
					<form id="join-form" name="joinForm" method="get" action="/mysite/user">

						
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value="${requestScope.uservo.name }" />
	
						<label class="block-label" for="email">이메일</label>
						<strong>${requestScope.uservo.email }</strong>
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="${requestScope.uservo.password}" />
						
						<fieldset>
							<legend>성별</legend>
							
							<c:choose>
							<c:when test="${requestScope.uservo.gender=='male' }"><!-- 변수 취급 할떄 ''가 필요 -->
							<label>여</label> <input type="radio" name="gender" value="female" >
							<label>남</label> <input type="radio" name="gender" value="male" checked="checked">
							</c:when>
							
							<c:when test="${requestScope.uservo.gender=='female' }">
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked" >
							<label>남</label> <input type="radio" name="gender" value="male" >
							 </c:when>
							    	
						</c:choose>
						</fieldset>
						<input type="text" name="a" value="modify" />
						
						<input type="submit" value="수정완료">
						
					</form>
				</div><!-- /user -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
		
	</div> <!-- /container -->

</body>
</html>
