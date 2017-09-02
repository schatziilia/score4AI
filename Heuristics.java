/* Chatziilia Sofia 3100202
 * Diniakoy Thaleia 3100132
 */
package texnhth1;

public class Heuristics {
    
    public Heuristics(){
     }//constractor
    
    public int evaluate(int board[][], int player){
        int score = 0;
        score = score + find4_horizontal(board, player);
        score = score + find4_vertical(board,player);
        score = score + find4_diagonal(board,player);
        if(score<999){
            score = score + find1_horizontal(board, player);
            score = score + find2_horizontal(board, player);
            score = score + find3_horizontal(board, player);
            
            score = score + find1_vertical(board,player);
            score = score + find2_vertical(board,player);
            score = score + find3_vertical(board,player);
          
            score = score + find1_diagonal(board,player);
            score = score + find2_diagonal(board,player);
            score = score + find3_diagonal(board,player);
        }//if
        score = score * player;//gia na vgenei thetiko i arnitiko analogos gia poion kalleite
        
        return score;
    }//evaluate(
    
    
    //vriskei 1 katheta
    public int find1_vertical(int board[][],int player){
        int score = 0;
        for (int j=0; j<7; j++){ //steiles
            for (int i=0; i<6; i++){ // seires
                try{
                    if (board[i][j] == player){
                                if(board[i+1][j]==0 && board[i+2][j]==0 && board[i+3][j]==0){
                                    score = score + 4;//score gia 3 kena
                                }//if
                        }//if
                }//try
                catch(ArrayIndexOutOfBoundsException e){
                }//catch
            }//for
        }//for
        
        return score;
   }//find1_vertical()
   
    
  //vriskei 1 orizontia kai analoga me to posa kena yparxoyn vgazei score
   public int find1_horizontal(int board[][],int player){
       int score=0;
       for(int i=0; i<6; i++){
           for(int j=0; j<7; j++){
               try{
                   if(board[i][j]==player){
                              if((board[i][j+1]==0 && board[i][j+2]==0 && board[i][j+3]==0) || (board[i][j-1]==0 && board[i][j-2]==0 && board[i][j-3]==0) || (board[i][j+1]==0 && board[i][j+2]==0 && board[i][j-1]==0) || (board[i][j+1]==0 && board[i][j-1]==0 && board[i][j-2]==0)){ //an yparxoyn kena deksia kai aristera me opoiodhpote syndiasmo
                                  score = score + 4;//score gia 3 kena amesa
                                  
                               }//if
                   }//if
               }catch(ArrayIndexOutOfBoundsException e){   
               }//catch  
           }//for
       }//for
       
       return score;
   }//find1_horizontial()
   
    
    //vriskei 1 diagonia kai analoga me to plhthos ton kenon vgazei score
   public int find1_diagonal(int board[][], int player){
        int score = 0;
        //\
        for(int i=0; i<6; i++){
             for(int j=0; j<7; j++){
                 try{
                    if(board[i][j]==player){
                                if((i>2 && j>2 && board[i-1][j-1]==0 && board[i-2][j-2]==0 && board[i-3][j-3]==0) || (i<3 && j<4 && board[i+1][j+1]==0 && board[i+2][j+2]==0 && board[i+3][j+3]==0) || (i>1 && j>1 && i<5 && j<6 &&  board[i-1][j-1]==0 && board[i-2][j-2]==0 && board[i+1][j+1]==0) || (i<4 && i>0 && j>0 && j<5 && board[i+1][j+1]==0 && board[i+2][j+2]==0 && board[i-1][j-1]==0)){
                                    
                                        score = score + 2;//score gia 3 kena amesa
                                    
                                }//if
                    }//if
                }catch(ArrayIndexOutOfBoundsException e){
                }//catch
            }//for
       }//for
       ///    
       for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                try{
                    if(board[i][j]==player){
                               if((i>3 && j<4 && board[i-1][j+1]==0 && board[i-2][j+2]==0 && board[i-3][j+3]==0) || (i<3 && j>2 && board[i+1][j-1]==0 && board[i+2][j-2]==0 && board[i+3][j-3]==0) || (i>1 && i<5 && j<5 && j>0 && board[i-1][j+1]==0 && board[i-2][j+2]==0 && board[i+1][j-1]==0) || (i<4 && i>0 && j>1 && j<6 && board[i+1][j-1]==0 && board[i+2][j-2]==0 && board[i-1][j+1]==0)){ //an yparxei keno deksia kai aristera 
                                  score = score + 2;//score gia 3 kena
                                   
                               }//if
                    }//if
                       
               }//try
               catch(ArrayIndexOutOfBoundsException e){
               }//catch
           }//for
       }//for
           
       return score;
   }//find1_diagonal()
   
  
    //find2 katheta
   public int find2_vertical(int board[][],int player){
       int score=0;
       for(int j=0; j<7; j++){
          for(int i=0; i<6; i++){
            try{
                if(board[i][j]==player && board[i-1][j]==player){
                        if(board[i+1][j]==0 && board[i+2][j]==0){
                            score = score + 16;//score fia 2 kena
                        }//if
                }//if
            }catch (ArrayIndexOutOfBoundsException e){ 
            }//catch
          }//for
       }//for
       
       return score;
   }//find2_v\ertical()
   
   
   //find2 orizontia
   public int find2_horizontal(int board[][],int player){
       int score = 0;    
       for (int i=0; i<6; i++){ //seires
           for (int j=0; j<7; j++){
               try{
                   if (board[i][j]==player && board[i][j+1]==player){
                             if((board[i][j+2]==0 && board[i][j+3]==0) || (board[i][j-1]==0 && board[i][j-2]==0) || (board[i][j-1]==0 && board[i][j+2]==0)){
                                 
                                     score = score +16;
                                
                             }//if
                   }//if
               }catch (ArrayIndexOutOfBoundsException e){
               }//catch
          }//for
      }//for
       
      return score;  
   }//find2_horizontal()
   
   
   //find2 diagwnia
   public int find2_diagonal(int board[][],int player){
        int score=0;
        ///
        for (int i=0; i<6; i++){ 
            for (int j=0; j<7; j++){ 
                try{
                    if (board[i][j]==player && board[i-1][j-1]==player){
                            if((i<4 && j<5 && board[i+1][j+1]==0 && board[i+2][j+2]==0) || (i>2 && j>3 && board[i-2][j-2]==0 && board[i-3][j-3]==0) || (i<5 && j<6 && i>1 && j>1 && board[i+1][j+1]==0 && board[i-2][j-2]==0)){
                                score = score + 8;//score gia 2 kena amesa
                                
                            }//if
                    }//if
                }catch (ArrayIndexOutOfBoundsException e){ 
                }//catch  
            }//for
        }// for
        //\
        for (int i=0; i<6; i++){ 
            for (int j=0; j<7; j++){
                try{
                    if (board[i][j]==player && board[i-1][j+1]==player){
                            if((board[i+1][j-1]==0 && board[i+2][j-2]==0) || (board[i-2][j+2]==0 && board[i-3][j+3]==0) || (board[i+1][j-1]==0 && board[i-2][j+2]==0)){
                                    score = score + 8;//score gia 2 kena amesa
                                
                            }//if
                    }//if
                }catch (ArrayIndexOutOfBoundsException e){ 
                }//catch 
            }//for
        }// for
    		
       return score;
   }//find2_diagonal()
   
   
   //vriskei 3 katheta
    public int find3_vertical(int board[][],int player){
       int score=0;
       for(int j=0; j<7; j++){
           for(int i=0; i<6; i++){
               try{
                   if(board[i][j]==player && board[i-1][j]==player && board[i-2][j] ==player){
                       if(board[i+1][j]==0){
                           score = score + 32;//gia ena keno apo panw
                       }//if
                   }//if
               }//try
               catch(ArrayIndexOutOfBoundsException e){
               }//catch
           }//for
       }//for
       
       return score;   
   }//find3_vertical
   
   //vriskei 3 orizontia
   public int find3_horizontal(int board[][],int player){
       int score = 0;
       for(int i=0; i<6; i++){
           for(int j=0; j<7; j++){
               try{
                   if(board[i][j]==player && board[i][j+1]==player && board[i][j+2] ==player){
                      if (board[i][j+3]== 0 || board[i][j-1] ==0){ //elegxos gia kena deksia h aristera
                            score = score + 32;//score gia 1 keno xwris keno apo kato (amesa)
                       }//if 
                   }//if
                   if(board[i][j]==player && board[i][j+1]==player && board[i][j+3]==player && board[i][j+2]==0){
                       score = score + 32;
                   }//if
                   if(board[i][j]==player && board[i][j+2]==player && board[i][j+3]==player && board[i][j+1]==0){
                       score = score + 32;
                   }//if
               }//try
               catch(ArrayIndexOutOfBoundsException e){    
               }//catch
           }//for
       }//for
       
       return score;
   }//find3horiontal()
   
   //find3 diagonia
   public int find3_diagonal(int board[][],int player){
       int score = 0;
       ///
       for (int i=0; i<6; i++){ 
           for (int j=0; j<7; j++){ 
               try{
                   if (board[i][j]==player && board[i-1][j-1]==player && board[i-2][j-2] ==player){
                       if((i<5 && j<6 && board[i+1][j+1]==0) || board[i-3][j-3]==0){ //elegxos gia kena deksia h aristera
                            score = score + 24;//score gia 1 keno 
                       }//if
                       
                   }//if
                }catch (ArrayIndexOutOfBoundsException e){ 
                }//catch
            }//for
    	}//for
    //\   
    for (int i=0; i<6; i++){
    	for (int j=0; j<7; j++){
            try{
    		if (board[i][j]==player && board[i-1][j+1]==player && board[i-2][j+2] ==player){
                    if(( i<5 && j>1 && board[i+1][j-1]==0) || board[i-3][j+3]==0){
                            score = score + 24;//score gia 1 keno (amesa)
                        
                    }//if
                }//if
            }catch (ArrayIndexOutOfBoundsException e){ 
            }//catch 
    	}//for
    }// for
        
   return score;
   }//find3_diagonal()
   
   
   //find 4 katheta
    public int find4_vertical(int board[][],int player){
        int score =0;
        for(int j=0; j<7; j++){
           for(int i=0; i<6 ;i++){
               try{
                   if(board[i][j]==player && board[i-1][j]==player && board[i-2][j] ==player && board[i-3][j]== player){
                      score = score + 1000;
                   }//if 
               }catch(ArrayIndexOutOfBoundsException e){
               }//catch
          }//for
       }//for
        
       return score;
    } //find4_vertical
    
    //find 4 orizontia
   public int find4_horizontal(int board[][], int player){
      int score = 0;
      for(int j=0; j<7; j++){
          for(int i=0; i<6 ;i++){
             try{
                if(board[i][j]==player && board[i][j+1]==player && board[i][j+2]==player && board[i][j+3] == player){
                    score = score + 1000;
                } //if
             }catch(ArrayIndexOutOfBoundsException e){
             }//catch
          }//for
      }//for
      
      return score;
   }//find4_Horizontal
   
   //find 4 diagonia
   public int find4_diagonal(int board[][],int player){
        int score=0;
        ///
        for (int i=0; i<6; i++){//seires
            for (int j=0; j<7; j++){ // steiles
    		try{
                    if (board[i][j]==player && board[i-1][j-1]==player && board[i-2][j-2]==player && board[i-3][j-3]==player){
    			score = score + 1000;
                    }//if
    		}catch (ArrayIndexOutOfBoundsException e){   
    		}//catch block 
            }//for
    	}
        //\
        for (int i=0; i<6; i++){ 
            for (int j=0; j<7; j++){ 
    		try{
                    if (board[i][j]==player && board[i-1][j+1]==player && board[i-2][j+2] ==player && board[i-3][j+3]==player ){
                        score = score + 1000;
                    }//if
    		}catch (ArrayIndexOutOfBoundsException e){ 
    		}//catch 
            }//for
    	}//for 
        
       return score;
   }//find4_diagonal()
   
}//class
