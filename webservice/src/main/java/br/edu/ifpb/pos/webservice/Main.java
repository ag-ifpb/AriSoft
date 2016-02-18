package br.edu.ifpb.pos.webservice;

import br.edu.ifpb.pos.webservice.services.MainService;
import java.net.MalformedURLException;
import javax.xml.ws.Endpoint;

/**
 * Classe responsável por disponibilizar o serviço do projeto contendo as 
 * funcionalidades do domínio do projeto.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
        Endpoint.publish("http://localhost:8082/service", new MainService());
    }
    
}
