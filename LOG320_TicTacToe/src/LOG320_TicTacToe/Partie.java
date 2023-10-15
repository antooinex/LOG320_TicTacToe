package LOG320_TicTacToe;

import java.util.Scanner;

public class Partie {
	
	public static void main(String[] args) {
		//création de la partie
		System.out.println("Début de la partie");
		
		//création du plateau
		Board plateau = new Board(); 
		
		//création du Joueur 1 (humain)
		Player J1 = new Player();
		System.out.println("Bienvenue "+ J1.getName()+" !");
		
		Scanner scanner = new Scanner(System.in);
		String markChoice = "null";
		while(!markChoice.equalsIgnoreCase("X") && !markChoice.equalsIgnoreCase("O")) {
			System.out.println("Veuillez choisir votre symbole, X ou O :");
			markChoice = scanner.nextLine();
		}
		J1.setMark(markChoice);
		System.out.println(J1.getName()+", vous jouez en tant que "+J1.printMark()+".");
		
		//création du Joueur 2 (CPU)
		CPUPlayer CPU;
		if(J1.getMark()==Mark.X) {
			CPU = new CPUPlayer(Mark.O);
		}
		else {
			CPU = new CPUPlayer(Mark.X);
		}
		
		Move CPUMove;
		
		System.out.println("Le CPU joue contre vous en tant que "+CPU.printMark()+".");
		
		//boucle des tours de jeu tant que personne n'a gagné
		String tempRowStr = "-1";
		String tempColStr = "-1";
		boolean validMove = false;
		boolean tourJ1 = true;
		boolean tourCPU = false;
		Move move = new Move();
		Mark gagnant = Mark.EMPTY;
		while(gagnant == Mark.EMPTY) {
			if(tourJ1) {
				tempRowStr = "-1";
				tempColStr = "-1";
				validMove = false;
				move = new Move();
				while(!validMove) {
					while(!tempRowStr.equals("1") && !tempRowStr.equals("2") && !tempRowStr.equals("3")) {
						System.out.println("Entrez la ligne où placer votre "+ J1.printMark()+" (1, 2 ou 3) :");
						tempRowStr = scanner.nextLine();
						switch(tempRowStr) {
							case "1":
								move.setRow(0);
								break;
							case "2":
								move.setRow(1);
								break;
							case "3":
								move.setRow(2);
								break;
							default: 
								move.setRow(-1);
						}
					}
					while(!tempColStr.equals("1") && !tempColStr.equals("2") && !tempColStr.equals("3")) {
						System.out.println("Entrez la colonne où placer votre "+ J1.printMark()+" sur la ligne "+tempRowStr+" (1, 2 ou 3) :");
						tempColStr = scanner.nextLine();
						switch(tempColStr) {
							case "1":
								move.setCol(0);
								break;
							case "2":
								move.setCol(1);
								break;
							case "3":
								move.setCol(2);
								break;
							default: 
								move.setCol(-1);
						}
					}
					if(plateau.getMark(move.getRow(), move.getCol()) == Mark.EMPTY) {
						validMove = true;
					}
					else {
						System.out.println("Cette case est déjà occupée.");
						tempRowStr = "-1";
						tempColStr = "-1";
					}
				}
				
				System.out.println(J1.getName()+", vous venez de jouer un "+J1.printMark()+" en ("+(move.getRow()+1)+","+(move.getCol()+1)+").");
				plateau.play(move, J1.getMark());
				plateau.printBoard();
			}
			else if(!tourJ1) {
				//tour du CPU
				//System.out.println("\nLe CPU commence son tour avec Max.");
				CPUMove = CPU.getNextMoveMinMax(plateau).get(0);
				plateau.play(CPUMove, CPU.getMark());
				System.out.println("\nLe CPU joue un "+CPU.printMark()+" en ("+(CPUMove.getRow()+1)+","+(CPUMove.getCol()+1)+").");
				plateau.printBoard();
			}
			
			switch(plateau.evaluate(J1.getMark())) {
				case 100:
					gagnant = J1.getMark();
					System.out.println("Gagnant : "+J1.getName()+" avec le signe "+J1.getMark()+" !");
					break;
				case -100:
					gagnant = CPU.getMark();
					System.out.println("Gagnant : "+J1.getName()+" avec le signe "+J1.getMark()+" !");
					break;
				default: 
					if(tourJ1) {
						tourJ1 = false;
					}
					else {
						tourJ1 = true;
					}
			}
		}
		System.out.println("Fin de la partie.");
	}
}
