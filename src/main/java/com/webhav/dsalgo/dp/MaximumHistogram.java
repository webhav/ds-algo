package com.webhav.dsalgo.dp;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumHistogram {
	
	public int maxHistogram(int[] input) {
		int maxArea = 0;
		int area = 0;
		int i;
		
		Deque<Integer> stack = new LinkedList<>();
		
		for(i=0; i < input.length; ) {
			
			if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
				stack.offerFirst(i++);
			} else {
				int top = stack.pollFirst();
				if(stack.isEmpty()) {
					area = input[top] * i;
				} else {
					area = input[top] * (i - stack.peekFirst() - 1);
				}
				if(area > maxArea) {
					maxArea = area;
				}
			}
			
		}
		
		while(!stack.isEmpty()) {
			int top = stack.pollFirst();
			if(stack.isEmpty()) {
				area = input[top] * i;
			} else {
				area = input[top] * (i - stack.peekFirst() - 1);
			}
			if(area > maxArea) {
				maxArea = area;
			}
		}
		
		
		return maxArea;
	}

	public static void main(String[] args) {
		MaximumHistogram mh = new MaximumHistogram();
		int[] input = new int[] {1,2,3,2,1};
		System.out.println(mh.maxHistogram(input));
	}

}
