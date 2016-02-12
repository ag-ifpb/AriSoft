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
 *
 * @author douglasgabriel
 */
@WebService(name = "InfraestruturaService"
        , targetNamespace = "http://servicos.infraestrutura.pos.ifpb.edu.br/")
public interface InfraestruturaService {
    
    public void adicionarJogo (Jogo jogo);
    
    public void atualizarJogo (Jogo jogo);
    
    public Jogo verJogo (long id);
    
    public Jogo verJogoPeloToken (String token);
    
    public void adicionarMembrosAoJogo (long idJogo, Membro... membros);
    
    public Jogos recuperarPaginaJogo (int page, int pageSize);
    
    public Foto recuperarFoto (long id);
    
    public void adicionarMembro (Membro membro);
    
    public Membro verMembro (String email);
    
    public List<Membro> verTodosMembros ();
    
    public void enviarEmail (Email email);
    
    public void criarAlbum (AlbumFotos album);
    
    public AlbumFotos verAlbumJogo (long jogoId);
    
}
