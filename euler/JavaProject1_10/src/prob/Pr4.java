package prob;

public class Pr4 {
/**
 * 
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
 */
	public Pr4() {
	System.out.println(isPalindrome(900019));
 int n=1;
           for(int i=99;i<999;i++)
        	   for(int j=99;j<999;j++)
        		   if(isPalindrome(i*j) && n<i*j ){
                           n=i*j;
        		   }
           System.out.println(n);
 
	}

	private boolean isPalindrome(int n){
		int nn=n;
		int aux=0;
		while(nn!=0){
			aux=aux*10+nn%10;
			nn=nn/10;
		}
		if(aux==n)
		return true;
		else
			return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
new Pr4();
	}

}
