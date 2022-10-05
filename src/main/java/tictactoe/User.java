package tictactoe;

import com.google.common.annotations.VisibleForTesting;

import java.io.PrintWriter;
import java.util.Scanner;

public class User extends Player{

    public User(char mark) {
        super(mark);
    }

    @Override
    public void makeMove(char[][] board) {
        makeMove(board, new Scanner(System.in), new PrintWriter(System.out));

    }

    @VisibleForTesting
    public void makeMove(char[][] board, Scanner scanner, PrintWriter output) {
        while (true) {
            output.print("Enter the coordinates: > ");
            int c1, c2;

            try {
                c1 = Integer.parseInt(scanner.next());
                c2 = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                output.println("You should enter numbers");
                continue;
            }

            if (c1 > 3 || c2 > 3) {
                output.print("Coordinates should be from 1 to 3!\n");
            } else if (board[c1 - 1][c2 - 1] != ' ') {
                output.print("This cell is occupied! Choose another one!\n");
            } else {
                board[c1 - 1][c2 - 1] = this.mark;
                break;
            }
        }
    }
}
