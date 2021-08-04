import java.util.Scanner;

public class TicTacToe {
    private String[][] gameBoard = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
    private String changeInput = "O";
    Scanner sc = new Scanner(System.in);

    public void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public void changeBoard(String input) {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++)
                if (input.equals(this.gameBoard[i][j])) {
                    this.gameBoard[i][j] = this.changeInput;
                    this.toggleChangeInput();
                }
        }
    }

    public void toggleChangeInput() {
        if (this.changeInput == "O")
            changeInput = "X";
        else
            changeInput = "O";
    }

    public void play() {
        String input = sc.next();
        this.changeBoard(input);
        this.printBoard(this.gameBoard);
        System.out.println("Please play your next step");
    }

    public void cleanup() {
        this.sc.close();
    }

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        System.out.println("Do you want to play Tic Tac Toe? If yes then play your first step");
        tictactoe.printBoard(tictactoe.gameBoard);
        while (true) {
            tictactoe.play();
        }
    }
}