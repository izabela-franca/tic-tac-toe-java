package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;

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

    public Symbol update(Symbol symbol, Coord coord) {
        Objects.requireNonNull(symbol);
        Objects.requireNonNull(coord);

        if (symbol == Symbol.NONE) {
            throw new IllegalArgumentException("None cannot be added to the board");
        }

        if (matrix[coord.l()][coord.c()] != Symbol.NONE) {
            throw new IllegalArgumentException("This move has already been chosen");
        }

        matrix[coord.l()][coord.c()] = symbol;
        return findSequence();
    }

    public boolean isFull() {
        for (int l = 0; l < Board.SIZE; l++) {
            for (int c = 0; c < Board.SIZE; c++) {
                if (matrix[l][c] == Symbol.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    private Symbol findSequence() {
        Symbol symbol = findSequenceInRows();
        if (symbol != null) {
            return symbol;
        }

       symbol = findSequenceInColumns();
        if (symbol != null) {
            return symbol;
        }

        return findSequenceInDiagonals();
    }

    private Symbol findSequenceInRows() {
        for (int l  = 0; l < Board.SIZE; l++) {
            Symbol symbol = findSequenceInRow(l);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

    private Symbol findSequenceInRow(int l) {
        return matrix[l][0] == matrix[l][1]
                && matrix[l][1] == matrix[l][2]
                && matrix[l][0] != Symbol.NONE
                ? matrix[l][0]
                : null;
    }

    private Symbol findSequenceInColumns() {
        for (int c = 0; c < SIZE; c++) {
            Symbol symbol = findSequenceInColumn(c);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

    private Symbol findSequenceInColumn(int c) {
        return matrix[0][c] == matrix[1][c]
                && matrix[1][c] == matrix[2][c]
                && matrix[0][c] != Symbol.NONE
                ? matrix[0][c]
                : null;
    }

    private Symbol findSequenceInDiagonals() {
        if (matrix[0][0] == matrix[1][1]
                && matrix[1][1] == matrix[2][2]
                && matrix[0][0] != Symbol.NONE
        ) {
            return matrix[0][0];
        }

        if (matrix[0][2] == matrix[1][1]
                && matrix[1][1] == matrix[2][0]
                && matrix[0][2] != Symbol.NONE
        ) {
            return matrix[0][2];
        }

        return null;
    }
}
