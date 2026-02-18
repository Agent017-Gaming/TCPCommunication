package Client;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");


        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("il client si è connesso al server!");

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.print("Ciao server!");
            pw.flush();
            socket.close();
        } catch (IOException e) {
            System.err.println("Errore nella connessione al server!");
        }


    }
}
