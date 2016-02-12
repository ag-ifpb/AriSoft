package br.edu.ifpb.pos.core.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Entity
@XmlRootElement(name="jogo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jogo {

    @Id
    @GeneratedValue
    private long id;
    private String objetivo;
    private String enredo;
    private String missao;
    private String local;
    private String horario;
    private String token;
    @Enumerated(EnumType.STRING)
    private JogoStatus status;
    @OneToOne (cascade = CascadeType.ALL)
    private Foto foto;
    @ManyToMany (fetch = FetchType.EAGER)
    private List<Membro> membrosNaoConfirmados;
    @ManyToMany (fetch = FetchType.EAGER)
    private List<Membro> membrosConfirmados;

    public List<Membro> getMembrosConfirmados() {
        return membrosConfirmados;
    }

    public void setMembrosConfirmados(List<Membro> membrosConfirmados) {
        this.membrosConfirmados = membrosConfirmados;
    }
    
    public JogoStatus getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(JogoStatus status) {
        this.status = status;
    }

    public List<Membro> getMembrosNaoConfirmados() {
        return membrosNaoConfirmados;
    }

    public void setMembrosNaoConfirmados(List<Membro> membrosNaoConfirmados) {
        this.membrosNaoConfirmados = membrosNaoConfirmados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    public int qtdMembros (){
        int qtd = 0;
        qtd += membrosConfirmados != null ? membrosConfirmados.size() : 0;
        qtd += membrosNaoConfirmados != null ? membrosNaoConfirmados.size() : 0;
        return qtd;
    }
    
}
