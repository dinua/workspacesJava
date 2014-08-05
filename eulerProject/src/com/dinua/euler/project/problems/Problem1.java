package com.dinua.euler.project.problems;

import com.dinua.euler.project.util.MathUtil;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */
public class Problem1 {

	public static void main(String[] args){
		int limit=1000;
		int numbersDivededBy3 = (limit-1)/3;
		int numbersDivededBy5 = (limit-1)/5;
		int numbersDivededBy15 = (limit-1)/15;
		System.out.println(3*MathUtil.sum(numbersDivededBy3) 
				+ 5*MathUtil.sum(numbersDivededBy5)
				- 15*MathUtil.sum(numbersDivededBy15));
	}
}
