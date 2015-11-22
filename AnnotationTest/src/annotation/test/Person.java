package annotation.test;

import deprecated.AgeDeprecated;
import annotation.AgeError;

public class Person {

	@AgeError(4)
//	@AgeDeprecated(3)
//	@SuppressWarnings(value = { "sd" })
	private int age;
	
	public static void main(String[] args){
		System.out.println(Person.class.getName());
	}
}
