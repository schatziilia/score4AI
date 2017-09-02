/* Chatziilia Sofia 3100202
 * Diniakoy Thaleia 3100132
 */
package texnhth1;

import java.util.ArrayList;

public class Computer {
    private int winner; // o nikitis tou paixnidiou
    private Heuristics h; // antikeimeno pou xrisimopoieitai gia axiologisi twn komvwn , kalei tin euretiki
    private int maxDepth; 
    //private int colorPlaying;
    
    
    public Computer(){
	maxDepth = 6;
	//colorPlaying= BoardGame.getBlue();
        h = new Heuristics();
    }//constructor
	
    public Computer(int maxDepth, int colorPlaying){
	this.maxDepth = maxDepth;
	//this.colorPlaying = colorPlaying;
        h = new Heuristics();
    }//constructor
    
    
   //Initiates the MiniMax algorithm with a-b pruning
   public BoardGame alpha_beta_search(BoardGame board){
        //BoardGame copy = board.copy_board(board);
        BoardGame best_move = null;
	int best_value = Integer.MIN_VALUE;
	ArrayList <BoardGame> children = board.getChildren();
	for(int i=0; i<children.size(); i++){
            int score = min_value(children.get(i),Integer.MIN_VALUE,Integer.MAX_VALUE,0);
            if(score > best_value){
		best_value = score;
		best_move = children.get(i);
            }//if
	}//for
        
	return best_move;    
    }//alpha_beta_search()

   private int max_value(BoardGame board , int a , int b , int depthIn){
	/*a einai i timi tis kaliteris enalaktikis epilogis tou max panw sti diadromi pros to board
	 *b einai i timi tis kaliteris enalaktikis epilogis tou min panw sti diadromi pros to board
	*/
	if(isTerminal(board)){//an eimaste se teliki katastasi, des pios kerdise
            if(winner==1){//an kerdise o ipologistis
               return 100000; //dwse tou ena megalo noumero
            }else if(winner==-1){//an kerdise o anthrwpos
               return -100000;//dwse toconstructoru to antistoixo arnitiko noumero
            }else{
		return 0;//aliws isopalia , dwse 0
            }//if
	}//if
        
	if(depthIn==maxDepth){//to vathos teleiwse
            return h.evaluate(board.getBoard(), 1); //axiologise ton komvo xrisimopoiwntas tin euretiki
	}//if

	int v = Integer.MIN_VALUE;
	ArrayList <BoardGame> children = board.getChildren();//ftiaxe ta paidia
	for(BoardGame c : children){
			int score = min_value(c, a, b, depthIn+1);//aksiologise ta paidia kai proxwra ena epipedo katw
			if(score > v){
				v=score; // krataei to kalitero max score
			}
			if(v >= b){
				return v;
			}/*prionisma me b*/
			if(v > a){
				a=v;
			}//enimerwsi tou a komvou max pou vriskomaste
		}
		return v;
	}//anaparista tous max komvous kai prospathei na megistopoihsei tin aksia tou min
	
	private int min_value(BoardGame board , int a , int b , int depthIn){
		if(isTerminal(board)){//an eimaste se teliki katastasi, des pios kerdise
			if(winner==1){//kerdise o ipologistis
				return 100000;//dwse tou ena autheraita megalo noumero
			}else if(winner==-1){//kerdise o anthrwpos
				return -100000;//dwse tou to antistoixo arnitiko noumero
			}else{
				return 0;//isopalia , dwse 0
			}
		}
		if(depthIn==maxDepth){//to vathos teleiwse
			return h.evaluate(board.getBoard(), -1);//axiologise ton komvo xrisimopoiwntas tin euretiki
		}
		
		int v = Integer.MAX_VALUE;
		ArrayList <BoardGame> children = board.getChildren();
		for(BoardGame c : children){
			int score = max_value(c, a, b, depthIn+1);
			if(score < v){//krataei to kalitero min score 
				v=score;
			}	
			if(v <= a){
				return v;
			}/*prionisma me a*/
			if(v < b){
				b = v;//enimerwsi tou b komvou min pou vriskomaste
			}
		}
		return v;
	}//anaparista tous min komvous kai prospathei na elaxistopoihsei tin aksia tou max
    
//telos ilopoiisis algorithmou
        
    public boolean isTerminal(BoardGame b){    //vriskei an einai to paixnidi einai se teliki katastasi
        int sit[][] = b.getBoard(); 
        int winner = 0;
        
        //elegxos gia orizontia niki
        for(int r = 0; r<6; r++){
			if( (sit[r][0]==sit[r][1] && sit[r][1]==sit[r][2] && sit[r][2]==sit[r][3] && sit[r][3]!=0) 
			   || (sit[r][1]==sit[r][2] && sit[r][2]==sit[r][3] && sit[r][3]==sit[r][4] && sit[r][4]!=0)
			   || (sit[r][2]==sit[r][3] && sit[r][3]==sit[r][4] && sit[r][4]==sit[r][5] && sit[r][5]!=0)
			   || (sit[r][3]==sit[r][4] && sit[r][4]==sit[r][5] && sit[r][5]==sit[r][6] && sit[r][6]!=0) )
			{
				if(sit[r][3]==1 || sit[r][4]==1 || sit[r][5]==1 || sit[r][6]==1){
					winner = 1;
				}//if
				if(sit[r][3]==-1 || sit[r][4]==-1 || sit[r][5]==-1 || sit[r][6]==-1){
					winner = -1;
				}//if
				return true;
			}//if
		}//for
		
		//elegxos gia kathetes nikes
		for(int c=0; c<7; c++){
		    if( (sit[0][c]==sit[1][c] && sit[1][c]==sit[2][c] && sit[2][c]==sit[3][c] && sit[3][c]!=0)
		    	|| (sit[1][c]==sit[2][c] && sit[2][c]==sit[3][c] && sit[3][c]==sit[4][c] && sit[4][c]!=0)
		        || (sit[2][c]==sit[3][c] && sit[3][c]==sit[4][c] && sit[4][c]==sit[5][c] && sit[5][c]!=0) )
		    {
		    	if(sit[3][c]==1 || sit[4][c]==1 || sit[5][c]==1){
					winner = 1;
				}//if
				if(sit[3][c]==-1 || sit[4][c]==-1 || sit[5][c]==-1){
					winner = -1;
				}//if
		    	return true;
		    }//	if
		}//for
		
		//elegxos gia diagwnies nikes
		
		//elegxos apo katw pros ta panw(kai pigainwntas apo aristera pros dexia)
		for(int row=5; row>=3; row--){
			for(int col=0; col<4; col++){
				if(sit[row][col]!=0 &&
				   sit[row][col]==sit[row-1][col+1] &&	
				   sit[row][col]==sit[row-2][col+2] &&
				   sit[row][col]==sit[row-3][col+3])
				{
					if(sit[row][col]==1){
						winner = 1;
					}//if
					if(sit[row][col]==-1){
						winner = -1;
					}//if
					return true;
				}//if
			}//for
		}//for
		
		//elegxos apo panw pros ta katw(kai pigainwntas apo aristera pros dexia)
		for(int row=0; row>=2; row++){
			for(int col=0; col<4; col++){
				if(sit[row][col]!=0 &&
				   sit[row][col]==sit[row+1][col+1] &&	
				   sit[row][col]==sit[row+2][col+2] &&
				   sit[row][col]==sit[row+3][col+3])
				{
					if(sit[row][col]==1){
						winner = 1;
					}//if
					if(sit[row][col]==-1){
						winner = -1;
					}//if
					return true;
				}//if
			}//for
		}//for
        
        return false;
    }//isTerminal
    
    
}//class computer
