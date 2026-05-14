import java.net.*;
import java.util.*;

public class ucchat{
    public static void main(String[] args) {
        try{
            DatagramSocket socket=new DatagramSocket();
            InetAddress address=InetAddress.getByName("localhost");

            Scanner sc=new Scanner(System.in);
            while(true)
            {
                System.out.println("Enter a message ");
                String message=sc.nextLine();
                if(message.equals("exit"))
                {
                    System.out.println("chat ended");
                    break;
                }
                
                byte[] buffer=message.getBytes();
                DatagramPacket packet=new DatagramPacket(buffer, buffer.length,address,5000);
                socket.send(packet);

                byte reply[]=new byte[1024];
                DatagramPacket rpacket=new DatagramPacket(reply, reply.length);
                socket.receive(rpacket);
                String replydata=new String(rpacket.getData(),0,rpacket.getLength());
                System.out.println(replydata);

            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}