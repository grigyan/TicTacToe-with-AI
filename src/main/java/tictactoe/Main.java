package tictactoe;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Player player1, player2;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.split(" ").length == 3) {
                String[] inputArr = input.split(" ");
                String input1 = inputArr[1];
                String input2 = inputArr[2];

                player1 = switch (input1) {
                    case "easy" -> new EasyAI('X');
                    case "medium" -> new MediumAI('X');
                    case "hard" -> new HardAI('X');
                    default -> new User('X');
                };

                player2 = switch (input2) {
                    case "easy" -> new EasyAI('O');
                    case "medium" -> new MediumAI('O');
                    case "hard" -> new HardAI('O');
                    default -> new User('O');
                };

                new Game(player1, player2, "_________")
                        .playGame();
            } else {
                System.out.println("Bad parameters!");
            }

        }
    }
}