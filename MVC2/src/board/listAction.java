package board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.ActionForward;

public class listAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		boardDataBean bbean = new boardDataBean();
		ArrayList<boardDataBean> blist = new ArrayList();
		ActionForward forward = new ActionForward();
		
		try {
			request.setCharacterEncoding("utf-8");
			blist = bdao.list();
			request.setAttribute("blist", blist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward.setRedirect(false);
		forward.setPath("listBoard.bo");
		//forward.setPath("/board/mvc_boardList.jsp");
		return forward;
	}

}
