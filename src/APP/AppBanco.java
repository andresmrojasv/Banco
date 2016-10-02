/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import Controlador.ControladorTrans;
import Controlador.ControladorCuenta;
import Modelo.CuentaDAO;
//import Modelo.Ahorro;
//import Modelo.Corriente;
import Modelo.Cuenta;
import Vista.VistaCuenta;
import Vista.VistaListaCuentas;
import Vista.VistaTransaccion;

public class AppBanco {

    public static void main(String[] args) {
        VistaCuenta vistacuenta = new VistaCuenta();
        VistaListaCuentas vlc = new VistaListaCuentas();
        VistaTransaccion vistaTrans = new VistaTransaccion();
        CuentaDAO cuentaDao = new CuentaDAO();

        ControladorCuenta controladorCuenta = new ControladorCuenta(cuentaDao, vistacuenta);
        //ControladorTrans controladorTrans = new ControladorTrans(cuentaDao, vistaTrans);

    }

}
