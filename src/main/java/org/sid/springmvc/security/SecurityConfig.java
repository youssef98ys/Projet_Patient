package org.sid.springmvc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN","USER");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/save**/**","/delete**/**","/edit**/**","/form**/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/patients**/**").hasRole("USER");
		//http.authorizeRequests().anyRequest().authenticated();
		http.csrf();
		http.exceptionHandling().accessDeniedPage("/notAuthorized");
	}
}
