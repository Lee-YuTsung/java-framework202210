package Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Member.MemberDaoImpl;
import Model.Member;

public class AddMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMemberController() {
        super();
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("big5");
		response.setCharacterEncoding("big5");
		HttpSession session = request.getSession();
		
    	String userName = request.getParameter("username");
		
		if(new MemberDaoImpl().queryUser(userName)) {
			response.sendRedirect("member/addMemberError.jsp");
		}else {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String mobile = request.getParameter("mobile");
			
			Member m = new Member(name, userName, password, address, phone, mobile);
			
			new MemberDaoImpl().add(m);
			
			session.setAttribute("M", m);
			response.sendRedirect("member/addMemberSuccess.jsp");
		}
	}

}
