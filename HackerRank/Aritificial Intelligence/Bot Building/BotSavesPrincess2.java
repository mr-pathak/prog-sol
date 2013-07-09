import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

static void nextMove(int n, int x, int y, String [] board){
    int px=-1,py=-1,bx=x, by=y;
    String op;
    
    for(int i=0;i<n;i++) {
        if((py=board[i].indexOf('p'))>-1){
            px=i;
            break;
        }
    }
     
    int dx=px-bx,dy=py-by;
    if(Math.abs(dx)>Math.abs(dy))
    {
        if(dx>0)op="DOWN\n";
        else op="UP\n";
    
    }
    else
    {
        if(dy>0)op="RIGHT\n";
        else op="LEFT\n";
    }
    System.out.print(op);
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,x,y;
        n = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        in.useDelimiter("\n");
        String board[] = new String[n];


        for(int i = 0; i < n; i++) {
            board[i] = in.next();
        }

    nextMove(n,x,y,board);

    }
}
