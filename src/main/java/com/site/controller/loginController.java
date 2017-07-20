package com.site.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;
import org.mybatis.generator.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class loginController {

	@Autowired
	private AuthenticationManager myAuthenticationManager;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam(defaultValue="") String username,@RequestParam(defaultValue="") String password,HttpServletRequest request)
	{/*
		//验证码不对
		if(!checkValidateCode(request)){
			return "failuer";
		}*/
		username=username.trim();
		UsernamePasswordAuthenticationToken authRequest=new UsernamePasswordAuthenticationToken(username, password);
		try{
			Authentication authentication=myAuthenticationManager.authenticate(authRequest);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			HttpSession session=request.getSession();
			session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
			return "login";
		}catch(AuthenticationException e){
			return "failuer";
			
		}
	}

	private boolean checkValidateCode(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String result_verifyCode=request.getSession().getAttribute("verifyResult").toString();
		String user_verifyCode=request.getParameter("verifyCode");
		if(null==user_verifyCode || !result_verifyCode.equalsIgnoreCase(user_verifyCode))
			return false;
		return true;
	}
}
