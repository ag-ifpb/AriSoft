package br.edu.ifpb.pos.webservice.infraestrutura.interfaces;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class InfraestruturaServiceSingleton {

    private static InfraestruturaService service = null;

    private InfraestruturaServiceSingleton() {
    }

    public static InfraestruturaService getInstance() {
        if (service == null) {
            try {
                service = recuperarInfraestruturaService();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return service;
    }

    private static InfraestruturaService recuperarInfraestruturaService() throws MalformedURLException {
        URL url = new URL("http://localhost:8081/service?wsdl");
        QName qname = new QName("http://servicos.infraestrutura.pos.ifpb.edu.br/", "InfraestruturaService");
        Service service = Service.create(url, qname);
        return service.getPort(InfraestruturaService.class);
    }

}
