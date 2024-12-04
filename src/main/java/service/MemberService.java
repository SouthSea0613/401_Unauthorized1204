package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JdbcUtil;
import dao.MemberDao;
import dto.Member;

// 회원관리 서비스 클래스
public class MemberService {
	HttpServletRequest req;
	HttpServletResponse resp;

	public MemberService(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	public String join() {
		// 파라미터부터 수집하자!
		String username = req.getParameter("username");
		String userpw = req.getParameter("userpw");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		// Dto or HashMap으로 데이터를 저장(우린 Dto로 해보자)
		Member member = new Member();
		member.setUsername(username);
		member.setUserpw(userpw);
		member.setName(name);
		member.setGender(gender);
		
		// 회원관리 DB로직이야!
		MemberDao mDao = new MemberDao();
		mDao.connect();
		boolean result = mDao.join(member);  // boolean으로 둔 것은 결과가 참이냐 거짓이냐로 따지기 좋으니까
		mDao.close();
		if(result) {
			return "loginform.jsp";
		} else {
			return "joinform.jsp";
		}
	}

	public String login() {
		return null;
	}

}
