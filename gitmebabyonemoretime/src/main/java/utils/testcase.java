package utils;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class testcase extends BrowserCommands{


{
		System.setProperty("atu.reporter.config", "./config/atu.properties");
	}


	@Test
	public void testMethod() {
		launchChromeDriver();
		launchURL("http://www.gmail.com");
		click(driver.findElement(By.id("dumbass")));
		
	}
}
