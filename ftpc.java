import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ftpc {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter command (UPLOAD <file> / DOWNLOAD <file>): ");
            String command = sc.nextLine();
            out.println(command);

            if (command.startsWith("UPLOAD")) {
                String filename = command.split(" ")[1];
                FileInputStream fis = new FileInputStream(filename);
                int data;
                while ((data = fis.read()) != -1) {
                    out.write(data);
                }
                fis.close();
                out.flush();
                System.out.println("File sent to server successfully!");
            }

            else if (command.startsWith("DOWNLOAD")) {
                String filename = command.split(" ")[1];
                FileOutputStream fos = new FileOutputStream("copy_" + filename);
                int data;
                while ((data = in.read()) != -1) {
                    fos.write(data);
                }
                fos.close();
                System.out.println("File downloaded from server successfully!");
            }

            in.close();
            out.close();
            socket.close();
            sc.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
