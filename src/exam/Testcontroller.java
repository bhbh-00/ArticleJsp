package exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Testcontroller")
public class Testcontroller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String dest = "WEB-INF/exam/exam_0105.jsp";
		
		if (action != null && action.equals("doTest")) {
			String text = request.getParameter("text");
			String select = request.getParameter("select");
			String chkbox = request.getParameter("chkbox");
			
			System.out.println(text);
			System.out.println(select);
			System.out.println(chkbox);
		}

		RequestDispatcher rd = request.getRequestDispatcher(dest);
		rd.forward(request, response);
	}
}
