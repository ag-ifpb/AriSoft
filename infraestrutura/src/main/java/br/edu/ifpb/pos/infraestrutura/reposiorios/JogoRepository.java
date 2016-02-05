package br.edu.ifpb.pos.infraestrutura.reposiorios;

import br.edu.ifpb.pos.core.entidades.Jogo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author douglasgabriel
 */
public interface JogoRepository extends CrudRepository<Jogo, Long>{
    
    public Page<Jogo> findAll (Pageable page);
    
}
