package br.com.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration Class for SWAGGER
 * The Class enables Swagger and scans the classes inside 'br.com', displaying all the endpoints
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer  {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				
				.title("1k Guesser Game")
				.description("I will Automagically guess your number!")
				.version("1.0.0")
				.contact(new Contact("Jonathan H Flores", "https://github.com/jonahanzen", "jona_hanzen@hotmail.com"))
				.build();
				
	}

}