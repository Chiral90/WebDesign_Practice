package board;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

// Action Interface : client 요청을 수행하고 결과를 ActionForward type으로 return하는 method execute()를 정의
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
	}
}
