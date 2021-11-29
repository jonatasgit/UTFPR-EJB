/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import br.model.Jogada;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author default
 */
@Stateful
public class EjbJogada {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Jogada jogada;
    private List<Jogada> jogadas;
    
    @Resource( lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory factory;
    
    @Resource(lookup = "java/Fila")
    private Queue fila;

    public EjbJogada() {
        this.jogadas = new ArrayList<>(); 
        this.jogada = new Jogada();
    }

    public void addJogada(String jogador, Integer n1, Integer n2, Integer tentativa){
        System.out.println(">>>>>>>>>>>>>>>>> ENTROU NO EJB -- n1= " + n1+ " n1= " + n2 + " tent " + tentativa );
        if((n1 + n2) == tentativa){
            Boolean teveMudanca = false;
            if(jogadas.size() > 0){
                for(Jogada jog : jogadas){
                    if(jog.getJogador().equalsIgnoreCase(jogador)){
                        jog.setTotalPontos(jog.getTotalPontos()+1);
                        this.send();
                        teveMudanca = true;
                    }
                }
                if(!teveMudanca){
                     Jogada jnovo = new Jogada();
                     jnovo.setJogador(jogador);
                     jnovo.setTotalPontos(1);
                     jogadas.add(jnovo);
                     this.send();
                }
            } else {
                var pontuacao = jogada.getTotalPontos();
                jogada.setJogador(jogador);
                jogada.setTotalPontos(1);
                jogadas.add(jogada);
                this.send();
            }

            
        }
    }
    
    public List<Jogada> getJogadas(){
        return jogadas;
    }
    
    public void send(){
        try {
            JMSContext context = factory.createContext();
            context.createProducer().send(fila, "Novo jogador pontuando!");
        } catch (Exception e) {
            System.err.println("Erro ao gerar contexto");
        }
        
    }
}
