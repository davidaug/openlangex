package edu.openlangex.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Value("${rapidapi.proxyheader}")
	private String proxyHeader;
	
	@Value("${rapidapi.active}")
	private Boolean rapidApiActive;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if(rapidApiActive) {
		
			http.authorizeRequests()
				.anyRequest()
				.permitAll()
				.and()
				.exceptionHandling()
		        .accessDeniedHandler(new AccessDeniedHandlerImpl())
		        .and()
				.addFilterBefore(new RapidAPIFilter(proxyHeader), BasicAuthenticationFilter.class);
		
		}
			
	}

}
