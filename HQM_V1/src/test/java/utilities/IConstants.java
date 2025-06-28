package utilities;

import java.time.Duration;

/**
 * it is a interface and it consists of all the common data which can be used across the framework
 */
 



public interface IConstants {
	
	String EXCEL_PATH=".//testData//All_HQM_Details.xlsx";
	String PROPERTY_FILEPATH="./src//test//resources//config.properties";
	int IMPLICITLY_WAIT_TIMEOUT=20;
    Duration EXPLICITLY_WAIT_TIMEOUT=Duration.ofSeconds(20);

}
