package Server;

import java.io.*;
import java.io.OutputStream;
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
            System.out.println("SERVER: Il cliente ha scritto '" + m + "'");

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
