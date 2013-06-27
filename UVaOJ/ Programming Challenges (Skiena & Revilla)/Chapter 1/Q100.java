/* @JUDGE_ID: mr_pathak 100 JAVA "Chapter 1: 3n+1 problem" */

/* @BEGIN_OF_SOURCE_CODE */

import java.util.Scanner;

public class Q100 {
    public static void main(String args[]) {
        try {
        Scanner src=new Scanner(System.in);
        
        while (src.hasNext()) {
            int i=src.nextInt();
            int j=src.nextInt();
            int cyc_len[];
            int o_p=-1;
            int l,h;
            if (i>j) {
                h=i;l=j;
            }
            else {
                h=j;l=i;
            }
            //l=lower_bound and h=higher_bound
            cyc_len=new int [(h-l)+1];
            
            for (int n=l,tmp,max=-1,index;n<=h;n++) {
                tmp=n;
                index=n-l;
                cyc_len[index]=1;
                //count cycle length for each n between l & h
                while (tmp!=1) {
                    if(tmp%2==0) 
                        tmp=tmp/2;
                    else 
                        tmp=tmp*3+1;
                    cyc_len[index]++;
                }
                
                if (cyc_len[index]>max) {
                    max=cyc_len[index];
                    o_p=index;
                }                
            }
            
            System.out.println(i+" "+j+" "+cyc_len[o_p]);
        }     
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
/* @END_OF_SOURCE_CODE */
