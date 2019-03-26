package com.meng.anjia.configuration;

import com.meng.anjia.interceptor.LoginInterceptor;
import com.meng.anjia.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by yue on 2019/2/28
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    PassportInterceptor passportInterceptor;
    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginInterceptor).addPathPatterns("/wenda").addPathPatterns("/question/*").addPathPatterns("/addComment/*");
    }
}
