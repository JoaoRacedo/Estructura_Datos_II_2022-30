import java.net.*;
import java.io.*;

public class Client_Class {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void Connect_to_Server(String ip, int port){
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String sendMessage(String msg){
        try {
            out.println(msg);
            return in.readLine();
        } catch (Exception e) {
            return null;
        }
    } 

    public void stop(){
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}