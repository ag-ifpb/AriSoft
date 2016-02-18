package br.edu.ifpb.pos.webapp.controller.forms;

/**
 * Classe que representa o formulario de criaçao de membros
 * 
 * @author douglasgabriel
 * @version 0.1
 */
public class AdicionarMembroForm {

    private String nome;
    private String email;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
