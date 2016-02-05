package br.edu.ifpb.pos.webapp.controller.services;

import br.edu.ifpb.pos.webapp.controller.forms.AdicionarJogoForm;
import java.rmi.RemoteException;

/**
 *
 * @author douglasgabriel
 */
public interface JogoService {
    
    public void criarJogo (AdicionarJogoForm form, byte[] imagem) throws RemoteException;
}
