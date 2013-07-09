import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

/* Head ends here */
    static void next_move(int posx, int posy, String[] board){
    int bx=posx, by=posy;
    int px=-1,py=-1,mind=Integer.MAX_VALUE;
    String op;
    int n=board.length;
    for(int i=0;i<n;i++) {
        char cs[]=board[i].toCharArray();
        for(int j=0,dx,dy;j<n;j++){
            if(cs[j]=='d'){
                dx=i-bx;
                dy=j-by;
                if((Math.abs(dx)+Math.abs(dy))<mind) {
                    mind=Math.abs(dx)+Math.abs(dy);
                    px=i;
                    py=j;
                }
            }
        }
    }
    int dx=px-bx,dy=py-by;
    
    if(dx==0&&dy==0) op="CLEAN\n";
    else
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


/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}

