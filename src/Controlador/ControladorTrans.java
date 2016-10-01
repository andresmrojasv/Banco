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
import Modelo.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaTransaccion;

public class ControladorTrans implements ActionListener {

    Cuenta cuenta1;
    Ahorro ahorro;
    Corriente corriente;
    CuentaDAO cuentaDAO;
    VistaTransaccion vistaTrans;
    Persona persona;

    public ControladorTrans(CuentaDAO cuentaDAO, VistaTransaccion vistaTrans) {

        this.cuentaDAO = cuentaDAO;
        this.vistaTrans = vistaTrans;

        this.vistaTrans.jBbuscar.addActionListener(this);
        this.vistaTrans.jBRetirar.addActionListener(this);
        this.vistaTrans.jBConsignar.addActionListener(this);

        this.vistaTrans.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Buscar".equals(e.getActionCommand())) {

            System.out.println("test base");

            cuenta1 = cuentaDAO.buscarCuenta(Integer.parseInt(this.vistaTrans.jTnumeroCuenta.getText()));

            System.out.println(cuenta1);

            if (cuenta1 != null) {
                vistaTrans.jTnumeroCuenta.setText(String.valueOf(cuenta1.getNumero()));
                vistaTrans.jTtitular.setText(cuenta1.getTitular().getNombre());
                vistaTrans.jTtipoCuenta.setText(cuenta1.getTipoCuenta());
                //cambiar a double
                vistaTrans.jTsaldo.setText(String.valueOf(cuenta1.getSaldo()));
            }

        }

    }

}
