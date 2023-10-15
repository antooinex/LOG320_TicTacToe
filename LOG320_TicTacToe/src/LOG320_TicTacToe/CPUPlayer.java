package LOG320_TicTacToe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{

	private Mark mark;
	private ArrayList<Move> nextMoveMinMax = new ArrayList<Move>();
	
	
    // Contient le nombre de noeuds visités (le nombre
    // d'appels à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
    	this.mark = cpu;
    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }
    
	public String printMark() {
		if(this.mark == Mark.X) {
			return "X";
		}
		else if(this.mark == Mark.O){
			return "O";
		}
		else {
			return "null";
		}
	}
	
	public Mark getMark() {
		return this.mark;
	}
    
    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board)
    {
    	this.nextMoveMinMax.clear();
    	numExploredNodes = 0;
    	this.play(board, true, 0);
    	return this.nextMoveMinMax;
    }
    
    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;
        return null;
    }
	
	public boolean play(Board b, boolean MinMax, int profondeur) {
		int eval = 0;
		//définition de la liste des sous-arbres à créer et explorer
		List<Board> boardsList = new ArrayList<Board>();
		
		//boucle pour trouver chaque case vide du tableau original
    	for(int i=0; i<3; i+=1) {
    		for(int j=0; j<3; j+=1) {
    			if(b.getMark(i, j) == Mark.EMPTY) {
    				//si la case est vide, copie du plateau original
    				Board copiedBoard = new Board(b);
    				
    				//ajout du signe du CPU à l'emplacement de la case vide de la copie
    				if(MinMax) {
    					copiedBoard.play(new Move(i, j), this.mark);
    				}
    				else {
    					if(this.mark == Mark.X) {
    						copiedBoard.play(new Move(i, j), Mark.O);
    					}
    					else {
    						copiedBoard.play(new Move(i, j), Mark.X);
    					}
    				}
    				    				
    				//ajout de la copie avec signe du CPU à la liste à explorer
    				boardsList.add(copiedBoard);
    			}
    		}	
    	}

		//boucle parmi les plateaux imaginés
		Iterator<Board> it = boardsList.iterator();
		while(it.hasNext()) {
			//affichage des plateaux imaginés
			Board noeud = it.next();
			//System.out.println("Plateau imaginé par le CPU :");
			//noeud.printBoard();
			
			//évaluation des plateaux imaginés pour savoir si on continue à imaginer
			//conditions pour continuer : le plateau n'est pas plein et l'évaluation est de 0
			eval = noeud.evaluate(this.getMark());
			//System.out.println("évalué à "+eval+" pour "+this.getMark());
			
			//appel récursif à la méthode play() pour continuer à imaginer des plateaux
			if(MinMax && !noeud.isFull() && eval == 0) {
				//System.out.println("\nLe CPU continue avec Min.");
				numExploredNodes += 1;
				profondeur +=1;
				if(this.play(noeud, false, profondeur)) {
					//System.out.println(profondeur);
					if(profondeur == 1) {
						addNextMoveAB(noeudToMove(b, noeud));
					}
					else {
						return true;
					}
				}
				
			}
			else if (!MinMax && !noeud.isFull() && eval == 0){
				//System.out.println("\nLe CPU continue avec Max.");
				numExploredNodes += 1;
				//profondeur +=1;
				if(this.play(noeud, true, profondeur)) {
					if(profondeur == 0) {
						addNextMoveAB(noeudToMove(b, noeud));
					}
					else {
						return true;
					}
				}
			}
			else if(eval == 100) {
				//System.out.println("trouvé 100");
				return true;
			}
			else if(eval == -100) {
				//System.out.println("trouvé -100");
				return false;
			}
		}
		//System.out.println("rien trouvé");
		return false;
	}
	
	public Move noeudToMove(Board plateau, Board b) {
		Move move = null;
		//plateau.printBoard();
		//b.printBoard();
		for(int i=0; i<3; i+=1) {
    		for(int j=0; j<3; j+=1) {
    			if(plateau.getMark(i, j) != b.getMark(i, j)) {
    				move = new Move(i,j);
    			}
    		}
    	}
		return move;
	}
	
	public void addNextMoveAB(Move m) {
		this.nextMoveMinMax.add(m);
	}
}