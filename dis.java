import java.util.*;

public class dis{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of node");
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
                if(a[i][j]!=999)
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
                for(int k=0;k<n;k++)
                {
                    if(dist[i][k]!=999 && dist[k][j]!=999)
                    {
                        if(dist[i][k]+dist[k][j]<dist[i][j])
                        {
                            dist[i][j]=dist[i][k]+dist[k][j];
                            next[i][j]=next[i][k];
                            changed=true;
                        }
                    }
                }
            }
        }
    }

    for(int i=0;i<n;i++)
    {
        System.out.println("Router "+i);
        for(int j=0;j<n;j++)
        {
            System.out.println(dist[i][j]+" "+next[i][j]);
        }
    }
    }
}