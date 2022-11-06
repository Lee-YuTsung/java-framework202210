package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Member.MemberDaoImpl;
import Model.Member;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginController() {
        super();
    }
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		Member m = new MemberDaoImpl().queryMember(userName, password);
		
		if(m != null) {
			session.setAttribute("M", m);
			response.sendRedirect("member/loginSuccess.jsp");
		}else {
			response.sendRedirect("member/loginError.jsp");
		}
		
		
	}

}
