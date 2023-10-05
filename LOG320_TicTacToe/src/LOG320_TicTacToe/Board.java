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
    	this.winnerIs = Mark.EMPTY;
    	for(int i=0; i<3; i+=1) {
    		for(int j=0; j<3; j+=1) {
    			this.board[i][j]=Mark.EMPTY;
    		}
    	}
    	System.out.println("Plateau créé :");
    	printBoard();
    }
    
    public Board(Board b) {
    	this.board = new Mark[3][3];
    	this.winnerIs = Mark.EMPTY;
    	for(int i=0; i<3; i+=1) {
    		for(int j=0; j<3; j+=1) {
    			switch(b.board[i][j]) {
				case EMPTY:
					this.board[i][j] = Mark.EMPTY;
					break;
				case X:
					this.board[i][j] = Mark.X;
					break;
				case O:
					this.board[i][j] = Mark.O;
					break;
				default: 
					this.board[i][j] = Mark.EMPTY;
    			}
    		}
    	}
    	/*
    	System.out.println("Plateau copié :");
    	printBoard();
    	*/
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
			if(i<2) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark){
    	this.board[m.getRow()][m.getCol()] = mark;
    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark){
    	
		//une ligne gagnante
		for (int i = 0; i < 3; i++) {
			if(this.board[i][0]==this.board[i][1] && this.board[i][1]==this.board[i][2]){
				this.winnerIs=this.board[i][0];
				break;
			}
		}

		//une colonne gagnante
		for (int i = 0; i < 3; i++) {
			if(this.board[0][i]==this.board[1][i] && this.board[1][i]==this.board[2][i]){
				this.winnerIs=this.board[0][i];
				break;
			}
		}

		//diagonale \ gagnante
		if(this.board[0][0]==this.board[1][1] && this.board[1][1]==this.board[2][2]){
			this.winnerIs=this.board[1][1];
		}

		//diagonale / gagnante
		if(this.board[0][2]==this.board[1][1] & this.board[1][1]==this.board[2][0]){
			this.winnerIs=this.board[1][1];
		}

		if (this.winnerIs==mark){return 100;}
		if (this.winnerIs!=mark && this.winnerIs!=Mark.EMPTY){return -100;}
		else {return 0;}
    }
    
    public Mark getMark(int row, int col) {
    	return this.board[row][col];
    }
    
    public Mark[][] getBoard(){
    	return this.board;
    }
    
    public Mark getWinnerIs() {
    	return this.winnerIs;
    }    
    
    public boolean isFull() {
    	boolean isFull = true;
    	for(int i=0; i<3; i+=1) {
    		for(int j=0; j<3; j+=1) {
    			if(this.getMark(i, j) == Mark.EMPTY) {
    				isFull = false;
    			}
    		}
    	}
    	return isFull;
    }
}
