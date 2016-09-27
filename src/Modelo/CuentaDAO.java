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
    private Ahorro cuenta;
    ArrayList<Cuenta> listaCliente =new ArrayList();
    
    public void adicionarCuenta(Cuenta cuenta) {

        listaCliente.add(cuenta);
        JOptionPane.showMessageDialog(null, "Cliente adicionado correctamente");

    }
    
    public Ahorro buscarCuenta(int numero) {

        Ahorro buscar = null;

        for (Ahorro c : listaCliente) {
            if (c.) == identificacion) {
                cliente = c;
                break;
            }
        }
        return cliente;
    }
    
}
