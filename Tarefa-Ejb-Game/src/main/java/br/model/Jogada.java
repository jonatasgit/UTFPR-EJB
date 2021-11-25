/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author default
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jogada {
    private Integer cod;
    private String Jogador;
    private Integer totalPontos = 0;    
}
