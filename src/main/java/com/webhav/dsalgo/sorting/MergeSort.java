package com.webhav.dsalgo.sorting;

public class MergeSort {
	
	/**
	 * Time Complexity : O(nlogn) : Bost best case and worst case
	 * Space Complexity : O(n)
	 * Based on divide and conquer
	 * Out of place as it requires extra space.
	 * 
	 * @param arr
	 * @param p
	 * @param q
	 */
	static void mergeSort(int[] arr, int p, int q) {
		if(p < q) {
			int m = (q+p)/2;
			mergeSort(arr, p, m);
			mergeSort(arr, m+1, q);
			merge(arr, p, m, q);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		
		int n1 = q-p+2;
		int n2 = r-q+1;
		
		int[] left = new int[n1];
		int[] right = new int [n2];
		
		
		for(int i=0; i < n1; i++) {
			left[i] = arr[i+p];
		}
		left[n1-1] = Integer.MAX_VALUE;
		
		for(int i=0; i<n2-1; i++) {
			right[i] = arr[i+q+1];
		}
		right[n2-1] = Integer.MAX_VALUE;
		
		int i=0; int j=0;
		
		for(int k=p; k<=r; k++) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,6,4,2,8,9,5,3,33,22,11,99,56,43,12};
		mergeSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

}