package br.edu.ifpb.pos.core.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AlbumFotos {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private long jogoId;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @XmlElement(name = "fotos")
    private List<Foto> fotos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getJogoId() {
        return jogoId;
    }

    public void setJogoId(long jogoId) {
        this.jogoId = jogoId;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
    
}
