package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Action;
import board.ActionForward;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("/BoardFrontController")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * 
     */
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String RequestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = RequestURI.substring(contextPath.length());
    	String folderPath = "/board";
    	command = command.substring(folderPath.length());
    	//System.out.println(command);
    	ActionForward forward = null;
    	Action action = null; // interface filename:action생성 필요
    	
    	if (command.equals("/mainBoard.bo")) {
    		forward = new ActionForward();
    		forward.setRedirect(true);
    		forward.setPath("mvc_boardMain.jsp");
    	}
    	
    	if (command.equals("/getlistBoard.bo")) {
    		action = new listAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/listBoard.bo")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("mvc_boardList.jsp");
    	}
    	
    	if (command.equals("/detailBoard.bo")) {
    		action = new detailAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/likeAction.bo")) {
    		action = new likeAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (forward!=null) {
    		if (forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
