package br.edu.ifpb.pos.core.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Entity
public class AlbumFotos {

    @Id
    private long id;
    private String nome;
    @OneToMany
    private List<Foto> fotos;
    
}
