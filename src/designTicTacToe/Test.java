package designTicTacToe;

import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		TicTacToe ttt = new TicTacToe(5);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int player = -1;
		int res = 0;
		while(true){
			player = player == 1 ? 2 : 1;
			System.out.print("For player" + player + "row:");
			int row = scan.nextInt();
			System.out.print("col:");
			int col = scan.nextInt();
			res = ttt.move(row, col, player);
			if(res != 0) break;
		}
		System.out.println("\nPlayer " + player + " is winner!");
		
	}
}
