package br.edu.ifpb.pos.infraestrutura.reposiorios;

import br.edu.ifpb.pos.core.entidades.Jogo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface relacionada à manipulação de dados referentes à entidade 
 * {@link Jogo}
 * 
 * @author douglasgabriel
 */
public interface JogoRepository extends CrudRepository<Jogo, Long>{
    
    /**
     * Recupera uma página de jogos.
     * 
     * @param page descreve as características da página que deverá ser retornada
     * @return uma página de jogos conforme as características informadas.
     */
    public Page<Jogo> findAll (Pageable page);
    
    /**
     * Recupera um jogo através do seu token único.
     * 
     * @param token token único do jogo
     * @return um jogo
     */
    public Jogo findByToken (String token);
    
    /**
     * Recupera uma página de jogos que possuem o status 'encerrado'.
     * 
     * @param page descreve as características da página que deverá ser retornada.
     * @return uma página de jogos conforme as características informadas.
     */
    @Query("SELECT j FROM Jogo j WHERE j.status like 'ENCERRADO'")
    public Page<Jogo> findAlreadyRealized (Pageable page);
    
}
