package com.example.security_gateway;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("ravi").password("ravi").roles("Admin");

	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		*/
//		http.csrf().disable()
//				.authorizeRequests().anyRequest().authenticated()
//				.and().httpBasic();

		http.cors().and().csrf().disable()
				.authorizeRequests().antMatchers(HttpMethod.POST, "/**")
				.hasRole("Admin")
				.antMatchers(HttpMethod.GET,"/**").permitAll()
				.and().httpBasic();

		//.formLogin()
//		.permitAll();

//		http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and
//				().httpBasic();

	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
