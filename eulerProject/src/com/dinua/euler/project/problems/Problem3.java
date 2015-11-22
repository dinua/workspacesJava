
package com.dinua.euler.project.problems;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author adi
 *
 */
public class Problem3 {

	private static long number = 600851475143L;

	public static void main(String[] args) {
		final double sqrt = Math.sqrt(number);
		for (int i = 2; i < sqrt; i++) {
			while (number % i == 0) {
				number = number / i;
			}
			if (number == 1) {
				System.out.println(i);
				i = (int) sqrt;
			}
		}
	}

}
