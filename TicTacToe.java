import java.util.Scanner;

public class TicTacToe {
    private String[][] gameBoard = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
    private String changeInput = "O";
    Scanner sc = new Scanner(System.in);

    public void printBoard() {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++)
                System.out.print(this.gameBoard[i][j] + " ");
            System.out.println();
        }
    }

    public void changeBoard(String input) {
        if (this.isIncorrectInput(input)) {
            System.out.println("You have entered an incorrect input. Please try again");
            return;
        }

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

    public boolean isRowEqual() {
        for (int row = 0; row < this.gameBoard.length; row++) {
            if (this.gameBoard[row][0].equals(this.gameBoard[row][1])
                    && this.gameBoard[row][1].equals(this.gameBoard[row][2]))
                return true;
        }
        return false;
    }

    public boolean isColumnEqual() {
        for (int column = 0; column < this.gameBoard.length; column++) {
            if (this.gameBoard[0][column].equals(this.gameBoard[1][column])
                    && this.gameBoard[1][column].equals(this.gameBoard[2][column]))
                return true;
        }
        return false;
    }

    public boolean isDiagonalEqual() {
        return (this.gameBoard[0][0].equals(this.gameBoard[1][1]) && this.gameBoard[1][1].equals(this.gameBoard[2][2]))
                || (this.gameBoard[0][2].equals(this.gameBoard[1][1])
                        && this.gameBoard[1][1].equals(this.gameBoard[2][0]));
    }

    public boolean isGameWon() {
        return this.isRowEqual() || this.isColumnEqual() || this.isDiagonalEqual();
    }

    public boolean isInputInBoard(String input) {
        for (int row = 0; row < this.gameBoard.length; row++) {
            for (int col = 0; col < this.gameBoard[row].length; col++) {
                if (this.gameBoard[row][col].equals(input))
                    return true;
            }
        }
        return false;
    }

    public boolean isIncorrectInput(String input) {
        boolean isIncorrect = true;
        for (int i = 1; i < 10; i++) {
            if (String.valueOf(i).equals(input) && this.isInputInBoard(input)) {
                isIncorrect = false;
                break;
            }
        }
        return isIncorrect;
    }

    public boolean isTie() {
        for (int row = 0; row < this.gameBoard.length; row++) {
            for (int col = 0; col < this.gameBoard[row].length; col++) {
                if (!this.gameBoard[row][col].equals("X") && !this.gameBoard[row][col].equals("O"))
                    return false;
            }
        }
        return true;
    }

    public void play() {
        String input = sc.next();
        this.changeBoard(input);
        this.printBoard();
        System.out.println("Please play your next step");
    }

    public void cleanup() {
        this.sc.close();
    }

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        System.out.println("Do you want to play Tic Tac Toe? If yes then play your first step");
        tictactoe.printBoard();
        while (true) {
            tictactoe.play();
            if (tictactoe.isGameWon()) {
                tictactoe.toggleChangeInput();
                System.out.println("Congrats! " + tictactoe.changeInput + " has won the game");
                break;
            } else if (tictactoe.isTie()) {
                System.out.println("Opss ! It's a TIE !!");
                break;
            }

        }

        tictactoe.cleanup();
    }
}