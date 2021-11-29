/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbJogada;
import br.ejb.EjbJogo;
import br.model.Jogada;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import lombok.Data;

/**
 *
 * @author default
 */
@Data
@Named(value = "jsfJogada")
@SessionScoped
public class JsfJogada implements Serializable {

    @EJB
    private EjbJogo ejbJogo;

    @EJB
    private EjbJogada ejbJogada;
    
    private String jogador;
    private Integer tentativa;

    /**
     * Creates a new instance of JsfJogada
     */
    public JsfJogada() {
    }
    
    public void addJogada( Integer n1, Integer n2){
        ejbJogada.addJogada(this.jogador, n1, n2, this.tentativa);
    }
    
    public List<Jogada> getAll(){
        return ejbJogada.getJogadas();
    }
    
    
    
}
