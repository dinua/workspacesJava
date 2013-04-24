package prob;
/**
 * 

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

 * @author adi
 *  (a+b+c)(a+b+c) = a^2 + ab+ac+ba+b^2+bc+ca+cb+c^2=a^2+b^2+c^2+2ab+2bc+2ac=1000*1000
 *  c^2+ab+bc+ac=1000*500
 *  c(c+a)+ b(c+a)=1000*500
 *  (c+a)(c+b)=1000*500
 *  (c+a)(1000-a)=1000*500
 */
public class Pr9 {
  
	 private final int sum=1000;
	
	public Pr9() {
         for (int i=sum/3;i<=sum/2;i++){
               if(isInteger(i))
            	   calculateProd(i);
         }
       
	}
	private void calculateProd(int c) {
		long p=sum/2*c*(sum-2*c);
		System.out.println(p+"      "+c);
	}
	private boolean isInteger(int c){
 	    long val=(sum+c)*(sum+c)-2*sum*sum;
 	    double sqrt=Math.sqrt(val);
 	    int aux=(int)sqrt;
 	    if(aux*aux==val)
		        return true;
 	    else
 	    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Pr9();
	}

}
