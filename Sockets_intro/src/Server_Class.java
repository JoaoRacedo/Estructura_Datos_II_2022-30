import java.net.*;
import java.io.*;

public class Server_Class {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String texto = in.readLine();
            
            if ("hello server".equals(texto)){
                System.out.println(texto);
                out.println("hello client");
            }else{
                out.println("No se quien eres");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void stop(){
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        Server_Class server = new Server_Class();
        server.start(5555);

    }
}