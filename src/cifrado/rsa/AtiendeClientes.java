package cifrado.rsa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AtiendeClientes extends Thread { //Creamos proceso
Socket socket;
String mensaje;
ArrayList<Socket> listaCliente;
int cliente;

AtiendeClientes(ArrayList<Socket> lista, Socket socket){
    this.listaCliente = lista;
    this.socket=socket;
    start();
}
    public void run(){
        while(true){   // Bucle infinito para lectura y escritura
            try {
                InputStream is = socket.getInputStream(); // Se abre flujo de lectura
                DataInputStream flujo = new DataInputStream(is);
                mensaje=flujo.readUTF();  // Permanece escuchando hasta que alguno de los clientes le envía un mensaje
                for(int cont=0; cont<listaCliente.size(); cont++){
                    if(listaCliente.get(cont).isClosed()){
                        listaCliente.remove(cont);
                    }else{
                        OutputStream os = listaCliente.get(cont).getOutputStream();
                        DataOutputStream flujoDOS = new DataOutputStream(os);
                        flujoDOS.writeUTF(mensaje);
                        System.out.println(mensaje);
                    }
                }
            }catch(Exception e) { System.out.println("Error de comunicacion"+e);   }
        }
    }
}
