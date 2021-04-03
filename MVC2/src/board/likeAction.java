package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class likeAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boardDataBean bbean = new boardDataBean();
		BoardDAO bdao = new BoardDAO();
		ActionForward forward = new ActionForward();
		bbean.setNo((int) request.getAttribute("no"));
		System.out.println((int) request.getAttribute("no"));
		try {
			bdao.likeCount(bbean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward.setRedirect(false);
		forward.setPath("detailBoard.bo?no="+bbean.getNo());
		System.out.println(bbean.getNo());
		return forward;
	}
}
