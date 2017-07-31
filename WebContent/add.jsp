<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.GuestbooksDao" %>
<%@ page import="com.javaex.vo.GuestbooksVo" %>



<%
  request.setCharacterEncoding("UTF-8");
  String name=request.getParameter("ln");
  String password=request.getParameter("ps");
  String content=request.getParameter("co");
  content=content.replace("\r\n", "<br>");

  
  GuestbooksVo vo=new GuestbooksVo(name,password,content);
  
  GuestbooksDao dao=new GuestbooksDao();
  dao.insert(vo);
  
  response.sendRedirect("/mysite/gb");//이게 list인 경우는 프로젝트 1을 했을때의 사례
 
  
  
  %>
