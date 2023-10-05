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
    
/*

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board)
    {
        numExploredNodes = 0;

    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;

    }*/
	
	public void play(Board b, boolean MinMax) {
		int min = 0;
		int max = 0;
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
			System.out.println("Plateau imaginé par le CPU :");
			noeud.printBoard();
			
			//évaluation des plateaux imaginés pour savoir si on continue à imaginer
			//conditions pour continuer : le plateau n'est pas plein et l'évaluation est de 0
			max = noeud.evaluate(this.getMark());
			System.out.println("évalué à "+max+" pour "+this.getMark());
			
			//appel récursif à la méthode play() pour continuer à imaginer des plateaux
			if(MinMax && !noeud.isFull() && max == 0) {
				System.out.println("\nLe CPU continue avec Min.");
				this.play(noeud, false);
			}
			else if (!MinMax && !noeud.isFull() && max == 0){
				System.out.println("\nLe CPU continue avec Max.");
				this.play(noeud, true);
			}
		}
	}
}