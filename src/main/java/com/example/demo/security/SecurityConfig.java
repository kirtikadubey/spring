package com.example.demo.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)
        auth.inMemoryAuthentication()
                .withUser("usr").password(("{noop}usr")).roles("USER")
                .and()
                .withUser("user2").password(("{noop}user2Pass")).roles("USER")
                .and()
                .withUser("ad").password(("{noop}ad")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // http builder configurations for authorize requests and form login (see below)
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
              //  .antMatchers(HttpMethod.GET, "/book/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/stu").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/stu/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/stu/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/employee").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/employee/**").hasRole("USER")
                .and()
               .csrf().disable()
               .headers().frameOptions().disable();// TO enable H2 databse access

    }

}
