package com.webhav.dsalgo.dp;

public class MaxRectangleSubArray {

	public static void main(String[] args) {
		int[][] arr = new int[][] 
				{{1,1,1,1},
				 {1,1,1,0},
				 {1,1,1,0},
				 {0,0,0,1}};
				 
		System.out.println(maxRectangleSubArray(arr));
		
	}

	public static int maxRectangleSubArray(int[][] arr) {
		int max = 0;
		MaximumHistogram mh = new MaximumHistogram();

		int[] histogram = new int[arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					histogram[j] = 0;
				} else {
					histogram[j] += arr[i][j];
				}
			}
			int area = mh.maxHistogram(histogram);
			if(area > max) {
				max = area;
			}
		}
		

		return max;
	}

}
