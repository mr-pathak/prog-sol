import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        
        int N = src.nextInt();
        int Q = src.nextInt();
        StringBuilder op= new StringBuilder();
        
        char[] a=new char[N],b=new char[N];
        StringBuilder as = new StringBuilder(src.next());
        StringBuilder bs = new StringBuilder(src.next());
        as.reverse();
        bs.reverse();
        as.getChars(0, N, a, 0);bs.getChars(0, N, b, 0);
        
        String query;
        for(int i=Q,id,pid;i>0;i--) {
            query=src.next();
            id=src.nextInt();
            
            switch (query) {
                case "set_a":
                    a[id]=src.next().charAt(0);
                    break;
                case "set_b":
                    b[id]=src.next().charAt(0);
                    break;
                case "get_c":
                    
                    pid=0;
                    
                    if(id!=N && a[id]=='0' && b[id]=='0'){
                        op.append('0');
                        continue;
                    }
                    
                    for(int j=id-1;j>=0;j--)
                        if(a[j]==0 && b[j]==0) {
                            pid=j;
                            break;
                        }
                    
                    boolean carry=false;
                    
                    for(int j=pid;j<id;j++) {
                        
                        if(!carry) {
                            if(a[j]=='1' && b[j]=='1')
                                carry=true;
                        } else //no carry
                            if(a[j]=='0' && b[j]=='0')
                                carry=false;
                    }
                    //carry ,a,b=? id==N?
                    if(id==N) {
                        if(carry) op.append('1');
                        else op.append('0');
                        continue;
                    }
                    if(!carry){
                        if(a[id]=='1') {
                            if(b[id]=='1')
                                op.append('0');
                            else op.append('1');
                        }
                        else {
                            if(b[id]=='1')
                                op.append('1');
                            else op.append('0');
                        }    
                    } else {
                        if(a[id]=='1') {
                            if(b[id]=='1')
                                op.append('1');
                            else op.append('0');
                        }
                        else {
                            if(b[id]=='1')
                                op.append('0');
                            else op.append('1');
                        }
                    }
            }
            
        }
        System.out.println(op);
    }
}

