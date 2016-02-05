package br.edu.ifpb.pos.infraestrutura;

import br.edu.ifpb.pos.infraestrutura.servicos.JogoService;
import br.edu.ifpb.pos.infraestrutura.servicos.InfraestruturaService;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages = "br.edu.ifpb.pos")
public class Main {

    @Inject
    private InfraestruturaService mainServiceTmp;
    private static InfraestruturaService mainService;
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);        
        Endpoint.publish("http://localhost:8081/service",mainService);
    }
    
    @PostConstruct
    public void init(){
        mainService = mainServiceTmp;
    }
}
