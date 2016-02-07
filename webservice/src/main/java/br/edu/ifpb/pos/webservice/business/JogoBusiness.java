package br.edu.ifpb.pos.webservice.business;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.webservice.infraestrutura.interfaces.InfraestruturaService;
import br.edu.ifpb.pos.webservice.infraestrutura.interfaces.InfraestruturaServiceSingleton;
import java.rmi.RemoteException;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class JogoBusiness {

    private InfraestruturaService infraestruturaService;
    private final int PAGE_SIZE = 5;

    public JogoBusiness(){
        infraestruturaService = InfraestruturaServiceSingleton.getInstance();
    }

    public void salvarJogo(Jogo jogo) throws RemoteException {
        regrasParaSalvar(jogo);
        infraestruturaService.adicionarJogo(jogo);
    }
    
    public Jogo verJogo (long id){
        return infraestruturaService.verJogo(id);
    }
    
    public Jogos recuperarPagina (int page){
        return infraestruturaService.recuperarPaginaJogo(page, PAGE_SIZE);
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

    

}
