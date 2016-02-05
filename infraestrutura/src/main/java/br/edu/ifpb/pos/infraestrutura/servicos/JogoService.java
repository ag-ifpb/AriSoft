package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.infraestrutura.reposiorios.JogoRepository;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.infraestrutura.servicos.JogoService", serviceName = "JogoService")
@Named
public class JogoService {

    @Inject
    private JogoRepository repositorio;

    public void criar(Jogo jogo) {
        repositorio.save(jogo);
    }

    public Jogos recuperarPagina(int page, int pageSize) {
        Jogos lista = new Jogos();
        lista.setJogos(repositorio.findAll(new PageRequest(page, pageSize)).getContent());
        return lista;
    }

}
