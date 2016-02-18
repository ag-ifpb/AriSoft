package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.infraestrutura.reposiorios.FotoRepository;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Serviço contendo operações referentes à entidade {@link Foto}
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class FotoService {

    @Inject
    private FotoRepository repository;
   
    /**
     * Recupera uma foto através do seu identificador
     * 
     * @param id identificador da foto
     */
    public Foto recuperarFoto (long id){
        return repository.findOne(id);
    }
    
}
