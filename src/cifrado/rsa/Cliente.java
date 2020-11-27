package cifrado.rsa;

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente{ 
    Scanner entrada;
    String nombre;
    Ventana p;
    Escribir hilo1;
    Leer hilo2;
    public Cliente(String nombre, Ventana p){	 
        this.nombre = nombre;  
        this.p=p;
        this.hilo1=null;
        try{
            String host = "localhost";
            
            Inet4Address in = (Inet4Address) Inet4Address.getByName(host);
            Socket skCliente = new Socket (in, 5000);         			
//            System.out.println("Introduce tu Nombre:");			 
//            String nombre=entrada.next();	

            hilo1=new Escribir(skCliente,nombre,p);  //hilo que escribe se envía el nombre ingresado por el cliente y el socket 
            hilo2= new Leer(skCliente);    //hilo que lee, se envía como parámetro el Socket				   skCliente.close();         
        }catch (Exception e)    {  
            e.printStackTrace();      
        }     
    }	 
//public static void main (String [] args){         
//    new Cliente();     
//}     
}

