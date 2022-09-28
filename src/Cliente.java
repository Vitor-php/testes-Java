// ex 6 -> Restaurante


import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    
    public static void main(String[] args) {

        try{
            Socket cliente = new Socket("localhost",1234);
            
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            out.writeInt(Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite o total de despesas em seu restaurante: ")));
            
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            javax.swing.JOptionPane.showMessageDialog(null, "O somatório é "+in.readInt(), "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            //Fechar conexões
            cliente.close();
            in.close();
            out.close();
                  
        }catch(IOException | HeadlessException | NumberFormatException e){
            System.out.println(e.toString());
        }
        
    }
    
}
