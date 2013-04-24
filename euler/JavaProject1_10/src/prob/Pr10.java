package prob;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  Find the sum of all the primes below two million.
 */
public class Pr10 {

	private final int n=2*1000*1000;
	public Pr10() {
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(2);
		long s=2;
		for(int i=3;i<n;i=i+2){
			if(isPrime(i)){
				list.add(i);
				s=s+i;
//				System.out.println(i);
			}
		}
		Iterator<Integer> it=list.iterator();
		int sum=0;
		while(it.hasNext()){
			int a=it.next();
			sum=sum+a;
		}
		System.out.println(s+"   "+sum);
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
            new Pr10();
	}

}
