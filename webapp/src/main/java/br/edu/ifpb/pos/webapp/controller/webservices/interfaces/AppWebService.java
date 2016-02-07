package br.edu.ifpb.pos.webapp.controller.webservices.interfaces;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.core.entidades.Membro;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name="MainService", targetNamespace = "http://services.webservice.pos.ifpb.edu.br/")
public interface AppWebService {
    
    public void criarJogo (Jogo jogo) throws RemoteException;
    
    public Jogo verJogo (long id);
    
    public Jogos recuperarPaginaJogo (int page);
    
    public Foto verFoto (long id);
    
    public void criarMembro (Membro membro);
    
    public List<Membro> verTodosMembros ();
    
}
