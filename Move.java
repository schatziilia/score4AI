/* Chatziilia Sofia 3100202
 * Diniakoy Thaleia 3100132
 */
package texnhth1;

public class Move {
    int row;
    int column;
    int player;
    
    public Move(){
        this.row=-1;
        this.column=-1;
        this.player=0;
        
    }//constructor
    
    public Move(int row, int column, int player){
        this.row=row;
        this.column=column;
        this.player=player;
    }//constructor
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
     
}//class
