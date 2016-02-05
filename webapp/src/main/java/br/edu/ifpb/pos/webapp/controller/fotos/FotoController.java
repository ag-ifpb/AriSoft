package br.edu.ifpb.pos.webapp.controller.fotos;

import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/imagem/{id}")
public class FotoController {

    @RequestMapping(value="", produces = {MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE}, method = RequestMethod.GET)
    public void servirFoto(HttpServletResponse response, @PathVariable long id) {
        Foto foto = AppWebServiceSingleton.getInstance().verFoto(id);
        try {
            OutputStream out = response.getOutputStream();
            out.write(foto.getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
