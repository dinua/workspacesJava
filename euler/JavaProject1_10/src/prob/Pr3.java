package prob;
/**
 * The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 * @author adi
 *
 */
public class Pr3 {
   private long  n=600851475143L;
	public Pr3() {

		 double sqrt=Math.sqrt(n);
		 for(int i=2;i<sqrt;i++){
			 while(n%i==0) n=n/i;
			 if(n==1) {
				 System.out.println(i);
			      i=(int) sqrt;	 
			 }
		 }
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
                   new Pr3();
	}

}
