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
import Vista.VistaListaCuentas;
import Vista.VistaCuenta;
import javax.swing.JOptionPane;

public class ControladorTrans implements ActionListener {

    Cuenta cuenta1;
    Ahorro ahorro;
    Corriente corriente;
    CuentaDAO cuentaDAO;
    VistaTransaccion vistaTrans;
    Persona persona;
    VistaCuenta vistaCuenta;

    public ControladorTrans(CuentaDAO cuentaDAO, VistaTransaccion vistaTrans) {

        this.cuentaDAO = cuentaDAO;
        this.vistaTrans = vistaTrans;

        this.vistaTrans.jBbuscar.addActionListener(this);
        this.vistaTrans.jBRetirar.addActionListener(this);
        this.vistaTrans.jBConsignar.addActionListener(this);
        
        this.vistaTrans.setVisible(true);
        this.vistaTrans.setLocationRelativeTo(null);

    }

    public void inicializartransaccion() {

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
                vistaTrans.jTIdentificacion.setText(String.valueOf(cuenta1.getTitular().getId()));
                vistaTrans.jTtipoCuenta.setText(cuenta1.getTipoCuenta());
                //cambiar a double
                vistaTrans.jTsaldo.setText(String.valueOf(cuenta1.getSaldo()));
            }

        }

        if ("Consignar".equals(e.getActionCommand())) {

            int indice = cuentaDAO.obtenerProducto(cuenta1);

            String tipocuenta = this.vistaTrans.jTtipoCuenta.getText();

            int NumeroDeCuenta = Integer.parseInt(this.vistaTrans.jTnumeroCuenta.getText());

            long saldo = cuenta1.deposito(Long.parseLong(vistaTrans.jTvalor.getText()));

            int CedulaDeCiudadania = Integer.parseInt(this.vistaTrans.jTIdentificacion.getText());
            String nombre = this.vistaTrans.jTtitular.getText();

            if (tipocuenta.equals("Ahorros")) {
                this.cuentaDAO.modificaProducto(indice, new Ahorro(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), "Ahorros"));

            } else {

                this.cuentaDAO.modificaProducto(indice, new Corriente(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), "Corriente"));

            }
        }

        if ("Retirar".equals(e.getActionCommand())) {

            int indice = cuentaDAO.obtenerProducto(cuenta1);

            String tipocuenta = this.vistaTrans.jTtipoCuenta.getText();

            int NumeroDeCuenta = Integer.parseInt(this.vistaTrans.jTnumeroCuenta.getText());

            long saldo = cuenta1.retiro(Long.parseLong(vistaTrans.jTvalor.getText()));

            int CedulaDeCiudadania = Integer.parseInt(this.vistaTrans.jTIdentificacion.getText());
            String nombre = this.vistaTrans.jTtitular.getText();

            if (tipocuenta.equals("Ahorros")) {
                this.cuentaDAO.modificaProducto(indice, new Ahorro(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), "Ahorros"));

            } else {

                this.cuentaDAO.modificaProducto(indice, new Corriente(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), "Corriente"));

            }

        }

    }
}
