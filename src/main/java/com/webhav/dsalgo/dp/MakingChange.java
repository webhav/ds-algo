package com.webhav.dsalgo.dp;

public class MakingChange {

	private static int[] coins = { 10, 6, 1 };

	public static void main(String[] args) {
		System.out.println(makeChangeDPBotUp(48));
	}

	private static int makeChangeDP(int amount) {
		int[] cache = new int[amount + 1];
		for (int i = 0; i < amount + 1; i++) {
			cache[i] = -1;
		}
		return makeChangeDP(amount, cache);
	}

	private static int makeChangeDP(int amount, int[] cache) {
		System.out.println("make change called for amount " + amount);

		if (cache[amount] >= 0)
			return cache[amount];

		if (amount == 0) {
			return 0;
		}

		int minCoins = Integer.MAX_VALUE;

		for (int coin : coins) {
			if (amount - coin >= 0) {
				int currCoins = makeChangeDP(amount - coin, cache);
				if (currCoins < minCoins) {
					minCoins = currCoins;
				}
			}
		}

		cache[amount] = minCoins + 1;
		return cache[amount];
	}

	private static int makeChangeDPBotUp(int c) {
		int[] cache = new int[c + 1];
		for (int i = 1; i <= c; i++) {
			int minCoins = Integer.MAX_VALUE;

			// Try removing each coin from the total
			// and see which requires the fewest
			// extra coins
			for (int coin : coins) {
				if (i - coin >= 0) {
					int currCoins = cache[i - coin] + 1;
					if (currCoins < minCoins) {
						minCoins = currCoins;
					}
				}
			}
			cache[i] = minCoins;
		}
		
		/*for(int cach : cache) {
			System.out.println(cach);
		}*/

		return cache[c];
	}

	private static int makeChange(int amount) {

		System.out.println("make change called for amount " + amount);

		if (amount == 0) {
			return 0;
		}

		int minCoins = Integer.MAX_VALUE;

		for (int coin : coins) {
			if (amount - coin >= 0) {
				int currCoins = makeChange(amount - coin);
				if (currCoins < minCoins) {
					minCoins = currCoins;
				}
			}
		}
		return minCoins + 1;
	}

}
