package com.saeyon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyon.dao.MemberDAO;
import com.saeyon.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		HttpSession session = request.getSession(); // session객체 구하기
		if (session.getAttribute("loginUser") != null) {// 이미 로그인 된 사용자이면
			url = "main.jsp"; // 메인 페이지로 이동한다.
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); // 주소가 변경되지 않음 (주소를 바꾸소 싶을 경우 redirect)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		MemberDAO mDao=MemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);
		if(result==1) { // id,비밀번호가 일치할때
			MemberVO mVo = mDao.getMember(userid);
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", mVo);
			url="main.do";
			
			response.sendRedirect(url); // 주소변경
		}else if(result==0) { // 비밀번호가 일치하지 않을 때
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response); // 주소가 변경되지 않음 (주소를 바꾸소 싶을 경우 redirect)
		}else if(result==-1) { // 아이디가 존재하지 않을 때
			request.setAttribute("message", "존재하지않는 아이디");			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response); // 주소가 변경되지 않음 (주소를 바꾸소 싶을 경우 redirect)
		}
	}

}
