package com.dinua.euler.project.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class MathUtilTest {

	@Test
	public void testIsPalindrome1() {
		assertTrue(MathUtil.isPalindrome(1));
	}
	
	@Test
	public void testIsPalindrome2() {
		assertTrue(MathUtil.isPalindrome(1234321));
	}
	
	@Test
	public void testIsPalindrome3() {
		assertFalse(MathUtil.isPalindrome(125));
	}
	
	@Test
	public void testIsPalindrome4() {
		assertFalse(MathUtil.isPalindrome(123532));
	}

}
