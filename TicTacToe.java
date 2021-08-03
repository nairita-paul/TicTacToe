import java.util.Scanner;

public class TicTacToe {
    public int[][] gameBoard() {
        int[][] board = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        return board;
    }

    public int input() {
        System.out.println("Do you want to play Tic Tac Toe? If yes then play your first ball");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        return input;

    }

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.gameBoard();
        tictactoe.input();
    }
}