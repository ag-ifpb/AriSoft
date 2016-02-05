package br.edu.ifpb.pos.webservice.business;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.webservice.infraestrutura.interfaces.JogoService;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class JogoBusiness {

    private JogoService jogoService;
    private final int PAGE_SIZE = 5;

    public JogoBusiness() throws MalformedURLException {
        jogoService = recuperarJogoService();
    }

    public void salvarJogo(Jogo jogo) throws RemoteException {
        regrasParaSalvar(jogo);
        jogoService.criar(jogo);
    }
    
    public Jogos recuperarPagina (int page){
        return jogoService.recuperarPagina(page, PAGE_SIZE);
    }

    private void regrasParaSalvar(Jogo jogo) throws RemoteException {
        try {
            if (jogo.getEnredo().isEmpty()) throw new RemoteException("Campo enredo está vazio");
            if (jogo.getFoto().getBytes().length == 0) throw new RemoteException("Campo foto está vazio");
            if (jogo.getLocal().isEmpty()) throw new RemoteException("Campo local está vazio");
            if (jogo.getMissao().isEmpty()) throw new RemoteException("Campo missão está vazio");
            if (jogo.getObjetivo().isEmpty()) throw new RemoteException("Campo objetivo está vazio");
        } catch (Exception e) {
            throw new RemoteException();
        }
    }

    private JogoService recuperarJogoService() throws MalformedURLException {
        URL url = new URL("http://localhost:8081/jogo?wsdl");
        QName qname = new QName("http://servicos.infraestrutura.pos.ifpb.edu.br/", "JogoService");
        Service service = Service.create(url, qname);
        return service.getPort(JogoService.class);
    }

}
