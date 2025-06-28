package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility {
	
	
	
	public static String getKeyValuefromProperty(String Key) throws Throwable {
		
		FileInputStream file= new FileInputStream(IConstants.PROPERTY_FILEPATH);
		Properties porty= new Properties();
		           porty.load(file);
		String value=porty.getProperty(Key);
		return value;
	}

}
