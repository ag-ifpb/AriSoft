package br.edu.ifpb.pos.webapp.controller.services;

import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.webapp.controller.forms.AdicionarJogoForm;
import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class JogoService {

    public void criarJogo(AdicionarJogoForm form, byte[] imagem) throws RemoteException {
        Jogo jogo = new Jogo();
        jogo.setEnredo(form.getEnredo());
        Foto foto = new Foto();
        foto.setBytes(imagem);
        jogo.setFoto(foto);
        jogo.setHorario(form.getHorario());
        jogo.setLocal(form.getLocal());
        jogo.setMissao(form.getMissao());
        jogo.setObjetivo(form.getObjetivo());
        AppWebServiceSingleton.getInstance().criarJogo(jogo);
    }

    public void adicionarMembros(long idJogo, String emails) {
        AppWebServiceSingleton.getInstance().adicionarMembrosAoJogo(idJogo, emails.split(","));
    }

    public void confirmarPresencaMembro(String email, String token) {
        AppWebServiceSingleton.getInstance().confirmarPresencaMembro(email, token);
    }

    public void addAlbum(long jogoId, List<MultipartFile> files) {
        AlbumFotos album = new AlbumFotos();
        album.setJogoId(jogoId);
        album.setFotos(new ArrayList<>());
        for (MultipartFile file : files){
            try {
                Foto foto = new Foto();
                foto.setBytes(file.getBytes());
                album.getFotos().add(foto);
            } catch (Exception e) {

            }
        }
        marshalingExample(album);
        AppWebServiceSingleton.getInstance().adicionarAlbumJogo(album);
    }

    public void encerrarJogo(long jogoId) {
        AppWebServiceSingleton.getInstance().encerrarJogo(jogoId);
    }

    public void cancelarJogo(long jogoId) {
        AppWebServiceSingleton.getInstance().cancelarJogo(jogoId);
    }

    private static void marshalingExample(AlbumFotos album) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AlbumFotos.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in console
            jaxbMarshaller.marshal(album, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
