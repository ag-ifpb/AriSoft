package br.edu.ifpb.pos.webapp.controller.webservices.interfaces;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.AlbumFotos;
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
    
    public Jogo verJogoPeloToken (String token);
    
    public void adicionarAlbumJogo (AlbumFotos album);
    
    public AlbumFotos verAlbumJogo (long jogoId);
    
    public void adicionarMembrosAoJogo (long idJogo, String... emails);
    
    public Jogos recuperarPaginaJogo (int page);
    
    public void confirmarPresencaMembro (String emailMembro, String token);
    
    public void cancelarJogo (long jogoId);
    
    public void encerrarJogo (long jogoId);
    
    public Foto verFoto (long id);
    
    public void criarMembro (Membro membro);
    
    public List<Membro> verTodosMembros ();
    
}
