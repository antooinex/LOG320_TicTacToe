package LOG320_TicTacToe;

import java.util.Scanner;

public class Player {
	
	private String name = "null";
	private Mark mark;

	Player(){
		System.out.println("Veuillez entrer votre nom :");
		Scanner scanner = new Scanner(System.in);
		this.name = scanner.nextLine();
		this.mark = Mark.EMPTY;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setMark(String choice) {
		if(choice.equalsIgnoreCase("X")) {
			this.mark = Mark.X;
		}
		else {
			this.mark = Mark.O;
		}
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
}
