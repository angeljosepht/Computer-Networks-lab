import java.util.*;
import java.net.*;
import java.io.*;

public class tcp {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server listening...");

            Socket s = ss.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            while (true) {
                
                String message = in.readLine();
                if (message == null || message.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    s.close();
                    ss.close();
                    return;
                }

                System.out.println("Client: " + message);

                System.out.print("You: ");
                String response = sc.nextLine();
                out.println(response);
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
