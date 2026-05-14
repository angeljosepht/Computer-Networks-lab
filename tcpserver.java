import java.net.*;
import java.io.*;

public class tcpserver{
    public static void main(String[] args) {
        try{
        ServerSocket server=new ServerSocket(5000);
        System.out.println("Server listening...");

        Socket socket=server.accept();
        System.out.println("Client connected");

        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out=new PrintWriter(socket.getOutputStream());
        
        String message=in.readLine();
        System.out.println("recieved from client "+message);
        
        System.out.println("Message received");

        socket.close();
        server.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}