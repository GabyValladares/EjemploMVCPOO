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

//        //LISTAS DE ESTÁTICAS 
//        String[] listaEstudiantes = new String[7];
//        listaEstudiantes[0] = "Oscar";
//        //Declaración
//        String[] listaEstudiantes1 = {"Oscar", "Isaac", "Israel", "Dickson", "Marco Antonio", "Alan", "Gaby"};
//        //for 
////          String[]listaEstudiantes3=new String[7];   
////          for (int i = 0; i <listaEstudiantes3.length ; i++) {
////              listaEstudiantes3[i]=JOptionPane.showInputDialog("Ingrese un nombre"); 
////              System.out.println("*"+i+listaEstudiantes3[i]);
////        }
//
//        //OBJETO COMPUESTOS O COMPLEJOS PERSONA
//        PersonaModelo[] listaPersonas = new PersonaModelo[7];
//        for (int i = 0; i < 7; i++) {
//            PersonaModelo persona = new PersonaModelo();
//            persona.setNombres(JOptionPane.showInputDialog("Ingrese nombre"));
//            persona.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad")));
//            persona.toString();
//            listaPersonas[i] = persona;
//            System.out.println("---" + listaPersonas[i]);
//
//        }
//        //EJERCICIO 3 
//        //DATOS PRIMITIVOS
//        int[] listNum = new int[Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la lista"))];
//        for (int i = 0; i < listNum.length; i++) {
//            listNum[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número del 1 al 10"));
//
//        }
//        //si el valor es múltiplo de 2 que se sume caso contrario que se liste
//        int acumular = 0;
//        String num="";
//        for (int i : listNum) {
//            if (i % 2 == 0) {
//                acumular += i;
//                num+=i+"-";
//                
//            } else {
//                System.out.println("Estos no son números pares:"+i);
//            }
//        }
//        System.out.println("La suma de los múltiplos de 2 es:"+acumular);
//                System.out.println("El número es:"+num);
//    
//    Ejercicio 1:
//Realizar un programa que inicialice una lista con 10 valores aleatorios (del 1 al 10) y posteriormente muestre en
//pantalla cada elemento de la lista junto con su cuadrado y su cubo.
        //CREAR LA LISTA
//        double[] listaAleatorios = new double[10];
//        //INICIALIZAR 
//        for (int i = 0; i < 10; i++) {
//            //AUXILIARES
//            double cuadrado = 0;
//            double cubo = 0;
//            //uso de números randomicos
//            listaAleatorios[i] = (Math.random() * 10 + 1);
//            cuadrado = Math.pow(listaAleatorios[i], 2);
//            cubo = Math.pow(listaAleatorios[i], 3);
//            System.out.println("Posición" + i + ":" + listaAleatorios[i] + "\n"
//                    + "El número elevado al cuadrado es:" + cuadrado + "\n"
//                    + "El número elevado al cubo es:" + cubo);
//
//            //PENDIENTE: QUE EL NÚMERO SEA ENTERO ,2 DECIMALES
//        }
////Ejercicio 2:
////Crea una lista e inicializala con 5 cadenas de caracteres leídas por teclado. 
////Copia los elementos de la lista en otra lista pero en orden inverso,
////y muestra sus elementos por la pantalla.
//        int n = 4;
//        String[] listados = new String[5];
//        String[] Listauno = new String[5];
//        String[] listaTres = new String[5];
//        for (int i = 0; i < 5; i++) {
//            Listauno[i] = JOptionPane.showInputDialog("ingrese una palabra");
//            listados[n] = Listauno[i];
//            n--;
//
//        }
//        int y = 0;
//        for (String puntero : Listauno) {
//            String reversa = "";
//
//            for (int i = puntero.length() - 1; i >= 0; i--) {
//                reversa += puntero.charAt(i);
//            }
//            listaTres[y] = reversa;
//            y++;
//            System.out.println("puntero:" + puntero + "\n" + "reversa:" + reversa);
//        }
//
//        for (String puntero : listados) {
//            System.out.println("puntero2:" + puntero);
//
//        }
//        for (String puntero : listaTres) {
//            System.out.println("puntero3:" + puntero);
//
//        }

        //Ejercicio 3:
//Se quiere realizar un programa que lea por teclado las 5 notas obtenidas por un alumno 
//(comprendidas entre 0 y 10). A continuación debe mostrar todas las notas, la nota media, 
//la nota más alta que ha sacado y la menor
        double[] listaNotas = new double[5];
        double prom = 0;
        double max = 0;
        double min = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            listaNotas[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nota 1"));
             System.out.println("Los números son:"+i+" "+listaNotas[i]);
        }
        min=listaNotas[0];
        for (double l : listaNotas) {
           
            prom += (l) / listaNotas.length;
                    if(l>max){
                        max=l;
                    }
                    if(l<min){
                        min=l;
                    }
        }
        System.out.println("el promedio es:"+prom+"\n"+
                "El mayor es:"+max+"\n"+
                "El menor es:"+min);
    }

}

//
//

