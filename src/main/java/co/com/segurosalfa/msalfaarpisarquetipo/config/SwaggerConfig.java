package co.com.segurosalfa.msalfaarpisarquetipo.config;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title(this.swaggerProperties.getProjectName())
                        .description(this.swaggerProperties.getProjectShortDescription())
                        .contact(contactApiInfo())
                        .version(this.swaggerProperties.getVersion()))
                    .extensions(Collections.singletonMap("charset", StandardCharsets.UTF_8.name()));
    }

    private Contact contactApiInfo() {
        Contact contact= new Contact();

        contact.setName(this.swaggerProperties.getDeveloperName());
        contact.setEmail(this.swaggerProperties.getDeveloperMail());
        contact.setUrl(this.swaggerProperties.getOrganizationUrl());

        return contact;
    }
    
}
