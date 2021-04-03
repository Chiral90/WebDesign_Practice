package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class listAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();
		ActionForward forward = new ActionForward();
		MemberBean mbean = null;
		/*
		// 수업시간 해설
		try {
			request.setCharacterEncoding("utf-8");
			ArrayList<MemberBean> mlist = mdao.list();
			request.setAttribute("mlist", mlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward.setRedirect(true);
		forward.setPath("mvc_memberList.jsp");
		return forward;
		*/
		
		// 내 방법
		ArrayList<MemberBean> mlist = mdao.list();
		request.setAttribute("length", mlist.size());
		for (int i=0;i<mlist.size();i++) {
			mbean = mlist.get(i);
			request.setAttribute("id"+i, mbean.getId());
			request.setAttribute("name"+i, mbean.getName());
		}
		return null;
		
	}
}
