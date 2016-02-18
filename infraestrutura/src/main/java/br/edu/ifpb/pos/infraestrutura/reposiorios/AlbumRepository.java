package br.edu.ifpb.pos.infraestrutura.reposiorios;

import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface relacionada à manipulação de dados referentes à entidade 
 * {@link AlbumFotos}.
 * 
 * @author douglasgabriel
 */
public interface AlbumRepository extends CrudRepository<AlbumFotos, Long>{
    
    /**
     * Recupera um album de fotos através do ID do jogo ao qual está relacionado.
     * 
     * @param jogoId corresponde à identificação do jogo.
     * @return um album de fotos
     * @see AlbumFotos
     */
    public AlbumFotos findByJogoId (long jogoId);
    
}
