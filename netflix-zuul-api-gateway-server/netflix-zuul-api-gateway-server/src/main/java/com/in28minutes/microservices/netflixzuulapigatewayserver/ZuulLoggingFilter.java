package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() {
		//Actual Implementaion.
		//Here we are going to log the request information.
		//In real world we can use this method to implement authentication, security etc..
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request ->{} request uri -> {}",request,request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true; // If true it filters all the requests.
	}

	@Override
	public int filterOrder() {
		return 1; // Setting the priority
	}

	@Override
	public String filterType() {
		return "pre"; 
		// Pre - Filter before request is processed.
		// Post - Filter after the request is processed.
		// err - Filter error requests.
		
	}

}
