package br.edu.ifpb.pos.webapp.controller.jogos;

import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.webapp.controller.services.JogoService;
import br.edu.ifpb.pos.webapp.controller.services.MembroService;
import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import br.edu.ifpb.pos.webapp.utils.PageServerUtils;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controlador responsável por servir páginas de informações referentes aos jogos.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/jogos")
public class JogosController {

    @Inject
    private MembroService membroService;
    @Inject
    private JogoService jogoService;
    
    /**
     * Serve a página principal de jogos.
     */
    @RequestMapping("")
    public @ResponseBody
    void index(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        PageServerUtils.serve("fragments/jogos", request, response);
    }
    
    /**
     * Serve a página principal contendo apenas jogos já realizados.
     */
    @RequestMapping("/realizados")
    public @ResponseBody
    void indexJogosRealizados(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        PageServerUtils.serve("fragments/jogos_realizados", request, response);
    }
    
    /**
     * Método responsável por servir páginas de jogos.
     * 
     * @param page página que deverá ser recuperada.
     */
    @RequestMapping("/page/{page}")
    public @ResponseBody
    void paginacao(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int page) throws IOException {
        request.setAttribute("jogos", AppWebServiceSingleton.getInstance().recuperarPaginaJogo(page).getJogos());
        PageServerUtils.serve("fragments/lista_jogos", request, response);
    }
    
    /**
     * Método responsável por servir páginas contendo apenas jogos realizados.
     * 
     * @param page página que deverá ser recuperada.
     */
    @RequestMapping("/page/{page}/realizados")
    public @ResponseBody
    void paginacaoRealizados(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int page) throws IOException {
        request.setAttribute("jogos", AppWebServiceSingleton.getInstance().recuperarPaginaJogoRealizados(page).getJogos());
        PageServerUtils.serve("fragments/lista_jogos_realizados", request, response);
    }
    
    /**
     * Método resposável por servir a página de um único jogo.
     * 
     * @param id identificação do jogo que deverá ser visualizado.
     */
    @RequestMapping("/jogo/{id}")
    public @ResponseBody
    void verJogo(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int id) throws IOException {
        request.setAttribute("jogo", AppWebServiceSingleton.getInstance().verJogo(id));
        PageServerUtils.serve("fragments/jogo", request, response);
    }
    
    /**
     * Método responsável por servir os membros presentes em um jogo.
     * 
     * @param id identificador do jogo que deverá ter seus membros recuperados.
     */
    @RequestMapping("/jogo/{id}/membros")
    public @ResponseBody
    void verMembrosJogo(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int id) throws IOException {
        request.setAttribute("membrosCadastrados", membroService.verTodosMembros());
        Jogo jogo = AppWebServiceSingleton.getInstance().verJogo(id);
        request.setAttribute("membrosNaoConfirmados", jogo.getMembrosNaoConfirmados());
        request.setAttribute("membrosConfirmados", jogo.getMembrosConfirmados());
        request.setAttribute("qtdMembros", jogo.qtdMembros());
        request.setAttribute("jogoId", id);
        PageServerUtils.serve("fragments/jogo_membros", request, response);
    }
    
    /**
     * Método responsável por servir as informações presentes em um jogo.
     * 
     * @param id identificador do jogo que deverá ter seus membros recuperados.
     */
    @RequestMapping("/jogo/{id}/info")
    public @ResponseBody
    void verInfosJogo(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int id) throws IOException {
        request.setAttribute("jogo", AppWebServiceSingleton.getInstance().verJogo(id));
        PageServerUtils.serve("fragments/jogo_info", request, response);
    }
    
    /**
     * Método responsável por servir a visão responsável por mostrar as fotos 
     * relacionadas ao jogo.
     * 
     * @param id identificador do jogo que deverá ter o album recuperado.
     */
    @RequestMapping("/jogo/{id}/album")
    public @ResponseBody
    void verAlbumJogo(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int id) throws IOException {
        request.setAttribute("jogo", AppWebServiceSingleton.getInstance().verJogo(id));
        AlbumFotos album = AppWebServiceSingleton.getInstance().verAlbumJogo(id);
        request.setAttribute("fotos", album != null ? album.getFotos() : null);
        PageServerUtils.serve("fragments/jogo_album", request, response);
    }
    
    /**
     * Método responsável por confirmar a presença de membro no jogo.
     * 
     * @param token token único do jogo ao qual o membro está confirmando
     * sua resença.
     */
    @RequestMapping("/jogo/confirmar/{token}")
    public @ResponseBody
    void confirmarPresencaMembro(HttpServletRequest request,
            HttpServletResponse response, @PathVariable String token) throws IOException {
        String email = (String) request.getParameter("email");
        jogoService.confirmarPresencaMembro(email, token);
        request.setAttribute("jogoId", AppWebServiceSingleton.getInstance().verJogoPeloToken(token).getId());
        PageServerUtils.serve("index", request, response);
    }
    
    
    
}
