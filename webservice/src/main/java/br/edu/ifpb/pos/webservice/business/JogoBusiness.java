package br.edu.ifpb.pos.webservice.business;

import br.edu.ifpb.pos.core.dto.Jogos;
import br.edu.ifpb.pos.core.entidades.AlbumFotos;
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
 * Classe contendo regras de negócio referentes à manipulação da entidade 
 * {@link Jogo}.
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

    /**
     * Verifica a consistência das informações referentes ao jogo, caso estejam
     * corretas, aciona o serviço básico para adição de jogo.
     * 
     * @throws RemoteException caso as informações não estejam consistentes.
     */
    public void salvarJogo(Jogo jogo) throws RemoteException {
        regrasParaSalvar(jogo);
        infraestruturaService.adicionarJogo(jogo);
    }

    /**
     * Recupera um jogo através do seu identificador.
     * 
     * @param id identificador do jogo que se deseja recuperar.
     */
    public Jogo verJogo(long id) {
        return infraestruturaService.verJogo(id);
    }
    
    /**
     * Recupera um jogo através do seu token único.
     * 
     * @param token token do jogo que se deseja recuperar.
     */
    public Jogo verJogo(String token) {
        return infraestruturaService.verJogoPeloToken(token);
    }

    /**
     * Adiciona membros a um jogo.
     * 
     * @param idJogo identificador do jogo que deve ter os membros adicionados.
     * @param emails e-mails dos membros que devem ser adicionados ao jogo.
     */
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
                                    + " para confirmar sua participação acesse o link: http://localhost:8080/jogos/jogo/confirmar/" + jogo.getToken()+"?email="+email));
                }
            }
            Membro[] arrayMembros = new Membro[membros.size()];
            infraestruturaService.adicionarMembrosAoJogo(idJogo, membros.toArray(arrayMembros));
        }
    }

    /**
     * Recupera uma página de jogos.
     * 
     * @param page número da página que deve ser recuperada.
     */
    public Jogos recuperarPagina(int page) {
        return infraestruturaService.recuperarPaginaJogo(page, PAGE_SIZE);
    }
    
    /**
     * Recupera uma página apenas com jogos realizados.
     */
    public Jogos recuperarPaginaRealizados(int page){
        return infraestruturaService.recuperarPaginaJogoRealizados(page, PAGE_SIZE);
    }
    
    /**
     * Adiciona um album de fotos de um jogo caso o mesmo já tenha sido encerrado.
     */
    public void adicionarAlbumJogo (AlbumFotos album){
        Jogo jogo = infraestruturaService.verJogo(album.getJogoId());
        if (jogo != null && jogo.getStatus().equals (JogoStatus.ENCERRADO))
            infraestruturaService.criarAlbum(album);
    }
    
    /**
     * Confirma presença de um membro em um jogo.
     * 
     * @param email e-mail do membro que confirmou presença.
     * @param token token único do jogo o qual o membro confirmou a presença.
     */
    public void confirmarPresencaMembro (String email, String token){
        Jogo jogo = infraestruturaService.verJogoPeloToken(token);
        Membro membro = infraestruturaService.verMembro(email);
        if (membro != null){
            if (jogo.getMembrosNaoConfirmados().contains(membro)){
                jogo.getMembrosNaoConfirmados().remove(membro);
                if (jogo.getMembrosConfirmados() == null)
                    jogo.setMembrosConfirmados(new ArrayList<>());
                jogo.getMembrosConfirmados().add(membro);
                infraestruturaService.atualizarJogo(jogo);
            }
        }
    }

    /**
     * Cancela um jogo e notifica os membros via e-mail.
     * 
     * @param jogoId identificador do jogo que deverá ser cancelado.
     */
    public void cancelarJogo(long jogoId) {
        Jogo jogo = verJogo(jogoId);
        jogo.setStatus(JogoStatus.CANCELADO);
        infraestruturaService.atualizarJogo(jogo);
        new EnviaEmailThread(jogo, JogoStatus.CANCELADO).start();
    }

    /**
     * Encerra um jogo e notifica os membros via e-mail.
     * 
     * @param jogoId identificador do jogo que deverá ser encerrado.
     */
    public void encerrarJogo(long jogoId) {
        Jogo jogo = verJogo(jogoId);
        jogo.setStatus(JogoStatus.ENCERRADO);
        infraestruturaService.atualizarJogo(jogo);
        new EnviaEmailThread(jogo, JogoStatus.ENCERRADO).start();
    }

    /**
     * Thread responsável por enviar e-mail de notificação para membros.
     */
    private class EnviaEmailThread extends Thread {

        private Jogo jogo;
        private JogoStatus status;

        public EnviaEmailThread(Jogo jogo, JogoStatus status) {
            this.jogo = jogo;
            this.status = status;
        }
        
        /**
         * Constroi a mensagem de e-mail dependendo do Status do jogo informado e
         * em seguida acessa o serviço básico de envio de e-mail.
         */
        public void run() {
            String mensagem = "", assunto = "";
            if (status.equals(JogoStatus.CANCELADO)) {
                mensagem = "Um jogo que você foi convidado foi cancelado. Acesse o link para visualizá-lo: "
                        + "http://localhost:8080/?id=" + jogo.getId();
                assunto = "Jogo cancelado";
            }
            if (status.equals(JogoStatus.ENCERRADO)) {
                mensagem = "Um jogo que você foi convidado foi encerrado. Acesse o link para visualizá-lo: "
                        + "http://localhost:8080/?id=" + jogo.getId();
                assunto = "Jogo encerrado";
            }
            if (jogo.getMembrosConfirmados() != null) {
                for (Membro membro : jogo.getMembrosConfirmados()) {
                    infraestruturaService.enviarEmail(new Email().comAssunto(assunto).comMensagem(mensagem).comDestinatario(membro.getEmail()));
                }
            }
            if (jogo.getMembrosNaoConfirmados() != null) {
                for (Membro membro : jogo.getMembrosNaoConfirmados()) {
                    infraestruturaService.enviarEmail(new Email().comAssunto(assunto).comMensagem(mensagem).comDestinatario(membro.getEmail()));
                }
            }
        }
    }

    /**
     * Método responsável por verificar a consistência das informações do jogo
     * que deverá ser salvo.
     * 
     * @throws RemoteException caso algum dado não esteja consistente.
     */
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
