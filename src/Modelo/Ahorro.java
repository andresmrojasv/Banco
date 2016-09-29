/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * *Autores: Pablo Garcia (38862), Andrés Rojas (41423), Daniel Rosero (41305)
 *
 * @author ESTACION
 */
public class Ahorro extends Cuenta {

    public Ahorro(int numero, long saldo, Persona titular, String tipoCuenta) {
        super(numero, saldo, titular, tipoCuenta);

    }

    @Override
    public long deposito(long deposito) {

        //suma del saldo mas el deposito
        saldo += deposito;
        //suma del saldo mas el 3% del interes

        saldo = (long) (saldo + (saldo * 0.03));
        //se muestra el nuevo saldo de la cuenta

        return saldo;

    }

    @Override
    public long retiro(long retiro) {

        //condición para verificar que no se presente un sobregiro en la cuenta
        if (retiro > saldo) {

        } else {

            retiro = (saldo - retiro);

        }

        return saldo;

    }

}
