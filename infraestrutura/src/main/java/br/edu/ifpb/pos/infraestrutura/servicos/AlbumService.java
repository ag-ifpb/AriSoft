package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.AlbumFotos;
import br.edu.ifpb.pos.infraestrutura.reposiorios.AlbumRepository;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * Serviço contendo operações referentes à entidade {@link AlbumFotos}.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class AlbumService {

    @Inject
    private AlbumRepository repository;

    /**
     * Salva um novo album no banco de dados.
     */
    public void criarAlbum(AlbumFotos album) {
        marshalingExample(album);
        repository.save(album);
    }

    /**
     * Recupera um album associado à um jogo.
     * 
     * @param jogoId identificador do jogo que deverá ter seu album procurado.
     */
    public AlbumFotos verAlbumJogo(long jogoId) {
        AlbumFotos album = repository.findByJogoId(jogoId);
        marshalingExample(album);
        return album;
    }

    /**
     * Método utilizado para fins de teste. O mesmo faz a conversão de uma entidade
     * do tipo {@link AlbumFotos} para um formato XML e imprime o resultado no console.
     */
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
