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
import Vista.VistaListaCuentas;
import Vista.VistaTransaccion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCuenta implements ActionListener {

    //implementación de variables
    Cuenta cuenta;
    Ahorro ahorro;
    Corriente corriente;
    CuentaDAO cuentaDAO;
    VistaCuenta vistaCuenta;
    Persona persona;
    VistaTransaccion vistaTrans;
    VistaListaCuentas listaCuentas;

    //creacion del constructor solo con clase DAO y con la vista a manejar 
    public ControladorCuenta(CuentaDAO cuentaDAO, VistaCuenta vistaCuenta) {

        this.cuentaDAO = cuentaDAO;
        this.vistaCuenta = vistaCuenta;

        //setvisible hace visible el jframe que se utiliza en el momento
        this.vistaCuenta.setVisible(true);

        // setlocationrelativeto permite ubicar jframe en el centro de la pantalla siempre y cuando este en null                
        this.vistaCuenta.setLocationRelativeTo(null);

        // implementamos los actionlistener de lso botones a utilizar 
        this.vistaCuenta.jBCrear.addActionListener(this);
        this.vistaCuenta.jBListaCuentas.addActionListener(this);
        this.vistaCuenta.jBTransaccion.addActionListener(this);
        this.vistaCuenta.jBConsulta.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // se realiza la validación del boton que fue seleccionado en el jframe y se hace la operación correspondiente
        String tipoCuenta = null;

        if ("Crear".equals(e.getActionCommand())) {

            // se toman los datos de la vista
            int NumeroDeCuenta = Integer.parseInt(this.vistaCuenta.jTNumeroDeLaCuenta.getText());
            long saldo = Long.parseLong(this.vistaCuenta.jTSaldo.getText());
            int CedulaDeCiudadania = Integer.parseInt(this.vistaCuenta.jTCedulaDeCiudadania.getText());
            String nombre = this.vistaCuenta.jTNombreDelTitular.getText();

            // se identifica que radiobuttom fue seleccionado
            if (this.vistaCuenta.jRAhorros.isSelected() == true) {

                tipoCuenta = "Ahorros";

            } else {
                if (this.vistaCuenta.jRCorriente.isSelected() == true) {

                    tipoCuenta = "Corriente";

                }
            }

            // dependiendo del tipo de cuenta seleccionado se crea el objeto que se implementará en el array
            if (tipoCuenta == "Ahorros") {
                this.cuentaDAO.adicionarCuenta(new Ahorro(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), tipoCuenta));
            } else {
                if (tipoCuenta == "Corriente") {
                    this.cuentaDAO.adicionarCuenta(new Corriente(NumeroDeCuenta, saldo, new Persona(CedulaDeCiudadania, nombre), tipoCuenta));
                }

            }
            
            // todos los jtext del jframe utilizado se dejan en blanco

            this.vistaCuenta.jTCedulaDeCiudadania.setText(null);
            this.vistaCuenta.jTNombreDelTitular.setText(null);
            this.vistaCuenta.jTNumeroDeLaCuenta.setText(null);
            this.vistaCuenta.buttonGroupTCuenta.clearSelection();
            this.vistaCuenta.jTSaldo.setText(null);
        }

        if ("Consulta".equals(e.getActionCommand())) {
            
            // se toma el dato de la CC que se tiene en el jframe, se utiliza el metodo correspondiente a "buscar" que se tiene en 
            // la clase DAO 

            cuenta = cuentaDAO.buscarCuentaCedula(Integer.parseInt(this.vistaCuenta.jTCedulaDeCiudadania.getText()));
            
            // una vez identificado el objeto que se estaba buscando se muestran todos sus datos en el jfráme 

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

        if (e.getSource() == this.vistaCuenta.jBTransaccion) {
            
            //se cierra la vista actual y pasa a la vista seleccionada

            VistaTransaccion vistatrans = new VistaTransaccion();

            ControladorTrans controladorTrans = new ControladorTrans(cuentaDAO, vistatrans);

            this.vistaCuenta.hide();

        }

        if (e.getSource() == this.vistaCuenta.jBListaCuentas) {
            
            //se cierra la vista actual y pasa a la vista seleccionada

            VistaListaCuentas ListaProducto = new VistaListaCuentas();

            ControladorListaCuentas controladorLista = new ControladorListaCuentas(cuentaDAO, ListaProducto);

            this.vistaCuenta.hide();
        }

    }
}
