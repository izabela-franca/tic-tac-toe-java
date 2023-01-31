package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Board {

    public static final int SIZE = 3;

    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];

    public Board() {
        for ( Symbol[] symbols : matrix) {
            Arrays.fill(symbols, Symbol.NONE);
        }
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);

        for (int l = 0; l < SIZE; l++) {
            boolean first = true;
            for (int c = 0; c < SIZE; c++) {
                if (!first) {
                    out.print(" | ");
                }
                out.print(matrix[l][c]);
                first = false;
            }
            out.println();
            if (l + 1 < SIZE) {
                out.println("---------");
            }
        }
        return sw.toString();
    }
}
