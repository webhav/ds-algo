package com.webhav.dsalgo.backtracking;

public class KnightTourProblem {
	
	static ThreadLocal<Integer> counter = new ThreadLocal<>();

	public static void main(String[] args) {
		solveKT();
	}
	
	/**
	 * Total number of times solveKT called recusively is 1,655,578,825
	 * @return
	 */
	static boolean solveKT() {
		int[][] sol = new int[8][8];
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				sol[i][j] = -1;
			}
		}
		
		int[] xMove = {2, 1, -1, -2, -2,  2,  1, -1};
		int[] yMove = {1, 2,  2,  1, -1, -1, -2, -2};
		
		counter.set(0);
		
		sol[0][0] = 0;
		if(solveKT(xMove, yMove, sol, 0, 0, 1)) {
			printSolution(sol);
			System.out.println("Total moves = " + counter.get());
			return true;
		}
		
		return false;
	}
	
	private static void printSolution(int[][] sol) {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(sol[i][j] + "\t");
			}
			System.out.println();
		}
	}

	static boolean solveKT(int[] xMove, int[] yMove, int[][] sol, int x, int y, int move) {
		if(move == 64) {
			return true;
		}
		counter.set(counter.get()+1);
		for(int i=0; i<8; i++) {
			int nextX = xMove[i] + x;
			int nextY = yMove[i] + y;
			if(isSafe(nextX, nextY, sol)) {
				sol[nextX][nextY] = move;
				if(solveKT(xMove, yMove, sol, nextX, nextY, move+1)) {
					return true;
				} else {
					sol[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}
	
	static boolean isSafe(int x, int y, int[][] sol) {
		return x >= 0 && y >=0 && x < 8 && y <8 && sol[x][y] == -1;
	}

}
