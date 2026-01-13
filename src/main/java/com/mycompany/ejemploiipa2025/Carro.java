/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploiipa2025;

/**
 *
 * @author hp
 */
public class Carro implements Runnable {
    private int numero;

    public Carro() {
    }

    public Carro(int numero) {
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
          System.out.println("Habilitado ejecución en paralelo"+""+numero);   
    
         }
    
}
