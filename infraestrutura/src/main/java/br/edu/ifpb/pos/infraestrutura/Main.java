package br.edu.ifpb.pos.infraestrutura;

import br.edu.ifpb.pos.infraestrutura.servicos.JogoService;
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
    private JogoService jogoServiceTmp;
    private static JogoService jogoService;
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);        
        Endpoint.publish("http://localhost:8081/jogo",jogoService);
    }
    
    @PostConstruct
    public void init(){
        jogoService = jogoServiceTmp;
    }
}
