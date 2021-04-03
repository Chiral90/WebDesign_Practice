package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class detailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boardDataBean bbean = new boardDataBean();
		boardDataBean detail = new boardDataBean();
		ActionForward forward = new ActionForward();
		//BoardDAO cnt = new BoardDAO();
		BoardDAO bdao = new BoardDAO();
		bbean.setNo(Integer.parseInt(request.getParameter("no")));
		bbean.setView(Integer.parseInt(request.getParameter("view")));
		//System.out.println(request.getParameter("view"));
		try {
			//cnt.viewCount(bbean);
			bdao.viewCount(bbean);
			bdao = new BoardDAO();
			detail = bdao.detail(bbean);
			request.setAttribute("detail", detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward.setRedirect(false);
		forward.setPath("mvc_boardDetail.jsp");
		return forward;	
	}

}
