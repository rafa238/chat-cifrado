package cifrado.rsa;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

class Escribir extends Thread {
    
    private boolean diegounmensaje=false;
    Ventana p;
    Socket socket;
    String name;
    Scanner entrada;
    Escribir(Socket socket, String name, Ventana p){      //Recibe objeto de tipo Socket para identificar el Socket que está ejecutando el proceso y
        // en el parámetro name recibirá como el cliente desea ser nombrado
        entrada = new Scanner(System.in);  //Objeto para recibir datos desde teclado
        this.socket=socket;
        this.name=name;
        this.p=p;
        start();  //Inicia el Hilo, se llama automáticamente al método run()
    }
    
    public void run(){
        try{
            boolean terminar=false;
            String mensaje;
            while(!terminar){      // Creamos bucle infinito para escritura
                OutputStream os= socket.getOutputStream();
                DataOutputStream flujoDOS = new DataOutputStream(os);
                
                if(diegounmensaje){
                    
                    mensaje=p.getjtf1().getText();
                    
                    flujoDOS.writeUTF(name+" dice: "+mensaje);  //Si no se ingresa salir, se envía mensaje de escritura
                    diegounmensaje=false;
                }
                
                
                
            }
            socket.close();
        }catch(Exception e){
            System.out.println("Error de escribir" + e);
        }
    }

    public boolean isDiegounmensaje() {
        return diegounmensaje;
    }

    public void setDiegounmensaje(boolean diegounmensaje) {
        this.diegounmensaje = diegounmensaje;
    }
}

    

