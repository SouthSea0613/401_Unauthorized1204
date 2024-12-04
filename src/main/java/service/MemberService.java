package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 회원관리 서비스 클래스
public class MemberService {
	HttpServletRequest req;
	HttpServletResponse resp;

	public MemberService(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	public String join() {
		return null;
	}

}
