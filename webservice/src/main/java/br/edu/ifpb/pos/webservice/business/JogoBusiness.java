package br.edu.ifpb.pos.webservice.business;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.Email;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.core.entidades.JogoStatus;
import br.edu.ifpb.pos.core.entidades.Membro;
import br.edu.ifpb.pos.webservice.infraestrutura.interfaces.InfraestruturaService;
import br.edu.ifpb.pos.webservice.infraestrutura.interfaces.InfraestruturaServiceSingleton;
import br.edu.ifpb.pos.webservice.utils.GenerateCodeUtils;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class JogoBusiness {

    private InfraestruturaService infraestruturaService;
    private final int PAGE_SIZE = 5;

    public JogoBusiness() {
        infraestruturaService = InfraestruturaServiceSingleton.getInstance();
    }

    public void salvarJogo(Jogo jogo) throws RemoteException {
        regrasParaSalvar(jogo);
        infraestruturaService.adicionarJogo(jogo);
    }

    public Jogo verJogo(long id) {
        return infraestruturaService.verJogo(id);
    }

    public void adicionarMembrosAoJogo(long idJogo, String... emails) {
        List<Membro> membros = new ArrayList<>();
        Jogo jogo = infraestruturaService.verJogo(idJogo);
        if (jogo != null) {
            for (String email : emails) {
                Membro membro = infraestruturaService.verMembro(email);
                if (membro != null) {
                    membros.add(membro);
                    infraestruturaService.enviarEmail(new Email().comAssunto("Você foi adicionado a um novo jogo")
                            .comDestinatario(email).comMensagem("Você foi convidado a participar de um novo jogo"
                                    + " para confirmar sua participação acesse o link: http://localhost:8080/jogo/confirmar/"+jogo.getToken()));
                }
            }
            Membro[] arrayMembros = new Membro[membros.size()];
            infraestruturaService.adicionarMembrosAoJogo(idJogo, membros.toArray(arrayMembros));
        }
    }

    public Jogos recuperarPagina(int page) {
        return infraestruturaService.recuperarPaginaJogo(page, PAGE_SIZE);
    }

    public void cancelarJogo(long jogoId) {
        Jogo jogo = verJogo(jogoId);
        jogo.setStatus(JogoStatus.CANCELADO);
        infraestruturaService.atualizarJogo(jogo);
        enviarEmailMudancaStatus(jogo, JogoStatus.CANCELADO);
    }

    public void encerrarJogo(long jogoId) {
        Jogo jogo = verJogo(jogoId);
        jogo.setStatus(JogoStatus.ENCERRADO);
        infraestruturaService.atualizarJogo(jogo);
        enviarEmailMudancaStatus(jogo, JogoStatus.ENCERRADO);
    }
    
    private void enviarEmailMudancaStatus (Jogo jogo, JogoStatus status){
        String mensagem = "", assunto = "";
        if (status.equals(JogoStatus.CANCELADO)){
            mensagem = "Um jogo que você foi convidado foi cancelado. Acesse o link para visualizá-lo: "
                    + "http://localhost:8080/jogo/"+jogo.getId();
            assunto = "Jogo cancelado";
        }
        if (status.equals(JogoStatus.ENCERRADO)){
            mensagem = "Um jogo que você foi convidado foi encerrado. Acesse o link para visualizá-lo: "
                    + "http://localhost:8080/jogo/"+jogo.getId();
            assunto = "Jogo encerrado";
        }
        for (Membro membro : jogo.getMembrosConfirmados()){
            infraestruturaService.enviarEmail(new Email().comAssunto(assunto).comMensagem(mensagem).comDestinatario(membro.getEmail()));
        }
        for (Membro membro : jogo.getMembrosNaoConfirmados()){
            infraestruturaService.enviarEmail(new Email().comAssunto(assunto).comMensagem(mensagem).comDestinatario(membro.getEmail()));
        }
    }

    private void regrasParaSalvar(Jogo jogo) throws RemoteException {
        try {
            if (jogo.getEnredo().isEmpty()) {
                throw new RemoteException("Campo enredo está vazio");
            }
            if (jogo.getFoto().getBytes().length == 0) {
                throw new RemoteException("Campo foto está vazio");
            }
            if (jogo.getLocal().isEmpty()) {
                throw new RemoteException("Campo local está vazio");
            }
            if (jogo.getMissao().isEmpty()) {
                throw new RemoteException("Campo missão está vazio");
            }
            if (jogo.getObjetivo().isEmpty()) {
                throw new RemoteException("Campo objetivo está vazio");
            }
            if (jogo.getStatus() == null) {
                jogo.setStatus(JogoStatus.ATIVO);
            }
            jogo.setToken(GenerateCodeUtils.generateCode("", 8, jogo.getObjetivo(), System.currentTimeMillis()));
        } catch (Exception e) {
            throw new RemoteException();
        }
    }

}
