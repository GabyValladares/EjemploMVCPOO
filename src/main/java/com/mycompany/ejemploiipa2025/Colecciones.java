/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploiipa2025;

import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Colecciones {
    
    public static void main(String[] args) {
        
        //LISTAS DE ESTÁTICAS 
        String[]listaEstudiantes=new String[7];
        listaEstudiantes[0]="Oscar";
        //Declaración
       String[] listaEstudiantes1={"Oscar","Isaac","Israel","Dickson","Marco Antonio","Alan", "Gaby"};
        //for 
          String[]listaEstudiantes3=new String[7];   
          for (int i = 0; i <listaEstudiantes3.length ; i++) {
              listaEstudiantes3[i]=JOptionPane.showInputDialog("Ingrese un nombre"); 
              System.out.println("*"+i+listaEstudiantes3[i]);
        }
        
        
        
        
    }
    
}
