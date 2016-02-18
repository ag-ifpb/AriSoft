package br.edu.ifpb.pos.webapp.controller;

import br.edu.ifpb.pos.webapp.utils.PageServerUtils;
import java.io.IOException;
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
@RequestMapping("/")
public class MainController {

    /**
     * Método responsável por servir a pagina principal da aplicaçao
     */
    @RequestMapping("/")
    public @ResponseBody
    void index(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        PageServerUtils.serve("index", request, response);
    }
}
