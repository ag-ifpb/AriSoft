package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import br.edu.ifpb.pos.infraestrutura.reposiorios.AlbumRepository;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class AlbumService {

    @Inject
    private AlbumRepository repository;

    public void criarAlbum(AlbumFotos album) {
        marshalingExample(album);
        repository.save(album);
    }

    public AlbumFotos verAlbumJogo(long jogoId) {
        AlbumFotos album = repository.findByJogoId(jogoId);
        marshalingExample(album);
        return album;
    }

    private static void marshalingExample(AlbumFotos album){
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
