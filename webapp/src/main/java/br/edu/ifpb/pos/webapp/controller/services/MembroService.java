package br.edu.ifpb.pos.webapp.controller.services;

import br.edu.ifpb.pos.core.entidades.Membro;
import br.edu.ifpb.pos.webapp.controller.forms.AdicionarMembroForm;
import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class MembroService {

    public void adicionarMembro (AdicionarMembroForm form){
        Membro membro = new Membro();
        membro.setNome(form.getNome());
        membro.setEmail(form.getEmail());
        membro.setTelefone(form.getTelefone());
        AppWebServiceSingleton.getInstance().criarMembro(membro);
    }
    
    public List<Membro> verTodosMembros (){
        return AppWebServiceSingleton.getInstance().verTodosMembros();
    }
    
}
