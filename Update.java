package fr.tbr.iam.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOUpdateException;
import fr.tbr.iamcore.service.dao.DAODeleteException;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;

@WebServlet(name="Update", urlPatterns="/Update")
public class Update extends GenericSpringServlet {
	
private static final long serialVersionUID = 1L;
	
	IAMLogger logger = IAMLogManager.getIAMLogger(Update.class);
	
	@Inject
	IdentityDAOInterface dao;

	public Update() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int identityId=  Integer.parseInt(request.getParameter("id"));
		Identity identity =	dao.getIdentity(identityId);
		HttpSession session = request.getSession();
		session.setAttribute("identity", identity);
		response.sendRedirect("Update.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Identity identity = (Identity) session.getAttribute("identity");
		identity.setDisplayName(request.getParameter("displayName"));
		identity.setUid(request.getParameter("uid"));
		identity.setEmail(request.getParameter("email"));
		/**
		 * To update an identity.
		 */
		try {
			dao.update(identity);
		} catch (DAOUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		response.sendRedirect("index.jsp");
	}
}
