package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import model.KicMember;

public class loginProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDao md = new MemberDao();
		KicMember mem = md.oneMember(id);
		
		HttpSession session=request.getSession();

		String msg = "아이디를 확인하세요";
		String url = "/member/loginForm.jsp";
		if(mem != null) { //id 존재할때
			if (pass.equals(mem.getPass())) { //login ok
				session.setAttribute("id", id);
			msg = mem.getName() + "님이 로그인 하셨습니다.";
		    url = "/member/index";
			}else {
				msg = "비밀번호를 확인하세요";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/WEB-INF/view/alert.jsp";
	}

}
