import java.net.*;
import java.io.*;
import java.util.*;

public class ftpserver{
    public static void main(String args[])
    {
        try{
            Scanner sc=new Scanner(System.in);
            ServerSocket ss=new ServerSocket(5000);
            System.out.println("Server waiting....");

            Socket s=ss.accept();
            System.out.println("Client connected");

            byte[] buffer=new byte[1024];
            int bytesread;

            FileInputStream fis=new FileInputStream("file.txt");
            OutputStream os=s.getOutputStream();
            PrintWriter out = new PrintWriter(os, true);

            //
            String correctPassword = "12345"; 
            out.println("Enter password:");
            String receivedPassword = in.readLine();

            if (!correctPassword.equals(receivedPassword)) {
                out.println("Authentication failed. Connection closing.");
                System.out.println("Client failed authentication.");
                return;
            }

            out.println("Authentication successful! Sending file...");
       


        /*Listing all files
         File folder=new File(".");
        File[] files=folder.listFiles();
        if(files!=null)
        {
            for(File f:files)
            {
                System.out.println(f.getName());
            }
        }
        else{
            System.out.println("No files found");
        } 
         */
        
             
            

            /* to check if file exists
             File file=new File("file.txt");
            if(!file.exists())
            {
                System.out.println("File doesnt exist");
            }
            {
             */
            
           
            //code for writing to file
           /* 
              System.out.println("Enter data");
              String message=sc.nextLine()
              out.println(message);
           */

             while((bytesread=fis.read(buffer))!=-1)
             {
              os.write(buffer,0,bytesread);
             }
            

            fis.close();
            os.close();
            s.close();
            ss.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception");
        }   



    }
}