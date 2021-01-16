package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam_1214")
public class exam_1214 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 문제풀기
		
		// 브라우저 출력기 인코딩 UTF-8로 설정
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charser=utf-8");

		// 브라우저 출력기
		PrintWriter out = response.getWriter();

		// 문제 1 http://localhost:9000/JSP/test2?action=printGuGu1
		// 문제 2 http://localhost:9000/JSP/test2?action=printGuGu2&limit=20
		// 문제 3 http://localhost:9000/JSP/test2?action=hello&age=30&name=홍길동
		// ?action=printGuGu1 -> ? 뒷부분 쿼리스트링이라고 함

		// 여기서 action 스캐너 역할을 하는 것
		String action = request.getParameter("action");

		if (action.equals("printGuGu1")) {
			for (int dan = 2; dan < 10; dan++) {
				out.println(" <h2> " + dan + "단 </h2> ");
				for (int i = 1; i < 10; i++) {
					out.println(dan + " * " + i + " = " + dan * i + " </br> ");
				}
			}
		} else if (action.equals("printGuGu2")) {
			String limit = request.getParameter("limit");
			int limit2 = Integer.parseInt(limit);

			for (int dan = 2; dan <= limit2; dan++) {
				out.println(" <h2> " + dan + "단 </h2> ");
				for (int i = 1; i < 10; i++) {
					out.println(dan + " * " + i + " = " + dan * i + " </br> ");
				}
			}

		} else if (action.equals("hello")) {
			String age = request.getParameter("age");
			int age2 = Integer.parseInt(age);
			String name = request.getParameter("name");
			out.println("<h1>" + "안녕하세요" + age2 + " 살 " + name + " 입니다." + "</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
