package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.infraestrutura.reposiorios.JogoRepository;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class JogoService {

    @Inject
    private JogoRepository repositorio;

    public void criar(Jogo jogo) {
        repositorio.save(jogo);
    }

    public Jogo recuperar(long id){
        return repositorio.findOne(id);
    }
    
    public Jogos recuperarPagina(int page, int pageSize) {
        Jogos lista = new Jogos();
        lista.setJogos(repositorio.findAll(new PageRequest(page, pageSize)).getContent());
        return lista;
    }

}
