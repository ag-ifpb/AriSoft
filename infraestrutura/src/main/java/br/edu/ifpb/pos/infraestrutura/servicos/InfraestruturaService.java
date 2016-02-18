package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import br.edu.ifpb.pos.core.entidades.Email;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.core.entidades.Membro;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;

/**
 * Classe que representa o serviço que disponibiliza as funcionalidades básicas.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.infraestrutura.servicos.InfraestruturaService", serviceName = "InfraestruturaService")
@Named
public class InfraestruturaService {

    @Inject
    private JogoService jogoService;
    @Inject
    private FotoService fotoService;
    @Inject
    private MembroService membroService;
    @Inject
    private EmailService emailService;
    @Inject
    private AlbumService albumService;

    /**
     * Adiciona um jogo ao repositório.
     */
    public void adicionarJogo(Jogo jogo) {
        jogoService.criar(jogo);
    }

    /**
     * Atualiza informações de um jogo já presente no repositório.
     */
    public void atualizarJogo(Jogo jogo) {
        jogoService.criar(jogo);
    }

    /**
     * Recupera um jogo no repositório através do seu identificador.
     */
    public Jogo verJogo(long id) {
        return jogoService.recuperar(id);
    }

    /**
     * Recupera um jogo no repositório através do seu token único.
     */
    public Jogo verJogoPeloToken(String token) {
        return jogoService.recuperar(token);
    }

    /**
     * Adiciona membros à um jogo.
     * 
     * @param idJogo identificador do jogo ao qual os membros deverão ser adicionados.
     * @param membros membros que deverão ser adicionados ao jogo.
     */
    public void adicionarMembrosAoJogo(long idJogo, Membro... membros) {
        jogoService.adicionarMembros(idJogo, membros);
    }

    /**
     * Faz uma recuperação paginada dentre todos os jogos presentes no repositório.
     * 
     * @param page número da página que deverá ser recuperada.
     * @param pageSize número de elementos presentes em uma página.
     */
    public Jogos recuperarPaginaJogo(int page, int pageSize) {
        return jogoService.recuperarPagina(page, pageSize);
    }

    /**
     * Faz uma recuperação paginada dentre todos os jogos já realizados.
     * 
     * @param page número da página que deverá ser recuperada.
     * @param pageSize número de elementos presentes em uma página.
     */
    public Jogos recuperarPaginaJogoRealizados(int page, int pageSize){
        return jogoService.recuperarPaginaRealizados(page, pageSize);
    }

    /**
     * Recupera uma imagem do repositório.
     */
    public Foto recuperarFoto(long id) {
        return fotoService.recuperarFoto(id);
    }

    /**
     * Adiciona um novo membro ao repositório.
     */
    public void adicionarMembro(Membro membro) {
        membroService.criar(membro);
    }

    /**
     * Recupera um membro no repositório atrabés do seu e-mail.
     */
    public Membro verMembro(String email) {
        return membroService.verMembro(email);
    }

    /**
     * Recupera todos os membros presentes no repositório.
     */
    public List<Membro> verTodosMembros() {
        return membroService.verTodosMembros();
    }

    /**
     * Envia um e-mail.
     * 
     * @param email contém informações relativas ao e-mail que deve ser enviado.
     */
    public void enviarEmail(Email email) {
        emailService.enviarEmail(email);
    }

    /**
     * Adiciona um novo album ao repositório.
     */
    public void criarAlbum(AlbumFotos album) {
        albumService.criarAlbum(album);
    }

    /**
     * Recupera um album do repositório relacionado à um jogo.
     * 
     * @param jogoId identificador do jogo que deverá ter seu album recuperado.
     */
    public AlbumFotos verAlbumJogo(long jogoId) {
        return albumService.verAlbumJogo(jogoId);
    }
}
