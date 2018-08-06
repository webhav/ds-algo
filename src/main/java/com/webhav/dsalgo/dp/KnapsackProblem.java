package com.webhav.dsalgo.dp;

import java.util.HashMap;
import java.util.Map;

public class KnapsackProblem {

	private static int knapsack(Item[] items, int maxW) {
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
		//return knapsackDPWithTopDown(items, maxW, 0, cache);
		return knapsack(items, maxW, 0);
	}

	/*
	 * This is a recursive solution for knapsack problem
	 * Time Complexity : O(2^n)
	 * Space Complexity : O(n)
	 */
	private static int knapsack(Item[] items, int maxW, int i) {
		System.out.println("method called with + " + i + " maxW " + maxW);
		if(i == items.length) {
			return 0;
		}
		
		if(maxW - items[i].getWeigth() < 0) {
			return knapsack(items, maxW, i+1);
		}
		
		return Math.max(knapsack(items, maxW - items[i].getWeigth(),  i+1) + items[i].getValue(), 
				knapsack(items, maxW, i+1));
		
	}
	
	private static int knapsackDPWithTopDown(Item[] items, int maxW, int i, Map<Integer, Map<Integer, Integer>> cache) {
		System.out.println("method called with + " + i + " maxW " + maxW);
		if(i == items.length) {
			return 0;
		}
		if(cache.containsKey(i)) {
			Map<Integer, Integer> map = cache.get(i);
			if(map.containsKey(maxW)) {
				return map.get(maxW);
			} else {
				int toReturn = 0;
				if(maxW - items[i].getWeigth() < 0) {
					toReturn = knapsackDPWithTopDown(items, maxW, i+1, cache);
				} else {
					toReturn = Math.max(knapsackDPWithTopDown(items, maxW - items[i].getWeigth(),  i+1, cache) + items[i].getValue(), 
							knapsackDPWithTopDown(items, maxW, i+1, cache));
				}
				cache.get(i).put(maxW, toReturn);
				return toReturn;
			}
		} else {
			cache.put(i, new HashMap<>());
			return knapsackDPWithTopDown(items, maxW, i, cache);
		}
		
	}
	
	/**
	 * Time Complexity : O(nW)
	 * Space Complexity : O(nW)
	 * @param items n is number of item
	 * @param maxW W is maxWeight
	 * @return
	 */
	private static int knapsackBotUp(Item[] items, int maxW) {
		int[][] cache = new int[items.length + 1][maxW + 1];
		
		for(int i=1; i<= items.length; i++) {
			for(int j=0; j<=maxW; j++) {
				if(items[i-1].getWeigth() > j) {
					cache[i][j] = cache[i-1][j];
				} else {
					cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j-items[i-1].getWeigth()] + items[i-1].getValue());
				}
			}
		}
		
		for(int i=0; i<cache.length; i++) {
			for(int j=0; j<cache[i].length; j++) {
				System.out.println(i + ":" + j + " = " + cache[i][j]);
			}
		}
		
		return cache[items.length][maxW];
	}

	public static void main(String[] args) {
		Item[] items = new Item[] {(new Item(2, 6)), new Item(2,10), new Item(3,12)};
		System.out.println(knapsackBotUp(items, 5));
	}

	static class Item {
		private int weigth;
		private int value;

		public Item(int weigth, int value) {
			super();
			this.weigth = weigth;
			this.value = value;
		}

		public int getWeigth() {
			return weigth;
		}

		public void setWeigth(int weigth) {
			this.weigth = weigth;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

}
