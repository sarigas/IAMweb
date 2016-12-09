package fr.tbr.iamcore.service.authentication;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOSearchException;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;

public class AuthenticationService {
	
	@Inject
	IdentityDAOInterface dao;

	public boolean authenticate(String username, String password) throws DAOSearchException {
		// FIXME implement this authentication method
		if(username.equals("test") && password.equals("test"))
			return true;
		else {
				
				Identity user = new Identity(username, password);
				
				/**
				 * Checks whether user is present or not in the database - Authentication
				 */
				List<Identity> usersearch = dao.readAllusers(user);
				
				if(usersearch.size() != 0)
				{
					return true;
					
				}
				else
				{
					return false;
				}
			}
		   		
		}
	}

