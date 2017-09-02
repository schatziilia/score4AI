/* Chatziilia Sofia 3100202
 * Diniakoy Thaleia 3100132
 */
package texnhth1;
import java.util.ArrayList;
public class BoardGame {
    
    public int board[][]=new int[6][7];
    Move move ;
    int turn;
    private int column_filled;
    private static int red = 1;
    private static int blue = -1;
    private static int empty = 0;
    private int lastColorPlayed;
    
    public BoardGame(){
        //arxikopoihsh board[][]
        this.move= new Move();
        this.turn = blue;
        this.column_filled = 0;
        for(int i=0; i<=5; i++){
           for(int j =0; j<=6; j++){
               board[i][j]=0;
           } //for  
        }//for
    }//constructor

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }


    public void setMove(Move move) {
        this.move = move;
    }
    public void setTurn(int t){
        this.turn= t;
    }
    
    public static void setBlue(int blue) {
        BoardGame.blue = blue;
    }

    public void setLastColorPlayed(int lastColorPlayed) {
        this.lastColorPlayed = lastColorPlayed;
    }

    public static void setRed(int red) {
        BoardGame.red = red;
    }
    
    public static void setEmpty(int empty) {
        BoardGame.empty = empty;
    }
    public Move getMove() {
        return move;
    }
    public int getTurn(){
        return this.turn;
    }
       public static int getBlue() {
        return blue;
    }

    public int getLastColorPlayed() {
        return lastColorPlayed;
    }

    public static int getRed() {
        return red;
    }
    
    public static int getEmpty() {
        return empty;
    }
    
    public int getColumn_filled() {
        return column_filled;
    }

    public void setColumn_filled(int column_filled) {
        this.column_filled = column_filled;
    }

    //afoy ginei kinhsh thn ekxorei sto board efoson einai dynath!
    public void input(Move move){
       if(isPossible(move)){
           board[move.row][move.column]=move.player;
       }else{
           System.out.print("This move is not valid. Try again.");
       } //if
       
   }//input()
   
    //analoga thn kinhsh koitaei an yparxei nikh
   public boolean check(Move move){
        boolean win=false;
        //katheta
        if(move.row>=4){
            for(int i=0; i<=move.row; i++){
                if(move.row-3<=5){
                    if((board[move.row][move.column]==board[move.row-1][move.column])&&(board[move.row-2][move.column]==board[move.row-3][move.column])&&(board[move.row][move.column]==move.player)&&(board[move.row-3][move.column]==move.player)){
                                win= true;
                    }//if
                }//if
            }//for
        }//if
        
        //orizontia
        for(int i=0; i<=6; i++){
            if(i-3>=0){
                 if((board[move.row][i]==board[move.row][i-1])&&(board[move.row][i-2]==board[move.row][i-3])&&(board[move.row][i]==move.player)&&(board[move.row][i-3]==move.player)){
                      win= true;
                 }//if  
            }//if
        }//for
        
        //diagwnia
        ///
        int r=move.row; 
        while(move.column-r<0){
            r++;
        } 
        for( int i=move.row-r; i<=move.row; i++){
    		for(int j=move.column+r; j<=6; j++ ){
                    if((i+3<=5)&&(j+3<=6)){
                        if((board[i][j]==board[i+1][j+1])&&(board[i+1][j+1]==board[i+2][j+2])&&(board[i+2][j+2]==board[i+3][j+3])&&(board[i+3][j+3]==move.player)){
                            win=true;
                        }//if  
                    }//if
                    
                }//for
        }//for
        
        //\
        r=move.row; 
        while(move.column+r>=6){
            r--;
        }
        for(int i=move.row-r; i<=move.row; i++){
    		for(int j=move.column-r; j<=6; j++ ){
                    if((i+3<=5)&&(j-3>=0)){
                        if((board[i][j]==board[i+1][j-1])&&(board[i+1][j-1]==board[i+2][j-2])&&(board[i+2][j-2]==board[i+3][j-3])&&(board[i+3][j-3]==move.player)){
                            win=true;
                        }//if  
                    }//if
                }//for
        }//for
        
        return win;
    
   }//check()
   
   public boolean find2(Move move){
      boolean win=false;
        //katheta
      if((move.row-1<=5)&&((move.row-1>=0))){
            if((board[move.row-1][move.column]==board[move.row][move.column])&&(board[move.row][move.column]==move.player)){
                   win= true;
            }//if
      }//if
        
        //orizontia
      if(move.column-1>=0){
          
              if((board[move.row][move.column-1]==board[move.row][move.column])&&(board[move.row][move.column]==move.player)){
                   win= true;
              }//if 
      }//if
      
        //diagwnia
        ///
         
        if(move.column-1<0){
           if((move.row+1<=5)&&(move.column+1<=6)){
               if((board[move.row][move.column]==board[move.row+1][move.column+1])&&(board[move.row+1][move.column+1]==move.player)){
                    win=true;
                }//if  
            }//if 
        }//if
        else{
            if((move.row+1<=5)&&(move.column+1<=6)){
                if((board[move.row-1][move.column-1]==board[move.row][move.column])&&(board[move.row][move.column]==board[move.row+1][move.column+1])&&(board[move.row+1][move.column+1]==move.player)){
                    win=true;
                }//if  
            }//if
        }//else
        
        //\
        if(move.column+1>=6){
            if((move.row+1<=5)&&(move.column-1>=0)){
                if((board[move.row+1][move.column-1]==board[move.row][move.column])&&(board[move.row][move.column]==board[move.row-1][move.column+1])&&(board[move.row-1][move.column+1]==move.player)){
                    win=true;
                }//if  
            }//if
        }//if
        else{
            if((move.row+1<=5)&&(move.column-1>=0)){
                if((board[move.row+1][move.column-1]==board[move.row][move.column])&&(board[move.row][move.column]==board[move.row-1][move.column+1])&&(board[move.row-1][move.column+1]==move.player)){
                    win=true;
                }//if  
            }//if
        }//else
        
        return win;
    
   }//find2()
   
   
   public boolean find3(Move move){
       boolean win=false;
        //katheta
                if((move.row-1<=5)&&(move.row-1>=0)){
                    if((board[move.row-1][move.column]==board[move.row][move.column])&&(board[move.row][move.column]==board[move.row+1][move.column])&&(board[move.row+1][move.column]==move.player)){
                                win= true;
                    }//if
                }//if
        
        //orizontia
              if((move.column-1>=0)&&(move.column<=6)){  
                    if((board[move.row][move.column-1]==board[move.row][move.column])&&(board[move.row][move.column]==board[move.row][move.column-1])&&(board[move.row][move.column-1]==move.player)){
                   win= true;
                    }//if
              }//if  
        
        //diagwnia
        ///
        int r=move.row; 
        while(move.column-r<0){
            r++;
        }//while
        
            for( int i=move.row-r; i<=move.row; i++){
    		for(int j=move.column+r; j<=6; j++ ){
                    if((move.row+1<=5)&&(move.column+1<=6)&&(move.row-1>=0)&&(move.column>=0)){
                        if((board[i][j]==board[i+1][j+1])&&(board[i+1][j+1]==board[i+2][j+2])&&(board[i+2][j+2]==move.player)){
                            win=true;
                        }//if  
                    }//if
                }//for
            }//for
            
            
        //\
        r=move.row; 
        while(move.column+r>=6){
            r--;
        }//while
        for(int i=move.row-r; i<=move.row; i++){
    		for(int j=move.column-r; j<=6; j++ ){
                    if((move.row+1<=5)&&(move.column-1>=0)&&(move.row-1>=0)&&(move.column+1<=6)){
                        if((board[i][j]==board[i+1][j-1])&&(board[i+1][j-1]==board[i+2][j-2])&&(board[i+2][j-2]==move.player)){
                            win=true;
                         }//if  
                    }//if
                }//for
        }//for
        
        return win;
    
   }//find3()
   
  
   
   //elegxei an einai dynath h kinhsh.PREPEI:
    //na mhn ksepernaei to megethos toy pinaka(sosta stoixeia)
    //na exoyn dothei ola ta aparethta stoixeia
    //na yparxei xoros sth sthlh
    public boolean isPossible(Move move){
        boolean pos=false;
        //na exoyn dothei ola ta aparethta stoixeia
        if(move.player!=0){
        //na mhn ksepernaei to megethos toy pinaka(sosta stoixeia)
           if((move.column<=6)){
        //na yparxei xoros sth sthlh
              if(!isColFull(move.column)){
                    pos=true;
              } //if
           }//if
         }//if
       return pos;
        
    }//isPossible()
 
    //gemath sthlh
    public boolean isColFull(int column){
        int count=0;
        for(int i=0; i<=5; i++){
            if (board[i][column]!=0){
                count++;
            }//if
        }//for
        if(count== 6){
            return true;
        }else{
            return false;
        }
        
    }//ifFull()
    
    public Move findRow(int column, int player){
        int row=0;
        if(!isColFull(column)){
            while(board[row][column]!=0){
                row++;
            }//while
        }//if
        Move moveR = new Move(row, column, player);
        return moveR;
    }//findRow()
    
   public int changeTurn(){
       turn=(move.getPlayer() == red)? blue : red; 
       return turn;
   }//changeTurn()
   
   
   //epistrefei ena array list me ola ta paidia
   public ArrayList<BoardGame> getChildren(){
	ArrayList<BoardGame> children = new ArrayList<BoardGame>();
	BoardGame copy = new BoardGame();
        copy.copy_board(this);//to copy einai antigrafo tis katastasis
            for(int col=0; col<7; col++){
               // Move move = findRow(col,changeTurn());
		if(!isColFull(col)){
                    BoardGame child = new BoardGame();
                    child.copy_board(copy);//arxika kathe paidi einai idio me ton patera tou
                    child.input(findRow(col,changeTurn()));//to paidi kanei kinisi
                    child.column_filled= col; //pare ton arithmo tis stilis pou epaixe to paidi
                    //child.input(move);
                    children.add(child);
		}//if
            }//for
	
        
	return children;
    }//getChildren()
   
   //methodos pou antigrafei ena BoardGame se ena allo kai epistrefei to allo
   public BoardGame copy_board(BoardGame b){
		for(int i=0; i<6; i++ ){
			for(int j=0; j<7; j++){
				board[i][j] = b.board[i][j];
			}
		}
		move = b.move;
		turn  = b.turn;
		return this;
	}//copy_board
   
   public void printBoard(){
		System.out.println();
		for(int i=5; i>=0; i--){
			for(int j=0; j<7; j++){
				char out_char;
				if(board[i][j] == blue){ // gia ton anthrwpo , pou einai to -1 , emfanise ton xaraktira 'r'
                                    out_char = 'B';
                                }else if(board[i][j] == red){ // gia ton ipologisti , pou einai to 1 , emfanise ton xaraktira 'b'
                                    out_char = 'R';
                                }
				else { //an i thesi einai keni emfanise ton xaraktira '_'
                                    out_char = '_';
                                }//if	
				System.out.print(" "+ out_char+" ");
			}
			System.out.println();
		}
	}//emfanizei ton pinaka tou paixnidiou
   
   public boolean isFull(){
       boolean full = false;
       int col=0;
       for(int i=0; i<7; i++){
           if(isColFull(i)){
               col++;
           }//if
       }//for
       if(col==7){
          full=true; 
       }//if
       return full;
   }//isFull()
   
}//class