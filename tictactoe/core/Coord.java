package tictactoe.core;

import tictactoe.util.ValidationUtils;

import static java.util.Objects.requireNonNull;

public record Coord(int l, int c) {

    public Coord {
        ValidationUtils.require(l >= 0 && l < Board.SIZE, "Out of range");
        ValidationUtils.require(c >= 0 && c < Board.SIZE, "Out of range");
    }

    public static Coord parse(String text) {
        requireNonNull(text);

        String[] tokens = text.split(",");

        if (tokens.length != 2) {
            throw new IllegalArgumentException("Invalid format");
        }

        try {
            return new Coord(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number");
        }

    }
}
