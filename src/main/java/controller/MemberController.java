package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

// "/" default servlet 정적리소스 사용하기 위함. index.jsp
@WebServlet({"/main", "/joinform", "/join", "/login", "/logout"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getServletPath();
		System.out.println(cmd);
		
		MemberService memberService = new MemberService(req, resp);
		
		String path = null;
		switch (cmd) {
		case "/joinform": 
			// 회원가입 창열기
			path = "joinform.jsp";
			break;
		case "/join":
			// db에 회원가입하기
			path = memberService.join();
			break;
		case "loginform":
			path = "loginform.jsp";
			break;
		case "/login":
			path = memberService.login();
			break;
		}
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
