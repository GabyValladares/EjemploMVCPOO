/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.UsuarioModelo;
import vista.UsuarioVista;

/**
 *
 * @author hp
 */
public class UsuarioControlador {
    //ATRIBUTOS
    private UsuarioModelo modelo;
    private UsuarioVista vista;
    
    //CONSTRUCTORES

    public UsuarioControlador() {
    }

    public UsuarioControlador(UsuarioModelo modelo, UsuarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    //MÉTODOS
    public void generarUsuario(){
        // RECUPERAR LA INFORMACIÓN DEL FRONTEND
        String nombre = vista.getCampoNombre().trim();// trim me sirve para eliminar los espacion en blanco
        String cedula = vista.getCampoCedula().trim();
        String direccion = vista.getCampoDireccion().trim();
        String alias = vista.getCampoAlias().trim();
        String clave = vista.getCampoClave().trim();
        
        // Validar que la edad sea un número válido
        int edad;
        try {
            edad = vista.getCampoEdad();  
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("La edad debe ser un número válido.");
            return;
        }
        // Validar que la edad sea positiva
        if (edad <= 0) {
            vista.mostrarMensaje("La edad debe ser mayor que cero.\nNo se permiten edades negativas ni cero.");
            return;
        }
        
        //COMPROBAR LOS DATOS INGRESADOS POR EL USUARIO
        //OR u O ->||
        //AND o y -> &&
        // VALIDACIÓN CORRECTA: campos vacíos 
        if (nombre.isEmpty() || cedula.isEmpty() || direccion.isEmpty() ||
        alias.isEmpty() || clave.isEmpty()) {
        vista.mostrarMensaje("Todos los campos son obligatorios. Por favor complételos.");
        return;
        }

        // Validar longitud de cédula (10 dígitos)
        if (cedula.length() != 10) {
            vista.mostrarMensaje("La cédula debe tener exactamente 10 dígitos.");
            return;
        }
        

       
        
    //  SI TODO ESTÁ CORRECTA INICIALIZAMOS EL MODELO
        UsuarioModelo nuevoUsuario=new UsuarioModelo( nombre, cedula, direccion, alias, clave, edad);
        vista.setCampoResultado(nuevoUsuario.toString());
        
        
    }
     public void iniciar() {
        // 1. Asignar el Controlador como oyente a los botones de la Vista
        vista.getCampoCrear().addActionListener(e -> generarUsuario());
        //pv.getBtnListar().addActionListener(e -> actualizarListaPersonas());

        // 2. Mostrar la Vista
        vista.setVisible(true);
        //actualizarListaPersonas(); // Carga inicial
}
    
}
