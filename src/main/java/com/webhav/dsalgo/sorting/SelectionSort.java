package com.webhav.dsalgo.sorting;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,6,4,2,8,9,5,3,33,22,11,99,56,43,12};
		sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	
	/**
	 * Time complexity : O(n^2)
	 * Number of swaps is better than bubble sort : O(n)
	 * @param arr
	 */
	static void sort(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			int minIdx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
 		
	}

}
