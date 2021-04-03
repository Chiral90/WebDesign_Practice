package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();
		MemberBean mbean = new MemberBean();
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("utf-8");
		try {
			mbean.setId(request.getParameter("id"));
			mbean.setPw(request.getParameter("pw"));
			mbean.setName(request.getParameter("name"));
			mbean.setEmail(request.getParameter("email"));
		
		mdao.update(mbean);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward.setRedirect(true);
		forward.setPath("detailMember.me?id="+mbean.getId()); // 방금 수정한 id의 상세페이지로 이동
		return forward;
	}

}
