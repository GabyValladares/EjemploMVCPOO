/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.PersonaControlador;
import controlador.UsuarioControlador;
import modelo.PersonaModelo;
import modelo.UsuarioModelo;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
       
    // 1. Crear una instancia del Modelo (el DAO)
        // El DAO es el gestor de los datos PersonaModelo
//        PersonaModelo modelo = new PersonaModelo(); 
//
//        // 2. Crear una instancia de la Vista (la interfaz gráfica)
//        PersonaVista vista = new PersonaVista();
//
//        // 3. Crear una instancia del Controlador, pasándole el Modelo y la Vista
//        // Esto le da al Controlador los "cables" para mediar entre ambos.
//        PersonaControlador controlador = new PersonaControlador( modelo,vista);

        // 4. Iniciar la aplicación a través del Controlador
        // El método 'iniciar' es donde el Controlador configura los listeners
        // de la Vista y la hace visible.
        
        UsuarioModelo  usuario = new UsuarioModelo();
        PersonaUsuarioVista persona = new  PersonaUsuarioVista ();
        UsuarioControlador controlador = new UsuarioControlador (usuario, persona);

        controlador.iniciar();
    }    
}
