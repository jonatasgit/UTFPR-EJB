/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.data.crud;

import br.model.Jogo;
import java.util.Random;

/**
 *
 * @author default
 */
public class crudJogo {
    public Jogo obterJogo(){        
        Jogo j  = new Jogo();
        j.setNum1(77);
        j.setNum2(23);
        
        return j;
    }
    
    private Integer obterRandom(){
        return (int) (Math.random() * (100-1));
    }
}
