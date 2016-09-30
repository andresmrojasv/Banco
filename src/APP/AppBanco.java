/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import Controlador.ControladorBanco;
import Modelo.CuentaDAO;
//import Modelo.Ahorro;
//import Modelo.Corriente;
import Modelo.Cuenta;
import Vista.VistaCuenta;
import Vista.VistaListaCuentas;

public class AppBanco {

    public static void main(String[] args) {
        VistaCuenta vistacuenta = new VistaCuenta();
        VistaListaCuentas vlc = new VistaListaCuentas();
        CuentaDAO cuentaDao = new CuentaDAO();

        ControladorBanco controladorBanco = new ControladorBanco(cuentaDao, vistacuenta);
    }

}
