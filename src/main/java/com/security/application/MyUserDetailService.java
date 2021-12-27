package com.security.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.application.model.MyUserDetails;
import com.security.application.model.User;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(userName);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		return user.map(MyUserDetails::new).get();
	}

}
