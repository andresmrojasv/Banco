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
import Vista.VistaListaClientes;

public class AppBanco {
    
   VistaCuenta vistacuenta=new VistaCuenta();
   VistaListaClientes vlc=new VistaListaClientes();
   CuentaDAO cuentaDao=new CuentaDAO();
   
   
   ControladorBanco controladorBanco=new ControladorBanco(cuentaDao,vistacuenta);
   
    
}
