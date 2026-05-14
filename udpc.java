import java.net.*;

public class udpc{
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(); // random client port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;

            while (true) {
                
                String messageToSend = "hello";
                byte[] sendData = messageToSend.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);

                
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server says: " + reply);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
