package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.Membro;
import br.edu.ifpb.pos.infraestrutura.reposiorios.MembroRepository;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class MembroService {

    @Inject
    private MembroRepository repositorio;
    
    public void criar (Membro membro){
        repositorio.save(membro);
    }
    
    public List<Membro> verTodosMembros (){
        return Lists.newArrayList(repositorio.findAll());
    }
    
}
