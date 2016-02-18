package br.edu.ifpb.pos.infraestrutura;

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
 * Classe responsável por disponibilizar o serviço do projeto contendo as 
 * funcionalidades básicas do sistema.
 * 
 * @author douglasgabriel
 * @version 0.1
 * 
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages = "br.edu.ifpb.pos")
public class Main {

    @Inject
    private InfraestruturaService mainServiceTmp;
    private static InfraestruturaService mainService;
    
    /**
     * Inicia a aplicação Spring, que realiza as configurações da aplicação, e
     * posteriormente disponibiliza o Web Service.
     * 
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);        
        Endpoint.publish("http://localhost:8081/service",mainService);
    }
    
    /**
     * Método utilizado para forçar a injeção de dependência do campo estático.
     */
    @PostConstruct
    public void init(){
        mainService = mainServiceTmp;
    }
}
