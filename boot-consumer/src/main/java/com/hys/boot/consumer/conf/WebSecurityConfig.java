package com.hys.boot.consumer.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.hys.boot.consumer.Interceptor.MyFilterSecurityInterceptor;
import com.hys.boot.consumer.service.CustomUserService;
import com.hys.boot.consumer.util.MD5Util;

@Configuration
@EnableWebSecurity
@ImportResource(locations={"classpath:application-bean.xml"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
	    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
	
		@Bean
		CustomUserService customUserService(){ //注册UserDetailsService 的bean
	        return new CustomUserService();
	    }		
		
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {	    	
	        auth.userDetailsService(customUserService());  //user Details Service验证
	        //以下增加md5加密验证
	        /*	.passwordEncoder(new PasswordEncoder(){
	                @Override
	                public String encode(CharSequence rawPassword) {
	                    return MD5Util.encode((String)rawPassword);
	                }
	                @Override
	                public boolean matches(CharSequence rawPassword, String encodedPassword) {
	                    return encodedPassword.equals(MD5Util.encode((String)rawPassword));
	                }}); */
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.csrf().disable()
            .authorizeRequests()                
                .antMatchers("/", "/home").permitAll()  //允许所有用户访问"/"和"/home"
                .anyRequest().authenticated()  //其他地址的访问均需验证权限
                .and()
            .formLogin()
                .loginPage("/login")     //指定登录页是"/login"
                .defaultSuccessUrl("/web")  //登录成功后默认跳转到"/hello"
                .failureUrl("/login?error=true")
                .permitAll()
                .and()                
                .logout()
                .logoutSuccessUrl("/login?logout=true")//退出登录后的默认url是"/home"
                .permitAll();
	    	http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	    }
}
