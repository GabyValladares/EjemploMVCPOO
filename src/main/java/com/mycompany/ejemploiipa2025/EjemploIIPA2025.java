/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejemploiipa2025;

import controlador.UsuarioControlador;
//import controlador.UsuarioControlador;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import modelo.ConexionBDD;

import modelo.UsuarioModelo;
import vista.InicioSesionVista;
//import modelo.UsuarioModelo;

//import vista.UsuarioVista;

/**
 *
 * @author Usuario
 */
public class EjemploIIPA2025 {

    public static void main(String[] args) {
//        UsuarioModelo modelo = new UsuarioModelo();
//        UsuarioVista vista = new UsuarioVista();
////        UsuarioControlador controlador = new UsuarioControlador(modelo, vista);
//        
//        PersonaModelo modelo = new PersonaModelo();
//        PersonaVista vista = new  PersonaVista();
//         PersonaControlador controlador = new  PersonaControlador(modelo, vista);
//
    //controlador.iniciar();
        ConexionBDD base = new ConexionBDD();
        base.conectar();
        
     

//EJECUTAMOS EL INICIO DE SESIÓN
//ñññ
    UsuarioModelo modelo = new UsuarioModelo();
    InicioSesionVista vista = new   InicioSesionVista();
    UsuarioControlador controlador = new UsuarioControlador(modelo, vista);
    controlador.invocarInicioSesion();
        

    }
}
