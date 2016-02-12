package br.edu.ifpb.pos.infraestrutura.reposiorios;

import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author douglasgabriel
 */
public interface AlbumRepository extends CrudRepository<AlbumFotos, Long>{
    
    public AlbumFotos findByJogoId (long jogoId);
    
}
