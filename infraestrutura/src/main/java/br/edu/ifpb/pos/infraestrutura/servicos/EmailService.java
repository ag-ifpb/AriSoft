package br.edu.ifpb.pos.infraestrutura.servicos;

import br.edu.ifpb.pos.core.entidades.Email;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class EmailService {

    @Inject
    private MailSender sender;
    
    public void enviarEmail (Email email){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(email.getDestinatario());
        mailMessage.setSubject(email.getAssunto());
        mailMessage.setText(email.getMensagem());
        sender.send(mailMessage);
    }
    
}
