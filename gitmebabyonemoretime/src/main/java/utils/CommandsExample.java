package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CommandsExample {

	public void get() {
		
		String websiteurl = "https://www.seleniumeasy.com/test/";
		String chromedriverpath = "./drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		WebDriver driver = new ChromeDriver();
		
		driver.get(websiteurl);
		
		
	}
	
	public void findElements(){
		
		/*
		 * 
		 * 
		 */
		
		String demowebsite = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";
		
		String chromedriverpath = "./drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		WebDriver driver = new ChromeDriver();
		
		driver.get(demowebsite);
		
		File file = driver.findElement(By.id("example")).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(file, new File("E:\\screenshots\\screenshot.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.findElement(By.id("example")).getLocation());
		
		List<WebElement> names = driver.findElements(By.xpath("//table[@id='example']//td[1]"));
	 	List<WebElement> salaries = driver.findElements(By.xpath("//table[@id='example']//td[1]"));
	 	
	 	for(int i=0;i<names.size();i++) {
	 		WebElement name = names.get(i);
	 		WebElement salary = salaries.get(i);
	 		if(name.getText().contains("Wagner")) {
	 			System.out.println("Salary is "+salary.getText());
	 			
	 		}
	 	}
				
	}
	
	public void navigateMethods() {
		
		/*
		 * 
		 * methods: get, navigate().to(), navigate().forward(), navigate().back(), navigate().refresh()
		 */
		
		String demowebsite1 = "https://www.seleniumeasy.com/test/";
		String demowebsite2 = "https://learn.letskodeit.com/p/practice";
		String chromedriverpath = "./drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		WebDriver driver = new ChromeDriver();

		driver.get(demowebsite1);	
		driver.navigate().to(demowebsite2);
		
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		
	}

	
	public void basic1() {
		
		/*
		 * Methods: sendKeys(), click(), getText();
		 * 
		 */
		
		String demowebsite = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
		String chromedriverpath = "./drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		WebDriver driver = new ChromeDriver();

		driver.get(demowebsite);
		
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("Hiiiiiii");
		
		driver.findElement(By.xpath("//form[@id='get-input']/button")).click();
		
		String textfromelement = driver.findElement(By.id("display")).getText();
		
		System.out.println("I have typed: "+textfromelement);
		
		
	}
	
	
	public static void main(String[] args) {

	String demowebsite1 = "https://www.seleniumeasy.com/test/";	
	String demowebsite2 = "https://learn.letskodeit.com/p/practice";
	String chromedriverpath = "./drivers/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chromedriverpath);
	WebDriver driver = new ChromeDriver();

	 CommandsExample example = new CommandsExample();
	 example.findElements();
		
	}
	
}
