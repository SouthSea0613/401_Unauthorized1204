package service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;
import dao.MemberDao;
import dto.Forward;
import dto.Member;

public class MemberService {
	HttpServletRequest req;
	HttpServletResponse resp;

	public MemberService(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	public Forward join() {
		// 파라미터 수집
		String username = req.getParameter("username");
		String userpw = req.getParameter("userpw");
		String irum = req.getParameter("irum");
		String gender = req.getParameter("gender");
		// 데이터 뭉치기 : Dto or HashMap으로 데이터 저장
		Member member = new Member();
		member.setUsername(username);
		member.setUserpw(userpw);
		member.setIrum(irum);
		member.setGender(gender);
		// 회원관리 DB 로직
		MemberDao mDao = new MemberDao();
		mDao.connect();
		mDao.setRequest(req);
		boolean result = mDao.join(member);
		mDao.close();
		Forward fw = new Forward();
		if (result) {
			// 주소창 -> join
			fw.setPath("loginfrm.jsp");
			fw.setRedirect(true);
			// return "loginfrm.jsp";
		} else {
			req.setAttribute("msg", "회원가입 실패");
			fw.setPath("joinfrm.jsp");
			fw.setRedirect(false); // true 하면 msg 객체 날라감
			// return "joinfrm.jsp";
		}
		return fw;
	}

	public Forward login() {
		String username = req.getParameter("username");
		String userpw = req.getParameter("userpw");
		MemberDao mDao = new MemberDao();

		HashMap<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("userpw", userpw);

		mDao.connect();
		//boolean result = mDao.login(map);
		Member member = mDao.login(map);
		mDao.close();

		Forward fw = new Forward();
		if (member!=null) {
			// 서버에서 세션객체 가져오기
			HttpSession session = req.getSession();
			//인증했다는 마깅, 회원정보 출력
			session.setAttribute("member", member);
			session.setAttribute("logout", makeLogoutHtml());
			fw.setPath("main.jsp");
			fw.setRedirect(true);
			// path="./main.jsp";
		} else {
			// 주소창 --> login
			// req.getSession().setAttribute("msg","로그인 실패");
			req.setAttribute("msg", "로그인 실패");
			fw.setPath("loginfrm.jsp");
			fw.setRedirect(false);
			// path="./loginfrm.jsp";
		}
//	      System.out.println(username+","+userpw);
		return fw;
	}

	private String makeLogoutHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<form action='./loginfrm' method='post'>");
		sb.append("<button>로그아웃</button>");
		sb.append("</form>");
		return sb.toString();
	}
}