
package com.dinua.euler.project.util;

public class MathUtil {

	public static int sum(int number) {
		return number * (number + 1) / 2;
	}

	public static boolean isPalindrome(int number) {
		final StringBuilder numerToString = new StringBuilder("" + number);
		return numerToString.toString().equals(numerToString.reverse().toString());
	}

	public static long leastCommonMultiple(long first, long second) {
		return first / leastCommonDivizor(first, second) * second;

	}
	public static long leastCommonDivizor(long first, long second) {
		long a = first;
		long b = second;
		long aux= a%b;
		while (aux != 0) {
			a = b;
			b = aux;
			aux = a % b;
		}
		return b;

	}
}
