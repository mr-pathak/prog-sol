import java.util.Arrays;
import java.util.Scanner;

class Solution {

private int N,pj[],ej[];

    public Solution(int N) {
        this.N = N;
        pj=new int[N+1];
        ej=new int[N+1];
    }
    
    private void prime_pj()
    {
        Arrays.fill(pj,1);
	for(int i=2;i*i<=N;i++)
            if(pj[i]==1)
            for(int j=i;j*i<=N;j++)
		pj[j*i]=0;
    }
    
    private void get_factors_ej()
    {
        Arrays.fill(ej,-1);
	for(int i=2;i<=N;i++)
            if(pj[i]==1)
             {
                int e=0;
                for(int x=N;x!=0;x/=i)
                 e+=x/i;
                ej[i]=2*e+1 ;
             }
    }   
            
    
    public void display()
    {
        prime_pj();
        get_factors_ej();
        long ans=1;
        for( int i=2;i<=N;i++)
          if(ej[i]>0)ans=(ans*ej[i])%1000007;
        System.out.println(ans);
	
    }



public static void main(String args[]) throws Exception
{
	Solution obj=new Solution(new Scanner(System.in).nextInt());
        obj.display();
}

}
