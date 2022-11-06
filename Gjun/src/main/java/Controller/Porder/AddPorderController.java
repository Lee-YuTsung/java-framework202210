package Controller.Porder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Porder.PorderDaoImpl;
import Model.Porder;

public class AddPorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddPorderController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("big5");
		response.setCharacterEncoding("big5");
		
		HttpSession session = request.getSession();
		Porder p = (Porder)session.getAttribute("P");
		
		new PorderDaoImpl().add(p);
		session.setAttribute("P", p);
		
		response.sendRedirect("porder/finish.jsp");
	}

}
