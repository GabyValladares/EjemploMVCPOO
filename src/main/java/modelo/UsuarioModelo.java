/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class UsuarioModelo extends PersonaModelo {
    //ATRIBUTOS 
    private static int idUsuario;
    private String alias;
    private String clave;
    

    public UsuarioModelo() {
        idUsuario++;
    }

    public UsuarioModelo( String nombres, String cedula, String direccion, String alias, String clave, int edad) {
        this();
        
        this.alias = alias;
        this.clave = clave;
        
     
    }

    public UsuarioModelo(String alias, String clave, String nombres, int edad, String cedula, String direccion) {
        super(nombres, edad, cedula, direccion);
        this.alias = alias;
        this.clave = clave;
    }
  
    public static int getIdUsuario() {
        return idUsuario;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

 public void insertarUsuario( PersonaModelo p1) {
        //1.- UTILIZAR EXCEPCIÓN
        try {//LANZAR TESTEAR UN CONJUNTO DE CÓDIGO 
         
            int idPersona = p1.buscarUsuarioPorCedula(p1.getCedula());
            String sentenciaSQL ="insert into usuarios(Alias ,Contrasenia, FK_IdPersona)" +
            "values('"+getAlias()+"','"+getClave()+"','"+idPersona+"');" ;
            ejecutar = conectado.prepareCall(sentenciaSQL);
            //TODA INSERCIÓN DEVUELVE UN ESTADO >0 CUANDO FUE FAVORABLE Y MENOR A O CUANDO NO SE REALIZÓ 
            int resu = ejecutar.executeUpdate();
            if (resu > 0) {
                JOptionPane.showMessageDialog(null,"Usuario Creado con éxito");
                ejecutar.close();
              
            }else{
                JOptionPane.showMessageDialog(null,"El Usuario no ha sido creado,"
                        + " revise que los datos ingresados sean correctos");
            }

        } catch (SQLException e) {
            //CAPTURAR PARA DARLE UN TRATAMIENTO 
            JOptionPane.showMessageDialog(null,"Comuniquese con el Administrador para solicitar ayuda");
                
        }

    }

    public String toString(PersonaModelo p) {
        return "DATOS DEL USUARIO" +"\n"+
                "Id:"+getIdUsuario()+"\n"+
                "Nombres:"+p.getNombres()+"\n"+
                "Cédula:"+p.getCedula()+"\n"+
                "Edad:"+p.getEdad()+"\n"+
                "Dirección:"+p.getDireccion()+"\n"+
                "Alias:"+getAlias()+"\n"+
                "Clave:"+getClave();}
    
    
     public boolean  validarCredenciales( UsuarioModelo p1) {
        //1.- UTILIZAR EXCEPCIÓN
        try {//LANZAR TESTEAR UN CONJUNTO DE CÓDIGO 
         
            int idPersona = p1.buscarUsuarioPorCedula(p1.getCedula());
            String sentenciaSQL ="call sp_validar_credenciales(" +
            "'"+p1.getAlias()+"','"+p1.getClave()+"');" ;
            ejecutar = conectado.prepareCall(sentenciaSQL);
            //TODA INSERCIÓN DEVUELVE UN ESTADO >0 CUANDO FUE FAVORABLE Y MENOR A O CUANDO NO SE REALIZÓ 
            ResultSet resu = ejecutar.executeQuery();
            while (resu.next()) {
                JOptionPane.showMessageDialog(null,"Bienvenido");
                ejecutar.close();
                return true;
              
            }{
                JOptionPane.showMessageDialog(null,"El Usuario no existe,"
                        + " revise que los datos ingresados sean correctos");
                return false;
            }

        } catch (SQLException e) {
            //CAPTURAR PARA DARLE UN TRATAMIENTO 
            JOptionPane.showMessageDialog(null,"Comuniquese con el Administrador para solicitar ayuda");
                
        }
        return false;

    }


}
