
package com.dinua.euler.project.problems;

import com.dinua.euler.project.util.MathUtil;

/***
 * 
 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * @author adi
 *
 */
public class Problem5 {

	private static final int LIMIT = 20;

	public static void main(String[] args) {
		long value = 2;
		for (int i = 3; i <= LIMIT; i++) {
			value = MathUtil.leastCommonMultiple(value, i);
		}
		System.out.println(value);

	}
}
