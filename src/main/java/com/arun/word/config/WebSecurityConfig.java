package com.arun.word.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.arun.word.constant.Constant;
import com.arun.word.security.ProjectDetailsService;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = ProjectDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);// .passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.authorizeRequests().antMatchers("/index",
		// "/").permitAll().antMatchers("/admin", "/user").authenticated()
		// .and().formLogin().and().logout().logoutRequestMatcher(new
		// AntPathRequestMatcher("/logout"));

		http.authorizeRequests().antMatchers(Constant.USER_ACCESS_URLS).permitAll()
				.antMatchers(Constant.ADMIN_ACCESS_URLS).access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and()
				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and()
				.exceptionHandling().accessDeniedPage("/na").and().csrf();
		// http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}