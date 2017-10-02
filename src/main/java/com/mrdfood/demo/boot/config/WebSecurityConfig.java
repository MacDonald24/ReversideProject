package com.mrdfood.demo.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String SUPER_USER_ROLE = "SUPER_USER";
    private static final String ADMIN = "ADMIN";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/filters/secured").hasRole(SUPER_USER_ROLE)
                .antMatchers("/admin/**").hasRole(ADMIN)
                .antMatchers("/**").permitAll();

        http
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("chuck").password("password").roles(USER_ROLE, SUPER_USER_ROLE)
                .and()
                .withUser("fred").password("password").roles(USER_ROLE)
                .and()
                .withUser("boss").password("password").roles(ADMIN);
    }
}