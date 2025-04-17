package model2.mvcboard;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시물 불러오기
        MVCBoardDAO dao = new MVCBoardDAO();
        String idx = req.getParameter("idx");
        MVCBoardDTO dto = dao.selectView(idx);
        
        // 게시물 조회 이력 체크 및 조회수 증가
        boolean isVisited=false; // 방문 이력
        String cookieName = "visited_" + idx; // 방문한 게시글의 쿠키이름
        Cookie[] cookies = req.getCookies();
        if(cookies!=null) {
        	for(Cookie cookie:cookies) {
        		if(cookie.getName().equals(cookieName)) { // 이미 쿠키값이 있으면
        			isVisited=true;
        			break;
        		}
        	}
        }
        if(!isVisited) {
        	dao.updateVisitCount(idx);  // 조회수 1 증가
        	Cookie newcookie=new Cookie(cookieName, "true");
        	newcookie.setMaxAge(60*60*24); // 하루동안 유지
        	newcookie.setPath("/"); // 모든 경로에서 접속 허용
        	resp.addCookie(newcookie);
        }

        dao.close();

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
        
        //첨부파일 확장자 추출 및 이미지 타입 확인
        String ext = null, fileName = dto.getSfile();
        if(fileName!=null) {
        	ext = fileName.substring(fileName.lastIndexOf(".")+1);
        }
        String[] mimeStr = {"png","jpg","gif"};
        List<String> mimeList = Arrays.asList(mimeStr);
        boolean isImage = false;
        if(mimeList.contains(ext)) {
        	isImage = true;
        }
        
        //--------------------------------------------
        // reply
        
        
        // 게시물(dto) 저장 후 뷰로 포워드
        req.setAttribute("dto", dto);
        req.setAttribute("isImage", isImage);
        req.getRequestDispatcher("/14MVCBoard/View.jsp").forward(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
