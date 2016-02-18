package br.edu.ifpb.pos.infraestrutura.reposiorios;

import br.edu.ifpb.pos.core.entidades.Membro;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface relacionada à manipulação de dados referentes à entidade 
 * {@link Membro}.
 * @author douglasgabriel
 */
public interface MembroRepository extends CrudRepository<Membro, Long>{

    /**
     * Recupera um mebro através do seu e-mail.
     * 
     * @param email E-mail que deverá ser procurado.
     * @return o membro que possui o e-mail informado.
     */
    public Membro findByEmail (String email);
    
}
