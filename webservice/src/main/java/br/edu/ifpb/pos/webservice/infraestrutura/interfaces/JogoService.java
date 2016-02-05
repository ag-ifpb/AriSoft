package br.edu.ifpb.pos.webservice.infraestrutura.interfaces;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "JogoService"
        , targetNamespace = "http://servicos.infraestrutura.pos.ifpb.edu.br/")
public interface JogoService {
    
    public void criar (Jogo jogo);
    
    public Jogos recuperarPagina (int page, int pageSize);
    
}
