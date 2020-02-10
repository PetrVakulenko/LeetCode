package Array.AvailableCapturesforRook_999;

import java.util.HashSet;
import java.util.Set;

/**
 999. Available Captures for Rook

 On an 8 x 8 chessboard, there is one white rook. There also may be empty squares, white bishops, and black pawns.
 These are given as characters 'R', '.', 'B', and 'p' respectively.
 Uppercase characters represent white pieces, and lowercase characters represent black pieces.

 The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
   then moves in that direction until it chooses to stop, reaches the edge of the board,
   or captures an opposite colored pawn by moving to the same square it occupies.
 Also, rooks cannot move into the same square as other friendly bishops.
 Return the number of pawns the rook can capture in one move.

 Example 1:

 Input: [
    [".",".",".",".",".",".",".","."],
    [".",".",".","p",".",".",".","."],
    [".",".",".","R",".",".",".","p"],
    [".",".",".",".",".",".",".","."],
    [".",".",".",".",".",".",".","."],
    [".",".",".","p",".",".",".","."],
    [".",".",".",".",".",".",".","."],
    [".",".",".",".",".",".",".","."]
 ]
 Output: 3
 Explanation:
 In this example the rook is able to capture all the pawns.

 Example 2:
 Input: [
    [".",".",".",".",".",".",".","."],
    [".","p","p","p","p","p",".","."],
    [".","p","p","B","p","p",".","."],
    [".","p","B","R","B","p",".","."],
    [".","p","p","B","p","p",".","."],
    [".","p","p","p","p","p",".","."],
    [".",".",".",".",".",".",".","."],
    [".",".",".",".",".",".",".","."]
 ]
 Output: 0
 Explanation:
 Bishops are blocking the rook to capture any pawn.

 Example 3:
 Input: [
    [".",".",".",".",".",".",".","."],
    [".",".",".","p",".",".",".","."],
    [".",".",".","p",".",".",".","."],
    ["p","p",".","R",".","p","B","."],
    [".",".",".",".",".",".",".","."],
    [".",".",".","B",".",".",".","."],
    [".",".",".","p",".",".",".","."],
    [".",".",".",".",".",".",".","."]
 ]
 Output: 3
 Explanation:
 The rook can capture the pawns at positions b5, d6 and f5.

 Note:
 board.length == board[i].length == 8
 board[i][j] is either 'R', '.', 'B', or 'p'
 There is exactly one cell with board[i][j] == 'R'

 */

public class Solution {
    public int numRookCaptures(char[][] board) {
        int i, j, result = 0, elemJ = -1;
        Set<Integer> tmp = new HashSet();
        boolean leftElement = false;

        for (i = 0; i < 8; i++) {
            leftElement = false;

            for (j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    elemJ = j;
                }

                if (elemJ != -1 && board[i][j] == 'p') {
                    result++;
                    break;
                }
                if (board[i][j] == 'p') {
                    tmp.add(j);
                    if (elemJ == -1) leftElement = true;
                }
                if (board[i][j] == 'B') {
                    tmp.add(0);

                    if (elemJ == -1) leftElement = false;

                    if (elemJ != -1) break;
                }
            }

            if (elemJ != -1) break;
        }

        if (tmp.contains(elemJ)) result++;

        if (leftElement) result++;

        for (j = i+1; j < 8; j++) {
            if (board[j][elemJ] == 'p') {
                result++;
                break;
            }

            if (board[j][elemJ] == 'B') break;
        }

        return result;
    }
}