package br.edu.ifpb.pos.webservice.infraestrutura.interfaces;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import br.edu.ifpb.pos.core.entidades.Email;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.core.entidades.Membro;
import java.util.List;
import javax.jws.WebService;

/**
 * Interface responsável por mapear o Web Service básico.
 * 
 * @author douglasgabriel
 */
@WebService(name = "InfraestruturaService"
        , targetNamespace = "http://servicos.infraestrutura.pos.ifpb.edu.br/")
public interface InfraestruturaService {
    
    /**
     * Adiciona um jogo ao repositório.
     */
    public void adicionarJogo (Jogo jogo);
    
    /**
     * Atualiza informações de um jogo já presente no repositório.
     */
    public void atualizarJogo (Jogo jogo);
    
    /**
     * Recupera um jogo no repositório através do seu identificador.
     */
    public Jogo verJogo (long id);
    
    /**
     * Recupera um jogo no repositório através do seu token único.
     */
    public Jogo verJogoPeloToken (String token);
    
    /**
     * Adiciona membros à um jogo.
     * 
     * @param idJogo identificador do jogo ao qual os membros deverão ser adicionados.
     * @param membros membros que deverão ser adicionados ao jogo.
     */
    public void adicionarMembrosAoJogo (long idJogo, Membro... membros);
    
    /**
     * Faz uma recuperação paginada dentre todos os jogos presentes no repositório.
     * 
     * @param page número da página que deverá ser recuperada.
     * @param pageSize número de elementos presentes em uma página.
     */
    public Jogos recuperarPaginaJogo (int page, int pageSize);
    
    /**
     * Faz uma recuperação paginada dentre todos os jogos já realizados.
     * 
     * @param page número da página que deverá ser recuperada.
     * @param pageSize número de elementos presentes em uma página.
     */
    public Jogos recuperarPaginaJogoRealizados(int page, int pageSize);
    
    /**
     * Recupera uma imagem do repositório.
     */
    public Foto recuperarFoto (long id);
    
    /**
     * Adiciona um novo membro ao repositório.
     */
    public void adicionarMembro (Membro membro);
    
    /**
     * Recupera um membro no repositório atrabés do seu e-mail.
     */
    public Membro verMembro (String email);
    
    /**
     * Recupera todos os membros presentes no repositório.
     */
    public List<Membro> verTodosMembros ();
    
    /**
     * Envia um e-mail.
     * 
     * @param email contém informações relativas ao e-mail que deve ser enviado.
     */
    public void enviarEmail (Email email);
    
    /**
     * Adiciona um novo album ao repositório.
     */
    public void criarAlbum (AlbumFotos album);
    
    /**
     * Recupera um album do repositório relacionado à um jogo.
     * 
     * @param jogoId identificador do jogo que deverá ter seu album recuperado.
     */
    public AlbumFotos verAlbumJogo (long jogoId);
    
}
