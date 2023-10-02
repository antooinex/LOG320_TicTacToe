package LOG320_TicTacToe;

import java.util.*;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
    private Mark[][] board;
    private Mark winnerIs;

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
    
	public void printBoard(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append("|");
			for (int j = 0; j < 3; j++) {
				if (this.board[i][j] == Mark.EMPTY) {
					sb.append("-");
				}
				if (board[i][j] == Mark.X) {
					sb.append("X");
				}
				if (board[i][j] == Mark.O) {
					sb.append("O");
				}
				sb.append("|");
			}
			sb.append("\n");
		}
		System.out.println(sb);
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
    public int evaluate(Mark mark){
    	
		this.winnerIs = Mark.EMPTY;

		//une ligne gagnante
		for (int i = 0; i < 3; i++) {
			if(this.board[i][0]==this.board[i][1] && this.board[i][1]==this.board[i][2]){
				winnerIs=this.board[i][0];
				break;
			}
		}

		//une colonne gagnante
		for (int i = 0; i < 3; i++) {
			if(this.board[0][i]==this.board[1][i] && this.board[1][i]==this.board[2][i]){
				winnerIs=this.board[0][i];
				break;
			}
		}

		//diagonale \ gagnante
		if(this.board[0][0]==this.board[1][1] && this.board[1][1]==this.board[2][2]){
			winnerIs=this.board[1][1];
		}

		//diagonale / gagnante
		if(this.board[0][2]==this.board[1][1] & this.board[1][1]==this.board[2][0]){
			winnerIs=this.board[1][1];
		}

		if (winnerIs==mark){return 100;}
		if (winnerIs!=mark && winnerIs!=Mark.EMPTY){return -100;}
		else {return 0;}
    }
}
