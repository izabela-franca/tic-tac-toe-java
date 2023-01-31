package tictactoe.io;

import java.util.Scanner;

public final class Input {

    private Input() {}  //It can be instantiated

    public static String read(String message) {
        if (message != null) {
            Output.write(message + " ");
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
