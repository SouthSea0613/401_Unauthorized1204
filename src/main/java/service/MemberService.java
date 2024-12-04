package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.Member;

public class MemberService {
	HttpServletRequest req;
	HttpServletResponse resp;
	
	public MemberService(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	public String join() {
		String username = req.getParameter("username");
		String userPW = req.getParameter("userPW");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		// Dto or HashMap로 데이터를 저장
		Member member = new Member(username, userPW, name, gender);
		
		// 회원관리 DB로직
		MemberDao memberDao = new MemberDao();
		memberDao.connect();
		memberDao.setRequest(req);
		boolean result = memberDao.join(member);
		memberDao.close();
		if(result) {
			return "loginform.jsp";
		}
		else {
			return "joinform.jsp";
		}
	}

	public String login() {
		return null;
	}
}
