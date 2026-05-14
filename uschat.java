import java.net.*;
import java.util.*;

public class uschat{
    public static void main(String args[])
    {
        try{
             Scanner sc=new Scanner(System.in);
             DatagramSocket socket=new DatagramSocket(5000);
             byte buffer[]=new byte[1024];

             while(true)
             {
                DatagramPacket packet=new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message=new String(packet.getData(),0,packet.getLength());
                System.out.println("Client says "+message);

                if(message.equalsIgnoreCase("exit"))
                {
                    System.out.println("Chat ended");
                    break;
                }

                System.out.print("You: ");
                String reply=sc.nextLine();
                if(reply.equalsIgnoreCase("exit"))
                {
                    System.out.println("Chat ended");
                    break;
                }

                byte[] replydata=reply.getBytes();
                DatagramPacket replypacket=new DatagramPacket(replydata, replydata.length,packet.getAddress(),packet.getPort());
                socket.send(replypacket);

                System.out.println("Message sent!");

             }

        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
}