package com.webhav.dsalgo.backtracking;

import java.util.*;

public class KnightTour implements Iterable<Position> {
    /**
     * Comparator that puts positions with fewer exits first, breaking ties in
     * favor of smaller degree of freedom first.
     */
    private Comparator<Position> hardestPositionsFirstWithLookahead1 = new Comparator<Position>() {
        @Override
        public int compare(Position a, Position b) {
            int aPossibleMoves = KnightTour.this.possibleMoves(a).size();
            int bPossibleMoves = KnightTour.this.possibleMoves(b).size();
            if (aPossibleMoves != bPossibleMoves) {
                return aPossibleMoves - bPossibleMoves;
            } else {
                return KnightTour.this.getDegreesOfFreedom(a) - KnightTour.this.getDegreesOfFreedom(b);
            }
        }
    };

    private static final int[][] KNIGHT_MOVES = {
        { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 },
        { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }
    };
    private final int[][] degreesOfFreedom;
    private Set<Position> path;         // LinkedHashSet preserves insertion order

    /**
     * Knight's tour for an 8x8 board starting at A1.
     */
    public KnightTour() {
        this(8);
    }

    /**
     * Knight's tour starting at A1.
     */
    public KnightTour(int boardSize) {
        this(boardSize, new Position(0, 0));
    }

    public KnightTour(int boardSize, Position start) {
        this.degreesOfFreedom = initDegreesOfFreedom(boardSize);
        this.path = new LinkedHashSet<Position>(boardSize * boardSize);
        if (this.solve(start)) {
            // Prevent Iterator.remove()
            this.path = Collections.unmodifiableSet(this.path);
        } else {
            // Indicate that no moves are possible
            this.path.clear();
        }
    }

    @Override
    public Iterator<Position> iterator() {
        return this.path.iterator();
    }

    public int getSize() {
        return this.degreesOfFreedom.length;
    }

    private int getDegreesOfFreedom(Position p) {
        return this.degreesOfFreedom[p.getX()][p.getY()];
    }

    private static int[][] initDegreesOfFreedom(int boardSize) {
        int[][] board = new int[boardSize][boardSize];
        // Most squares allow full freedom of motion
        for (int[] row : board) {
            Arrays.fill(row, KNIGHT_MOVES.length);
        }
        // Reduced freedom of motion in the two ranks and files near the edges
        for (int x = 0; x < board.length; x++) {
            for (int y : new int[] { 0, 1, board.length - 2, board.length - 1 }) {
                board[x][y] = board[y][x] =
                    possibleMoves(new Position(x, y), boardSize, Collections.<Position>emptySet()).size();
            }
        }
        return board;
    }

    private boolean solve(Position p) {
        this.path.add(p);
        while (this.path.size() < this.getSize() * this.getSize()) {
            List<Position> possibleMoves = possibleMoves(p);
            if (possibleMoves.isEmpty()) {
                return false;
            }
            Collections.sort(possibleMoves, this.hardestPositionsFirstWithLookahead1);
            this.path.add(p = possibleMoves.get(0));
        }
        return true;
    }

    private List<Position> possibleMoves(Position position) {
        return possibleMoves(position, this.getSize(), this.path);
    }

    private static List<Position> possibleMoves(Position position, int boardSize, Set<Position> prohibited) {
        List<Position> result = new ArrayList<Position>(KNIGHT_MOVES.length);
        for (int[] posMove : KNIGHT_MOVES) {
            int x = position.getX() + posMove[0];
            int y = position.getY() + posMove[1];
            if (x >= 0 && y >= 0 && x < boardSize && y < boardSize) {
                Position possiblePos = new Position(x, y);
                if (!prohibited.contains(possiblePos)) {
                    result.add(possiblePos);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long time = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (Position p : new KnightTour(50, new Position(0, 0))) {
            sb.append("N-").append(p).append('\n');
        }
        System.out.print(sb);
        System.err.printf("\nTime used to solve: %d nanoseconds\n", System.nanoTime() - time);
    }
}