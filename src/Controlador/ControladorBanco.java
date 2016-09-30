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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBanco implements ActionListener {

    Cuenta cuenta;
    CuentaDAO cuentaDAO;
    VistaCuenta vistaCuenta;

    public ControladorBanco(CuentaDAO cuentaDAO, VistaCuenta vistaCuenta) {

        this.cuentaDAO = cuentaDAO;
        this.vistaCuenta = vistaCuenta;

        this.vistaCuenta.setVisible(true);

        this.vistaCuenta.jBCrear.addActionListener(this);
        this.vistaCuenta.jBListaCuentas.addActionListener(this);
        this.vistaCuenta.jBTransaccion.addActionListener(this);
        this.vistaCuenta.jBConsulta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Crear".equals(e.getActionCommand())) {
            
            long CedulaDeCiudadania=Long.parseLong(this.vistaCuenta.jTCedulaDeCiudadania.getText());
            String nombre= this.vistaCuenta.jTNombreDelTitular.getText();
            long NumeroDeCuenta=Long.parseLong(this.vistaCuenta.jTNumeroDeLaCuenta.getText());
            
            /*
            long identificacion = Long.parseLong(this.vistacliente.JTdatoIdentificacion.getText());
            String nombre = this.vistacliente.JTdatoNombre.getText();
            String direccion = this.vistacliente.JTdatoDireccion.getText();
            String ciudad = this.vistacliente.JTciudad.getText();
            
            this.modelocliente.adicionarcliente(new ClienteVO(identificacion, nombre, direccion, ciudad));
            
            this.vistacliente.JTdatoIdentificacion.setText(null);
            this.vistacliente.JTdatoNombre.setText(null);
            this.vistacliente.JTdatoDireccion.setText(null);
            this.vistacliente.JTciudad.setText(null);*/

        }
    }

}
