package com.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diary.dao.DiaryDAO;
import com.diary.vo.DiaryVO;

/**
 * Servlet implementation class DiaryController
 */
@WebServlet("/write.do")
public class DiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiaryVO vo=new DiaryVO();
		vo.setWeather(request.getParameter("weather"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		DiaryDAO dao=new DiaryDAO();
		int result=dao.insertDiary(vo);
		dao.close();
		
		if(result==1) { // 글쓰기 성공
			System.out.println("일기 작성 성공");
		}else {  // 글쓰기 실패
			System.out.println("일기 작성 실패");
		}
		
		response.sendRedirect("/Diary/register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
