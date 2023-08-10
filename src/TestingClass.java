import java.time.Duration;
import java.util.Random;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class TestingClass extends DataField  {
	
	@BeforeTest
	public void beforeTest() {
		driver.get(homePage);
	}
	
	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(loginPage);
		
		Thread.sleep(3000);
		
		int randomNumber = new Random().nextInt();
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
		WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
		WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		
		name.sendKeys("osama");
		emailAddress.sendKeys("osama"+randomNumber+"@HTU.com");
		signUpButton.click();
		
		Thread.sleep(4000);
		
		WebElement title = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
		WebElement title2 = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		Select objSelectDay =new Select(driver.findElement(By.name("days")));
		Select objSelectMonth =new Select(driver.findElement(By.name("months")));
		Select objSelectYear =new Select(driver.findElement(By.name("years")));
		Select objSelectCountry =new Select(driver.findElement(By.name("country")));
		WebElement newsletterButton = driver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
		WebElement ReceiveSpecialOffers = driver.findElement(By.xpath("//*[@id=\"optin\"]"));
		WebElement FirstName  = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		WebElement LastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
		WebElement Company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
		WebElement Address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		WebElement Address2 = driver.findElement(By.xpath("//*[@id=\"address2\"]"));
		WebElement State = driver.findElement(By.xpath("//*[@id=\"state\"]"));
		WebElement City = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		WebElement Zipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
		WebElement MobileNumber = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
		WebElement SignUpButton2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button"));
		
		
		title.click();
		password.sendKeys("HTU@"+randomNumber);
		newsletterButton.click();
		ReceiveSpecialOffers.click();
		FirstName.sendKeys("osama");
		LastName.sendKeys("HTU");
		Company.sendKeys("HTU");
		Address.sendKeys("Amman-Jordan");
		Address2.sendKeys("Business Park");
		State.sendKeys("Amman");
		City.sendKeys("Amman");
		Zipcode.sendKeys("21110");
		MobileNumber.sendKeys("0790889876");
		objSelectDay.selectByVisibleText("1");
		objSelectMonth.selectByVisibleText("May");
		objSelectYear.selectByVisibleText("2000");
		objSelectCountry.selectByVisibleText("Canada");
		newsletterButton.click();
		ReceiveSpecialOffers.click();
		
		Thread.sleep(1000);
		SignUpButton2.click();
		
		Thread.sleep(2000);
		WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		continueButton.click();
		
		driver.get(homePage);
	}
	
	@Test(priority = 2)
	public void SignIn() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();//to click LogOut button
		
		driver.get(loginPage);
		WebElement password = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
		WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
		emailAddress.sendKeys("osama@htu.com");
		password.sendKeys("HTU@1234");
		loginButton.click();
	}
	
	@Test(priority = 3)
	public void addFirstFiveItems() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		for(int i = 0 ; i < urls.length ; i++) {
		driver.get(urls[i]);
		WebElement addButton = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
		addButton.click();
		Thread.sleep(2000);
		}
		driver.get("https://automationexercise.com/view_cart");
	}
	
	@Test (priority = 4)
	public void addRandomSevenItems() throws InterruptedException {
		
		int[] randomNumbers = new int[7];
        Random random = new Random();
        
        for (int i = 0; i < 7; i++) {
            int randomNumber = random.nextInt(43) + 1; // Generate a random number between 1 and 43
            randomNumbers[i] = randomNumber; // Store the random number in the array
        }
        System.out.println("Random Numbers: " + Arrays.toString(randomNumbers));
        for (int i = 0; i < 7; i++) {
        	driver.get(products+randomNumbers[i]);
			WebElement addButton = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
    		addButton.click();
    		Thread.sleep(2500);
        }
        
		driver.get(cart);
		Thread.sleep(4000);
		for(int i = 0 ; i < 7 ; i++) {
			driver.findElement(By.xpath("//*[@id=\"product-"+randomNumbers[i]+"\"]/td[6]/a")).click();//to click Remove button
			Thread.sleep(2000);
		}
	}
	
	@Test(priority = 5)
	public void contactUs() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://automationexercise.com/contact_us");
		Thread.sleep(2000);
		WebElement Name = driver.findElement(By.name("name"));
		WebElement Email  = driver.findElement(By.name("email"));
		WebElement Subject = driver.findElement(By.name("subject"));
		WebElement Notes = driver.findElement(By.name("message"));
		WebElement ChooseFile = driver.findElement(By.name("upload_file"));
		String filePath = "/Users/user/Desktop/QA/HTU Logo-250px.png";
        ChooseFile.sendKeys(filePath);
		WebElement Submit = driver.findElement(By.name("submit"));
			
		Name.clear();
		Name.sendKeys("Ibrahim khalil");
		Email.sendKeys("ibrahimmubark1999@gmail.com");
		Subject.sendKeys("New order");
		Notes.sendKeys("please i need the order as fast as possible");
		ChooseFile.sendKeys(filePath);
		Submit.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	@Test(priority = 6)
	public void screenshot() throws IOException, InterruptedException {
		
		driver.get(cart);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
		Thread.sleep(3000);
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("./src/screens");
        FileUtils.copyFile(SrcFile, DestFile);
	}
	
	@AfterTest
	public void AfterTest() {
		
	}
}
