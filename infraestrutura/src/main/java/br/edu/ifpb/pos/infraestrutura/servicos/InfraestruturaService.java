package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
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
    
    public void adicionarJogo (Jogo jogo){
        jogoService.criar(jogo);
    }
    
    public Jogos recuperarPaginaJogo (int page, int pageSize){
        return jogoService.recuperarPagina(page, pageSize);
    }
    
    public Foto recuperarFoto (long id){
        return fotoService.recuperarFoto(id);
    }
}
