import java.net.*;
import java.io.*;
import java.util.*;

public class ftc{
    public static void main(String args[])
    {
        try{
            Socket s=new Socket("localhost",5000);
            System.out.println("Server connected");


            InputStream is=s.getInputStream();
            FileOutputStream fos=new FileOutputStream("recieved.txt");
            PrintWriter out=new PrintWriter(fos,true);

            out.println("ho");

            byte[] buffer=new byte[1024];
            int bytesread;



            while((bytesread=is.read(buffer))!=-1)
            {
                fos.write(buffer,0,bytesread);
            }

            is.close();
            fos.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println("Except");
        }
    }
}