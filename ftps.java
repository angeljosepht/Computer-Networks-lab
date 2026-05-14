import java.io.*;
import java.net.*;

public class ftps {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
     
            String command = in.readLine();
            System.out.println("Command received: " + command);

            if (command.startsWith("UPLOAD")) {
                String filename = command.split(" ")[1];
                FileOutputStream fos = new FileOutputStream(filename);
                int data;
                while ((data = in.read()) != -1) {
                    fos.write(data);
                }
                fos.close();
                System.out.println("File " + filename + " uploaded successfully!");
            }

            else if (command.startsWith("DOWNLOAD")) {
                String filename = command.split(" ")[1];
                FileInputStream fis = new FileInputStream(filename);
                int data;
                while ((data = fis.read()) != -1) {
                    out.write(data);
                }
                fis.close();
                out.flush();
                System.out.println("File " + filename + " sent successfully!");
            }
            in.close();
            out.close();
            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
