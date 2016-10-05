/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Andrés
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CuentaDAO {

    // creación de variables a utilizar (en este caso variables que hacen referencia a clases)
    private Cuenta cuenta;
    private Ahorro ahorro;
    private Corriente corriente;

    // creación de array donde se almacenarán los objetos (en este caso lo usamos en lugar de una base de datos)
    ArrayList<Cuenta> listaCliente = new ArrayList();

    // Creación de metodos que se utilizarán en el desarrollo de la aplicación (serán llamados desde los controladores)
    public void adicionarCuenta(Cuenta cuenta) {

        listaCliente.add(cuenta);
        JOptionPane.showMessageDialog(null, "Cliente adicionado correctamente");
        System.out.println(cuenta.toString());
    }

    public Cuenta buscarCuentaCedula(int codigo) {
        Cuenta buscar = null;
        for (Cuenta p : listaCliente) {
            if (codigo == p.titular.getId()) {
                buscar = p;
                break;
            }
        }
        return buscar;
    }

    public Cuenta buscarCuenta(int codigo) {
        System.out.println("Comenzo la busqueda");
        Cuenta buscar = null;
        for (Cuenta p : listaCliente) {
            if (codigo == p.getNumero()) {
                buscar = p;
                break;
            }
        }
        return buscar;
    }

    public void modificaProducto(int indice, Cuenta cuenta) {

        listaCliente.set(indice, cuenta);

    }

    public void elimaProducto(Cuenta cuenta) {
        listaCliente.remove(cuenta);
    }

    public ArrayList<Cuenta> listaDeCuentas() {
        return listaCliente;
    }

    public int obtenerProducto(Cuenta cuenta) {
        return listaCliente.indexOf(cuenta);

    }

}
