package jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// http://127.0.0.1:9001/board/article?action=list

		// 공통작업
		System.out.println("공통작업코드");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청 url 가져오기
		String uri = request.getRequestURI();
		String[] uris = uri.split("/");
		
		String module = uris[2];
		String dest = "";
		
		if(module.equals("article")) {
			ArticleController2 Controller = new ArticleController2();
			dest = Controller.doAction(request, response);
		} else if(module.equals("member")) {
			MemberController2 Controller = new MemberController2();
			dest = Controller.doAction(request, response);
		}

		/*
		 * 요청 1 A -> B
		 * 
		 * forward A가 B에게 요청위임
		 * 
		 * Redirect A가 B에게 새로요청
		 */
		if (dest.startsWith("redirect: ")) {
			// 리다이렉팅
			String[] bits = dest.split(" ");
			String url = bits[1];

			response.sendRedirect(url);

		} else {
			// 포워딩
			RequestDispatcher rd = request.getRequestDispatcher(dest);
			rd.forward(request, response);

		}
	}

}
