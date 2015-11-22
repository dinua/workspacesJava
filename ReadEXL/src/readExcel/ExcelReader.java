package readExcel;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {

	public static void main(String[] args) {
        //path
		String fileName = "airline.xls";
		Vector<Vector<HSSFCell>> dataHolder = readCSV(fileName);
		printCellDataToConsole(dataHolder);
	}

	public static Vector<Vector<HSSFCell>> readCSV(String fileName) {
		Vector<Vector<HSSFCell>> cellVectorHolder = new Vector<Vector<HSSFCell>>();

		try {
			FileInputStream myInput = new FileInputStream(fileName);

			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

			HSSFSheet mySheet = myWorkBook.getSheetAt(0);

			Iterator<Row> rowIter = mySheet.rowIterator();

			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator<Cell> cellIter = myRow. cellIterator();
				Vector<HSSFCell> cellStoreVector = new Vector<HSSFCell>();
				while (cellIter.hasNext()) {
					HSSFCell myCell = (HSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
				}
				cellVectorHolder.addElement(cellStoreVector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellVectorHolder;
	}

	private static void printCellDataToConsole(Vector<Vector<HSSFCell>> dataHolder) {

		for (int i = 0; i < dataHolder.size(); i++) {
			Vector<HSSFCell> cellStoreVector = (Vector<HSSFCell>) dataHolder.elementAt(i);
			for (int j = 0; j < cellStoreVector.size(); j++) {
				HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();
				System.out.print(stringCellValue + "\t");
			}
			System.out.println();
		}
	}
}