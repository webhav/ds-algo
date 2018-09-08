package com.webhav.dsalgo.sorting;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,6,4,2,8,9,5,3,33,22,11,99,56,43,12};
		sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	/**
	 * Time Complexity
	 * Best case : O(n)
	 * Worst & Avg case : O(n^2)
	 * @param arr
	 */
	static void sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			boolean swapped = false;
			for(int j=0; j<arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

}
