package todo;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class TodoTasks {

	WebDriver driver;
	Properties prop;
	InputStream inputStream;
	
	@BeforeTest
	@Parameters({"browser"})
 	  private void setUp(String browser) {
	    
	  
			if (browser.equals("Chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			else if (browser.equals("Firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		  }
  
 @BeforeTest
	  private void loadProperties() throws IOException {
	
	  	  prop = new Properties();
	  
	  inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
	  if (inputStream != null) {
		  prop.load(inputStream);
	  } else {
		  throw new FileNotFoundException("property file not found in the classpath");
	  }
  }
	  
@BeforeTest(dependsOnMethods = {"loadProperties","setUp"})
  	private void openUrl() {
		 	  
		 driver.get(prop.getProperty("url"));
		 	 
	 }

  @Test(priority = 0)
  @Parameters({"task","footerCount"})
  private void createTask(String task,int footerCount) {
  	 String xpath=prop.getProperty("textbox");
  	 waitForElement(xpath);
  	 WebElement textBox=driver.findElement(By.xpath(xpath));
  	 textBox.sendKeys(task);
  	 textBox.sendKeys(Keys.ENTER);
  	 String footerTextActual = driver.findElement(By.xpath(prop.getProperty("footerText"))).getText();
  	 String footerTextExpected=null;
  	 
  	 if(footerCount>1)
  	 {
  		footerTextExpected=footerCount+" items left";
  	 }
  	 else
  	 {
  		footerTextExpected=footerCount+" item left";
  	 }
  	 if(footerTextActual.equals(footerTextExpected))
  	 {
  		 System.out.println("The task has been created and "+footerCount+ " item left' is displayed at the bottom");
  	 }
  	 else
  	 {
  		 System.out.println(footerCount +" item left' is not displayed at the bottom");
  	 }
  	 Assert.assertEquals(footerTextActual,footerTextExpected);
   }
  
  private void waitForElement(String xpath) {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	 }
  
  @Test(priority = 1)
  @Parameters({"task"})
  private void editTask(String task) throws InterruptedException { 
		 
	  	
		 Actions action = new Actions(driver);
		 WebElement enteredText = driver.findElement(By.xpath(prop.getProperty("addedText").replace("%s",task)));
		 action.doubleClick(enteredText).perform();
		 Thread.sleep(2000);
		 WebElement editText = driver.findElement(By.xpath(prop.getProperty("editText")));
		 editText.sendKeys("Edited");
		 Thread.sleep(2000);
		 editText.sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
		 String actualText = enteredText.getText();
		 
		 if(actualText.equals("Test1Edited"))
		 {
			 System.out.println("The task has been edited and saved successfully");
		 } 
		 else 
		 {
			 System.out.println("The task was not edited");
		 }
	 }

  private void clickTask(String task) {
	    WebElement checkText = driver.findElement(By.xpath(prop.getProperty("checkText").replace("%s", task)));
		 checkText.click();
  }

  @Test(priority = 2)
  @Parameters({"task"})
  private void uncheckTask(String task) throws InterruptedException {
	  	
	  	 clickTask(task);
	  	 Thread.sleep(2000);
	  	 clickTask(task);
		 WebElement comp = driver.findElement(By.xpath(prop.getProperty("notCompleted")));
		 if(comp.isEnabled()) 
		 {
			 System.out.println("Task is unchecked");
			 String footerTextActual = driver.findElement(By.xpath(prop.getProperty("footerText"))).getText();
			 String footerTextExpected = "1 items left";
			 if(footerTextActual.equals(footerTextExpected))
			 {
				 System.out.println("The task has been marked as completed and the expected footer text is present");
			 } else
			 {
				 System.out.println("'1 item left' text is not present at the bottom");
			 }
			 
		}
	 }

  @Test(priority = 3)
  @Parameters({"task"})
  private void checkTask(String task) {
	  	
	  	 clickTask(task);
		 WebElement comp = driver.findElement(By.xpath(prop.getProperty("completed")));
		 if(comp.isEnabled()) 
		 {
			 System.out.println("Task is checked");
			 String footerTextActual = driver.findElement(By.xpath(prop.getProperty("footerText"))).getText();
			 String footerTextExpected = "0 items left";
			 if(footerTextActual.equals(footerTextExpected))
			 {
				 System.out.println("The task has been marked as completed and the expected footer text is present");
			 } else
			 {
				 System.out.println("'0 items left' text is not present at the bottom");
			 }
			 
		}
		 		 clearCompletedTask();
	 }
  
  private void clearCompletedTask() {
		 
		 driver.findElement(By.xpath(prop.getProperty("clearCompleted"))).click();
		 System.out.println("The task was removed by clicking the 'Clear Completed' link");
		 
	 }
  
  @Test(priority = 4)
  @Parameters({"task"})
  private void removeTask(String task) throws InterruptedException {
	     createTask(task,1);
	  	driver.findElement(By.xpath(prop.getProperty("addedText").replace("%s", task))).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(prop.getProperty("removeText"))).click();
		 Thread.sleep(5000);
		 
		 System.out.println("A new task was created and deleted");
	}
  
  @Test(priority = 5, groups = "multiple")
  @Parameters({"task1","task2"})
   private void createMultipleTask(String task1,String task2) throws InterruptedException
  {
	  createTask(task1,1);
	  Thread.sleep(3000);
	  createTask(task2,2);
	  Thread.sleep(3000);
	  
		System.out.println("The tasks were created successfully");
	  
  }
  
  @Test(priority = 6, groups = "multiple")
  @Parameters({"task1","task2"})
   private void deleteLastTask() throws InterruptedException
  {
	driver.findElement(By.xpath(prop.getProperty("checkLast"))).click();;
	Thread.sleep(3000);
	driver.findElement(By.xpath(prop.getProperty("clearLast"))).click();;
	Thread.sleep(3000);
	 
	System.out.println("The tasks were deleted successfully");
	
  }
    
  @AfterTest
  private void tearDown() {
		 
		 driver.close();
		 driver.quit();
	}

}
