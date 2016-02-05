package br.edu.ifpb.pos.webapp.controller.webservices.interfaces;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class AppWebServiceSingleton {

    private static AppWebService webService = null;
    
    private AppWebServiceSingleton(){}
    
    public static AppWebService getInstance (){
        if (webService == null){
            try {
                webService = recuperarWebService();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return webService;
    }

    private static AppWebService recuperarWebService() throws MalformedURLException {
        URL url = new URL ("http://localhost:8082/service");
        QName qName = new QName("http://services.webservice.pos.ifpb.edu.br/", "MainService");
        Service service = Service.create(url, qName);
        return service.getPort(AppWebService.class);
    }
    
}
