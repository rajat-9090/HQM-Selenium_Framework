package testData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_read {
	
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream read= new FileInputStream("./testData//Login_Details.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(read);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		Row row;
		
		for(int r=0; r <= ws.getLastRowNum(); r++) {
			
			row=ws.getRow(r);
			
			for(int c=0; c < row.getLastCellNum(); c++) {
				
				String str=row.getCell(c).getStringCellValue();
				System.out.println(str);
			}
		}
		wb.close();
		read.close();
	}

}
