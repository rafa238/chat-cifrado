package cifrado.rsa;



import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Arrays;
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
            String mensajeDes;
            while(!terminar){      // Creamos bucle infinito para escritura
                OutputStream os= socket.getOutputStream();
                DataOutputStream flujoDOS = new DataOutputStream(os);
                BigInteger[] cifrado;
                
                if(diegounmensaje){
                    
                    RSA rsa = new RSA(100);
                    rsa.generarPrimo();
                    rsa.generarClaves();
                    mensaje=p.getjtf1().getText();
                    cifrado = rsa.encriptar(mensaje);
                    
                    //mensajeDes=rsa.descifrar(cifrado);
                    
                    Gson g = new Gson();
                    DatosJSon dtjs= new DatosJSon(cifrado,rsa.getD(),rsa.getN());
//
//                    JSONParser parser = new JSONParser();
//                    JSONObject json = (JSONObject) parser. parse(g.toJson(dtjs)+"");
                    DatosJSon hlhl = g.fromJson(g.toJson(dtjs), DatosJSon.class);
                    //String d = json.get("d").toString(); 
                    
                    //flujoDOS.writeUTF(name+" dice: "+mensajeDes);
                    flujoDOS.writeUTF(name+" dice: "+Arrays.toString(hlhl.getCifrado()));  //Si no se ingresa salir, se envía mensaje de escritura
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

    

