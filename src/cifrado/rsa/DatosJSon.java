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
    
    public DatosJSon(BigInteger[] cifrado,BigInteger d,BigInteger n){
        this.cifrado=cifrado;
        this.d=d;
        this.n=n;
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
    
}
