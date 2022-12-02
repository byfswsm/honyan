/*
package com.clusterProject.unifiedVerificationPlatform.config;

import com.clusterProject.unifiedVerificationPlatform.properties.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

*/
/**
 * @className: SwaggerConfig
 * @description:
 * @author: lxt
 * @create: 2021-11-08
 **//*

@Configuration
// @Enablexxx
@EnableSwagger2
public class SwaggerConfig {


    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("REST接口")
                .apiInfo(apiInfo())
                .select()
                //  配置自动扫描那些包下类型生成接口文档
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackageRest()))
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title(swaggerProperties.getTitle())
                //创建人
                .contact(new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(),swaggerProperties.getContactEmail()))
                //版本号
                .version(swaggerProperties.getVersion())
                //描述
                .description(swaggerProperties.getDescription())
                .build();
    }
}
*/
