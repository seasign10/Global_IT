package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get으로 받을 때
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버가 클라이언트로부터 받은 요청의 문자 인코딩(msg호출되기 전에)
		request.setCharacterEncoding("utf-8");
		
		String msg = request.getParameter("msg");
		
		// HTML 페이지에 한글이 포함된 경우, 클라이언트가 이를 올바르게 보여주기 위한 문자 인코딩
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter(); 
		out.println("<html>");
		
		// 한글이 깨져서 나온다면 아래의 코드를 추가해도 됨
		// out.println("<head>");
		// out.println("<meta charset=\"UTF-8\">");
		// out.println("<head>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Post Servlet 방식</h1>");
		out.println("<h2>msg : "+msg + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
