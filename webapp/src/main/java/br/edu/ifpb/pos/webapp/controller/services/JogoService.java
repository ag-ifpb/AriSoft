package br.edu.ifpb.pos.webapp.controller.services;

import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.webapp.controller.forms.AdicionarJogoForm;
import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.springframework.web.multipart.MultipartFile;

/**
 * Serviço responsável por disponibilizar funcionalidades de manipulação de entidades
 * {@link Jogo}.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class JogoService {

    /**
     * Método responsável por montar um {@link Jogo} e utilizar a funcionalidade
     * do Web Service de domínio para adicionar o novo jogo.
     * 
     * @param form contém os parâmetros para criação do jogo.
     * @param imagem imagem que será relacionada ao jogo.
     */
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

    /**
     * Método responsável por adicionar membros à um jogo.
     * 
     * @param idJogo identificação do jogo ao qual os membros devem ser adicionados.
     * @param emails string contendo e-mails dos membros que deverão ser adicionados
     * ao jogo separados por vírgula (,).
     */
    public void adicionarMembros(long idJogo, String emails) {
        AppWebServiceSingleton.getInstance().adicionarMembrosAoJogo(idJogo, emails.split(","));
    }

    /**
     * Método responsável por confirmar presença de um membro em um jogo.
     * 
     * @param email e-mail do membro que confirmou presença no jogo.
     * @param token token único do jogo ao qual o membro está confirmando presença.
     */
    public void confirmarPresencaMembro(String email, String token) {
        AppWebServiceSingleton.getInstance().confirmarPresencaMembro(email, token);
    }

    /**
     * Método responsável por montar um album que será associado à um jogo.
     * 
     * @param jogoId identificador do jogo que deverá ser associado ao album.
     * @param files arquivos de imagem que deverão compor o album.
     */
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

    /**
     * Método responsável por encerrar um jogo.
     * 
     * @param jogoId identificador do jogo que deverá ser encerrado.
     */
    public void encerrarJogo(long jogoId) {
        AppWebServiceSingleton.getInstance().encerrarJogo(jogoId);
    }

    /**
     * Método responsável por cancelar um jogo.
     * 
     * @param jogoId indentificador do jogo que deverá ser cancelado.
     */
    public void cancelarJogo(long jogoId) {
        AppWebServiceSingleton.getInstance().cancelarJogo(jogoId);
    }

    /**
     * Método utilizado para teste convertendo uma entidade {@link AlbumFotos}
     * em formato XML e imprimindo no console.
     */
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
