/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploiipa2025;

/**
 *
 * @author hp
 */
public class Contador implements Runnable{
    
    private String nombre;

    public Contador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(nombre + " en el paso: " + i);
                // Pausamos el hilo 500ms para notar la simultaneidad
                Thread.sleep(500); 
                
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
        System.out.println("--- " + nombre + " ha finalizado ---");
    }
}

