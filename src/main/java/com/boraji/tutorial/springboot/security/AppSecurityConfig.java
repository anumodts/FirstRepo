package com.boraji.tutorial.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return daoAuthenticationProvider;
	}
	
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  
		  
		  http
		  .csrf()
		  .disable()
		  .authorizeRequests()
		  .anyRequest().authenticated()
		  .and()
		  .httpBasic()
		  .and()
		  .authorizeRequests()
		  .antMatchers("/css/**","/js/**")
		  .permitAll()
		  .anyRequest()
		  .permitAll()
				/*
				 * .and() .authorizeRequests().antMatchers("/login") .permitAll()
				 */
		  .and()
		  .formLogin()
		  .loginPage("/login")
		  .defaultSuccessUrl("/home")
		  .and()
		  .logout()
		  .invalidateHttpSession(true)
		  .clearAuthentication(true)
		  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		  .logoutSuccessUrl("/login");
	  }
	 
	
	
}

