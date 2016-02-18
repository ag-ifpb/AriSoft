package br.edu.ifpb.pos.webapp.controller.jogos;

import br.edu.ifpb.pos.webapp.controller.forms.MultiplasImagensForm;
import br.edu.ifpb.pos.webapp.controller.services.JogoService;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controlador responsável por fornecer operações referentes a atualização de 
 * atributos de jogos.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/conf/jogo/{id}")
public class JogoConfiguracoesController {

    @Inject
    private JogoService jogoService;
    
    /**
     * Método responsável por adicionar membros ao jogo.
     * 
     * @param id identificador do jogo ao qual os membros deverão ser atualizados.
     * @param emails string contendo os emails dos membros que deverão ser adicionados
     * separados por vírgula (,).
     * 
     * @return codigo 202 em caso de sucesso. Em caso de erro retorna uma mensagem
     * descrevendo o erro.
     */
    @RequestMapping("/membros/adicionar")
    public @ResponseBody String adicionarMembros (@PathVariable long id, String emails){
        try{
            jogoService.adicionarMembros(id, emails);
            return ""+HttpStatus.ACCEPTED;
        }catch (Exception e){
            return ""+e.getMessage();
        }
    }
    
    /**
     * Metodo responsavel por encerrar um jogo.
     * 
     * @param id identificador do jogo que devera ser encerrado
     * 
     * @return codigo 202 em caso de sucesso. Em caso de erro retorna uma mensagem
     * descrevendo o erro.
     */
    @RequestMapping("/encerrar")
    public @ResponseBody String encerrarJogo (@PathVariable long id){
        try{
            jogoService.encerrarJogo(id);
            return ""+HttpStatus.ACCEPTED;
        }catch (Exception e){
            return ""+e.getMessage();
        }
    }
    
    /**
     * Metodo responsavel por cancelar um jogo.
     * 
     * @param id identificador do jogo que devera ser cancelado
     * 
     * @return codigo 202 em caso de sucesso. Em caso de erro retorna uma mensagem
     * descrevendo o erro.
     */
    @RequestMapping("/cancelar")
    public @ResponseBody String cancelarJogo (@PathVariable long id){
        try{
            jogoService.cancelarJogo(id);
            return ""+HttpStatus.ACCEPTED;
        }catch (Exception e){
            return ""+e.getMessage();
        }
    }
    
    /**
     * Metodo responsavel por adicionar um album de fotos a um jogo
     * 
     * @param files arquivos de imagem que deverao ser adicionados ao album.
     * @param id identificador do jogo ao qual o album sera relacionado.
     * 
     * @return codigo 202 em caso de sucesso. Em caso de erro retorna uma mensagem
     * descrevendo o erro.
     */
    @RequestMapping("/addalbum")
    public @ResponseBody String addAlbum (MultiplasImagensForm files, @PathVariable long id){
        try{
            jogoService.addAlbum(id, files.getFiles());
            return ""+HttpStatus.ACCEPTED;
        }catch (Exception e){
            return ""+e.getMessage();
        }
    }
    
    
    
}
