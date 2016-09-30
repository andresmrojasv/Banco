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

    private Cuenta cuenta;
    private Ahorro ahorro;
    private Corriente corriente;

    ArrayList<Cuenta> listaCliente = new ArrayList();

    public void adicionarCuenta(Cuenta cuenta) {

        listaCliente.add(cuenta);
        JOptionPane.showMessageDialog(null, "Cliente adicionado correctamente");
        System.out.println(cuenta.toString());
    }

    public Cuenta buscarCuenta(int codigo) {
        Cuenta buscar = null;
        for (Cuenta p : listaCliente) {
            if (codigo == p.titular.getId()) {
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

    public ArrayList<Cuenta> listaDeProductos() {
        return listaCliente;
    }

    public int obtenerProducto(Cuenta cuenta) {
        return listaCliente.indexOf(cuenta);

    }

}
