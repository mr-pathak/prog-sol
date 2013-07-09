import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mitesh Pathak
 */
class Solution {
    public static void main(String args[])
    {
        Scanner src=new Scanner(System.in);
        int N=src.nextInt(),M=src.nextInt(),sum,front,flag,even_ans=0,A[][],count[];
        A=new int[M][2];
        count=new int[N+1];
        for(int i=0;i<M;i++)
        {
            A[i][0]=src.nextInt();
            A[i][1]=src.nextInt();
        }
        
        for(int i=1;i<=N;++i)
        count[i]=1;
    
        for(int i=0;i<M;++i)
        count[A[i][1]]=0;
        
        ArrayList<Integer> q=new ArrayList();
        
        for(int i=N;i>=0;i--)
        {
            q.add(i);
            sum=0;
            
            while(!q.isEmpty())
            {
                front=q.get(0);
                q.remove(0);
                flag=0;
                if(count[front]!=0)
                {
                    sum+=count[front];
                    flag=1;
                }
                else sum++;

                if(flag==0)
                for(int j=0;j<M;++j)
                 if(A[j][1]==front)
                    q.add(A[j][0]);
                
            }
            count[i]=sum;
        }
        
        for(int i=2;i<=N;++i)
            if(count[i]%2==0)++even_ans;
        System.out.println(even_ans);
    }
    
}
