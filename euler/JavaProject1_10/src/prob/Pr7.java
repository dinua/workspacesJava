package prob;
/**
 * 

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?

 * @author adi
 *
 */
public class Pr7 {

	public Pr7() {
          int n=10001;
          int ct=2;
          int it=4;
          while(ct<n){
        	  if(isPrime(it))
        		  ct++;
        	  it++;
          }
          System.out.println(--it);
	}
 
	private boolean isPrime(int n){
		if(n<2)
			return false;
		double sqrt=Math.sqrt(n);
		for(int i=2;i<=sqrt;i++){
			if(n%i==0) return false;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Pr7();

	}

}
