/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.PersonaModelo;
import vista.PersonaVista;

/**
 *
 * @author Usuario
 */
public class PersonaControlador {

    private PersonaModelo pm;
    private PersonaVista pv;

    public PersonaControlador() {
    }

    public PersonaControlador(PersonaModelo pm, PersonaVista pv) {
        this.pm = pm;
        this.pv = pv;
    }

    public void manejarPersona() {
        //RECUPERO LOS DATOS
        String nombre = pv.getCampoNombres();
        String cedula = pv.getCampoCedula();
        String direccion= pv.getCampoDireccion();
        int edad=pv.getCampoEdad();
        // VALIDO CAMPOS OBLIGATORIOS
            if (nombre.isEmpty() || cedula.isEmpty() || direccion.isEmpty()) {
                pv.mostrarMensaje("Todos los campos (Nombre, Cédula, Dirección) son obligatorios.");
                return;
            }

            // VALIDO LA EDAD
            if (edad <= 0) {
                pv.mostrarMensaje("La edad debe ser mayor a 0.");
                return;
            }

            // VALIDO LA CÉDULA (usando el método del modelo)
            if (cedula.length() != 10) {
                pv.mostrarMensaje("La cédula debe tener exactamente 10 dígitos.");
                return;
            }

            // Validar la cédula con el método del modelo (PersonaModelo)
            boolean esCedulaValida = pm.validarCedula(cedula); // <-- ¡CORREGIDO!

            if (!esCedulaValida) {
                pv.mostrarMensaje("La cédula ingresada no es válida.");
                return;
            }
        //SI TODO OK ARMO EL MODELO 
        PersonaModelo nuevaPersona=new PersonaModelo(nombre, edad, cedula, direccion);
        nuevaPersona.insertarPersona(nuevaPersona);

//MOSTRAR EL TOSTRING
        pv.setCampoResultado(nuevaPersona.toString());
    }

    public void guardarPersona(PersonaVista pv, PersonaModelo pm) {

    }
    
    public void iniciar() {
    // 1. Asignar el Controlador como oyente a los botones de la Vista
    pv.getBtnGuardar().addActionListener(e -> manejarPersona());
    //pv.getBtnListar().addActionListener(e -> actualizarListaPersonas());
    
    // 2. Mostrar la Vista
    pv.setVisible(true);
    //actualizarListaPersonas(); // Carga inicial
}

}
