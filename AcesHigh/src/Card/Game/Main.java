package Card.Game;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // write your code here
        Board board = new Board();
        board.Invalidate();
        int input = 0;
        String msg = "";
        do {
            Scanner scn = new Scanner(System.in);
            msg = "Enter 8 quit, 1 tap stockpile, 2 place stockpile, 3 add to foundation, " +
                    "4 move between stacks. ";
            input = GetScreenInteger(msg);
            if (input == 1) {
                board.TapStockpile();
                board.Invalidate();
            }
            else if (input == 2)
            {
                msg = "Enter column number: ";
                int intInput = GetScreenInteger(msg);;
                if(intInput >= 0 && intInput < 8) board.AddToTableauFromStockpile(intInput);
            }
            else if (input == 3)
            {
                msg = "Enter column number (0 from stockpile): ";
                int intInput = GetScreenInteger(msg);
                if(intInput >= 0 && intInput < 8) board.AddToFoundation(intInput);
            }
            else if (input == 4) {
                msg = "Enter FROM column number: ";
                int intInput = GetScreenInteger(msg);
                if (intInput > 0 && intInput < 8) {
                    int fromCol = intInput;
                    msg = "Enter TO column number: ";
                    intInput = GetScreenInteger(msg);
                    if (intInput > 0 && intInput < 8) {
                        int toCol = intInput;
                        board.MoveBetweenTableauColumns(fromCol, toCol);
                    }
                }
            }
        } while (input != 8);

    }

    private static int GetScreenInteger(String message)
    {
        Scanner scanner = new Scanner(System.in);
        int intInput = -1;
        do {
            System.out.printf(message);
            String input = scanner.next();
            try {
                intInput = Integer.parseInt(input);
            }
            catch(NumberFormatException e){}

        }while(intInput < 0);
        return intInput;
    }


}


