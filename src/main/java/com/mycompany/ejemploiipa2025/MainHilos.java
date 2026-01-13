/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploiipa2025;

/**
 *
 * @author hp
 */
public class MainHilos {

    public static void main(String[] args) {
//
//        Corredor c10 = new Corredor(10);
//        Corredor c3 = new Corredor(3);
//        Corredor c1 = new Corredor(1);
//        Corredor c5 = new Corredor(5);
//
//        Thread h1 = new Thread(c10);
//        Thread h2 = new Thread(c3);
//        Thread h3 = new Thread(c1);
//        Thread h4 = new Thread(c5);
//        h1.start();
//        h2.start();
//        h3.start();
//        h4.start();
//        Carro c10 = new Carro(10);
//        Carro c3 = new Carro(3);
//        Carro c1 = new Carro(1);
//        Carro c5 = new Carro(5);
//
//        Thread h1 = new Thread(c10);
//        Thread h2 = new Thread(c3);
//        Thread h3 = new Thread(c1);
//        Thread h4 = new Thread(c5);
//        h1.start();
//        h2.start();
//        h3.start();
//        h4.start();

        // Creamos las instancias de la tarea
        Thread hilo1 = new Thread(new Contador("Hilo A"));
        System.out.println("------"+hilo1.getState()); 
        Thread hilo2 = new Thread(new Contador("Hilo B"));
         Thread hilo3 = new Thread(new Contador("Hilo C"));

        // Iniciamos los hilos
        hilo1.start();
        System.out.println("------"+hilo1.getState()); 
        hilo2.start();
        hilo3.start();
        
        System.out.println("------"+hilo1.getState()); 
        
        System.out.println("=> El hilo principal sigue funcionando...");
        System.out.println("------"+hilo1.getState()); 
    }
}
