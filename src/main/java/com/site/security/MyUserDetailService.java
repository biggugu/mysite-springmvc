package com.site.security;

import com.site.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails details = null;
		try {
			com.site.model.User u = userService.getUserByName(username);
			if (u != null) {
				if (u.getUserRole().equals("admin"))
					details = new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassWord(),
							true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
				else if (u.getUserRole().equals("member"))
					details = new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassWord(),
							true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_USER"));
			}else{
				
				throw new UsernameNotFoundException("用户名或密码不正确");
			}
		} catch (UsernameNotFoundException usernameNotFoundException) {
			usernameNotFoundException.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return details;
	}

}