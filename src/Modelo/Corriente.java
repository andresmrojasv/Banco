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
public class Corriente extends Cuenta {
    

    public Corriente(int numero, long saldo, Persona titular, String tipoCuenta) {
        super(numero, saldo, titular, tipoCuenta);
        
    }
   

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    

    @Override
    public long deposito(long deposito) {

        //sumatoria del nuevo saldo
        saldo += deposito;
        return saldo;

    }

    @Override
    public long retiro(long retiro) {

        //condición para verificar los casos en los que se presenta un sobregiro en la cuenta
        if (retiro > saldo) {

            saldo = retiro - saldo;

        } else {
            saldo = saldo - retiro;

        }

        return saldo;

    }

}