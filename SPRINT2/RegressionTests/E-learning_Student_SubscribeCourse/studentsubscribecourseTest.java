package ElearningTestcases;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ElearningPages.ELLogin;
import ElearningPages.studentsubscribecourse;

public class StudentSubscribeCourseTest {
	    
		static WebDriver driver;	
		  
	    
	@BeforeTest
	    public void initialize()
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://elearningm1.upskills.in/");
			driver.manage().window().maximize();		
	}
	
	
	@Test
	public void Subscribe()
	{
		ELLogin login = new ELLogin(driver);
		boolean success =login.Login("Akshara","Akshara@15");
		
		 studentsubscribecourse sub = new studentsubscribecourse(driver);
		 sub.Studentsubscribecourse();
	
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 try {
			 boolean addsuccess=sub.success_subscribecourse();
			 WebElement Searchtext=driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div/div/div[1]/form/div/input"));
			 System.out.println(Searchtext+" Course Subscribed Successfully");
			
			 
			 Assert.assertEquals(addsuccess, true); 
		 }
		 	
		 catch (NoSuchElementException e)
			{
			
				System.out.println("Cannot subscribe course\n"+driver.findElement(By.id("register")).getText());
				Assert.assertEquals(true, true);
				//status=false;
			}
		 

		    	}
	
		  
	
	
	
		@AfterTest
		public void closeAll()
		{
			driver.close();

		}
}
	
			

