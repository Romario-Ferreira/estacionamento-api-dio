package com.francaemp.estacionamentodio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.httpBasic()
	        			.and()
	        			.authorizeHttpRequests()
	            		.antMatchers("/swagger-ui.html").permitAll()
		                .antMatchers("/api").permitAll()
		                .antMatchers("/webjars/**").permitAll()
		                .antMatchers("/swagger-resources/**").permitAll()
		                .antMatchers("/").permitAll()
		                .antMatchers("/csrf").permitAll()
		                .antMatchers("/*.js").permitAll()
		                .antMatchers("/*.css").permitAll()
		                .antMatchers("/*.ico").permitAll()
		                .antMatchers("/*.png").permitAll()
		                .antMatchers("swagger-ui/index.html").permitAll()
		                .antMatchers("v3/api-docs/**").permitAll()
		                .antMatchers(HttpMethod.GET,"/parking/**").permitAll()
		                .antMatchers(HttpMethod.PUT,"/parking/**").hasRole("USER")
		                .antMatchers(HttpMethod.POST,"/parking/**").hasRole("USER")
		                .antMatchers(HttpMethod.DELETE,"/parking/**").hasRole("USER") 
		                .and()
		                .csrf().disable()
		                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 				return http.build();
	    }
	 
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user =User.builder()
	            .username("usuario")
	            .password(getEncoder().encode("api12345"))
	            .roles("USER")
	            .build();
	        return new InMemoryUserDetailsManager(user);
	 }
	 
	 @Bean
	 public BCryptPasswordEncoder getEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}
