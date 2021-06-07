package com.huaxia.course.common.configure;

import com.huaxia.course.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfg implements WebMvcConfigurer {

    /**
     * 添加拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截器配置");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//匹配要过滤的路径
                .excludePathPatterns("/test","/assets/**","/login","/**.html");//匹配不过滤的路径
    }
}
