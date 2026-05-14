import java.util.*;
public class leaky{
public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter Bucket capacity");
    int c=sc.nextInt();

    System.out.println("Enter Leak Rate");
    int r=sc.nextInt();

    System.out.println("Enter Number of Processes");
    int n=sc.nextInt();
    int p=n;

    int a[][]=new int[2][n];

    System.out.println("Enter Packets incoming each process");
    for(int i=0;i<n;i++)
    {
        a[0][i]=sc.nextInt();
    }
    System.out.println("Enter Fill pattern for each process");
    for(int i=0;i<n;i++)
    {
        a[1][i]=sc.nextInt();
    }

    int stored=0;
    int dropped=0;
    int fill=0;

    while(p>0)
    {
    for(int i=0;i<n;i++)//each process
    {
        if(a[0][i]!=0)
        {
        fill=Math.min(a[0][i],a[1][i]);
        stored+=fill;
        a[0][i]-=fill;
        if(a[0][i]==0) p--;

        if (stored>c)
        {
            dropped+=stored-c;
            stored=c;
            System.out.println("Bucket overflow! Dropped " + dropped + " packets");
        }
        int leaked = Math.min(stored, r);
        stored-=leaked;
    System.out.println("Filled " +fill+ " bytes from p"+(i+1)+" bucket="+(stored+leaked)+" Remaining in p"+(i+1)+" " + a[0][i] + ", Leaked=" + leaked + ", Remaining in bucket=" + stored);
    }}
    }
}
}