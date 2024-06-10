package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
//BaseClass is used to load the config file and Initialize 
//WebDriver instance
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.apache.log4j.xml.DOMConfigurator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
//	public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>(); 
	@BeforeSuite
	public void beforeSuite()
	{
		DOMConfigurator.configure("log4j.xml");
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	public static Properties prop;
    @BeforeTest
	public void loadCofig() {
		try {
			File file = new File("./Configuration/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void launchApp() {
		String browserName1 = prop.getProperty("browser");
		if (browserName1.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName1.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName1.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("testURL"));
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
}
