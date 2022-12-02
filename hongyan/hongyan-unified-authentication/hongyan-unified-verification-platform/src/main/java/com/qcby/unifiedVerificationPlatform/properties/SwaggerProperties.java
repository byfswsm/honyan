/*
package com.clusterProject.unifiedVerificationPlatform.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

*/
/**
 * @className: SwaggerProperties
 * @description: swagger接口文档配置
 * @author: lxt
 * @create: 2021-11-08
 **//*

@Component
@ConfigurationProperties(prefix = "swagger20211108")
@Data
public class SwaggerProperties {
    private String title;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String version;
    private String description;
    private String basePackageRest;
    private String termsOfServiceUrl;
}
*/
