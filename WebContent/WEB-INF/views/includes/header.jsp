<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.UserVo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
   UserVo authUser=(UserVo)session.getAttribute("authUser");//변수의 내용을 꺼냄
   

%>

       <div id="header">
			 <h1>MySite: ${sessionScope.authUser.name}:${authUser.name}<!-- 내장 객체 생략시 --> </h1>
			 <ul>
			<c:choose>
			<c:when test="${sessionScope.authUser==null}">
			 	   <!-- 로그인 전 -->
				   <li><a href="/mysite/user?a=loginform">로그인</a></li>
				   <li><a href="/mysite/user?a=joinform">회원가입</a></li>
				</c:when>
				<c:when test="${sessionScope.authUser!=null}">
				<!-- 로그인 후 -->
				<li><a href="/mysite/user?a=modifyform">회원정보수정</a></li>
				<li><a href="/mysite/user?a=logout">로그아웃</a></li> 
				<li> ${sessionScope.authUser.name} 님 안녕하세요^^;</li>
				</c:when>
			</c:choose>
			</ul>
		</div> <!-- /header -->