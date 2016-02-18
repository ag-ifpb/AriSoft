package br.edu.ifpb.pos.webservice.services;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.AlbumFotos;
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
 * Classe que 
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
    
    /**
     * Adiciona um jogo ao repositório.
     */
    public void criarJogo (Jogo jogo) throws RemoteException{
        jogoBusiness.salvarJogo(jogo);
    }
    
    /**
     * Recupera um jogo no repositório através do seu identificador.
     */
    public Jogo verJogo (long id){
        return jogoBusiness.verJogo(id);
    }
    
    /**
     * Recupera um jogo no repositório através do seu token único.
     */
    public Jogo verJogoPeloToken (String token){
        return jogoBusiness.verJogo(token);
    }
    
    /**
     * Adiciona um album de fotos de um jogo caso o mesmo já tenha sido encerrado.
     */
    public void adicionarAlbumJogo (AlbumFotos album){
        jogoBusiness.adicionarAlbumJogo(album);
    }
    
    /**
     * Recupera um album do repositório relacionado à um jogo.
     * 
     * @param jogoId identificador do jogo que deverá ter seu album recuperado.
     */
    public AlbumFotos verAlbumJogo (long jogoId){
        return InfraestruturaServiceSingleton.getInstance().verAlbumJogo(jogoId);
    }
    
    /**
     * Adiciona membros a um jogo.
     * 
     * @param idJogo identificador do jogo que deve ter os membros adicionados.
     * @param emails e-mails dos membros que devem ser adicionados ao jogo.
     */
    public void adicionarMembrosAoJogo (long idJogo, String... emails){
        jogoBusiness.adicionarMembrosAoJogo(idJogo, emails);
    }
    
    /**
     * Recupera uma página de jogos.
     * 
     * @param page número da página que deve ser recuperada.
     */
    public Jogos recuperarPaginaJogo (int page){
        return jogoBusiness.recuperarPagina(page);
    }
    
    /**
     * Recupera uma página apenas com jogos realizados.
     */
    public Jogos recuperarPaginaJogoRealizados(int page){
        return jogoBusiness.recuperarPaginaRealizados(page);
    }
    
    /**
     * Confirma presença de um membro em um jogo.
     * 
     * @param emailMembro e-mail do membro que confirmou presença.
     * @param token token único do jogo o qual o membro confirmou a presença.
     */
    public void confirmarPresencaMembro (String emailMembro, String token){
        jogoBusiness.confirmarPresencaMembro(emailMembro, token);
    }
    
    /**
     * Cancela um jogo e notifica os membros via e-mail.
     * 
     * @param jogoId identificador do jogo que deverá ser cancelado.
     */
    public void cancelarJogo (long jogoId){
        jogoBusiness.cancelarJogo(jogoId);
    }
    
    /**
     * Encerra um jogo e notifica os membros via e-mail.
     * 
     * @param jogoId identificador do jogo que deverá ser encerrado.
     */
    public void encerrarJogo (long jogoId){
        jogoBusiness.encerrarJogo(jogoId);
    }
    
    /**
     * Recupera uma imagem do repositório.
     */
    public Foto verFoto (long id){
        return InfraestruturaServiceSingleton.getInstance().recuperarFoto(id);
    }
    
    /**
     * Adiciona um novo membro ao repositório.
     */
    public void criarMembro (Membro membro){
        InfraestruturaServiceSingleton.getInstance().adicionarMembro(membro);
    }
    
    /**
     * Recupera todos os membros presentes no repositório.
     */
    public List<Membro> verTodosMembros (){
        return InfraestruturaServiceSingleton.getInstance().verTodosMembros();
    }
    
}
