package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam_1211")
public class exam_1211 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // => 브라우저에 출력
		out.println(); // => ()안에 입력

		// 브라우저 출력기 인코딩 UTF-8로 설정
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charser=utf-8");

		String loginid = request.getParameter("loginid");

		System.out.print(loginid);

		String Name = "";

		if (loginid.equals("chacha")) {
			Name = "빨간망토차차";
		} else if (loginid.equals("hong")) {
			Name = "홍길동";
		}
		// 브라우저 출력기
		out = response.getWriter();
		out.println("<h1 style = 'color : #000'>" + Name + "님! 안녕하세요!</h1>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
