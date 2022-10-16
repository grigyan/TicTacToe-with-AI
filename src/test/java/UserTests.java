
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tictactoe.Game;
import tictactoe.Player;
import tictactoe.User;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTests {

    private static Stream<Arguments> fillTheBoard() {
        return Stream.of(
                Arguments.of("_________", new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}),
                Arguments.of("O_X__X__O", new char[][]{{'O', ' ', 'X'}, {' ', ' ', 'X'}, {' ', ' ', 'O'}}),
                Arguments.of("123456789", new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}})
        );
    }

    private static Stream<Arguments> winningPositions() {
        return Stream.of(
                Arguments.of("___XXXOO_", true),
                Arguments.of("_XO_XO_XO", true),
                Arguments.of("XO__XO_OX", true),
                Arguments.of("_________", false),
                Arguments.of("XOXOXOOX_", false),
                Arguments.of("OXOOXXXO_", false)
        );
    }

    @Test
    public void shouldMakeAValidMove() {
        // given
        String input = "asdf 4 4 1 1 2 2"; // asdf -> for text input, 4 4 -> out of range input, 1 1 -> occupied cell input, 2 2 -> valid input
        StringWriter output = new StringWriter();
        User user = new User('X');
        char[][] board = new char[3][3];

        // when
        board[0][0] = 'O';
        board[1][1] = ' ';
        user.makeMove(board, new Scanner(input), new PrintWriter(output));

        // then
        assertThat(output.toString(), containsString("You should enter numbers"));
        assertThat(output.toString(), containsString("Coordinates should be from 1 to 3!"));
        assertThat(output.toString(), containsString("This cell is occupied! Choose another one!"));
        assertEquals(board[1][1], 'X');
    }

    @ParameterizedTest
    @MethodSource("fillTheBoard")
    public void shouldFillBoard(String boardString, char[][] expected) {
        // given
        Game game = new Game(new User('X'), new User('O'), boardString);

        // when
        char[][] actual = game.getBoard();

        // then
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @ParameterizedTest
    @MethodSource("winningPositions")
    public void shouldFindWinningPosition(String boardString, boolean expected) {
        // given
        Game game = new Game(new User('X'), new User('O'), boardString);

        // when
        boolean actual = game.someoneWon(game.getBoard());

        // then
        assertEquals(expected, actual);
    }
}
