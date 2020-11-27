package cifrado.rsa;

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente{ 
    Scanner entrada;
    String nombre;

    public Cliente(String nombre){	 
        this.nombre = nombre;        
        try{
            //String host = "25.107.136.158";
            String host = "localhost";
            Inet4Address in = (Inet4Address) Inet4Address.getByName(host);
            Socket skCliente = new Socket (in, 5000);         			
//            System.out.println("Introduce tu Nombre:");			 
//            String nombre=entrada.next();						
            Escribir hilo1 =new Escribir(skCliente,nombre);  //hilo que escribe se envía el nombre ingresado por el cliente y el socket 
            Leer hilo2= new Leer(skCliente);    //hilo que lee, se envía como parámetro el Socket				   skCliente.close();         
        }catch (Exception e)    {  
            e.printStackTrace();      
        }     
    }	 
//public static void main (String [] args){         
//    new Cliente();     
//}     
}

