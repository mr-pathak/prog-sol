/* @JUDGE_ID: mr_pathak 10189 JAVA "Chapter 1: Minisweeper problem" */

/* @BEGIN_OF_SOURCE_CODE */

import java.util.Scanner;


public class Q10189 {
    public static void main(String args[]) {
        try {
            Scanner src=new Scanner(System.in);
            int n=src.nextInt();
            int m=src.nextInt();
            int f_count=0;
            
            String op="";
            
            while (n!=0 || m!=0) {
                f_count++;
                byte g[][]=new byte[n+2][m+2];            
                for (int i=1;i<=n;i++) {
                    char col[]=src.next().toCharArray();
                    for (int j=1;j<=m;j++)
                        if (col[j-1]=='*') {
                            g[i][j]=-10;
                            
                            g[i-1][j-1]++;
                            g[i-1][j]++;
                            g[i-1][j+1]++;
                            
                            g[i][j-1]++;
                            g[i][j+1]++;
                            
                            g[i+1][j-1]++;
                            g[i+1][j]++;
                            g[i+1][j+1]++;
                        }                            
                }
                op+="\nField #"+f_count+":\n";
                
                //print array
                for (int i=1;i<=n;i++){
                    for (int j=1;j<=m;j++) {
                        if (g[i][j]<0)
                            op+="*";
                        else 
                            op+=g[i][j];                        
                    }
                    op+="\n";
                }
                n=src.nextInt();
                m=src.nextInt();
            }
            System.out.print(op.substring(1));
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
