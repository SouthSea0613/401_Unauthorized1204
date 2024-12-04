package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

// "/" - 이건 쓰지마! 이유는 default servlet 정적리소스(이미 작업이 된 결과물)를 사용하고 있음.
@WebServlet({ "/main", "/joinform", "/join", "/login", "/logout" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getServletPath();
		System.out.println("cmd: " + cmd);

		String path = "null";
		switch (cmd) {
		case "/joinform":
			// 회원가입 창을 열자
			path = "joinform.jsp";
			break;
		case "/join":
			// 회원가입을 하자(DB)
			MemberService memberservice = new MemberService(req, resp); // 서블릿은 필드로 올리지말자!

			path = memberservice.join(); // 회원가입 성공시 loginform.jsp , 실패시 joinform.jsp
			break;
		case "/login":
			// 로그인을 하자
			path = "login.jsp";
			break;
		case "/logout":
			// 로그아웃을 하자
			path = "logout.jsp";
			break;
		}
		// 포워딩
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
