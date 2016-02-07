package br.edu.ifpb.pos.webapp.controller.jogos;

import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import br.edu.ifpb.pos.webapp.utils.PageServerUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/jogos")
public class JogosController {

    @RequestMapping("")
    public @ResponseBody
    void index(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        PageServerUtils.serve("fragments/jogos", request, response);
    }
    
    @RequestMapping("/page/{page}")
    public @ResponseBody
    void paginacao(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int page) throws IOException {
        request.setAttribute("jogos", AppWebServiceSingleton.getInstance().recuperarPaginaJogo(page).getJogos());
        PageServerUtils.serve("fragments/lista_jogos", request, response);
    }
    
    @RequestMapping("/jogo/{id}")
    public @ResponseBody
    void verJogo(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int id) throws IOException {
        request.setAttribute("jogo", AppWebServiceSingleton.getInstance().verJogo(id));
        PageServerUtils.serve("fragments/jogo", request, response);
    }
    
}
