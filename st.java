import java.util.*;

public class st{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of nodes");
        int n=sc.nextInt();

        int a[][]=new int[n][n];

        System.out.println("Enter cost matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        int dist[]=new int[n];
        
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            visited[i]=false;
            dist[i]=9999;
        }

        dist[0]=0;

        for(int count=0;count<n-1;count++)
        {
            int u=-1;
            int mindist=999;
            for(int i=0;i<n;i++)
            {
                if(!visited[i] &&dist[i]<mindist)
                {
                    mindist=dist[i];
                    u=i;
                }
            }
            visited[u]=true;

            for(int v=0;v<n;v++)
            {
                if(!visited[v] && a[u][v]!=0 && dist[u]+a[u][v]<dist[v])
                {
                    dist[v]=dist[u]+a[u][v];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                    System.out.print(dist[i]);        
            }System.out.println();
        }
    }
}