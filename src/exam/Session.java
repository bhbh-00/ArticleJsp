package exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Session")
public class Session extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		
		HttpSession aa = request.getSession();
		
		if(flag != null && flag.equals("a")) {
			String msg = (String)request.getAttribute("test");
			System.out.print(msg);
		} else if (flag != null && flag.equals("b")) {
			String msg = (String)aa.getAttribute("test2");
			System.out.print(msg);
		}
		
		request.setAttribute("test1", "테스트1");
		aa.setAttribute("test2", "테스트2");
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Sessiontest.jsp");
		rd.forward(request, response);	
	}
}
