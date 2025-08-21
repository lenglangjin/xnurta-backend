//package com.leda.config;
//
//import com.leda.interceptor.LoginHandlerInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Collections;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private LoginHandlerInterceptor loginHandlerInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration registration = registry.addInterceptor(loginHandlerInterceptor);
//        registration.addPathPatterns("/**");
//        registration.excludePathPatterns("/user/login");
//        registration.excludePathPatterns("/login", "/register", "*.html", "*.js", "*.css", "*.png", "*.jpg", "*.gif");
//        registration.excludePathPatterns(Collections.singletonList("/doc.html"));
//        registration.excludePathPatterns("/csrf", "/webjars/**", "/swagger-resources", "/swagger-resources/**", "/v3/**", "/favicon.ico", "/swagger-ui/**");
//
//    }
//}
