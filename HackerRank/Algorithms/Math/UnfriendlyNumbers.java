import java.util.Scanner;

class Solution {
    public static void main(String args[]){
        try{
        int N=-1,K=-1,divisors[],ans=0;
        long unf[];
        Scanner src=new Scanner(System.in);
        String ip,divisor[],ret="";
        
        N=src.nextInt();
        K=src.nextInt();
        
        unf=new long [N];
        
        for(int i=0;i<N;i++)
            unf[i]=src.nextLong();
         
        
        for (int i=K; i>0; i--)
         if (K%i == 0)
            ret+=i+" ";
        
        divisor=ret.split(" ");
        divisors=new int[divisor.length];
        
        for(int i=0;i<divisor.length;i++)
            divisors[i]=Integer.parseInt(divisor[i]);
        
        Outer:
        for(int i=0;i<divisors.length;i++){  
            for(int j=0;j<unf.length;j++)
                if(unf[j]%divisors[i]==0)
                    continue Outer;
            ans++;
        }
        System.out.print(ans);
    }
    catch(Exception ex)
    {System.out.println(ex);}
}
}
