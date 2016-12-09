package fr.tbr.iam.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.service.dao.DAODeleteException;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;

public class delete extends GenericSpringServlet {
	
private static final long serialVersionUID = 1L;
	
	IAMLogger logger = IAMLogManager.getIAMLogger(delete.class);
	
	@Inject
	IdentityDAOInterface dao;

	public delete() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int identityuid = Integer.parseInt(request.getParameter("uid"));
		try {
			dao.deleteuid(identityuid);
			response.sendRedirect("welcome.jsp");
		} catch (DAODeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
