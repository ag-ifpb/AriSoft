package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.Membro;
import br.edu.ifpb.pos.infraestrutura.reposiorios.MembroRepository;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Serviço contendo operações referentes à entidade {@link Membro}.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class MembroService {

    @Inject
    private MembroRepository repositorio;
    
    /**
     * Adiciona um novo membro ao repositório.
     */
    public void criar (Membro membro){
        repositorio.save(membro);
    }
    
    /**
     * Recupera um membro no repositório através do seu e-mail.
     * 
     * @param email e-mail do membro procurado.
     */    
    public Membro verMembro (String email){
        return repositorio.findByEmail(email);
    }
    
    /**
     * Recupera todos os membros presentes no repositório.
     */
    public List<Membro> verTodosMembros (){
        return Lists.newArrayList(repositorio.findAll());
    }
    
}
