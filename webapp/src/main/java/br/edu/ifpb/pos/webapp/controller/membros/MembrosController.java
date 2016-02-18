package br.edu.ifpb.pos.webapp.controller.membros;

import br.edu.ifpb.pos.webapp.controller.services.MembroService;
import br.edu.ifpb.pos.webapp.utils.PageServerUtils;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/membros")
public class MembrosController {

    @Inject
    private MembroService service;
    
    /**
     * Método responsável por servir a página principal para visualização e cadastro
     * de membros.
     */
    @RequestMapping("")
    public @ResponseBody
    void index(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        request.setAttribute("membros", service.verTodosMembros());
        PageServerUtils.serve("fragments/membros", request, response);
    }
    
}
