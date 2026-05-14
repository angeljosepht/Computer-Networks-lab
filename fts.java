import java.net.*;
import java.io.*;
import java.util.*;

public class fts{
    public static void main(String args[])
    {
        try{

            ServerSocket ss=new ServerSocket(5000);
            System.out.println("Server waiting");

            Socket s=ss.accept();
            System.out.println("Client connected");

            byte[] buffer=new byte[1024];
            int bytesread;

            FileInputStream fis=new FileInputStream("file.txt");
            OutputStream os=s.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out=new PrintWriter(os,true);

            String pass=in.readLine();
            if(!pass.equals("123"))
             {System.out.println("Password wrong");
             fis.close();
            os.close();
            s.close();
            ss.close();
             return;

            }



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
            System.out.println("Except");
        }
    }
}