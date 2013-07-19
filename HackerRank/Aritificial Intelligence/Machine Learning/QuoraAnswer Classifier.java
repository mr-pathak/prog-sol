import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner src=new Scanner(System.in);
        int M,N,q;
        
        N=src.nextInt();
        M=src.nextInt();
        src.nextLine();
        
        Data.M=M;
        
        ArrayList<Data> data_p1=new ArrayList<>();
        ArrayList<Data> data_m1=new ArrayList<>();
        
        Data tmp_data,avg_p1=new Data(),avg_m1=new Data();
        
        
        String p1="+1",tmp_str,op="";
        
        for(int i=0;i<N;i++) {
            src.next();
            tmp_data=new Data();
            if(p1.equals(src.next())){
                    for(int j=0;j<M;j++){
                            tmp_str=src.next();
                            tmp_data.param[j]=Double.parseDouble(tmp_str.substring(tmp_str.indexOf(':')+1));
                            avg_p1.param[j]+=tmp_data.param[j];
                    }
                    data_p1.add(tmp_data);
            } else{
                    for(int j=0;j<M;j++){
                            tmp_str=src.next();
                            tmp_data.param[j]=Double.parseDouble(tmp_str.substring(tmp_str.indexOf(':')+1));
                            avg_m1.param[j]+=tmp_data.param[j];
                    }
                    data_m1.add(tmp_data);
            }
                
        }
        
        //find avg col and e dist;
        int no_p1=data_p1.size();
        int no_m1=data_m1.size();
        
        for(int i=0;i<M;i++){
            avg_p1.param[i]/=no_p1;
            avg_m1.param[i]/=no_m1;
        }
        q=src.nextInt();
        
        double ep1,em1;
        String name;
        for(int i=0;i<q;i++) {
            name=src.next();
            tmp_data=new Data();
            for(int j=0;j<M;j++){
                    tmp_str=src.next();
                    tmp_data.param[j]=Double.parseDouble(tmp_str.substring(tmp_str.indexOf(':')+1));
            }
            ep1=avg_p1.cal_e_dist(tmp_data);
            em1=avg_m1.cal_e_dist(tmp_data);
            
            if(ep1<em1)
                op+=name+" +1\n";
            else op+=name+" -1\n";
            //SOLVE
            
        }
        System.out.println(op);
    }
}

class Data {
    static int M=0;
    double param[];
    //double e_dist;
    Data() {
        param=new double[M];
    }
    
    double cal_e_dist(Data avg) {
        double e_dist=0;
        double tmp;
        for(int i=0;i<M;i++){
            tmp=(avg.param[i]-this.param[i]);
            e_dist+=tmp*tmp;
            
        }
        
        return Math.log10(Math.abs(e_dist));
    }
}

