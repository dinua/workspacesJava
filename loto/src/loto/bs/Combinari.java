package loto.bs;

import java.util.ArrayList;
import java.util.List;

public class Combinari {

	private final static int n=4;
	private final static int k=3;
	
	public Combinari() {
		genereazaPermutari();
	}

	public void genereazaPermutari(){
		List<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		for(int i=1;i<=n-k+1;i++){
			int ct=i;
			while(ct+k-1<=n){
			System.out.print("{ "+i+",");
			for(int j=ct+1;j<=k-1+ct;j++){
				System.out.print(j+",");
			}
			System.out.print("}");
			ct++;
			}
			System.out.println();
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Combinari();
	}

}
