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
		enum winnerIs=EMPTY;

		//une ligne gagnante
		for (int i = 0; i < 3; i++) {
			if(plateau[i][0]==plateau[i][1] && plateau[i][1]==plateau[i][2]){
				winnerIs=plateau[i][0];
				break;
			}
		}

		//une colonne gagnante
		for (int i = 0; i < 3; i++) {
			if(plateau[0][i]==plateau[1][i] && plateau[1][i]==plateau[2][i]){
				winnerIs=plateau[0][i];
				break;
			}
		}

		//diagonale \ gagnante
		if(plateau[0][0]==plateau[1][1] && plateau[1][1]==plateau[2][2]){
			winnerIs=plateau[1][1];
			break;
		}

		//diagonale / gagnante
		if(plateau[0][2]==plateau[1][1] & plateau[1][1]==plateau[2][0]){
			winnerIs=plateau[1][1];
			break;
		}

		if (winnerIs==mark){return 100;}
		if (winnerIs!=mark && winnerIs!=EMPTY){return -100;}
		else {return 0;}
    }
}
