/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejemploiipa2025;

import controlador.UsuarioControlador;
import modelo.UsuarioModelo;
import vista.UsuarioVista;

/**
 *
 * @author Usuario
 */
public class EjemploIIPA2025 {

    public static void main(String[] args) {
        UsuarioModelo modelo = new UsuarioModelo();
        UsuarioVista vista = new UsuarioVista();
        UsuarioControlador controlador = new UsuarioControlador(modelo, vista);

        controlador.iniciar();
    }
}
