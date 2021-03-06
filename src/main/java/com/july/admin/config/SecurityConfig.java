package com.july.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.july.admin.beans.LoginFailureHandler;
import com.july.admin.beans.LoginSuccessHandler;
import com.july.admin.common.Result;
import com.july.admin.constant.ResultConstant;
import com.july.admin.management.ReactAdminUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author july
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    @Autowired
    private ReactAdminUserDetailsService userService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailureHandler loginFailureHandler;
    /**
     * 配置加密方式
     * @return
     */
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    //重写configure(HttpSecurity http)的方法，这里面来自定义自己的拦截方法和业务逻辑
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        logger.info("configure=>");
        httpSecurity.authorizeRequests()
                .antMatchers( "/css/**", "/static/**", "/**/*.html").permitAll()
                .antMatchers("/", "/login", "/weather").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //登录失败
                .failureHandler(loginFailureHandler)
//                .failureUrl("/login?error")
                // 登录成功
                .successHandler(loginSuccessHandler)
//                .defaultSuccessUrl("/home")
                .permitAll()
                .and()
                .rememberMe()
                //其实默认就是remember-me，这里可以指定更换
                .rememberMeParameter("remember-me")
                .and()
                .logout()
//                .logoutSuccessUrl("/login?logout")  //退出登录
                .logoutSuccessHandler((request, response, authentication) -> {
                    Result result = Result.success(authentication, "退出成功");
                    postHandler(response, result);
                })
                .permitAll()
                .and()
                //允许跨域
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                            if (authException instanceof InsufficientAuthenticationException) {
                                postHandler(response, Result.fail(ResultConstant.authFail,"身份认证失败，请重新登录!"));
                            }
                        }
                );

    }

    /**
     * 跨域配置
     * @return
     */
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");	//同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
        corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
        corsConfiguration.addAllowedMethod("*");	//允许的请求方法，PSOT、GET等
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
        return source;
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    /**
     * 处理返回值
     *
     * @param response
     * @param result
     * @throws IOException
     */
    private void postHandler(HttpServletResponse response, Result result) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(result));
        out.flush();
        out.close();
    }
}