package com.webhav.dsalgo.dp;

public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(fibDPBotUp(10));
	}
	
	public static int fib(int n) {
		System.out.println("called for "+n);
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fib(n-1) + fib(n-2);
	}
	
	public static int fibDP(int n) {
		if(n < 2) {
			return n;
		}
		int[] cache = new int[n+1];
		cache[0] = 0;
		cache[1] = 1;
		for(int i=2; i<=n; i++) {
			cache[i] = -1;
		}
		return fibDP(n, cache);
	}
	
	public static int fibDP(int n, int[] cache) {
		System.out.println("called for "+n);
		if(cache[n] >= 0) {
			return cache[n];
		}
		cache[n] = fibDP(n-1, cache) + fibDP(n-2, cache);
		return cache[n];
	}
	
	public static int fibDPBotUp(int n) {
		int[] cache = new int[n+1];
		cache[0] = 0;
		cache[1] = 1;
		for(int i=2; i<=n; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		return cache[n];
	}
}
