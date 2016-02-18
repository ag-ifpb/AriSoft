package br.edu.ifpb.pos.webapp.controller.membros;

import br.edu.ifpb.pos.webapp.controller.forms.AdicionarMembroForm;
import br.edu.ifpb.pos.webapp.controller.services.MembroService;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/membros/cadastro")
public class MembrosCadastrarController {

    @Inject
    private MembroService service;

    /**
     * Método responsável por oferecer funcionalidade de adicionar um novo membro.
     * 
     * @param form contém parâmetros para a criação de um novo membro.
     * 
     * @return codigo 202 em caso de sucesso. Em caso de erro retorna uma mensagem
     * descrevendo o erro.
     */
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
