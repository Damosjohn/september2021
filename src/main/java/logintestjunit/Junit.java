package logintestjunit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit {
	WebDriver driver;

	@BeforeClass
	public static void beforetest() {
		System.out.println("before class");
	}

	@AfterClass
	public static void aftertest() {
		System.out.println("after test");
	}

	@Before
	public void lunchbrowser() {
		System.out.println("before");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
	}

	@Test
	public void logintest() {
		System.out.println("test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");

		driver.findElement(By.id("password")).sendKeys("abc123");

		driver.findElement(By.name("login")).click();
	}

	@Test
	public void logintest1() {
		System.out.println("test1");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");

		driver.findElement(By.id("password")).sendKeys("abc1234555");

		driver.findElement(By.name("login")).click();
		//DYNAMIC ELEMENTS
		//ul[@class='cn cn-list-hierarchical-xs cn--idx-0 cn-container_D8D065EA-02E6-CDB7-43EA-B5DE08F02B2D']/descendant::div/descendant::a[2]
	}

	@After
	public void teardown() {
		System.out.println("teardown");
		driver.close();
		driver.quit();
	}

}
