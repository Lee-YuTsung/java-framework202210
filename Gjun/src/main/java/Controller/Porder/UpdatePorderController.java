package Controller.Porder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Porder.PorderDaoImpl;
import Model.Porder;

public class UpdatePorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdatePorderController() {
        super();
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("big5");
		response.setCharacterEncoding("big5");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String desk = request.getParameter("desk");
		Integer A = Integer.parseInt(request.getParameter("A"));
		Integer B = Integer.parseInt(request.getParameter("B"));
		Integer C = Integer.parseInt(request.getParameter("C"));
		
		Porder p = new PorderDaoImpl().queryId(id);
		p.setDesk(desk);
		p.setA(A);
		p.setB(B);
		p.setC(C);
		p.getSum();
		
		new PorderDaoImpl().update(p);
		
		response.sendRedirect("porder/update.jsp");
	}

}
