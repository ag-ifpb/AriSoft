package br.edu.ifpb.pos.webapp.controller.membros;

import br.edu.ifpb.pos.webapp.controller.forms.AdicionarJogoForm;
import br.edu.ifpb.pos.webapp.controller.forms.AdicionarMembroForm;
import br.edu.ifpb.pos.webapp.controller.services.MembroService;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/membros/cadastro")
public class MembrosCadastrarController {

    @Inject
    private MembroService service;
    
    @RequestMapping(value="", method = RequestMethod.POST)
    public @ResponseBody String adicionarMembro (AdicionarMembroForm form){
        try{
            service.adicionarMembro(form);
            return "" + HttpStatus.ACCEPTED;
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
}
