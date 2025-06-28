package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders  {
	
	
     
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception{
		
		String path= IConstants.EXCEL_PATH;
		
		Excelutility xlutil= new Excelutility(path);
		
		int totalrows= xlutil.getRowCount("LogIN_DDT");
		int totalcols= xlutil.getCellCount("LogIN_DDT", 1);
		
		//Creating two dimential Array to store the data from the Excel
		String loginData[][]= new String[totalrows][totalcols];
		
		for(int i=1; i<=totalrows; i++) {
			
			for(int j=0; j<totalcols; j++) {
				
				loginData[i-1][j]= xlutil.getCellData("LogIN_DDT", i, j);
			}
		}
		
		return loginData;
	}
	
	
}
