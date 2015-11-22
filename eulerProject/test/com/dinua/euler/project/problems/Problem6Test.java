package com.dinua.euler.project.problems;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dinua.euler.project.problems.Problem6;

public class Problem6Test {

	@Test
	public void test() {
	Problem6 problem6 = new Problem6();
	assertEquals(2640,problem6.sumSquares(10));
	}

}
