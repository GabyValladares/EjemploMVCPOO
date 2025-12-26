/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploiipa2025;

import javax.swing.JOptionPane;
import modelo.PersonaModelo;

/**
 *
 * @author hp
 */
public class Colecciones {

    public static void main(String[] args) {

        //LISTAS DE ESTÁTICAS 
        String[] listaEstudiantes = new String[7];
        listaEstudiantes[0] = "Oscar";
        //Declaración
        String[] listaEstudiantes1 = {"Oscar", "Isaac", "Israel", "Dickson", "Marco Antonio", "Alan", "Gaby"};
        //for 
//          String[]listaEstudiantes3=new String[7];   
//          for (int i = 0; i <listaEstudiantes3.length ; i++) {
//              listaEstudiantes3[i]=JOptionPane.showInputDialog("Ingrese un nombre"); 
//              System.out.println("*"+i+listaEstudiantes3[i]);
//        }

        //OBJETO COMPUESTOS O COMPLEJOS PERSONA
        PersonaModelo[] listaPersonas = new PersonaModelo[7];
        for (int i = 0; i < 7; i++) {
            PersonaModelo persona = new PersonaModelo();
            persona.setNombres(JOptionPane.showInputDialog("Ingrese nombre"));
            persona.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad")));
            persona.toString();
            listaPersonas[i] = persona;
            System.out.println("---" + listaPersonas[i]);

        }
        //EJERCICIO 3 
        //DATOS PRIMITIVOS
        int[] listNum = new int[Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la lista"))];
        for (int i = 0; i < listNum.length; i++) {
            listNum[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número del 1 al 10"));

        }
        //si el valor es múltiplo de 2 que se sume caso contrario que se liste
        int acumular = 0;
        String num="";
        for (int i : listNum) {
            if (i % 2 == 0) {
                acumular += i;
                num+=i+"-";
                
            } else {
                System.out.println("Estos no son números pares:"+i);
            }
        }
        System.out.println("La suma de los múltiplos de 2 es:"+acumular);
                System.out.println("El número es:"+num);
    }

}
