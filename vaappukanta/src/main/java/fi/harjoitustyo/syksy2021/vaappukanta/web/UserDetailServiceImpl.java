package fi.harjoitustyo.syksy2021.vaappukanta.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.harjoitustyo.syksy2021.vaappukanta.domain.User;
import fi.harjoitustyo.syksy2021.vaappukanta.domain.UserRepository;

	
//**autentikointi ja käyttöoikeudet**//

@Service
public class UserDetailServiceImpl implements UserDetailsService  {
		
private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
	this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{   
			User curruser = repository.findByUsername(username);
			UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
			AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	 }   
} 

