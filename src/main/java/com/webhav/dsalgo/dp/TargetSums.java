package com.webhav.dsalgo.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSums {
	
	/**
	 * Time Complexity O(2^n)
	 * @param input
	 * @param 
	 * @return
	 */
	public static int targetSums(int[] input, int T) {
		return targetSums(input, T, 0, 0);
	}
	
	public static int targetSums(int[] input, int T, int i, int sum) {
		System.out.println(i + ":" + sum);
		if(i == input.length) {
			return T == sum ? 1 : 0;
		}
		return targetSums(input, T, i+1, sum + input[i]) + targetSums(input, T, i+1, sum - input[i]);
	}
	
	/**
	 * TimeComplexity O(i*sum(nums))
	 * SpaceComplexity same as above
	 * @param input
	 * @param T
	 * @return
	 */
	public static int targetSumsDPTopToBot(int[] input, int T) {
		System.out.println("Calling DP method");
		Map<String, Integer> cache = new HashMap<>();
		return targetSumsDPTopToBot(input, T, 0, 0, cache);
	}
	
	public static int targetSumsDPTopToBot(int[] input, int T, int i, int sum, Map<String, Integer> cache) {
		String cacheKey = i + ":" + sum;
		System.out.println(cacheKey);
		if(cache.containsKey(cacheKey)) {
			return cache.get(cacheKey);
		}
		if(i == input.length) {
			return T == sum ? 1 : 0;
		}
		int result = targetSumsDPTopToBot(input, T, i+1, sum + input[i], cache) + targetSumsDPTopToBot(input, T, i+1, sum - input[i], cache);
		cache.put(cacheKey, result);
		return result;
	}
	
	/**
	 * TimeComplexity O(i*sum(nums))
	 * SpaceComplexity same as above
	 * @param input
	 * @param T
	 * @return
	 */
	public static int targetSumsBotUp(int[] input, int T) {
		int sum = 0;
		for(int n: input) sum+=n;
		int[][] cache = new int[input.length + 1][2*sum+1];
		if(sum == 0)return 0;
		
		cache[0][sum] = 1;
		
		for(int i=1; i<=input.length; i++) {
			for(int j=0; j<2*sum+1; j++) {
				int prev = cache[i-1][j];
				if(prev !=0 ) {
					cache[i][j-input[i-1]] += prev;
					cache[i][j+input[i-1]] += prev;
				}
			}
		}
		
		for(int i=0; i<cache.length; i++) {
			for(int j=0; j<cache[i].length; j++) {
				//System.out.println(i + ":" + j + " = " + cache[i][j]);
				System.out.print(cache[i][j] + "\t");
			}
			System.out.println();
		}
		
		return cache[input.length][sum + T];
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {1,1,1,1,1};
		System.out.println(targetSumsBotUp(input, 3));
	}

}
