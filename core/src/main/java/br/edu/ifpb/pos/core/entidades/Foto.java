package br.edu.ifpb.pos.core.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa uma imagem.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
@Entity
@XmlRootElement
public class Foto {

    @Id
    @GeneratedValue
    private long id;
    private byte[] bytes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
    
}
