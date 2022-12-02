package com.qcby.hongyanredenvelopes.config;



import com.qcby.hongyanredenvelopes.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     *
     *  拦截器链   、   责任链模式
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
//                // 拦截所有路径
                .addPathPatterns("/**")
                // 那些路径不拦截
                .excludePathPatterns("/login/**","/error/**","/favicon.ico","/envelope/listAll");
    }

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
}
