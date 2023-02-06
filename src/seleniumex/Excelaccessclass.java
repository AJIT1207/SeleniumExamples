package seleniumex;

public class Excelaccessclass {

	public static void main(String[] args) {
		String projectpath ;
		 projectpath  = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectpath + "/excel/Data.xlsx", "sheet1");
		excel.getRowCount();
		excel.getCellDataStringcellvalue();
		excel.getCellDatanumeric(1, 1);

	}

}
