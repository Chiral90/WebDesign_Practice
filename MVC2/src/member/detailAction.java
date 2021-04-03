package member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class detailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberDAO mdao = new MemberDAO();
		MemberBean mbean = new MemberBean();
		MemberBean member = new MemberBean();
		mbean.setId(request.getParameter("id"));
		
		ActionForward forward = new ActionForward();
		try {
			member = mdao.detail(mbean);
			
			request.setAttribute("detail", member); // 수업 내용
			/*
			request.setAttribute("id", member.getId());
			request.setAttribute("pw", member.getPw());
			request.setAttribute("name", member.getName());
			request.setAttribute("birth", member.getBirth());
			request.setAttribute("age", member.getAge());
			request.setAttribute("gender", member.getGender());
			request.setAttribute("email", member.getEmail());
			
			
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return null;
		
		forward.setRedirect(false);
		forward.setPath("mvc_memberDetail.jsp"); // forward : jsp로 이동하지만 url주소는 detailMember.me?id=xxxx 임
		return forward;
	}

}
