package cifrado.rsa;

import java.net.*;
import java.io.*;

class Leer extends Thread {     
    Socket socket;
    public Leer( Socket socket){
        this.socket=socket;
        start();   //Iniciar el proceso
    }
    
    public void run(){
        try{
            while(true){     //bucle infinito para lectura
                InputStream aux = socket.getInputStream();
                DataInputStream flujo = new DataInputStream( aux );
                System.out.println(flujo.readUTF() );
            }
        }catch(Exception e){
            System.out.println("Error de leer");
        }
    }

    
}