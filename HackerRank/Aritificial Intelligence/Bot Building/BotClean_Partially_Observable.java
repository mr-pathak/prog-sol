import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    static void next_move(int posx, int posy, String[] board){

    int bx=posx, by=posy;
    int px=-1,py=-1,mind=Integer.MAX_VALUE;
    String op;
        char myb[][]=new char[5][];
    int n=5;

    for(int i=0;i<5;i++)
        myb[i]=board[i].toCharArray();
       
    if (myb[bx][by]=='d')
    {
        System.out.println("CLEAN");
        return;
    }
    
    for(int i=0;i<5;i++) {
        for(int j=0,dx,dy;j<5;j++){
            if(myb[i][j]=='d'){         
                    px=i;
                    py=j;
                }
            }
        }
    
    int dx=px-bx,dy=py-by;
    
    if(dx==0&&dy==0) {op="CLEAN\n";myb[bx][by]='-';}
    else
        if(px==-1){
        px=-1;py=-1;mind=-1;
            for(int i=0;i<5;i++) {
                for(int j=0;j<5;j++){
                    if(myb[i][j]=='o'){
                        px=i;
                            py=j;
                        
                    }
                }
            }
            dx=px-bx;dy=py-by;
            if(Math.abs(dx)>Math.abs(dy))
            {
                if(dx>0)op="DOWN\n";
                else op="UP\n";

            }
            else
                if(Math.abs(dx)==Math.abs(dy))
                {
                    int ran=(int) Math.random();
                    if(ran%2==0){
                            if(dy>0)op="RIGHT\n";
                            else op="LEFT\n";
                            
                     }
                     else
                     {
                            if(dx>0)op="DOWN\n";
                            else op="UP?\n"+px+py;
                     }
                }
                    else
                    {
                        if(dy>0)op="RIGHT\n";
                        else op="LEFT\n";
                    }
        }
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

