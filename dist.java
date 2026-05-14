import java.util.*;

public class dist{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of nodes");
        int n=sc.nextInt();

        int a[][]=new int[n][n];
        int dist[][]=new int[n][n];
        int next[][]=new int[n][n];

        System.out.println("Enter cost matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                dist[i][j]=a[i][j];
                if(dist[i][j]!=999)
                next[i][j]=j;
                else
                next[i][j]=-1;
            }
        }

        boolean changed=true;
        while(changed)
        {
        changed=false;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int upd=0;
                for(int k=0;k<n;k++)
                    {
                        if(dist[i][k]!=999 || dist[k][j]!=999)
                        {
                            upd=a[i][k]+dist[k][j];
                            if(upd<dist[i][j])
                            {
                               dist[i][j]=upd;
                               next[i][j]=k;
                               changed=true;
                            }

                        }
                    }
                    
            }
        }
    }
        
    System.out.println("Routing Tables");
    for(int i=0;i<n;i++)
        {
            System.out.println("Router "+i);
            System.out.println("Distance   | next hops");
            for(int j=0;j<n;j++)
            {
                System.out.println(dist[i][j] +"    "+next[i][j]);
            }
        }

       
    }
}