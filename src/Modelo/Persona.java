/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Autores: Pablo Garcia (38862), Andrés Rojas (41423), Daniel Rosero (41305)
 *
 * @author ESTACION
 */
public class Persona {

    //La clase persona es la que asociaremos con la clase Cuenta
    private int id;
    private String nombre;

    //se crea el constructor de las variables utilizadas
    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // implementamos get y set necesarios 
    
    public int getId() {
    return id;
    }
    
    public void setId(int id) {
    this.id = id;
    }
    
    public String getNombre() {
    return nombre;
    }
    
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    
    // se utilizó un to string para verificar el correcto funcionamiento durante el desarrollo.

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
