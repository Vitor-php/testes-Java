// ex 7 -> Venda de Produto


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String argv[]) {
        try {
        	
            ServerSocket socketRecepcao = new ServerSocket(1234);
            System.out.println("Servidor esperando conexão na porta 1234");

            Socket socketConexao = socketRecepcao.accept();
            System.out.println("Socket Conexão: "+socketConexao);
            System.out.println("Cliente " + socketConexao.getInetAddress().getHostAddress() + " conectado");

            DataInputStream in = new DataInputStream(socketConexao.getInputStream());
            
            int somatorio = FuncoesServidor.calcSomatorio(in.readInt(), in.readInt());
          
            DataOutputStream out = new DataOutputStream(socketConexao.getOutputStream());
            out.writeInt(somatorio); 

            in.close();
            out.close();
            
            socketConexao.close();
            socketRecepcao.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}