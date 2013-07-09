import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {

        Scanner src=new Scanner(System.in);
        Set<String> all_ss=new HashSet();
        
        for(int n=src.nextInt();n>0;n--){
            
            char c[]=src.next().toCharArray();
            for(int z=0,len=c.length;z<len;z++)
                for(int l=1;l<=len-z;l++)
                all_ss.add(new String(c,z,l));
            
        }
        String s[]= all_ss.toArray(new String[0]),opt="";
        Arrays.sort(s);
        for(int q=src.nextInt(),in,len=s.length;q>0;q--)
            if(len>(in=src.nextInt()-1))
                opt+=s[in]+"\n";
            else opt+="INVALID\n";
        System.out.println(opt);

    }
}
