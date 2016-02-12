package br.edu.ifpb.pos.core.entidades;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@XmlRootElement
public class Email {

    private String destinatario;
    private String assunto;
    private String mensagem;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Email comDestinatario (String destinatario){
        this.destinatario = destinatario;
        return this;
    }
    public Email comAssunto (String assunto){
        this.assunto = assunto;
        return this;
    }
    public Email comMensagem (String mensagem){
        this.mensagem = mensagem;
        return this;
    }
    
}
