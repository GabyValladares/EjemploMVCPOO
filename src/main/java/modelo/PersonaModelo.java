/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PersonaModelo {
    private int idPersona;
    private String nombres;
    private int edad;
    private String cedula;
    private String direccion;
    
   ConexionBDD conectar = new ConexionBDD();
        //CLASE QUE ME PERMITA CONECTARME DIRECTAMENTE A MYSQL
        Connection conectado = (Connection) conectar.conectar();
      
        
    public PersonaModelo() {
    }

    public PersonaModelo(String nombres, int edad, String cedula, String direccion) {
        this.nombres = nombres;
        this.edad = edad;
        this.cedula = cedula;
        this.direccion = direccion;
    }
    //FALTO AGREGAR EL GET DEL ID
     public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void insertarPersona(PersonaModelo p) {
        // DECLARAR 'ejecutar' como VARIABLE LOCAL
        PreparedStatement ejecutar = null;
        ResultSet idsGenerados = null;  // Declarar aquí para cerrar en finally

       try {
           // 1. Insertar la persona usando parámetros 
           String sentenciaSQL = "INSERT INTO personas(Nombres, Cedula, Direccion, Edad) " +
                                "VALUES(?, ?, ?, ?)";

           // Usamos RETURN_GENERATED_KEYS para obtener el ID automático
           ejecutar = conectado.prepareStatement(sentenciaSQL, java.sql.Statement.RETURN_GENERATED_KEYS);
           ejecutar.setString(1, p.getNombres());
           ejecutar.setString(2, p.getCedula());
           ejecutar.setString(3, p.getDireccion());
           ejecutar.setInt(4, p.getEdad());

           int filasAfectadas = ejecutar.executeUpdate();

           if (filasAfectadas > 0) {
               // Obtener el ID generado automáticamente por MySQL
               idsGenerados = ejecutar.getGeneratedKeys();  // Asignar a variable
               if (idsGenerados.next()) {
                   int idGenerado = idsGenerados.getInt(1);
                   p.setIdPersona(idGenerado);  // Asignar el ID al objeto
                   JOptionPane.showMessageDialog(null, " Persona creada con éxito. ID: " + idGenerado);
               }
           } else {
               JOptionPane.showMessageDialog(null, " La persona no ha sido creada");
           }

       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, " Error al crear persona: " + e.getMessage());
           e.printStackTrace();  // Esto ayuda a ver el error en consola

       } finally {
           // CIERRE SEGURO  SOLO recursos locales
           try {
               if (idsGenerados != null) {
                   idsGenerados.close();  // 1. Cerrar ResultSet
               }
               if (ejecutar != null) {
                   ejecutar.close();      // 2. Cerrar PreparedStatement
               }
               // NO cerrar conectado aquí  es atributo compartido
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }

    @Override
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", edad=" + edad + ", cedula=" + cedula + ", direccion=" + direccion + '}';
    }
    
     public boolean validarCedula(String cedula) {
        int sumImpar = 0, sumPar = 0, sumTot = 0, digtFinal = 0;

        if (cedula == null || cedula.length() != 10) {
            return false; // Cédula nula o no tiene 10 dígitos
        }

        // Validar que todos los caracteres sean dígitos
        for (int i = 0; i < cedula.length(); i++) {
            if (!Character.isDigit(cedula.charAt(i))) {
                return false; // Contiene caracteres no numéricos
            }
        }

        for (int i = 0; i < cedula.length(); i++) {
            int digito = (cedula.charAt(i)) - '0'; // Convertir char a int
            if (i % 2 == 0) { // Posiciones pares (0-indexed) -> 0, 2, 4, 6, 8
                int mul = digito * 2;
                if (mul > 9) {
                    mul -= 9;
                }
                sumImpar += mul;
            } else if (i % 2 != 0 && i != 9) { // Posiciones impares (0-indexed) -> 1, 3, 5, 7
                sumPar += digito;
            } else if (i == 9) { // Última posición (0-indexed) -> 9
                digtFinal = digito;
            }
        }
        sumTot = sumImpar + sumPar;

        if (sumTot % 10 == 0) {
            return (digtFinal == 0); // Si la suma es múltiplo de 10, el dígito verificador debe ser 0
        } else {
            int digitoEsperado = 10 - (sumTot % 10);
            return (digtFinal == digitoEsperado); // Si no, debe coincidir con 10 - (resto)
        }
    }
     
}
