package hh.swd20.bookstore;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/home").permitAll()
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()		
			.loginPage("/login")
			.defaultSuccessUrl("/booklist")
			.permitAll()
			.and()
		.logout()
			.permitAll()
			.and()
		.httpBasic();
		return http.build();
	}
	
	@Bean 
	public InMemoryUserDetailsManager userDetailsService() {
		
		List<UserDetails> users = new ArrayList();
	        UserDetails user1 = User.withDefaultPasswordEncoder()
	            .username("user")
	            .password("password")
	            .roles("USER")
	            .build();
	       users.add(user1);
	        
	        UserDetails user2 = User.withDefaultPasswordEncoder()
		            .username("admin")
		            .password("password")
		            .roles("ADMIN")
		            .build();
	        users.add(user2);
	        
		   return new InMemoryUserDetailsManager(users);
  }



}
