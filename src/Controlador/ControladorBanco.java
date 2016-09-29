/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.Ahorro;
import Modelo.Corriente;
import Modelo.CuentaDAO;
import Vista.VistaCuenta;
import Vista.VistaListaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBanco implements ActionListener{

    Cuenta cuenta;
    Ahorro ahorro;
    Corriente corriente;
    CuentaDAO cuentaDAO;
    VistaCuenta vistaCuenta;
    VistaListaClientes vlClientes;

    public ControladorBanco(Cuenta cuenta, Ahorro ahorro, Corriente corriente, CuentaDAO cuentaDAO, VistaCuenta vistaCuenta, VistaListaClientes vlClientes) {
        this.cuenta = cuenta;
        this.ahorro = ahorro;
        this.corriente = corriente;
        this.cuentaDAO = cuentaDAO;
        this.vistaCuenta = vistaCuenta;
        this.vlClientes = vlClientes;
        
        this.vistaCuenta.setVisible(true);
        this.vlClientes.setVisible(true);
        
        this.vistaCuenta.jBCrear.addActionListener(this);
        this.vistaCuenta.jBListaCuentas.addActionListener(this);
        this.vistaCuenta.jBTransaccion.addActionListener(this);
        this.vistaCuenta.jBConsulta.addActionListener(this);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("Crear".equals(e.getActionCommand())){
            
        }
    }
    
    

}
