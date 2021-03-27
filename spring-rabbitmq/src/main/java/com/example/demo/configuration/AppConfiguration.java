package com.example.demo.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfiguration {
	
	
	
	 	@Value("${sr.rabbit.queue.name}")
	    private String queueName;

	    @Value("${sr.rabbit.routing.name}")
	    private String routingName;

	    @Value("${sr.rabbit.exchange.name}")
	    private String exchangeName;

	    @Autowired
	    private RabbitTemplate rabbitTemplate;

	    @Bean
	    public Queue queue() {
	        return new Queue(queueName, true);
	    }

	    @Bean
	    public DirectExchange directExchange() {
	        return new DirectExchange(exchangeName);
	    }

	    @Bean
	    public Binding binding(final Queue queue, final DirectExchange directExchange){
	        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
	    }
	
	
	    
	    
	    
	    
	    
	    
	    
	    @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
	                .paths(PathSelectors.regex("/.*"))
	                .build().apiInfo(apiEndPointsInfo());

	    }


	    private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder().title("Spring Boot Swagger Example")
	                .description("User API Documentation")
	                .contact(new Contact("Omer Uysal", "", ""))
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	                .version("1.12.3")
	                .build();
	    }


}
