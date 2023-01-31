package tictactoe.io;

public final class Output {

    private Output() {} //It can be instantiated

    private static void writeNewLine() {
        write(null);
    }

    public static void write(Object obj) {
        write(obj, true);
    }

    public static void write(Object obj, boolean addNewLine) {
        if (obj == null) {
            System.out.println();
        } else {
            System.out.println(obj);
        }
    }
}
