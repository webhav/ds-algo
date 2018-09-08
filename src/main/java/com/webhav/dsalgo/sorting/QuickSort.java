package com.webhav.dsalgo.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,6,4,2,8,9,5,3,33,22,11,99,56,43,12};
		sort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	/**
	 * Time Complexity : Best Case : O(nlogn)
	 * Time Complexity : Worst Case : O(n^2)
	 * Space Complexity : Best case : O(logn)
	 * Space Complexity : Worst case : O(n)

	 * Deepends on concept of partitioning
	 * Divide and conquer algo
	 * 
	 * @param arr
	 * @param p
	 * @param r
	 */
	static void sort(int[] arr, int p, int r) {
		if(p < r) {
			int q = partition(arr, p, r);
			sort(arr, p, q-1);
			sort(arr, q+1, r);
		}
	}
	
	static int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i=p-1;
		
		for(int j=p ; j<r; j++) {
			if(arr[j] < x) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		arr[r] = arr[i+1];
		arr[i+1] = x;
		
		return i+1;
		
	}
	
}
