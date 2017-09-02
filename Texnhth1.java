/* Chatziilia Sofia 3100202
 * Diniakoy Thaleia 3100132
 */
package texnhth1;
import java.util.Scanner;
public class Texnhth1 {
    
    public static void main(String[] args) {
        Move move1 = new Move(); 
        Move move2 = new Move();
        int lastColor=0;
        System.out.println("Welcome to Four in a line game. You play first!!!");
        Scanner read =  new Scanner(System.in);
        BoardGame board = new BoardGame();
        //Heuristics h = new Heuristics();
        Computer comp = new Computer();
            board.printBoard();
        while(!comp.isTerminal(board)){
            System.out.println("Give column : ");
            int h_column = read.nextInt();
            move1 = board.findRow(h_column,-1);
            board.input(move1);
            board.printBoard();
            lastColor = -1;
            if(!comp.isTerminal(board)){
                System.out.println("Computer plays...");
                int pc_column = comp.alpha_beta_search(board).getColumn_filled();
                int pc_row = board.findRow(pc_column, 1).getRow();
                move2 = new Move(pc_row,pc_column,1);
                board.input(move2);
                board.printBoard();
                lastColor = 1;
            }//if
        }//while
        
        if(comp.isTerminal(board)){
            if(board.isFull() && board.check(move1)==false && board.check(move2)==false){
                lastColor=0;
            }//if
            if(lastColor==1){
                System.out.println("Computer wins!");
            }else if(lastColor==-1){ 
                System.out.println("You win!");
            }else{
                System.out.println("It's a tie!");
            }//if
        }//if  
        
    }//main
    
   
}//class
