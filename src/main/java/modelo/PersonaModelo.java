/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class PersonaModelo {
    private String nombres;
    private int edad;
    private String cedula;
    private String direccion;

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

    @Override
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", edad=" + edad + ", cedula=" + cedula + ", direccion=" + direccion + '}';
    }
    
    
    
    
}
