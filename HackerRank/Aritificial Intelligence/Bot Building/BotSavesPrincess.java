import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

static void displayPathtoPrincess(int n, String [] grid){
    int h_n=n/2;
    int px=-1,py=-1,bx = h_n, by=h_n;
    String op="";
    for(int i=0;i<n;i++) {
        if((py=grid[i].indexOf('p'))>-1){
            px=i;
            break;
        }
    }
     String ver=px>bx?"DOWN\n":"UP\n",hor=py>by?"RIGHT\n":"LEFT\n";
     while(h_n-->0)
         op+=ver+hor;
    System.out.print(op);
}

/* Tail starts here */
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}
