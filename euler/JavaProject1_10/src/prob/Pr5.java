package prob;
/**
 * 

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

 */
import java.util.ArrayList;
import java.util.List;

public class Pr5 {

	public Pr5() {
      int n=20;
      int value=2;
       for(int i=3;i<=n;i++){
                  value=cmmmc(value, i);
                  System.out.println(value+"      "+i);
       }
       System.out.println(value);
	}

	
	private int cmmmc(int a,int b){
		int a2=a;
		int b2=b;
		int aux;
		while(b!=0){
			aux=a%b;
			a=b;
			b=aux;
		}
		return a2*b2/a;
		
	}
	
	private List<Integer> divizor(int n){
		List<Integer> list=new ArrayList<Integer>();
		double sqrt=Math.sqrt(n);
		for(int i=2;i<=sqrt;i++){
			while(n%i==0){
				list.add(i);
				n=n/i;
			}
		}
		if(n!=1)
		list.add(n);
		return list;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Pr5();

	}

}
