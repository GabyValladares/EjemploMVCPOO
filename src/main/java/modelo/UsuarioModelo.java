/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        
    @Override  // Indica que este método reemplaza uno heredado del padre (PersonaModelo)
    public void setIdPersona(int idPersona) {  // Método para asignar un número como ID de persona
      super.setIdPersona(idPersona);  // Delega la asignación real al método de la clase padre
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
    public void insertarUsuario(PersonaModelo p1) {
        // 1. CONECTAR A LA BASE DE DATOS
        ConexionBDD conectar = new ConexionBDD();
        java.sql.Connection conectado = conectar.conectar();
        java.sql.PreparedStatement ejecutar = null;

        try {
            // 2. Obtener ID de la persona que ya se guardó
            int idPersona = p1.getIdPersona();

            // 3. Si ID es 0, hubo error al guardar persona
            if (idPersona == 0) {
                JOptionPane.showMessageDialog(null, " Error: La persona no tiene ID");
                return;
            }

            System.out.println(" Insertando usuario con ID Persona: " + idPersona);

            // 4. Preparar consulta SQL SEGURA
            String sql = "INSERT INTO usuarios(Alias, Contrasenia, FK_IdPersona) VALUES(?, ?, ?)";

            // 5. Ejecutar con parámetros
            ejecutar = conectado.prepareStatement(sql);
            ejecutar.setString(1, this.getAlias());  // Alias del usuario actual
            ejecutar.setString(2, this.getClave());  // Clave del usuario actual  
            ejecutar.setInt(3, idPersona);           // ID de la persona relacionada

            // 6. Ejecutar inserción
            int filasAfectadas = ejecutar.executeUpdate();

            // 7. Mostrar resultado
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, " Usuario creado con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no ha sido creado");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error SQL: " + e.getMessage());
            e.printStackTrace();  // Para ver el error en consola
        } finally {
            // 8. Cerrar recursos
            try {
                if (ejecutar != null) 
                    ejecutar.close();
                if (conectado != null) 
                    conectado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   public ArrayList<Object[]> datosUsuarios() throws SQLException {
        ArrayList<Object[]> listaObject=new ArrayList<>();
        ConexionBDD parametros = new ConexionBDD();
        Connection conectar = (Connection) parametros.conectar();
        
        java.sql.PreparedStatement ejecutar = null;
        
        String sql = "call sp_listaPersonas();";
        ejecutar = (PreparedStatement) conectar.prepareCall(sql);
        ResultSet res = ejecutar.executeQuery();
        int cont = 1;
        while (res.next()) {
            Object[] obpersona = new Object[6];
            for (int i = 1; i < 6; i++) {
                obpersona[i] = res.getObject(i+1);
            }
            obpersona[0]=cont;
            listaObject.add(obpersona);
            cont++;
        }
        ejecutar.close();
        return listaObject;

       
    }
    public String toString(PersonaModelo p) {
        return "DATOS DEL USUARIO" +"\n"+
                "Id:"+getIdUsuario()+"\n"+
                "Nombres:"+p.getNombres()+"\n"+
                "Cédula:"+p.getCedula()+"\n"+
                "Edad:"+p.getEdad()+"\n"+
                "Dirección:"+p.getDireccion()+"\n"+
                "Alias:"+getAlias()+"\n"+
                "Clave:"+getClave();
    }
       
}
