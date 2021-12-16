package com.msb.dongbao.portal.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 15:58
 * @Description: com.msb.dongbao.portal.Interceptor
 * @Version: 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/ums-member/load")
                .excludePathPatterns("/user-member/register")
                .excludePathPatterns("/code/**")
                .excludePathPatterns("/jcaptcha/**")
                .excludePathPatterns("/happycpatcha/**")
                .excludePathPatterns("/easycpatcha/**")
                .excludePathPatterns("/kaptcha/**");
    }
    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }
}
