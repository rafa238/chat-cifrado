/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado.rsa;

import java.math.BigInteger;

/**
 *
 * @author PC
 */
public class DatosJSon {
    private BigInteger[] cifrado;
    private BigInteger d;
    private BigInteger n;
    private String nombre;
    public DatosJSon(BigInteger[] cifrado,BigInteger d,BigInteger n, String nombre){
        this.cifrado=cifrado;
        this.d=d;
        this.n=n;
        this.nombre = nombre;
    }

    public BigInteger[] getCifrado() {
        return cifrado;
    }

    public void setCifrado(BigInteger[] cifrado) {
        this.cifrado = cifrado;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
