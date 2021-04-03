package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insertAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mdao = new MemberDAO();
		MemberBean mbean = new MemberBean();
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("utf-8");
		try {
			mbean.setId(request.getParameter("id"));
			mbean.setPw(request.getParameter("pw"));
			mbean.setName(request.getParameter("name"));
			mbean.setBirth(request.getParameter("birth"));
			mbean.setAge(Integer.parseInt(request.getParameter("age")));
			mbean.setGender(request.getParameter("gender"));
			mbean.setEmail(request.getParameter("email"));
		
			mdao.insert(mbean);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//String path = "mvc_memberList.jsp"; // insert 후에 mvc_memberList.jsp로 못감 --> selectAction 실행 안함
		String path = "listMember.me";
		forward.setRedirect(true); // 
		forward.setPath(path);
		return forward;
	}
}
