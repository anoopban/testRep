package com.oneclass.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest {
WebDriver driver;
String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

public void signUpTest (WebDriver driver)
{
this.driver = driver;	
	}

@BeforeTest
public void setup()
{
	System.setProperty("webdriver.chrome.driver","C:\\Working\\Workspace\\SeleniumProject\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://oneclass.com/signup");
}

@Test(priority = 1)
public void signUp()
{
	WebElement email = driver.findElement(By.id("email"));
	WebElement password = driver.findElement(By.id("password_"));
	WebElement signUp = driver.findElement(By.name("commit"));
	
	email.sendKeys("oneclass.interview"+timeStamp+"@yahoo.com");
	password.sendKeys("abcd-1234");
	signUp.click();
}

@Test(priority = 2)
public void activate() throws Exception{
	
	Thread.sleep(3000);
	By name = By.name("full_name");
	driver.findElement(name).sendKeys("OneClassInterview"+timeStamp);
	
	Thread.sleep(2000);
	
	WebElement statusBar = driver.findElement(By.id("user_option_select_chzn"));
	statusBar.click();
	WebElement status = driver.findElement(By.id("user_option_select_chzn_o_2"));
	status.click();

	Thread.sleep(2000);
	
	WebElement checkBox = driver.findElement(By.id("above_age"));
	checkBox.click();
	
	WebElement next = driver.findElement(By.className("next_btn"));
	next.click();
	
}

@Test(priority = 3)
public void addCourse() throws Exception{

	Thread.sleep(3000);
	
	WebElement skipTour = driver.findElement(By.id("skip-tour"));
	skipTour.click();
	
	Thread.sleep(2000);
	
	WebElement addCourse = driver.findElement(By.className("add-course-btn"));
	addCourse.click();
	
	Thread.sleep(2000);
	
	WebElement findCourse = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div[1]/a"));
	findCourse.click();

	Thread.sleep(2000);
	
	WebElement department = driver.findElement(By.id("department"));
	department.sendKeys("Political Science");
	
	WebElement courseCode = driver.findElement(By.id("c_code"));
	courseCode.sendKeys("POL SCI 1");

	WebElement courseName = driver.findElement(By.id("c_name"));
	courseName.sendKeys("Introduction to American Politics");
	
	WebElement professor = driver.findElement(By.id("professor"));
	professor.sendKeys("Ashcroft Richard");
	
	WebElement submit = driver.findElement(By.className("add_new_course_submit"));
	submit.click();
}

@AfterTest
public void tearDown()
{
	driver.close();
	driver.quit();
}
}
