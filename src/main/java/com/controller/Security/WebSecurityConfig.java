package com.controller.Security;

import com.controller.initListener.AuthorInterceptor;
import com.service.CustomUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //1扩展Spring Security配置需继承WebSecurityConfigurerAdapter

    @Autowired
    LoginFailurHandler loginFailurHandler;
    //2注册CustomUserService的Bean
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserServiceImpl();
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    //3添加我们自定义的user detail service认证。
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             .authorizeRequests()
                    .antMatchers("/login/check_login","/demo/test").permitAll()//哪些url不需要登陆验证
                    .anyRequest().authenticated()//其他url都需要验证
                    .and()
                    .formLogin().loginPage("/login/without_login").permitAll()//loginPage配置需要去登陆的url
                    .failureHandler(loginFailurHandler)//登陆失败的处理
                    .and()
                    .rememberMe().tokenValiditySeconds(1);
    }


}
