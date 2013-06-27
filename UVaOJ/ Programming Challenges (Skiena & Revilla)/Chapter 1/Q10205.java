import java.util.Scanner;

/**
 * UVa Judge Problem #10205 : Stack -em up
 */

class Main {
    public static void main(String args[]) {
        try {
            Scanner src=new Scanner(System.in);
            int test_cases=src.nextInt();
            String op="";
            
            int NCARDS_SUIT=13;
            int NCARDS=52;
            
            String SUITS[]={"Clubs", "Diamonds", "Hearts", "Spades"};
            String VALUES[]="2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace".split(","); 

            while (test_cases!=0) {
                
                int n=src.nextInt(); // no of shuffle
                byte ans[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,
                        14,15,16,17,18,19,20,21,22,23,24,25,26,
                        27,28,29,30,31,32,33,34,35,36,37,38,39,
                        40,41,42,43,44,45,46,47,48,49,50,51};
                
                
                src.nextLine();
                String lines2[]=new String[n];
                for (int i=0;i<n;i++)
                    lines2[i]=src.nextLine()+ " " +src.nextLine();
                
                
                int order[]=new int [n];
                for (int i=0;i<n;i++)
                    order[i]=-1;
                String s;
                int x=0;
                while (x<n && !(s=src.nextLine()).equals(""))
                    order[x++]=Integer.parseInt(s)-1;
                
                for (int i=0;i<n;i++) {
                    if(order[i]==-1)break;
		    byte temp[]=new byte[52];
                    Scanner src1=new Scanner(lines2[order[i]]);
                    for (int j=0;j<NCARDS;j++)
                        temp[j]=ans[src1.nextInt()-1];
                    
                    System.arraycopy(temp, 0, ans, 0, NCARDS);
                }
                

		op+="\n";
                for (int i=0;i<NCARDS;i++)
                    op+=VALUES[ans[i]%NCARDS_SUIT]+" of "+SUITS[ans[i]/NCARDS_SUIT]+"\n";
                
                test_cases--;
            }
            System.out.print(op.substring(1));
            }
        catch (Exception e) {
            System.exit(0);
        }
    }
}

