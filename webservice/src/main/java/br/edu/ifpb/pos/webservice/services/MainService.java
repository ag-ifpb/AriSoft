package br.edu.ifpb.pos.webservice.services;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.core.entidades.Membro;
import br.edu.ifpb.pos.webservice.business.JogoBusiness;
import br.edu.ifpb.pos.webservice.infraestrutura.interfaces.InfraestruturaServiceSingleton;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
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
    
    public Jogo verJogo (long id){
        return jogoBusiness.verJogo(id);
    }
    
    public Jogos recuperarPaginaJogo (int page){
        return jogoBusiness.recuperarPagina(page);
    }
    
    public Foto verFoto (long id){
        return InfraestruturaServiceSingleton.getInstance().recuperarFoto(id);
    }
    
    public void criarMembro (Membro membro){
        InfraestruturaServiceSingleton.getInstance().adicionarMembro(membro);
    }
    
    public List<Membro> verTodosMembros (){
        return InfraestruturaServiceSingleton.getInstance().verTodosMembros();
    }
    
}
