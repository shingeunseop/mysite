package com.javaex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String actionName=request.getParameter("a");//주소창에 a=에 있는 것을 가져온다.
		
		if("joinform".equals(actionName)) {
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/joinform.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/user/joinform.jsp");//내부에서 찾아내기 때문에 mysite는 불필요 특히 web-inf는 접근제한이므로
		   // rd.forward(request, response);
			
		}else if("join".equals(actionName)){//join에 들어갈 정보를 모아둔다
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String gender=request.getParameter("gender");
			String password=request.getParameter("password");
			
			UserVo vo=new UserVo(email,password,name,gender);//그 값들을 user에 넣는 과정
			UserDao dao=new UserDao();
			dao.insert(vo);
			
			WebUtil.forward(request, response,"/WEB-INF/views/user/joinsuccess.jsp");
			/*RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/user/joinsuccess.jsp");
			rd.forward(request, response);*/
			
			
		}else if("loginform".equals(actionName)) {
			//로그인 폼
			String result=request.getParameter("result");//result라고 내보네겠다고 설정
			
			WebUtil.forward(request, response,"/WEB-INF/views/user/loginform.jsp");
			/*RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/user/loginform.jsp");
			rd.forward(request, response);*/
			
		}else if("logout".equals(actionName)){
			HttpSession session=request.getSession();
			session.removeAttribute("authUser");
			session.invalidate();
			WebUtil.redirect(request, response,"/mysite/main" );
			//response.sendRedirect("/mysite/main");
			
			
			
		}else if("modify".equals(actionName)) {
			
			System.out.println("modify성공");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String gender=request.getParameter("gender");
			UserVo vo=new UserVo();
			
			vo.setName(name);
			vo.setPassword(password);
			vo.setGender(gender);
			
			HttpSession session=request.getSession();//setAttribute로 되어잇는 상태
			UserVo authorUser=(UserVo)session.getAttribute("authUser");//위에서 author이란 변수로 set을 해놓은 구간이 있음
			//authorUser라는 변수를 창출, 바뀌;웠으므로 set해서 다시 밖으로 보여야 함
			//session에 로그인한 사용자의 정보를 가져오기 위해 만듬
			
			
			int no=authorUser.getNo();
			vo.setNo(no);
			
			
			
			UserDao dao=new UserDao();
			dao.update(vo);
			//수정코드(몇번 데이터를 바꾸냐가 메인)
			authorUser.setName(name);
			
			WebUtil.forward(request, response,"/WEB-INF/views/main/index.jsp");
			/*RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/main/index.jsp");
			rd.forward(request, response);//보냄*/
			
			
			
		}else if("modifyform".equals(actionName)) {
			
			HttpSession session=request.getSession();//static과 비슷한 형세
			UserVo authUser=(UserVo)session.getAttribute("authUser");
			int no=authUser.getNo();
			
			
			UserDao dao=new UserDao();
			UserVo uservo=dao.getUser(no);
			System.out.println(uservo.toString());


			request.setAttribute("uservo", uservo);
			
			WebUtil.forward(request, response,"/WEB-INF/views/user/modifyform.jsp");
			/*RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/user/modifyform.jsp");
			rd.forward(request, response);//보냄*/
			
									
		}else if("login".equals(actionName)) {
			String email=request.getParameter("email");//정보꺼냄
			String password=request.getParameter("password");
			UserDao dao=new UserDao();
			UserVo vo=dao.getUser(email, password);
			
			if(vo==null) {
				System.out.println("실패");
				WebUtil.redirect(request, response,"/mysite/user?a=loginform&result=fail" );
				//response.sendRedirect("/mysite/user?a=loginform&result=fail");
			}else {
				System.out.println("성공");
				//이제부터 세션을 유지하는 법
				HttpSession session=request.getSession(true);//session이라는 자신만의 메모리 (내 전용 공간)
				//request를 통해서 session으로 가는길. true는 옵션
				session.setAttribute("authUser", vo);//로그인을 햇을때 set으로 올려놔야된다. 로그아웃시에는 세션삭제 authUser라는 변수로 vo의 형태의 값을 set한다.
				//들어 가 있는건 session
				
				WebUtil.redirect(request, response,"/mysite/main" );
				//response.sendRedirect("/mysite/main");
				return;
			}
			
			
			
			
		}else {
			WebUtil.redirect(request, response,"/mysite/main" );
			//response.sendRedirect("/mysite/main");//다시 요청하는것, main으로 가라고 사용자가 다시 찾아가는 것이므로 mysite가 필요
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
