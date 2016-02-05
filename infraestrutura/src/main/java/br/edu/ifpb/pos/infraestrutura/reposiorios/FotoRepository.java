package br.edu.ifpb.pos.infraestrutura.reposiorios;

import br.edu.ifpb.pos.core.entidades.Foto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author douglasgabriel
 */
public interface FotoRepository extends CrudRepository<Foto, Long>{
    
}
