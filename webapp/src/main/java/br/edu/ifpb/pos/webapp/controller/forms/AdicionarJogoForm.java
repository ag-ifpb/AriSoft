package br.edu.ifpb.pos.webapp.controller.forms;

/**
 * Classe que representa o formulario de criaçao de jogos
 * 
 * @author douglasgabriel
 * @version 0.1
 */
public class AdicionarJogoForm {

    private String objetivo;
    private String enredo;
    private String missao;
    private String local;
    private String horario;

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getEnredo() {
        return enredo;
    }

    public void setEnredo(String enredo) {
        this.enredo = enredo;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
