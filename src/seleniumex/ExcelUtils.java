package seleniumex;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelUtils {
//	static String projectpath ;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath, String sheetname) 
	{
		try {
		
		workbook = new XSSFWorkbook(excelpath); //projectpath + "/excel/Data.xlsx"
		XSSFSheet sheet = workbook.getSheet(sheetname); //sheet1
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		}
	

	public static void getRowCount()
	{
		
		try {
			
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("rowcount is = " + rowcount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
	}
	

	public static void getCellDataStringcellvalue()
	{
		
		try {
			
			String cellvalue = 	sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println("cell value is = " + cellvalue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
	}

	

	public static void getCellDatanumeric(int rownum, int colnum)
	{
//		rownum = 1;
//		colnum = 1;
		try {
			double cellvaluenumeric = 	sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
			System.out.println("cell value in numeru = " + cellvaluenumeric);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
	}
}