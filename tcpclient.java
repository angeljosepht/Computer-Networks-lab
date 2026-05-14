import java.util.*;
import java.net.*;
import java.io.*;

public class tcpclient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            while (true) {
               
                System.out.print("You: ");
                String message = sc.nextLine();
                out.println(message); 


                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Connection closed.");
                    s.close();
                    return;
                }

                String serverMessage = in.readLine();
                if (serverMessage == null) break; 
                System.out.println("Server: " + serverMessage);
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
