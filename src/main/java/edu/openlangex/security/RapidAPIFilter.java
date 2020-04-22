package edu.openlangex.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.OncePerRequestFilter;

public class RapidAPIFilter extends OncePerRequestFilter{
	
	private String proxyHeader;
	
	public RapidAPIFilter(String proxyHeader) {
		this.proxyHeader = proxyHeader;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			
			
			String xProxy = request.getHeader("X-RapidAPI-Proxy-Secret");
			
			
			if(xProxy==null) {
				throw new AccessDeniedException("Access Denied");
			}
			
			if(!xProxy.equals(proxyHeader)) {
				throw new AccessDeniedException("Access Denied");
			}
			
			
			filterChain.doFilter(request, response);
		
		} catch(AccessDeniedException ae) {
			response.setStatus(401);
		}
	}

}
