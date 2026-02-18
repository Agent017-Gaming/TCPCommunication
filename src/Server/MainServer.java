package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione!");


        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("SERVER: in attesa di richieste con clienti...");
            Socket clientSocket = server.accept();
            System.out.println("CLIENT: connesso al server!");
            //communicazione

            //Lettura
            InputStream is = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String m = br.readLine();
            System.out.println("SERVER: il cliente: "+ clientSocket +
                    "ha scritto '" + m + "'");

            //Scrittura

            //Chiusura
            clientSocket.close();   //chiusura data socket
            server.close();         //chiusura connection socket
        } catch (IOException e) {
            System.err.println("Non siamo riusciti ad avviare il server!" +
                    "errore nella creazione del connection socket");
        }
    }
}
