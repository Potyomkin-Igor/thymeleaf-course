package com.thymeleaf.course.security;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    static final String LOGIN_PAGE = "/login";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").authenticated()

                .and()
                .formLogin()
                .loginPage(LOGIN_PAGE)
                .loginProcessingUrl(LOGIN_PAGE)
                .successHandler(new DefaultAuthenticationSuccessHandler())

                .and()
                .logout()
                .logoutUrl("/logout")

                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("thymeleaf@test.com")
                .password("{noop}thymeleaf")
                .roles("USER");
    }
}
