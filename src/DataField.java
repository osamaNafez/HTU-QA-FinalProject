import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataField {
	
	WebDriver driver = new ChromeDriver(); 
	String homePage = "https://automationexercise.com/"; 
	String loginPage = "https://automationexercise.com/login";
	
	String [] urls = {"https://automationexercise.com/product_details/1",
				"https://automationexercise.com/product_details/2",
				"https://automationexercise.com/product_details/3",
				"https://automationexercise.com/product_details/4",
				"https://automationexercise.com/product_details/5"};
	
	String products = "https://automationexercise.com/product_details/"; 
	String cart= "https://automationexercise.com/view_cart";
}
