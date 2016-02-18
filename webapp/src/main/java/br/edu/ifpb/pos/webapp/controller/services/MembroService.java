package br.edu.ifpb.pos.webapp.controller.services;

import br.edu.ifpb.pos.core.entidades.Membro;
import br.edu.ifpb.pos.webapp.controller.forms.AdicionarMembroForm;
import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import java.util.List;
import javax.inject.Named;

/**
 * Classe responsável por oferecer funcionalidades referentes à manipulação de 
 * entidades do tipo {@link Membro}.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class MembroService {

    /**
     * Método responsável por montar um {@link Membro} e utilizar a funcionalidade
     * do Web Service de domínio para adicionar o novo membro.
     * 
     * @param form contém os parâmetros para criação de membro.
     */
    public void adicionarMembro (AdicionarMembroForm form){
        Membro membro = new Membro();
        membro.setNome(form.getNome());
        membro.setEmail(form.getEmail());
        membro.setTelefone(form.getTelefone());
        AppWebServiceSingleton.getInstance().criarMembro(membro);
    }
    
    /**
     * Método responsável por listar todos os membros.
     */
    public List<Membro> verTodosMembros (){
        return AppWebServiceSingleton.getInstance().verTodosMembros();
    }
    
}
