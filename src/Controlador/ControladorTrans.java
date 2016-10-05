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

    //creacion de variables a utilizar
    Cuenta cuenta1;
    Ahorro ahorro;
    Corriente corriente;
    CuentaDAO cuentaDAO;
    VistaTransaccion vistaTrans;
    Persona persona;
    VistaCuenta vistaCuenta;

    // creación del constructor donde solo dejamos la clase DAO y la vista que se está manejando
    public ControladorTrans(CuentaDAO cuentaDAO, VistaTransaccion vistaTrans) {

        this.cuentaDAO = cuentaDAO;
        this.vistaTrans = vistaTrans;

        //utilizamos el ActionListener para que los botones del jframe que se está manejando puedan ser utilizados
        this.vistaTrans.jBbuscar.addActionListener(this);
        this.vistaTrans.jBRetirar.addActionListener(this);
        this.vistaTrans.jBConsignar.addActionListener(this);
        this.vistaTrans.jBSalirTransaccion.addActionListener(this);

        // SetVisible permite que el Jframe sea visible
        this.vistaTrans.setVisible(true);

        // setLocationRelativeto nos permite ubicar el jframe en el centro de la panatalla (siempre y cuando sea null)
        this.vistaTrans.setLocationRelativeTo(null);

    }

    public void inicializartransaccion() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Se realizan las validaciones para identificar que botón fue seleccionado
        if ("Buscar".equals(e.getActionCommand())) {

            // se toma el dato de identificación que se tiene en el jframe, se utiliza el metodo correspondiente a "buscar" que se tiene en 
            // la clase DAO 
            cuenta1 = cuentaDAO.buscarCuenta(Integer.parseInt(this.vistaTrans.jTnumeroCuenta.getText()));

            // una vez identificado el objeto que se estaba buscando se muestran todos sus datos en el jfráme 
            System.out.println(cuenta1);

            if (cuenta1 != null) {
                vistaTrans.jTnumeroCuenta.setText(String.valueOf(cuenta1.getNumero()));
                vistaTrans.jTtitular.setText(cuenta1.getTitular().getNombre());
                vistaTrans.jTIdentificacion.setText(String.valueOf(cuenta1.getTitular().getId()));
                vistaTrans.jTtipoCuenta.setText(cuenta1.getTipoCuenta());
                vistaTrans.jTsaldo.setText(String.valueOf(cuenta1.getSaldo()));
            }

        }

        if ("Consignar".equals(e.getActionCommand())) {

            // una vez identificado el objeto que se va a manejar (por medio de buscar) se toman los nuevos datos (saldo) 
            // y son guardados nuevamente en el objeto
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

            this.vistaTrans.jTIdentificacion.setText(null);
            this.vistaTrans.jTnumeroCuenta.setText(null);
            this.vistaTrans.jTsaldo.setText(null);
            this.vistaTrans.jTtipoCuenta.setText(null);
            this.vistaTrans.jTtitular.setText(null);
            this.vistaTrans.jTvalor.setText(null);
        }

        if ("Retirar".equals(e.getActionCommand())) {

             // una vez identificado el objeto que se va a manejar (por medio de buscar) se toman los nuevos datos (saldo) 
            // y son guardados nuevamente en el objeto
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

            this.vistaTrans.jTIdentificacion.setText(null);
            this.vistaTrans.jTnumeroCuenta.setText(null);
            this.vistaTrans.jTsaldo.setText(null);
            this.vistaTrans.jTtipoCuenta.setText(null);
            this.vistaTrans.jTtitular.setText(null);
            this.vistaTrans.jTvalor.setText(null);

        }

        if (e.getSource() == this.vistaTrans.jBSalirTransaccion) {

            VistaCuenta vistaCuenta = new VistaCuenta();

            ControladorCuenta controladorCuenta = new ControladorCuenta(cuentaDAO, vistaCuenta);

            this.vistaTrans.hide();

        }

    }
}
