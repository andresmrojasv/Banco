/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 * *Autores: Pablo Garcia (38862), Andrés Rojas (41423), Daniel Rosero (41305)
 *
 * @author ESTACION
 */
public class Corriente extends Cuenta implements Serializable {
    
    // se implementa el constructor 
    public Corriente(int numero, long saldo, Persona titular, String tipoCuenta) {
        super(numero, saldo, titular, tipoCuenta);

    }

    @Override
    public long deposito(long deposito) {

        //sumatoria del nuevo saldo
        saldo += deposito;
        
        // Mediante un cuadro de dialogo se anuncia el nuevo saldo
        JOptionPane.showMessageDialog(null, "Su nuevo saldo es: " + saldo);

        return saldo;

    }

    @Override
    public long retiro(long retiro) {

        //condición para verificar los casos en los que se presenta un sobregiro en la cuenta
        if (retiro > saldo) {

            saldo = saldo - retiro;
            
            // Mediante un cuadro de dialogo se anuncia el nuevo saldo
            JOptionPane.showMessageDialog(null, "Se ha presentado un sobregiro de: " + saldo);

        } else {
            saldo = saldo - retiro;
            
            // Mediante un cuadro de dialogo se anuncia el nuevo saldo
            JOptionPane.showMessageDialog(null, "Su nuevo saldo es: " + saldo);

        }

        return saldo;

    }

}
