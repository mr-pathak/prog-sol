import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner src = new Scanner(System.in);
        String op="";
        for(int c=src.nextInt();c>0;c--) {
            char[] s = src.next().toCharArray();
            int ans=0;
            for(int i=0;i<s.length;i++)
                for(int j=i;j<s.length;j++){
                    if(s[j-i]!=s[j])
                        break;
                    ans++;
                }
            op+=ans+"\n";
        }
        System.out.println(op);
    }
}
