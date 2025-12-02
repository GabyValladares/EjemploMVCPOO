/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.PersonaModelo;
import modelo.UsuarioModelo;
import vista.PersonaUsuarioVista;
//import vista.UsuarioVista;

/**
 *
 * @author hp
 */
public class UsuarioControlador {
    //ATRIBUTOS
    private UsuarioModelo modelo;
    private PersonaUsuarioVista vista;
    
    //CONSTRUCTORES

    public UsuarioControlador() {
    }

    public UsuarioControlador(UsuarioModelo modelo, PersonaUsuarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    // Crea: PersonaModelo Y UsuarioModelo
  public void generarUsuario() {
        System.out.println("Iniciando Generacion Usuario ");
        
        // 1. RECUPERAR DATOS
        String alias = vista.getTxtAlias().trim();
        String clave = vista.getTxtClave().trim();
        String cedula = vista.getTxtCedula().trim();
        String nombre = vista.getTxtNombres().trim();
        String direccion = vista.getTxtDireccion().trim();
        String edadStr = vista.getTxtEdad().trim();
        
        System.out.println("Datos capturados:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Cédula: " + cedula);
        System.out.println("Edad: " + edadStr);
        System.out.println("Alias: " + alias);

        // 2. VALIDACIONES
        if (alias.isEmpty() || clave.isEmpty() || cedula.isEmpty() || 
            nombre.isEmpty() || direccion.isEmpty() || edadStr.isEmpty()) {
            vista.mostrarMensaje(" Todos los campos son obligatorios.");
            return;
        }

        // Validar edad
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
            if (edad <= 0) {
                vista.mostrarMensaje(" La edad debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("️ La edad debe ser un número válido.");
            return;
        }

        // Validar cédula (10 dígitos)
        if (cedula.length() != 10) {
            vista.mostrarMensaje("️ La cédula debe tener 10 dígitos.");
            return;
        }

        // 3. CREAR PERSONA
        System.out.println("Creando objeto PersonaModelo");
        PersonaModelo nuevaPersona = new PersonaModelo(nombre, edad, cedula, direccion);
        
        // Validar cédula con algoritmo
        if (!nuevaPersona.validarCedula(cedula)) {
            vista.mostrarMensaje("️ Cédula inválida.");
            return;
        }

        // 4. INSERTAR PERSONA EN BD
        System.out.println("Insertando persona en BDD");
        nuevaPersona.insertarPersona(nuevaPersona);
        
        // Verificar si se generó ID
        int idPersona = nuevaPersona.getIdPersona();
        System.out.println("ID Persona generado: " + idPersona);
        
        if (idPersona == 0) {
            vista.mostrarMensaje(" Error al guardar persona. Intente nuevamente.");
            return;
        }

        // 5. CREAR USUARIO
        System.out.println("Creando objeto UsuarioModelo");
        UsuarioModelo nuevoUsuario = new UsuarioModelo();
        nuevoUsuario.setAlias(alias);
        nuevoUsuario.setClave(clave);
        nuevoUsuario.setIdPersona(idPersona);  // Pasar el ID
        
        // 6. INSERTAR USUARIO EN BDD
        System.out.println("Insertando usuario en BDD");
        nuevoUsuario.insertarUsuario(nuevaPersona);

        // 7. MOSTRAR RESULTADO
        String resultado = "DATOS GUARDADOS\n" +
                          "ID Persona: " + idPersona + "\n" +
                          "Nombre: " + nombre + "\n" +
                          "Cédula: " + cedula + "\n" +
                          "Edad: " + edad + "\n" +
                          "Dirección: " + direccion + "\n" +
                          "Alias: " + alias + "\n" +
                          "Clave: " + clave ;
        
        vista.setCampoResultado(resultado);
        System.out.println("PROCESO COMPLETADO ");
        
    }
     public void iniciar() {
        // 1. Asignar el Controlador como oyente a los botones de la Vista
        vista.getBtnGuardar().addActionListener(e -> generarUsuario());
        //pv.getBtnListar().addActionListener(e -> actualizarListaPersonas());

        // 2. Mostrar la Vista
        vista.setVisible(true);
        //actualizarListaPersonas(); // Carga inicial
}
    
     
}
