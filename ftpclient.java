import java.net.*;
import java.io.*;
import java.util.*;

public class ftpclient{
    public static void main(String args[])
    {
        try{
            Socket s=new Socket("localhost",5000);
            System.out.println("Client connected");

            InputStream is=s.getInputStream();
            FileOutputStream fos=new FileOutputStream("recieved.txt");
            
            byte[] buffer=new byte[1024];
            int bytesread;

            //password
            System.out.println(in.readLine()); // "Enter password:"
            String password = sc.nextLine();
            out.println(password);

            String serverResponse = in.readLine();
            System.out.println(serverResponse);

            if (!serverResponse.startsWith("Authentication successful")) {
                s.close();
                return;
            }

            while((bytesread=is.read(buffer))!=-1)
            {
                fos.write(buffer,0,bytesread);
               //code for reading from file
               // String message=new String(buffer,0,bytesread);
               // System.out.println(message);
                
            }


            is.close();
            fos.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception");
        }   



    }
}