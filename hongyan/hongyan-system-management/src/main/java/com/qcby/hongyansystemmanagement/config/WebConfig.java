package com.qcby.hongyansystemmanagement.config;//package com.example.chatsystem.config;
//
//import com.example.chatsystem.util.AuthenticationInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///** jwt实现登录检验的demo
// *  并且已经将Spring boot 的拦截器集成在里面
// * @author Mi
// * @version 1.0
// * @description: TODO
// * @date 2022/1/7 17:45
// */
////@Configuration
////public class WebConfig implements WebMvcConfigurer {
////    @Autowired
////    private LoginInterceptor loginInterceptor;
////
////    // 这个方法是用来配置静态资源的，比如html，js，css，等等
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////    }
////
////    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        // addPathPatterns("/**") 表示拦截所有的请求，
////        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
////        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register");
////    }
////
////}
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/*");
//
//    }
//    @Bean
//    public AuthenticationInterceptor authenticationInterceptor(){
//        return new AuthenticationInterceptor();
//    }
//}