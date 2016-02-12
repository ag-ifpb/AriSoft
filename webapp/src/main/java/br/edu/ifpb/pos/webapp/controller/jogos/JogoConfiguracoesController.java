package br.edu.ifpb.pos.webapp.controller.jogos;

import br.edu.ifpb.pos.webapp.controller.services.JogoService;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/conf/jogo/{id}")
public class JogoConfiguracoesController {

    @Inject
    private JogoService jogoService;
    
    @RequestMapping("/membros/adicionar")
    public @ResponseBody String adicionarMembros (@PathVariable long id, String emails){
        try{
            jogoService.adicionarMembros(id, emails);
            return ""+HttpStatus.ACCEPTED;
        }catch (Exception e){
            return ""+e.getMessage();
        }
    }
    
    @RequestMapping("/encerrar")
    public @ResponseBody String encerrarJogo (@PathVariable long id){
        try{
            jogoService.encerrarJogo(id);
            return ""+HttpStatus.ACCEPTED;
        }catch (Exception e){
            return ""+e.getMessage();
        }
    }
    
    @RequestMapping("/cancelar")
    public @ResponseBody String cancelarJogo (@PathVariable long id){
        try{
            jogoService.cancelarJogo(id);
            return ""+HttpStatus.ACCEPTED;
        }catch (Exception e){
            return ""+e.getMessage();
        }
    }
    
}
