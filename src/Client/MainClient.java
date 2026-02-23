package Client;


import java.io.*;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");


        try {

            //3. Creazione del data socket e connessione al server
            Socket client = new Socket("localhost", 12345);
            System.out.println("il client si è connesso al server!");
            //communicazione
            //Scrittura
            // 4. il client comunica con il server
            OutputStream os = client.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            //5.1 il client scrive un messaggio al server
            pw.println("Ciao server!");
            //5.2 il client invia il messaggio al server
            pw.flush();

            //Lettura
            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String m = br.readLine();
            System.out.println("CLIENT: Il server ha scritto '" + m + "'");

            //Chiusura
            client.close();

        } catch (IOException e) {
            System.err.println("Errore nella connessione al server!");
        }


    }
}
