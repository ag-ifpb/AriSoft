package br.edu.ifpb.pos.infraestrutura.reposiorios;

import br.edu.ifpb.pos.core.entidades.Foto;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface relacionada à manipulação de dados referentes à entidade 
 * {@link Foto}
 * 
 * @author douglasgabriel
 */
public interface FotoRepository extends CrudRepository<Foto, Long>{
    
}
