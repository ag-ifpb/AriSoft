package br.edu.ifpb.pos.webservice.services;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.webservice.business.JogoBusiness;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.services.MainService"
        , serviceName = "MainService")
public class MainService {

    private JogoBusiness jogoBusiness;
    
    public MainService() throws MalformedURLException{
        this.jogoBusiness = new JogoBusiness();
    }
    
    public void criarJogo (Jogo jogo) throws RemoteException{
        jogoBusiness.salvarJogo(jogo);
    }
    
    public Jogos recuperarPaginaJogo (int page){
        return jogoBusiness.recuperarPagina(page);
    }
    
}
