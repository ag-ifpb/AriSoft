package br.edu.ifpb.pos.webapp.controller.jogos;

import br.edu.ifpb.pos.webapp.controller.forms.AdicionarJogoForm;
import br.edu.ifpb.pos.webapp.controller.services.JogoService;
import br.edu.ifpb.pos.webapp.utils.PageServerUtils;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controlador responsável por funcionalidades relacionadas ao cadastro de jogos.
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/jogo/cadastro")
public class JogosCadastroController {

    @Inject
    private JogoService jogoService;
    
    /**
     * Serve fragmento html referente à visão de cadastro de jogos.
     */
    @RequestMapping("")
    public @ResponseBody
    void index(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        PageServerUtils.serve("fragments/cadastro_jogos", request, response);
    }
    
    /**
     * Método responsável por tratar a requisição de adicionar um novo jogo.
     * 
     * @param form formulário contendo parâmetros para a criação de um novo jogo.
     * @param imagem imagem que será relacionada ao jogo.
     * 
     * @return codigo 202 em caso de sucesso. Em caso de erro retorna uma mensagem
     * descrevendo o erro.
     */
    @RequestMapping(value="/adicionar", method = RequestMethod.POST)
    public @ResponseBody String adicionarJogo (AdicionarJogoForm form, MultipartFile imagem){
        try{
            jogoService.criarJogo(form, imagem.getBytes());
            return "" + HttpStatus.ACCEPTED;
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
}

