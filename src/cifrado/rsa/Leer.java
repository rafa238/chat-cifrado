package cifrado.rsa;

import com.google.gson.Gson;
import java.net.*;
import java.io.*;

class Leer extends Thread {     
    Socket socket;
    Ventana p;
    Gson g = new Gson();
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
                System.out.println(s);
                DatosJSon data = g.fromJson(s, DatosJSon.class);
                RSA rsa = new RSA();
                rsa.setD(data.getD());
                rsa.setN(data.getN());
                String mensaje = data.getNombre() + " dice: " +rsa.descifrar(data.getCifrado());
                String cadena = p.textArea.getText() + mensaje + "\n";
                p.textArea.setText(cadena);
            }
        }catch(Exception e){
            System.out.println("Error de leer");
        }
    }

    
}