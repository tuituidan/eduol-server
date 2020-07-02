package com.edu.online.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建用于 Spring 管理的 Docket 实例.
     *
     * @return Docket 实例
     */
    @Bean
    public Docket newDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edu.online.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建 ApiInfo 实例.
     *
     * @return ApiInfo 实例
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线教育服务")
                .description("在线教育后台服务接口。")
                .version("1.0")
                .build();
    }

}
