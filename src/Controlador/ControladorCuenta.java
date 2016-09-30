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
import Vista.VistaCuenta;
import Vista.VistaTransaccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorCuenta implements ActionListener {

    Cuenta cuenta;
    Ahorro ahorro;
    Corriente corriente;
    CuentaDAO cuentaDAO;
    VistaCuenta vistaCuenta;
    Persona persona;

    public ControladorCuenta(CuentaDAO cuentaDAO, VistaCuenta vistaCuenta) {

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

        String tipoCuenta = null;

        if ("Crear".equals(e.getActionCommand())) {

            int CedulaDeCiudadania = Integer.parseInt(this.vistaCuenta.jTCedulaDeCiudadania.getText());
            String nombre = this.vistaCuenta.jTNombreDelTitular.getText();
            int NumeroDeCuenta = Integer.parseInt(this.vistaCuenta.jTNumeroDeLaCuenta.getText());

            if (this.vistaCuenta.jRAhorros.isSelected() == true) {

                tipoCuenta = "Ahorro";

            } else {
                if (this.vistaCuenta.jRCorriente.isSelected() == true) {

                    tipoCuenta = "Corriente";

                }
            }

            long saldo = Long.parseLong(this.vistaCuenta.jTSaldo.getText());

            if (tipoCuenta == "Ahorro") {
                this.cuentaDAO.adicionarCuenta(new Ahorro(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), tipoCuenta));
            } else {
                if (tipoCuenta == "Corriente") {
                    this.cuentaDAO.adicionarCuenta(new Corriente(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), tipoCuenta));
                }

            }
            this.vistaCuenta.jTCedulaDeCiudadania.setText(null);
            this.vistaCuenta.jTNombreDelTitular.setText(null);
            this.vistaCuenta.jTNumeroDeLaCuenta.setText(null);
            this.vistaCuenta.buttonGroupTCuenta.clearSelection();
            this.vistaCuenta.jTSaldo.setText(null);
        }

        if ("Consulta".equals(e.getActionCommand())) {

            cuenta = cuentaDAO.buscarCuentaCedula(Integer.parseInt(this.vistaCuenta.jTCedulaDeCiudadania.getText()));

            System.out.println(cuenta);

            if (cuenta != null) {
                vistaCuenta.jTCedulaDeCiudadania.setText(String.valueOf(cuenta.getTitular().getId()));
                vistaCuenta.jTNombreDelTitular.setText(cuenta.getTitular().getNombre());
                vistaCuenta.jTNumeroDeLaCuenta.setText(String.valueOf((cuenta.getNumero())));

                if (cuenta.getTipoCuenta() == "Ahorro") {
                    vistaCuenta.jRAhorros.setSelected(true);
                } else {
                    if (cuenta.getTipoCuenta() == "Corriente") {
                        vistaCuenta.jRCorriente.setSelected(true);
                    }
                }

                vistaCuenta.jTSaldo.setText(String.valueOf(cuenta.getSaldo()));

            }

        }
        
        if ("Transacción".equals(e.getActionCommand())){
            
            VistaTransaccion vistaTrans=new VistaTransaccion();
            vistaTrans.setVisible(true);
            vistaCuenta.setVisible(false);
            
            
        }

    }
}
