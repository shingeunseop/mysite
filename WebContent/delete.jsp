<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.GuestbooksDao" %>
<%@ page import="com.javaex.vo.GuestbooksVo" %>


<%   
      request.setCharacterEncoding("UTF-8");
      String password=request.getParameter("ps");
      
      GuestbooksVo vo=new GuestbooksVo(password);
      
      GuestbooksDao dao=new GuestbooksDao();
      dao.delete(vo);
      
      response.sendRedirect("/mysite/gb");


%>