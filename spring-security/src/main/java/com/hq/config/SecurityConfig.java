package com.hq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Note：设置⻆⾊和资源的关系
    //       Admin可以访问/admin和/index
    //       User可以访问/index
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/index").access("hasRole('ADMIN') or hasRole('USER')")
                .anyRequest().authenticated() // Note：所有的请求都需要验证
                .and()
                .formLogin()// Note：登录信息
                .loginPage("/login")// Note：登录页面，不需要权限
                .permitAll()
                .and()
                .logout()// Note：有退出功能，不需要权限
                .permitAll()
                .and()
                .csrf()// Note: 关闭csrf
                .disable();
    }

    // Note: 设置⽤户和⻆⾊的关系
    //       用户user，角色User，密码000
    //       用户admin，角色Admin，User，密码123
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).
                withUser("user").password(new MyPasswordEncoder().
                        encode("000")).roles("USER")
                .and()
                .withUser("admin").password(new MyPasswordEncoder().
                        encode("123")).roles("ADMIN","USER");
    }
}