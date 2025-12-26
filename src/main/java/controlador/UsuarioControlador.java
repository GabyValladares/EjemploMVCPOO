/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.PersonaModelo;
import modelo.UsuarioModelo;
import vista.InicioSesionVista;
import vista.PersonaUsuarioVista;


/**
 *
 * @author hp
 */
public class UsuarioControlador {
    //ATRIBUTOS
    private UsuarioModelo modelo;
    private PersonaUsuarioVista vista;
    private InicioSesionVista vistaSesion;
    
    //CONSTRUCTORES

    public UsuarioControlador() {
    }

    public UsuarioControlador(UsuarioModelo modelo, PersonaUsuarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
      public UsuarioControlador(UsuarioModelo modelo, InicioSesionVista vista) {
        this.modelo = modelo;
        this.vistaSesion = vista;
    }
      
    //MÉTODOS
    public void generarUsuario(){
        // RECUPERAR LA INFORMACIÓN DEL FRONTEND

        String alias = vista.getTxtAlias().trim();
        String clave = vista.getTxtClave().trim();
        String cedula = vista.getTxtCedula().trim();
        String nombre = vista.getTxtNombres().trim();
   
        String direccion= vista.getTxtDireccion();
        String edad=vista.getTxtEdad();
        
    
   
        
        //COMPROBAR LOS DATOS INGRESADOS POR EL USUARIO
        //OR u O ->||
        //AND o y -> &&
        // VALIDACIÓN CORRECTA: campos vacíos 
        if (alias.isEmpty() || clave.isEmpty()) 
         {
        vista.mostrarMensaje("Todos los campos son obligatorios. Por favor complételos.");
        return;
        }

    //  SI TODO ESTÁ CORRECTA INICIALIZAMOS EL MODELO
        PersonaModelo nuevaPersona=new PersonaModelo();
        UsuarioModelo nuevoUsuario=new UsuarioModelo();
        nuevoUsuario.setAlias(alias);
        nuevoUsuario.setClave(clave);
        nuevaPersona.setNombres(nombre);
        nuevaPersona.setDireccion(direccion);
        nuevaPersona.setEdad(Integer.parseInt(edad));
        nuevaPersona.setCedula(cedula);
        nuevaPersona.insertarPersona(nuevaPersona);
        nuevoUsuario.insertarUsuario(nuevaPersona);
        
        vista.setCampoResultado(nuevoUsuario.toString());
        

    }
    public void validarInicioSesion(){
        String alias= vistaSesion.getCampoAlias();
        String clave= vistaSesion.getCampoClave();
        
        if (alias.isEmpty() && clave.isEmpty()){
            vista.mostrarMensaje("Todos los campos son obligatorios. Por favor complételos");
        return;
            }
        modelo.setAlias(alias);
        modelo.setClave(clave);
        modelo.validarCredenciales(modelo);
        
        boolean resultadoInicioSesion=modelo.validarCredenciales(modelo);
        
         if (resultadoInicioSesion){
             PersonaUsuarioVista persona=new PersonaUsuarioVista();
             persona.setVisible(true);
         
         }
        
        
        
    
    }
    
     public void iniciar() {
        // 1. Asignar el Controlador como oyente a los botones de la Vista
        vista.getBtnGuardar().addActionListener(e -> generarUsuario());
        //pv.getBtnListar().addActionListener(e -> actualizarListaPersonas());

        // 2. Mostrar la Vista
        vista.setVisible(true);
        //actualizarListaPersonas(); // Carga inicial
    }
    public void invocarInicioSesion() {
          // 1. Asignar el Controlador como oyente a los botones de la Vista
          vistaSesion.getIniciarSesion().addActionListener(e -> validarInicioSesion());
          //pv.getBtnListar().addActionListener(e -> actualizarListaPersonas());

          // 2. Mostrar la Vista
          vistaSesion.setVisible(true);
          //actualizarListaPersonas(); // Carga inicial
      }
}
