package com.dghs.fyp.backend.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

@Slf4j
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig implements WebMvcConfigurer {

    private static final String VERSION = "1.0";

    @Bean
    @ConditionalOnMissingBean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dghs.fyp.backend.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()).build()
                .securitySchemes(Collections.singletonList(securityScheme()));
    }

    @Bean
    SecurityScheme securityScheme() {
        return new ApiKey("token", "token", "header");
    }


    private ApiInfo apiInf() {
        return new ApiInfoBuilder()
                .title("David FYP PostureDetection API Doc")
                .version(VERSION)
                .description("David FYP PostureDetection API Doc \r\n" +
                        "www.davidgonghongshen.com \r\n" +
                        "www.posturedetection.com ")
                .contact(new Contact("David Gong", "www.davidgonghongshen.com", "davidgonghongshen@gmail.com"))
                .termsOfServiceUrl("No terms of service")
                .license("The Apache License, Version 2.0")
                .termsOfServiceUrl("www.posturedetection.com")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs");
//        registry.addRedirectViewController("/documentation/configuration/ui", "/configuration/ui");
//        registry.addRedirectViewController("/documentation/configuration/security", "/configuration/security");
//        registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
//        registry.addRedirectViewController("/documentation", "/documentation/swagger-ui.html");
//        registry.addRedirectViewController("/v1/api/doc", "/swagger-ui.html");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/documentation/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}