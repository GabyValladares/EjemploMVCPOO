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
    private String nombres;
    private int edad;
    private String cedula;
    private String direccion;
   ConexionBDD conectar = new ConexionBDD();
        //CLASE QUE ME PERMITA CONECTARME DIRECTAMENTE A MYSQL
        Connection conectado = (Connection) conectar.conectar();
        //CLASE QUE ME PERMITE EJECUTAR MI SENTENCIA SQL
        PreparedStatement ejecutar;
        //OBTENER RESULTADOS DE LA CONSULTA
        ResultSet res;
        
    public PersonaModelo() {
    }

    public PersonaModelo(String nombres, int edad, String cedula, String direccion) {
        this.nombres = nombres;
        this.edad = edad;
        this.cedula = cedula;
        this.direccion = direccion;
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
    public void insertarPersona() {
        //1.- UTILIZAR EXCEPCIÓN
        try {//LANZAR TESTEAR UN CONJUNTO DE CÓDIGO 
            String sentenciaSQL ="insert into persona(nombres,cedula, direccion,edad)\n" +
"values('"+getNombres()+"','"+getCedula()+"','"+getDireccion()+"','"+getEdad()+"');" ;
            ejecutar = conectado.prepareCall(sentenciaSQL);
            //TODA INSERCIÓN DEVUELVE UN ESTADO >0 CUANDO FUE FAVORABLE Y MENOR A O CUANDO NO SE REALIZÓ 
            int resu = ejecutar.executeUpdate();
            if (resu > 0) {
                JOptionPane.showMessageDialog(null,"Postulante Creado con éxito");
                ejecutar.close();
              
            }else{
                JOptionPane.showMessageDialog(null,"El Postulante no ha sido creado,"
                        + " revise que los datos ingresados sean correctos");
            }

        } catch (SQLException e) {
            //CAPTURAR PARA DARLE UN TRATAMIENTO 
            JOptionPane.showMessageDialog(null,"Comuniquese con el Administrador para solicitar ayuda");
                
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
