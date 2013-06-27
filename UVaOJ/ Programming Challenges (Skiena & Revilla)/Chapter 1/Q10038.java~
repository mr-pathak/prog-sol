/* @JUDGE_ID: mr_pathak 10038 JAVA "Chapter 2: Jolly Jumper" */

/* @BEGIN_OF_SOURCE_CODE */

import java.util.Scanner;

public class Q10038 {
    
    public static void main(String args[]) {
        String op="";
        try {
            
            Scanner src=new Scanner(System.in);
            
            while (src.hasNext()) {
		    int n=src.nextInt();
		    boolean j=true;
		    
		    for (int i=n-1,prev,diff,curr=src.nextInt();i>0;i--) {
		        prev=curr;
		        curr=src.nextInt();
		        diff=Math.abs(curr-prev);
		        if (diff<1 || diff>n) {
		            j=false;
		            src.nextLine();
		            break;
		        }
		    }
		    
		    if (j) 
		        op+="\nJolly";
		    else 
		        op+="\nNot jolly";
            }
            System.out.print(op.substring(1));
        } 
	catch(Exception e)
        {
            System.exit(0);
        }
    }
}
