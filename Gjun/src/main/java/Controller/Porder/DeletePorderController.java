package Controller.Porder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Porder.PorderDaoImpl;

public class DeletePorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeletePorderController() {
        super();
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("big5");
		response.setCharacterEncoding("big5");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		new PorderDaoImpl().delete(id);
		
		response.sendRedirect("porder/delete.jsp");
	}

}
