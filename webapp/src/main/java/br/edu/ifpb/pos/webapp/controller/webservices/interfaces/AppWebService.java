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

    /**
     * Adiciona um jogo ao repositório.
     */
    public void criarJogo (Jogo jogo) throws RemoteException;
    
    /**
     * Recupera um jogo no repositório através do seu identificador.
     */
    public Jogo verJogo (long id);
    
    /**
     * Recupera um jogo no repositório através do seu token único.
     */    
    public Jogo verJogoPeloToken (String token);
    
    /**
     * Adiciona um album de fotos de um jogo caso o mesmo já tenha sido encerrado.
     */
    public void adicionarAlbumJogo (AlbumFotos album);
    
    /**
     * Recupera um album do repositório relacionado à um jogo.
     * 
     * @param jogoId identificador do jogo que deverá ter seu album recuperado.
     */
    public AlbumFotos verAlbumJogo (long jogoId);
    
    /**
     * Adiciona membros a um jogo.
     * 
     * @param idJogo identificador do jogo que deve ter os membros adicionados.
     * @param emails e-mails dos membros que devem ser adicionados ao jogo.
     */
    public void adicionarMembrosAoJogo (long idJogo, String... emails);
    
    /**
     * Recupera uma página de jogos.
     * 
     * @param page número da página que deve ser recuperada.
     */
    public Jogos recuperarPaginaJogo (int page);
    
    /**
     * Recupera uma página apenas com jogos realizados.
     */
    public Jogos recuperarPaginaJogoRealizados(int page);
    
    /**
     * Confirma presença de um membro em um jogo.
     * 
     * @param emailMembro e-mail do membro que confirmou presença.
     * @param token token único do jogo o qual o membro confirmou a presença.
     */
    public void confirmarPresencaMembro (String emailMembro, String token);
    
    /**
     * Cancela um jogo e notifica os membros via e-mail.
     * 
     * @param jogoId identificador do jogo que deverá ser cancelado.
     */
    public void cancelarJogo (long jogoId);
    
    /**
     * Encerra um jogo e notifica os membros via e-mail.
     * 
     * @param jogoId identificador do jogo que deverá ser encerrado.
     */
    public void encerrarJogo (long jogoId);
    
    /**
     * Recupera uma imagem do repositório.
     */
    public Foto verFoto (long id);
    
    /**
     * Adiciona um novo membro ao repositório.
     */
    public void criarMembro (Membro membro);
    
    /**
     * Recupera todos os membros presentes no repositório.
     */
    public List<Membro> verTodosMembros ();
    
}
