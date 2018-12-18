package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

	
	static Properties prop = new Properties();
	static FileInputStream fis;
	
	public static void main(String...s) {
		try {

			fis = new FileInputStream("./config/dubuks.properties");

			// load a properties file
			prop.load(fis);

			// get the property value and print it out
			System.out.println(prop.getProperty("ffuck1"));
			System.out.println(prop.getProperty("fuck2"));
		}catch(Exception e) {
			System.out.println("Totally fucked up this is catch block :(");
		}
		
	}
	
}
