import java.net.*;

public class udps {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            byte[] buffer = new byte[1024];
            System.out.println("UDP server listening on port 5000...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("From " + packet.getAddress() + ":" + packet.getPort() + " -> " + message);

                String reply = "hello";
                byte[] replyb = reply.getBytes();
                DatagramPacket replypacket = new DatagramPacket(replyb, replyb.length, packet.getAddress(), packet.getPort());
                socket.send(replypacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
