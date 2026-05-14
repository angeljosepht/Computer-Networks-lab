import java.util.*;

public class sel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter number of frames:");
        int n = sc.nextInt();

        System.out.println("Enter window size:");
        int w = sc.nextInt();

        System.out.println("Enter probability of loss of packets (0 to 1):");
        float p = sc.nextFloat();

        boolean[] ackReceived = new boolean[n]; 
        int nextFrame = 0;

        while (nextFrame < n) {
            for (int i = nextFrame; i < nextFrame + w && i < n; i++) 
            {
                if (!ackReceived[i]) 
                {
                    if (rand.nextFloat() < p) 
                        System.out.println("Frame " + i + " lost");
                    else {
                        System.out.println("Frame " + i + " sent successfully.");
                        if (rand.nextFloat() < p) {   
                          System.out.println("ACK for Frame " + i + " lost!");
                        } 
                        else {
                          ackReceived[i] = true; 
                          System.out.println("ACK for Frame " + i + " received.");
                        }
                    }
                }
            }
            while (nextFrame < n && ackReceived[nextFrame]) {
                nextFrame++;
            }
        }
    }
}
