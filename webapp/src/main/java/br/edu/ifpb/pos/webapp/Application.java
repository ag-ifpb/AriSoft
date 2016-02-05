package br.edu.ifpb.pos.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    
    private static TemplateEngine templateEngine;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    static {
        initializeTemplateEngine();        
    }

    //Thymeleaf configurations
    private static void initializeTemplateEngine() {

        ServletContextTemplateResolver templateResolver
                = new ServletContextTemplateResolver();
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(1L);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

    }

    public static TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

}
