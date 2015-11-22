package prob;
/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
 * @author adi
 *
 */
public class Pr1 {
  private final int n=1000;
	public Pr1() {
       int sum=0;
       sum=sumIt(3)+sumIt(5)-sumIt(15);
       System.out.println(sum);
	}
	
	private int sumIt(int val){
		int sum=0;
		for(int i=val;i<n;i=i+val)
			sum=sum+i;
		
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
              new Pr1();
	}

}
