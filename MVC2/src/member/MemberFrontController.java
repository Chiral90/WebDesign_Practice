package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;

import javax.activation.ActivationDataFlavor;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;


/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String RequestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = RequestURI.substring(contextPath.length());
    	
    	ActionForward forward = null;
    	Action action = null; // interface filename:action생성 필요
    	
    	//System.out.println("RequestURI : " + RequestURI);
    	//System.out.println("ContextPath : " + contextPath);
    	//System.out.println("Command : " + command);
    	
    	//command의 문자열이 "/insertMember.me"이면
    	if (command.equals("/insertMember.me")) {
    		//회원가입 폼(mvc_member.jsp) 실행
    		// 실행하기 위해서는 Line 34, 35 필요
    		forward = new ActionForward();
    		forward.setRedirect(false); // forward방식
    		forward.setPath("mvc_memberInsert.jsp");
    		
    	}
    	
    	// insertAction 실행
    	if (command.equals("/insertAction.me")) {
    		action = new insertAction();
    		try {
    			forward = action.execute(request, response);
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		//forward.setRedirect(true);
    		//forward.setPath("mvc_memberList.jsp");
    		
    		//response.sendRedirect("mvc_memberList.jsp");
    	}
    	if (command.equals("/updateMember.me")) {
    		action = new updateAction();
    		try {
    			forward
    				= action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		//response.sendRedirect("/MVC2/listMember.me");
    		/*
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("mvc_memberUpdate.jsp");
    		action = new updateAction();
    		try {
    			ActionForward forwardAct
    				= action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}*/
    		//response.sendRedirect("/MVC2/listMember.me");
    	}
    	//command의 문자열이 "/updateMember.me"
    	//회원정보 수정 폼(mvc_memberModify.jsp)
    	if (command.equals("/removeMember.me")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("mvc_memberRemove.jsp");
    	}
    	/*if (command.equals("/deleteMember.me")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("mvc_memberRemove.jsp");
    		
    	}*/
    	if (command.equals("/deleteMember.me")) {
    		
    		action = new deleteAction();
    		try {
    			forward
    				= action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	/*
    	if (command.equals("/listMember.me")) {
    		action = new listAction();
    		try {
    			forward
    				= action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	*/
    	
    		//my way
    	if (command.equals("/listMember.me")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("mvc_memberList.jsp");
    		action = new listAction();
    		try {
    			ActionForward forwardAct
    				= action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    		
    	if (command.equals("/detailMember.me")) {
    		/*
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("mvc_memberDetail.jsp");
    		action = new detailAction();
    		*/
    		action = new detailAction();
    		try {
    			forward
    				= action.execute(request, response);
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
