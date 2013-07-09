import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String args[]) {
        Scanner src=new Scanner(System.in);
        String op="";
        ArrayList<Vertex> g = new ArrayList();
        
        PriorityQueue<Vertex> pq;
        
        final int N=src.nextInt();
        final int M=src.nextInt();
        
        for(int x=0;x<N;x++) {
            g.add(new Vertex(x));
        }
        
        for(int x=0,w;x<M;x++){
            Vertex u=g.get(src.nextInt());
            Vertex v=g.get(src.nextInt());
            w=src.nextInt();
            
            Edge e=new Edge(u,v,w);
            u.conn.put(v, e);
            v.conn.put(u, e);
        }
            
        final Vertex S=g.get(src.nextInt());
        final Vertex D=g.get(src.nextInt());
        
        /*Iterator ww= g.iterator();
        while((ww.hasNext()))
            System.out.println(ww.next());
        */
        int Q=src.nextInt();
                
                
        while(Q-->0){
            Vertex u=g.get(src.nextInt());
            Vertex v=g.get(src.nextInt());
            
            Edge e= u.conn.get(v);
            int w=e.w;
            
            e.w= 32785;
            
            //dijkstra find min from  s to d
            
               
            pq = new PriorityQueue(25, new Comparator<Vertex>(){
                public int compare(Vertex u,Vertex v){
                    return (u.dfs-v.dfs);
                }
                });
                
            //reset
            for(int y=0;y<N;y++) {
                Vertex x=g.get(y);
                x.dfs=32768;
                x.visited=false;
            }    
            
            //ALGO----DIKSTRA
            {
                Vertex evaluate = S;
                evaluate.visited=true;
                evaluate.dfs=0;
                //as long as we have elements in the Graph to traverse
                while(!D.visited) {
                    
                    Set<Vertex> ver=evaluate.conn.keySet();
                    
                    for(Vertex tmp: ver)
                        if(!tmp.visited){
                            pq.add(tmp);
                            int wt=evaluate.conn.get(tmp).w;
                            
                            if((evaluate.dfs+wt)<tmp.dfs)
                                tmp.dfs=evaluate.dfs+wt;
                    } 
                    evaluate=pq.poll();
                    evaluate.visited=true;
                }
            }

            op+=D.dfs+"\n";
            e.w=w;
        }
        System.out.println(op);
    }
}

class Vertex{
    int id,dfs=32785;
    HashMap<Vertex,Edge> conn;
    boolean visited;
    public Vertex(int id) {
        conn=new HashMap();
        this.id=id;
    }    
    
    public String toString() {
        String s=""+this.id;
        
        Set<Vertex> v=conn.keySet();
        for(Vertex tmp: v){
            s+="\t("+tmp.id+"="+conn.get(tmp).w+")";
        }
        
        return s;
        
    }
}

class Edge {
    Vertex u, v;
    int w;
    public Edge(Vertex u, Vertex v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
