import java.util.Scanner;

public class TicTacToePractise {
    public String board[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
    Scanner sc = new Scanner(System.in);
    String changeInput = "X";

    public void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void changeBoard(String input) {
        if (!this.isValidInput(input)) {
            System.out.println("you have entered incorrect input.plz try again later");
        }
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (input.equals(this.board[i][j])) {
                    this.board[i][j] = this.changeInput;
                    this.toggleInput();
                }
            }
        }
    }

    public boolean isValidInput(String input) {
        boolean isValid = false;
        for (int i = 1; i < 10; i++) {
            if (String.valueOf(i).equals(input)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public void toggleInput() {
        if (this.changeInput.equals("X"))
            changeInput = "O";
        else
            changeInput = "X";

    }

    public boolean isRowEqual() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++)
                if (this.board[row][0].equals(this.board[row][1]) && this.board[row][1].equals(this.board[row][2]))
                    return true;
        }
        return false;
    }

    public boolean isColumnEqual() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++)
                if (this.board[0][col].equals(this.board[1][col]) && this.board[1][col].equals(this.board[2][col]))
                    return true;
        }
        return false;
    }

    public boolean isDiagonalEqual() {
        return (this.board[0][0].equals(this.board[1][1]) && this.board[1][1].equals(this.board[2][2]))
                || (this.board[0][2].equals(this.board[1][1]) && this.board[1][1].equals(this.board[2][0]));
    }

    public boolean isGameWon() {
        return this.isRowEqual() || this.isColumnEqual() || this.isDiagonalEqual();
    }

    public boolean isTie() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if (this.board[row][col].equals("X") && this.board[row][col].equals("O"))
                    return true;
            }
        }
        return false;
    }

    public void play() {
        String input = sc.next();
        this.changeBoard(input);
        this.printBoard();
        // System.out.println("play ur next step");
    }

    public void cleanUp() {
        this.sc.close();
    }

    public static void main(String[] args) {
        TicTacToePractise tictactoe = new TicTacToePractise();
        System.out.println("Do you wanna play it? if yes play ur first step. insert any of number from 1-9 .");
        tictactoe.printBoard();
        while (true) {
            tictactoe.play();
            if (tictactoe.isGameWon()) {
                tictactoe.toggleInput();
                System.out.println("congo! " + tictactoe.changeInput + " has won the match.");
                break;
            }

            else if (tictactoe.isTie()) {
                System.out.println("its a tie");
                break;
            }
        }
        tictactoe.cleanUp();
    }
}
