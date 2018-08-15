package com.webhav.dsalgo.dp;

public class IsWordPresentIn2DArray {
	
	public static void main(String[] args) {
		
		
		char[][] input = {{'a','b','c','e','e'},
						  {'a','a','c','d','e'},
						  {'a','p','o','k','e'},
						  {'a','b','c','s','e'},
						  {'a','b','t','s','e'},
						  {'a','b','o','p','o'}};
		
		System.out.println(isWordPresent(input, "spot", 0, 0, 0, false));
		
	}
	
	/**
	 * Brute-force method to find if string is present or not
	 * @param input
	 * @param word
	 * @param charAt
	 * @param i
	 * @param j
	 * @param isBackWard
	 * @return
	 */
	public static boolean isWordPresent(char[][] input, String word, int charAt, int i, int j, boolean isBackWard) {
		
		System.out.println("ch:" +charAt + " : " + i + " : " + j);
		
		if(i<0 || j<0 || i > input.length - 1 || j > input[0].length - 1 || charAt > word.length() - 1)
			return false;
		
		char character = word.charAt(charAt);
		
		char characterToCheck = input[i][j];
		
		if(charAt == word.length() - 1) {
			return character == characterToCheck;
		}
				
		if(character == characterToCheck) {
			return isWordPresent(input, word, charAt+1, i+1, j, false) || isWordPresent(input, word,charAt+1, i-1, j, true)
					|| isWordPresent(input, word,charAt+1, i, j+1, false) || isWordPresent(input, word,charAt+1, i, j-1, true);
		} else {
			if(isBackWard)
				return false;
			return isWordPresent(input, word, 0, i+1, j, false) || isWordPresent(input, word, 0, i, j+1, false);
		}
	}

}
