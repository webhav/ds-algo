package com.webhav.dsalgo.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,6,4,2,8,9,5,3,33,22,11,99,56,43,12};
		sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	/**
	 * Time Complexity : O(n^2)
	 * Space Complexity : O(1)
	 * Best case : O(n) -> when list is sorted
	 * @param arr
	 */
	static void sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j + 1] = key;
		}
	}

}
