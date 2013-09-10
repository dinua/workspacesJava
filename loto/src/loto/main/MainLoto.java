package loto.main;

import loto.bs.LotoBusinessService;
import loto.ps.LotoPersistenceService;
import loto.ui.MainFrame;

public class MainLoto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new MainFrame();
afiseaza();
	}

	private static void afiseaza(){
		LotoBusinessService loto = new LotoBusinessService();
		loto.big6();
	}
}
