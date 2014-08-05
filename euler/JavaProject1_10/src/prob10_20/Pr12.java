package prob10_20;

public class Pr12 {
	
	public static void main(String [] args ){

		int min=500;
		int n=1;
		boolean found = false;
		while(!found){
			if(n%2==0){
				found = nrOfDivisors(n/2) * nrOfDivisors(n+1) > min;
			}
			else {
				found = nrOfDivisors(n) * nrOfDivisors((n+1)/2) > min;
			}
			n++;
		}
		System.out.println(n-1);
		System.out.println(n*(n-1)/2);
	}
	
	private static int nrOfDivisors(int n){
		if(n==1){
			return 1;
		}
		int div=0;
		for(int i=2;i<=n/2;i++){
			if(n%i==0) div++;
		}
		
		return div+2;
	}

}
