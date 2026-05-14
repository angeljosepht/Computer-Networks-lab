import java.util.*;

public class go{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();

        System.out.println("Enter number of frames");
        int n=sc.nextInt();

        System.out.println("Enter size of window");
        int w=sc.nextInt();

        System.out.println("Enter probability of loss of packets(0 to 1)");
        float p=sc.nextFloat();

        int i=0;
        while(i<n)
        {
            boolean erroroccured=false;
            int errorindex=-1;
            for(int j=i;j< w+i && j<n;j++)
            {
                if(rand.nextFloat()<p)
                {
                    System.out.println("frame "+j+"lost");
                    erroroccured=true;
                    errorindex=j;
                    break;
                }
                else
                System.out.println("frame "+j+" sent");
            }
            if(erroroccured)
            {
                System.out.println("retransmitting from frame "+errorindex);
                i=errorindex;
            }
            else
            {
                boolean acklost=false;
                for(int k=i; k< w+i && k<n ;k++)
                {
                if(rand.nextFloat()<p)
                {
                    System.out.println("Ack "+k+"lost");
                    acklost=true;
                    errorindex=k;
                    break;
                }
                else
                {
                    System.out.println("Ack "+k+" received");
                }
                }
                if(acklost)
                {
                    System.out.println("Retransmitting from frame" +errorindex);
                    i=errorindex;

                }
                else
                {
                    System.out.println("All ACKs received. Sliding window forward.");
                    i=i+w;
                }

            }
        }

    }
}