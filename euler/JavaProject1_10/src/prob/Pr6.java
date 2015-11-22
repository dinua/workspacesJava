package prob;
/**
 * 

The sum of the squares of the first ten natural numbers is,
12 + 22 + ... + 102 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

 * @author adi
 *
 */
public class Pr6 {

	public Pr6() {
            int n=100;
            int sum=0;
            for(int i=1;i<=n;i++)
            	for(int j=1;j<=n;j++)
            		if(i!=j)  sum=sum+i*j;
	
            System.out.println(sum);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
            new Pr6();
	}

}
