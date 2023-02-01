package tictactoe.io;

import java.util.Scanner;

public final class Input {

    private Input() {}  //It cannot be instantiated

    public static String read(String message) {
        if (message != null) {
            Output.write(message + " ", false);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
