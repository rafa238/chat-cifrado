
package cifrado.rsa;

import java.math.BigInteger;
import java.util.Random;


public class RSA {
    int tamPrimo;
    BigInteger p,q,n;
    BigInteger e, d;
    BigInteger phi;
    
    public RSA  (int tamPrimo){
        this.tamPrimo = tamPrimo;
    }
    
    public RSA (){}
    
    public void generarPrimo(){
        p = new BigInteger(tamPrimo, 10, new Random());
        do q = new BigInteger(tamPrimo, 10, new Random());
            while(q.compareTo(p) == 0);
    }
    
    public void generarClaves(){
        //n = p*q
        n = p.multiply(q);
        //phi = (p-1)*(q-1)
        phi = p.subtract(BigInteger.valueOf(1));
        phi = phi.multiply(q.subtract(BigInteger.valueOf(1)));
        //calcular el primo relatico o coprimo e y menor n
        do e = new BigInteger(2*tamPrimo, new Random());
            //calcular mcd de e
            while((e.compareTo(phi) != 1) || (e.gcd(phi).compareTo(BigInteger.valueOf(1))!=0));
        d = e.modInverse(phi);
    }
    
    public BigInteger[] encriptar(String mensaje){
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        //primero es recorrer el tamaño de bigdigitos para asignarlos añ temp
        for(i=0; i<bigdigitos.length; i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }
        //necesito un biginteger para el cifrado
        BigInteger[] cifrado = new BigInteger[bigdigitos.length];
        for(i=0; i<bigdigitos.length; i++){
            //aplica el modulo del cifrado
            cifrado[i] = bigdigitos[i].modPow(e, n);
        }
        return cifrado;
    }
    
    public String descifrar(BigInteger[] cifrado){
        BigInteger[] descifrado = new BigInteger[cifrado.length];
        //descifrar
        for(int i=0; i <descifrado.length; i++){
            //aplico el descifrado
            descifrado[i] = cifrado[i].modPow(d, n);
        }
        //lo tengo que colocar en un arreglo de caracteres para despues pasarlo a una cadena
        char[] charArray = new char[descifrado.length];
        for(int i=0; i<charArray.length; i++){
            charArray[i] = (char)(descifrado[i].intValue());
        }
        return (new String(charArray));
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }
    
}
