/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploiipa2025;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Corredor extends Thread{
    private int numero;

    public Corredor() {
    }

    public Corredor(int numero) {
        this.numero = numero;
    }
     public int getNumero(){
         return numero;
     }
    public void setNumero(int numero){
        this.numero=numero;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Habilitado ejecución en paralelo"+""+numero);   
    }
    
    
}
