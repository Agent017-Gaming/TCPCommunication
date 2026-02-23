package Client;


import java.io.*;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");


        try {
            Socket client = new Socket("localhost", 12345);
            System.out.println("il client si è connesso al server!");


            //communicazione
            //Scrittura
            OutputStream os = client.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("Ciao server!");
            pw.flush();

            //Lettura
            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String m = br.readLine();
            System.out.println("CLIENT: il server ha scritto '" + m + "'");

            //Chiusura
            client.close();

        } catch (IOException e) {
            System.err.println("Errore nella connessione al server!");
        }


    }
}
