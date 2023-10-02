package LOG320_TicTacToe;

import java.util.*;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
    private Mark[][] board;

    // Ne pas changer la signature de cette méthode
    public Board() {
    	this.board = new Mark[3][3];
    	for(int i=0; i<3; i+=1) {
    		for(int j=0; j<3; j+=1) {
    			this.board[i][j]=Mark.EMPTY;
    		}
    	}
    	System.out.println("Plateau créé :");
    	printBoard();
    }
    
    public void printBoard() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.board[0][0]);
    	sb.append(" | ");
    	sb.append(this.board[0][1]);
    	sb.append(" | ");
    	sb.append(this.board[0][2]);
    	System.out.println(sb);
    	
    	sb.append(this.board[1][0]);
    	sb.append(" | ");
    	sb.append(this.board[1][1]);
    	sb.append(" | ");
    	sb.append(this.board[1][2]);
    	System.out.println(sb);
    	
    	sb.append(this.board[2][0]);
    	sb.append(" | ");
    	sb.append(this.board[2][1]);
    	sb.append(" | ");
    	sb.append(this.board[2][2]);
    	System.out.println(sb);
    	
    }

	public showBoard(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append("|");
			for (int j = 0; j < 3; j++) {
				if (plateau[i][j] == EMPTY) {
					sb.append("_");
				}
				if (plateau[i][j] == X) {
					sb.append("X");
				}
				if (plateau[i][j] == O) {
					sb.append("O");
				}
				sb.append("|");
			}
			sb.append("\n");
		}

	}

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark){


    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    //public int evaluate(Mark mark){

    //}
}
