package org.smallpineapple.springbootsecurity.config;

import org.smallpineapple.springbootsecurity.filter.JwtFilter;
import org.smallpineapple.springbootsecurity.filter.JwtLoginFilter;
import org.smallpineapple.springbootsecurity.filter.MyFilter;
import org.smallpineapple.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Zeng
 * @date 2020/2/24 22:52
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    MyFilter myFilter;
    @Autowired
    CustomAccessDecisionManager customAccessDecisionManager;

    //使用的密码加密方式
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //注册登录认证方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    //配置登录及注销及权限配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //注册MyFilter和customAccessDecisionManager
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(customAccessDecisionManager);
                        o.setSecurityMetadataSource(myFilter);
                        return o;
                    }
                })
                .antMatchers(HttpMethod.POST, "/doLogin")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                //添加登录的过滤器
                .addFilterBefore(new JwtLoginFilter("/doLogin",
                        authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //添加token校验的过滤器
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
}
