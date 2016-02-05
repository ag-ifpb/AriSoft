package br.edu.ifpb.pos.core.dto;

import br.edu.ifpb.pos.core.entidades.Jogo;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@XmlRootElement(name = "jogos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jogos{

    @XmlElement(name = "jogo")
    private List<Jogo> jogos;
    
    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    
}
