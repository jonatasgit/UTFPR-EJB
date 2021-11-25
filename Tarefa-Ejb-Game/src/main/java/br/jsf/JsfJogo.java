/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import br.ejb.EjbJogo;
import br.model.Jogo;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author default
 */
@Named(value = "jsfJogo")
@RequestScoped
public class JsfJogo {

    @EJB
    private EjbJogo ejbJogo;

    /**
     * Creates a new instance of JsfJogo
     */
    public JsfJogo() {
    }
    
    public Jogo getGame(){
        System.out.println("Entrou Jsf Jogo");
        Jogo j = ejbJogo.obterJogo();        
        System.err.println("JOGO - N1 " + j.getNum1() + " N2 - " + j.getNum2());
        return j;
    }
    
    
    
}
