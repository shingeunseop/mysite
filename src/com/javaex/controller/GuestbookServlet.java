package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbooksDao;
import com.javaex.vo.GuestbooksVo;


@WebServlet("/gb")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			System.out.println("기본값 리스트");
			GuestbooksDao dao=new GuestbooksDao();
			List<GuestbooksVo> list=dao.getList();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/main/list.jsp");
			rd.forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
