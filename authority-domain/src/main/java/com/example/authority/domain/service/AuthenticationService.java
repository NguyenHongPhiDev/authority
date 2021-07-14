package com.example.authority.domain.service;

import com.example.authority.domain.model.LoggedUser;
import com.example.authority.domain.model.User;
import com.example.authority.domain.model.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Srinivas Nalla
 *
 */
@Service
@Transactional
public class AuthenticationService implements UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired 
	private AppService appService;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user=appService.getUser(username);
		if(user==null){
			throw new UsernameNotFoundException("User doesn`t exist");
		}
		
		Set<UserRole> userRoles=user.getUserRoles();
		List<String> dbRoles=new ArrayList<String>();
		for (UserRole userRole : userRoles) {
			dbRoles.add(userRole.getRole().getRoleName());
		}
		logger.debug("Roles of :"+username+" is "+dbRoles);
		
		LoggedUser loggedUser=new LoggedUser(user, dbRoles);
		return loggedUser;
	}

}
