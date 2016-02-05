package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.infraestrutura.reposiorios.FotoRepository;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class FotoService {

    @Inject
    private FotoRepository repository;
    
    public Foto recuperarFoto (long id){
        return repository.findOne(id);
    }
    
}
