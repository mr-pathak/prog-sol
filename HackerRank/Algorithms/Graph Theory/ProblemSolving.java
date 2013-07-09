import java.util.Scanner;

class Solution {
    
    Scanner src=new Scanner(System.in);
    int T,N,K,v[],mday,slvd[];
            
    
    void run() 
    {
        T=src.nextInt();String ans="";
        while(T-->0)
        {
            N=src.nextInt();K=src.nextInt();v=new int[N];slvd=new int[N];mday=N;
            for(int i=0;i<N;i++)
                v[i]=src.nextInt();
            solve0();
            ans+=mday+"\n";
        }
        System.out.print(ans);
    }
    
    void solve(int k,int nd)
    {
        if(k==N)
        {  
            mday=mday>nd?nd:mday;
            return;
        }
        
        for(int i=0;i<N;i++)
        {
            if((v[i]-slvd[k-1]>=K || v[i]==slvd[k-1])&&v[i]!=Integer.MAX_VALUE)
            {
                slvd[k]=v[i];int y=v[i];
                v[i]=Integer.MAX_VALUE;
                solve(k+1,nd);
                v[i]=y;
            }
            else
            for(int j=0;j<N;j++)
                if(v[j]!=Integer.MAX_VALUE)
                    {
                     int y=v[j];   
                     slvd[k]=y;
                     v[j]=Integer.MAX_VALUE;
                     solve(k+1,nd+1);
                     v[j]=y;
                    }
            
        }
        
    }

    public static void main(String a[])
    {
        Solution s=new Solution();
        s.run();
    }

    private boolean ntSolved(int i,int k) {
        for(int x=0;x<k;x++)
            if(slvd[x]==i || i==Integer.MAX_VALUE )
                return false;
        return true;
    }

    private void solve0() {
        for(int i=0;i<N;i++)
        {
            slvd[0]=v[i];
            v[i]=Integer.MAX_VALUE;
            solve(1,1);
            v[i]=slvd[0];
        }
    }
}

