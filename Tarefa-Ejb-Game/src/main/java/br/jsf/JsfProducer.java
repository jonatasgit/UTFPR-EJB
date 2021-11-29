/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.jsf;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author default
 */
@Named(value = "jsfProducer")
@RequestScoped
public class JsfProducer {

    @Resource( lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory factory;
    
    @Resource(lookup = "java/Fila")
    private Queue fila;
    /**
     * Creates a new instance of JsfProducer
     */
    public JsfProducer() {
    }
    
    public void send(){
        try {
            JMSContext context = factory.createContext();
            context.createProducer().send(fila, "Olá mundinho");
        } catch (Exception e) {
            System.err.println("Erro ao gerar contexto");
        }
        
    }
}
