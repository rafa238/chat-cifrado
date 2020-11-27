package cifrado.rsa;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    ;
    ArrayList<Socket> listaCliente=new ArrayList();	    
    public Servidor(){        
        try{            
            ServerSocket ss = new ServerSocket (5000);			
            Socket cliente;            
            while(true){				
                cliente = ss.accept();
                System.out.println("Conexión exitosa");
                listaCliente.add(cliente);				
                AtiendeClientes cte = new AtiendeClientes(listaCliente,cliente); 
            }	            
        }        
        catch (Exception e){    
            e.printStackTrace();       
        }    
    }    
    public static void main (String [] args){        
        new Servidor(); 
    }
}
