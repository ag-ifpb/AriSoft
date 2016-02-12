package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Email;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.core.entidades.Membro;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;

/**
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
    
    public void adicionarJogo (Jogo jogo){
        jogoService.criar(jogo);
    }
    
    public void atualizarJogo (Jogo jogo){
        jogoService.criar(jogo);
    }
    
    public Jogo verJogo (long id){
        return jogoService.recuperar(id);
    }
    
    public void adicionarMembrosAoJogo (long idJogo, Membro... membros){
        jogoService.adicionarMembros(idJogo, membros);
    }
    
    public Jogos recuperarPaginaJogo (int page, int pageSize){
        return jogoService.recuperarPagina(page, pageSize);
    }
    
    public Foto recuperarFoto (long id){
        return fotoService.recuperarFoto(id);
    }
    
    public void adicionarMembro (Membro membro){
        membroService.criar(membro);
    }
    
    public Membro verMembro (String email){
        return membroService.verMembro(email);
    }
    
    public List<Membro> verTodosMembros (){
        return membroService.verTodosMembros();
    }
    
    public void enviarEmail (Email email){
        emailService.enviarEmail(email);
    }
}
