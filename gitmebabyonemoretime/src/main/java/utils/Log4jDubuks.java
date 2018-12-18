package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Log4jDubuks {

	private static WebDriver driver = null;
	static Logger log = Logger.getLogger(Log4jDubuks.class);
	public static void main(String[] args) {

	// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();

	// Hit the URL for which you want to see logs
	driver.get("https://www.google.co.in/");

	// Create reference variable “log” referencing getLogger method of Logger class, it is used to store logs in selenium.txt
	
	//PropertyConfigurator.configure("log4j.properties");
	// Call debug method with the help of referencing variable log and log the information in test.logs file
	log.debug("Getting errors");

	

	}
}
