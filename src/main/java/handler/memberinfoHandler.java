package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import model.KicMember;

public class memberinfoHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		MemberDao md = new MemberDao();
		HttpSession session=request.getSession();
		String login = (String) session.getAttribute("id");
		KicMember mem = md.oneMember(login);
		request.setAttribute("mem", mem);
		return "/WEB-INF/view/member/memberinfo.jsp";
	}

}
