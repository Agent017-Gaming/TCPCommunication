package Server;

import java.io.*;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione!");


        try {

            // 1. Creazione del connection socket
            ServerSocket server = new ServerSocket(12345);
            System.out.println("SERVER: in attesa di richieste con clienti...");
            // 2. Attesa di richieste di connessione da parte dei client
            Socket clientSocket = server.accept();
            System.out.println("CLIENT: connesso al server!");
            //communicazione

            //Lettura
            //6. il server deve leggere cio che il client ha scritto
            InputStream is = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String m = br.readLine();
            System.out.println("SERVER: Il cliente ha scritto '" + m + "'");

            //(fai il ciclo while per leggere più messaggi)

            //Scrittura
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("Ciao client!");
            pw.flush();
            //Chiusura
            clientSocket.close();   //chiusura data socket
            server.close();         //chiusura connection socket
        } catch (IOException e) {
            System.err.println("Non siamo riusciti ad avviare il server!" +
                    "errore nella creazione del connection socket");
        }
    }
}
