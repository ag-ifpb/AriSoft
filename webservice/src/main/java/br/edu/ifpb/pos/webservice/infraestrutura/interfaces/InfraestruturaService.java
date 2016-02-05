package br.edu.ifpb.pos.webservice.infraestrutura.interfaces;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "InfraestruturaService"
        , targetNamespace = "http://servicos.infraestrutura.pos.ifpb.edu.br/")
public interface InfraestruturaService {
    
    public void adicionarJogo (Jogo jogo);
    
    public Jogos recuperarPaginaJogo (int page, int pageSize);
    
    public Foto recuperarFoto (long id);
    
}
