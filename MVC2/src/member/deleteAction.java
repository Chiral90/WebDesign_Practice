package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();
		MemberBean mbean = new MemberBean();
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("utf-8");
		try {
		mbean.setId(request.getParameter("id"));
		mbean.setPw(request.getParameter("pw"));
		
		mdao.delete(mbean);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward.setRedirect(true);
		forward.setPath("listMember.me");
		return forward;
	}

}
