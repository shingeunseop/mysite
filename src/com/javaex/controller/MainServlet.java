package com.javaex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/main/index.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);// 꼭 있어야함, get으로 받을때 사용
	}

}//localhost:8088/mysite/user  ==메인창
  //localhost:8088/mysite/user?a=joinform ==회원가입폼
  //localhost:8088/mysite/user?a=join==DB회원 정보 -성공페이지
//localhost:8088/mysite/user?a=loginform-로그인 
//가끔 실행이 안되면 로그인 같은 타이틀을 바꾼뒤 되돌리면 된다.
//공통사항은 inculde로 모아서 간단화 시켜도 된다.
//<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include> 이와 같은 문법사용
//localhost:8088/mysite/user?a=login