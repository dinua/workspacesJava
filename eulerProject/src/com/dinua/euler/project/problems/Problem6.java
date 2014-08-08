package com.dinua.euler.project.problems;
/**
 * The sum of the squares of the first ten natural numbers is,
12 + 22 + ... + 102 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * @author vgq8936
 *
 */
public class Problem6 {

	public int sumSquares(int limit){
		int sum=0;
		 for(int i=1;i<=limit;i++)
         	for(int j=1;j<=limit;j++)
         		if(i!=j)  sum=sum+i*j;
	
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new Problem6().sumSquares(100));

	}

}
