
package com.dinua.euler.project.problems;

import com.dinua.euler.project.util.MathUtil;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 * 
 * @author adi
 *
 */

public class Problem4 {

	public static void main(String[] args) {
		int n = 1;
		for (int i = 99; i < 999; i++) {
			for (int j = 99; j < 999; j++) {
				if (MathUtil.isPalindrome(i * j) && n < i * j) {
					n = i * j;
				}
			}
		}
		System.out.println(n);

	}

}
