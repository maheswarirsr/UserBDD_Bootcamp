package utilities;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class PropertiesFile {
	
	private final static String propertyFilePath = "./src/test/resources/global.properties";	
	static FileInputStream fis;
	private static Properties prop = null;

	public static String getProperty(String property) throws IOException {		

		try {
			FileInputStream fis;
			fis = new FileInputStream(propertyFilePath);
			prop = new Properties();
			try {
				prop.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return prop.getProperty(property).trim();
	}
}
