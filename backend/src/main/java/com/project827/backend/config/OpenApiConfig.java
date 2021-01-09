package com.project827.backend.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(title = "재미로 보는 관상 API 명세서",
            description = "재미로 보는 관상 API 명세서",
            version = "v0.1",
            contact = @Contact(name = "Hodragon",email = "giddens5237@gmail.com"),
            license = @License(name = "Apache 2.0",
                    url = "http://www.apache.org/licenses/LICENSE-2.0.html")
    )
)

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi AccountOpenApi() {
            String[] paths = {"/api/account/**"};
            return GroupedOpenApi.builder()
                    .group("Account Api")
                    .pathsToMatch(paths)
                    .build();
    }
    
}