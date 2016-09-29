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
public abstract class Cuenta {

    /*creación de clase abstracta en donde se agregarán las variables y metodos 
     que serán utilizados diferentes subclases*/
    protected int numero;
    protected long saldo;
    protected Persona titular;
    protected String tipoCuenta;
    

    public Cuenta(int numero, long saldo, Persona titular, String tipoCuenta) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
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

    

    public abstract long deposito(long deposito);

    public abstract long retiro(long retiro);

}
