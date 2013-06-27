/* @JUDGE_ID: mr_pathak 10137 JAVA "Chapter 1: The Trip" */

/* @BEGIN_OF_SOURCE_CODE */

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Q10137 {
    public static void main(String args[]) {
        try {
            
            Scanner src=new Scanner(System.in);
            int n=src.nextInt();
            String op="";
            while(n!=0){
                double exp[]=new double[n];
                double avg=0;
                double ans=0;
                DecimalFormat formatter = new DecimalFormat("$0.00");
                
                for (int i=0;i<n;i++) {
                    exp[i]= Math.round((src.nextDouble()) * 100.0) / 100.0;
                    avg+=exp[i];
                }
                
                avg=avg/n;
                avg= Math.round(avg * 100.0) / 100.0;
                
                Arrays.sort(exp);
                int i=Arrays.binarySearch(exp, avg);
                if(i<0)i=0-i-1;
                if(exp[i]>avg)i--;
                
                for(int x=i;x>=0;x--)
                    ans=ans+(avg-exp[x]);
                
                op+="\n"+formatter.format(ans);
                n=src.nextInt();
            }
            if(op.length()>0)
                System.out.println(op.substring(1));
            
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
            
