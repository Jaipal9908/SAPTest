package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();

	public static String readPropertiesFile(String value) {
		String finalValue = null;
		try {
			InputStream input = new FileInputStream("./src/main/java/config/config.properties");
			prop.load(input);
//			System.out.println(prop.get(value));
			finalValue = String.valueOf(prop.get(value));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalValue;
	}
	
	

	public static void writePropertiesFile() {
		try {
			OutputStream output = new FileOutputStream("./src/test/java/config/config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
