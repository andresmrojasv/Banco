/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.CuentaDAO;
import Modelo.Cuenta;
import Vista.VistaCuenta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Vista.VistaListaCuentas;

/**
 *
 * @author Andrés
 */
public class ControladorListaCuentas implements ActionListener {

    private CuentaDAO cuentaDAO;
    private VistaListaCuentas listaCuentas;
    private DefaultTableModel tabla;
    private ArrayList<Cuenta> array;

    public ControladorListaCuentas(CuentaDAO cuentaDAO, VistaListaCuentas listaCuentas) {
        this.cuentaDAO = cuentaDAO;
        this.listaCuentas = listaCuentas;

        tabla = (DefaultTableModel) this.listaCuentas.jTListaCuentas.getModel();
        this.listaCuentas.jBListarCliente.addActionListener(this);
        this.listaCuentas.jBSalirLista.addActionListener(this);
        this.listaCuentas.setVisible(true);
        this.listaCuentas.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // se realiza un listado de todos los "clientes" en la tabla

        if (ae.getSource() == listaCuentas.jBListarCliente) {

            array = cuentaDAO.listaDeCuentas();

            for (int i = 0; i < tabla.getRowCount(); i++) {

                tabla.removeRow(i);

            }
            for (Cuenta cuenta : array) {
                Object[] fila = {cuenta.getTitular().getNombre(), cuenta.getTitular().getId(), cuenta.getTipoCuenta(), cuenta.getNumero(), cuenta.getSaldo()};
                tabla.addRow(fila);
            }

        }

        if (ae.getSource() == this.listaCuentas.jBSalirLista) {
            
            // se cierra la vista actual y se regresa a la jframe principal 

            VistaCuenta vistaCuenta = new VistaCuenta();

            ControladorCuenta controladorCuenta = new ControladorCuenta(cuentaDAO, vistaCuenta);

            this.listaCuentas.hide();

        }

    }

}
