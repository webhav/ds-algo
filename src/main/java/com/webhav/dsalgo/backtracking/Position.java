package com.webhav.dsalgo.backtracking;

public class Position {
    private final int x;
    private final int y;

    /**
     * Position(0, 0) represents "A1"; Position(28, 33) is "AC34".
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return x ^ (y << 16);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Position)) {
            return false;
        }
        Position p = (Position)other;
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public String toString() {
        int x = this.x + 1;
        StringBuilder result = new StringBuilder();
        do {
            result.append((char)('A' + (--x % 26)));
            x /= 26;
        } while (x != 0);
        return result.append(this.y + 1).toString();
    }
}