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
		while(!markChoice.equals("X") && !markChoice.equals("O")) {
			System.out.println("Veuillez choisir votre symbole, X ou O :");
			markChoice = scanner.nextLine();
		}
		J1.setMark(markChoice);
		System.out.println("Vous jouerez en tant que "+J1.printMark()+".");
		
		//création du Joueur 2 (CPU)
		//CPUPlayer CPU = new CPUPlayer();
		
		System.out.println(plateau.evaluate(J1.getMark()));
	}

}
