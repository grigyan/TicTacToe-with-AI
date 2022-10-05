import org.junit.Test;
import tictactoe.User;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

public class UserTests {

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
}
