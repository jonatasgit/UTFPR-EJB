/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import br.model.Jogada;
import javax.ejb.Stateful;

/**
 *
 * @author default
 */
@Stateful
public class EjbJogada {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Jogada jogada;

    public EjbJogada() {
        jogada = new Jogada();
    }

    public void addJogada(String jogador, Integer n1, Integer n2, Integer tentativa){
        System.out.println(">>>>>>>>>>>>>>>>> ENTROU NO EJB -- n1= " + n1+ " n1= " + n2 + " tent " + tentativa );
        if((n1 + n2) == tentativa){
            var pontuacao = jogada.getTotalPontos();
            jogada.setJogador(jogador);
            jogada.setTotalPontos(pontuacao + 1);
        }
    }
    
    public Jogada getJogada(){
        return jogada;
    }
}
