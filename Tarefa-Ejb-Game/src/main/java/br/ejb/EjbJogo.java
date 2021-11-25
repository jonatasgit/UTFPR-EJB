/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.ejb;

import br.data.crud.crudJogo;
import br.model.Jogo;
import javax.ejb.Stateless;

/**
 *
 * @author default
 */
@Stateless
public class EjbJogo {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Jogo obterJogo(){
        return new crudJogo().obterJogo();
    }
}
