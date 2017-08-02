package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.BoardDao;

import com.javaex.util.WebUtil;
import com.javaex.vo.BoardVo;

import com.javaex.vo.UserVo;

@WebServlet("/bs")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a");
		if ("writeform".equals(actionName)) {
			WebUtil.forward(request, response, "/WEB-INF/views/board/writeform.jsp");

		} else if ("write".equals(actionName)) {

			HttpSession session = request.getSession();// static과 비슷한 형세
			UserVo authUser = (UserVo) session.getAttribute("authUser");
			int no = authUser.getNo();

			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BoardVo bvo = new BoardVo(title, content);
			bvo.setNo(no);
			BoardDao dao = new BoardDao();

			dao.insert(bvo);
			
			

			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");

		} else if("read".equals(actionName)) {
			
			WebUtil.forward(request, response, "/WEB-INF/views/board/read.jsp");
			
			
		}else if("readfix".equals(actionName)) {
			HttpSession session = request.getSession();// static과 비슷한 형세
			UserVo authUser = (UserVo) session.getAttribute("authUser");
			int no = authUser.getNo();
			
			WebUtil.forward(request, response, "/WEB-INF/views/board/writeform.jsp");
			
			
		}else if("mywrite".equals(actionName)) {
			
			
		}else {

			BoardDao dao = new BoardDao();
			List<BoardVo> list = dao.select();// dao에서 만든 list를 List<BoardVo>에 대입
			

			request.setAttribute("list", list);// list라는 이름의 list 그룹이 만들어짐

			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
