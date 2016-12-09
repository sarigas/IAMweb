package fr.tbr.iam.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.service.dao.DAODeleteException;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;

@WebServlet(name="Delete", urlPatterns = "/Delete")
public class Delete extends GenericSpringServlet {
	
private static final long serialVersionUID = 1L;
	
	IAMLogger logger = IAMLogManager.getIAMLogger(Delete.class);
	
	@Inject
	IdentityDAOInterface dao;

	public Delete() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int identityuid = Integer.parseInt(request.getParameter("id"));
		try {
			dao.deleteuid(identityuid);
			response.sendRedirect("welcome.jsp");
		} catch (DAODeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
