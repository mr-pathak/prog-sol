import java.util.*;

public class Solution {

/* Complete the function below to print 2 integers separated by a single space which will be your next move */
    static String nextMove(String player, String [] board){
        TicTacToeAI ttt= new TicTacToeAI();
        int player_= "X".equals(player)?1:-1;
        char[]s=(board[0]+board[1]+board[2]).toCharArray();
        
        for(int i=0;i<9;i++)
            if(s[i]=='X')ttt.Move(i+1, 1);
            else if(s[i]=='O')ttt.Move(i+1, -1);
        
        
        int ret=ttt.GenerateMove(player_)-1;
        
        return ret/3+" "+ret%3;
  }
  
  public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player;
        String board[] = new String[3];

        //If player is X, I'm the first player.
        //If player is O, I'm the second player.
        player = in.next();

        //Read the board now. The board is a 3x3 array filled with X, O or _.
        for(int i = 0; i < 3; i++) {
            board[i] = in.next();
        }

        System.out.println(nextMove(player,board));   
    
    }
}



class TicTacToeAI {
	
	private int X = 0, O = 0;
	private void put(int pos) {
		X = X | pos & -((pos >> 31) + 1) & ~O;
		O = O | -pos & (pos >> 31) & ~X;
	}
	private void clear(int pos) {
		X = X & ~pos;
		O = O & ~pos;
	}

	private boolean Check(int P) {
		return  (P & 0x007) == 7 || 
				(P & 0x038) == 0x038 || 
				(P & 0x1C0) == 0x1C0 || 
				(P & 0x049) == 0x49 || 
				(P & 0x092) == 0x92 || 
				(P & 0x124) == 0x124 || 
				(P & 0x111) == 0x111 ||
				(P & 0x054) == 0x54;
	}

	private int GameOver() {
		return Check(X) ? 2048 : Check(O) ? 512 : ((X | O) & 511) == 511 ? 1024 : 0;
	}
	private int NegaMax(int p) {
		int End = GameOver();
		if (End != 0)
			return End;

		int best_value = (p == 1) ? 512 : 2048;
		for (int b = 1; b <= 256; b = b << 1) {
			int move = (~(X | O) & b);
			if (move != 0) {
				put(p * move);
				int s = NegaMax(-p);
				best_value = p * (s & 0xfffffe00) > p
						* (best_value & 0xfffffe00) ? ((s & 0xfffffe00) | move)
						: best_value;
				clear(move);
			}

		}
		return best_value;
	}

	private int PosToBit(int pos) {
		return pos>=1 && pos<=9 ? 1<<(pos-1) : 0;
	}

	private int BitToPos(int bitNum) {
		int result = 1;
		while ( (bitNum=bitNum>>1) > 0 ) result++;   
        return result;
	}
	public boolean Move(int pos, int player) {
		int p = PosToBit(pos);
		if ( p!=0  && ( player==1 || player==-1 ) && ((X | O) & p)==0) {
		  put(p*player);
		  return true;
		} else
		  return false; 
	}
 
	
	public int GenerateMove(int Player) {
		return BitToPos((NegaMax(Player) & 511));
	}

	public int getX() {
		return X;
	}
    public int getO() {
		return O;
	}
    public int getBoard() {
		return (X|O);
	}
	public void NewGame() {
		X=O=0;
	}
	public int isGameOver() {
		return Check(X) ? 1 : Check(O) ? -1 : ((X | O) & 511) == 511 ? 2 : 0;
	}
}
/*
license: http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_US
 */

