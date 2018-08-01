package com.webhav.dsalgo.dp;

import java.lang.Math;

public class MaxSquareSubArray {
	
	
	public static void main(String[] args) {
		int[][] arr = new int[][] 
				{{1,1,1,1},
				 {1,1,1,0},
				 {1,1,0,0},
				 {0,0,0,1}};
		System.out.println(maxSquareSubArray(arr));
	}
	
	/**
	 * creates a sizes 2d array where each element represents square subrray matrix size till that element
	 * {1,1,1,1}
	 * {1,2,2,0}
	 * {1,2,0,0}
	 * {0,0,0,1}
	 * @param arr
	 * @return
	 */
	public static int maxSquareSubArray(int[][] arr) {
		int max = 0;
		int[][] sizes = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(i == 0 || j == 0) {
					sizes[i][j] = arr[i][j];
				} else {
					if(arr[i][j] == 1) {
						sizes[i][j] = 1+ Math.min(Math.min(sizes[i-1][j], sizes[i][j-1]), sizes[i-1][j-1]);
					}
					if(sizes[i][j] > max) {
						max = sizes[i][j];
					}
				}
			}
		}
		
		return max;
	}

}
