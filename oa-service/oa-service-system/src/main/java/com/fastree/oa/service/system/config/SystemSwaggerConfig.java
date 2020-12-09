package com.fastree.oa.service.system.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemSwaggerConfig {

    //    @Bean
//    public SecurityConfiguration securityConfiguration() {
//        return SecurityConfigurationBuilder.builder()
//                .enableCsrfSupport(true)
//                .build();
//    }
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .groupName("系统服务")
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.fastree.oa"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("系统服务接口说明")
//                .description("System Service For Office Automation")
//                .contact(new Contact("Alex", "http://www.baidu.com", "121377726@qq.com"))
//                .version("1.0")
//                .build();
//    }
}
