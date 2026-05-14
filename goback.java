import java.util.*;

public class goback{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();

        System.out.println("Enter number frames");
        int n=sc.nextInt();

        System.out.println("Enter window size");
        int w=sc.nextInt();

        System.out.println("Enter probability");
        float p=sc.nextFloat();

        int i=0;
        while(i<n)
        {
            int errorindex=-1;
            boolean erroroccured=false;
            for(int j=i;j<i+w && j<n;j++)
            {if(rand.nextFloat()<p)
            {
                System.out.println("packet " +j+" lost");
                errorindex=j;
                erroroccured=true;
                break;
            }
            else
            {
                System.out.println("packet "+j+" sent successfully");
            }}
            if(erroroccured)
            {
                System.out.println("Retransmitting packet "+errorindex);
                i=errorindex;
            }
            else
            {
            
            boolean acklost=false;
            for(int j=i;j<i+w && j<n;j++)
            {
            if(rand.nextFloat()<p)
            {
                System.out.println("ack " +j+" lost");
                errorindex=j;
                acklost=true;
                break;
            }
            else
            {
                System.out.println("ack "+j+" sent successfully");
            }}
            if(acklost)
            {
                System.out.println("Retransmitting packet "+errorindex);
                i=errorindex;
            }
            else
            {
                System.out.println("All packets sent successfully.Sliding window");
                i=i+w;
            }

        }
        }
    }
}