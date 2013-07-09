import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        int tc=src.nextInt();
        String output="";
        
        while(tc-->0) {
            int a=src.nextInt(),b=src.nextInt();
            String op="";
            int count=0;
            for(int i=a;i<=b;i++)
            {
                op=Integer.toBinaryString(i);
                count+=(op.length()-(op.replace("1","")).length());
            }
            
            output+=count+"\n";
        }
        System.out.print(output);
    }
}
