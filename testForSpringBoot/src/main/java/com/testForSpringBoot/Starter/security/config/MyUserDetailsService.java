package com.testForSpringBoot.Starter.security.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.testForSpringBoot.Starter.dao.Ac_User_Dao;
import com.testForSpringBoot.Starter.model.Ac_User_Model;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	Ac_User_Dao ac_user_dao;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {		
		BCryptPasswordEncoder encoder = passwordEncoder();
		Ac_User_Model ac_user_model = ac_user_dao.findByemail(email);
		
		if(ac_user_model == null){
	        throw new UsernameNotFoundException("User Name "+email +"Not Found");
	    }
		
		return new org.springframework.security.core.userdetails.User(ac_user_model.getEmail(),
				encoder.encode(ac_user_model.getPwd()),getGrantedAuthorities(ac_user_model));	
		
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(Ac_User_Model ac_user_model){

	    Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
	    if(ac_user_model.getRights().equals("Admin")){
	        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	    }
	    grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
	    return grantedAuthority;
	}
	
	
	
	

}
