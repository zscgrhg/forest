package com.frost.forest.pen.bean.config;

/**
 * Created by wenkui on 2015/3/13.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.security.SecureRandom;


@EnableWebSecurity
@PropertySource("classpath:global.properties")
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Resource
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username username,authorities_authority authority from users where username = ?")
        .passwordEncoder(new BCryptPasswordEncoder(6, new SecureRandom()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN') and hasIpAddress('127.0.0.1/80')")
                .antMatchers("/rest/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/user_login")
                .defaultSuccessUrl("/index")
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/static/**", "/resources/**");
    }


}
