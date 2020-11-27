package cifrado.rsa;

import java.net.*;
import java.io.*;

class Leer extends Thread {     
    Socket socket;
    Ventana p;
    public Leer( Socket socket, Ventana p){
        this.socket=socket;
        this.p = p;
        start();   //Iniciar el proceso
    }
    
    public void run(){
        try{
            while(true){     //bucle infinito para lectura
                InputStream aux = socket.getInputStream();
                DataInputStream flujo = new DataInputStream( aux );
                //System.out.println(flujo.readUTF());
                String s = flujo.readUTF();
                String cadena = p.textArea.getText() + s + "\n";
                p.textArea.setText(cadena);
            }
        }catch(Exception e){
            System.out.println("Error de leer");
        }
    }

    
}