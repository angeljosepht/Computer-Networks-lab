import java.util.*;

public class stop{
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        Random rand=new Random();

        System.out.println("Enter number of frames to send");
        int n=sc.nextInt();

        System.out.println("Enter packet loss probability(0 to 1)");
        Float p=sc.nextFloat();


        for(int i=0;i<n;i++)
        {
        boolean ackrecieved=false;
        while(!ackrecieved)
        {
            System.out.println("Sending Frame " + i);
            if(rand.nextFloat()<p)
            {
                System.out.println("packet " + i +" lost");
            }
            else
            {
                System.out.println("packet " + i +" recieved");
                if(rand.nextFloat()<p)
              {
                System.out.println("Acknwoledgement " + i +" lost");
                ackrecieved=false;
              }
              else
              {
                System.out.println("Acknowledgement " + i +" recieved");
                ackrecieved=true;
              }
            }

            

            if (!ackrecieved) {
                    System.out.println("Timeout! Resending Frame " + i + "...\n");
                }

        }
      }
    }
}