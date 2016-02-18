package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.core.entidades.Membro;
import br.edu.ifpb.pos.infraestrutura.reposiorios.JogoRepository;
import com.google.common.collect.Lists;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.data.domain.PageRequest;

/**
 * Serviço contendo operações referentes à entidade {@link Jogo}.
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class JogoService {

    @Inject
    private JogoRepository repositorio;

    /**
     * Adiciona um novo jogo ao repositório.
     */
    public void criar(Jogo jogo) {
        repositorio.save(jogo);
    }

    /**
     * Recupera um jogo do repositório através do seu identificador.
     * 
     * @param id identificador do Jogo que se deseja recuperar.
     */
    public Jogo recuperar(long id){
        return repositorio.findOne(id);
    }
    
    /**
     * Recupera um jogo do repositório através do seu token único.
     * 
     * @param token token correspondente ao jogo que se deseja recuperar.
     */
    public Jogo recuperar (String token){
        return repositorio.findByToken(token);
    }
    
    /**
     * Adiciona novos membros ao jogo.
     * 
     * @param id identificador do jogo que se deseja adicionar os membros.
     * @param membros membros que se deseja adicionar ao jogo.
     */
    public void adicionarMembros (long id, Membro... membros){
        Jogo jogo = repositorio.findOne(id);
        jogo.getMembrosNaoConfirmados().addAll(Lists.newArrayList(membros));
        repositorio.save(jogo);
    }
    
    /**
     * Faz uma recuperação paginada dentre todos os jogos contidos no repositório.
     * 
     * @param page número da página que se deseja recuperar.
     * @param pageSize quantidade de elementos que devem ser considerados na página.
     * 
     * @return DTO contendo a lista de jogos recuperados
     */
    public Jogos recuperarPagina(int page, int pageSize) {
        Jogos lista = new Jogos();
        lista.setJogos(repositorio.findAll(new PageRequest(page, pageSize)).getContent());
        return lista;
    }
    
    /**
     * Semelhante ao método {@link JogoService#recuperarPagina(int, int)} porém a lista
     * gerada apenas considera jogos sinalizados com já realizados.
     * 
     * @param page número da página que se deseja recuperar.
     * @param pageSize quantidade de elementos que devem ser considerados na página.
     * 
     * @return DTO contendo a lista de jogos recuperados
     */    
    public Jogos recuperarPaginaRealizados (int page, int pageSize){
        Jogos lista = new Jogos();
        lista.setJogos(repositorio.findAlreadyRealized(new PageRequest(page, pageSize)).getContent());
        return lista;
    }

}
