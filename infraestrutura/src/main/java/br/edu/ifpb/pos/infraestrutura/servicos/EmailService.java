package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.Email;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Serviço que possui funcionalidades referentes ao envio de e-mails
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class EmailService {

    @Inject
    private MailSender sender;

    /**
     * Instancia uma thread responsável por mandar o e-mail.
     * 
     * @param email contém as características do e-mail que deverá ser enviado
     */
    public void enviarEmail(Email email) {
        new EnviaEmail(email, sender).start();
    }

    /**
     * Thread responsável por enviar o e-mail.
     */
    private class EnviaEmail extends Thread {

        private Email email;
        private MailSender sender;

        public EnviaEmail(Email email, MailSender sender) {
            this.email = email;
            this.sender = sender;
        }
        
        /**
         * Utiliza-se do pacote org.springframework.mail para enviar o e-mail
         * desejado.
         */
        public void run() {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email.getDestinatario());
            mailMessage.setSubject(email.getAssunto());
            mailMessage.setText(email.getMensagem());
            sender.send(mailMessage);
        }
    }

}
