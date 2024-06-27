package AmazonTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Home_Page {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");                                             //to navigate home page

		// Verify that HomePage and Search Functionality 

		driver.findElement(By.xpath("//html")).isDisplayed();                             //Verify that feature products are displayed on home page
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).isDisplayed();    //Verify that Account sign are displayed on home page
		driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();        //Verify that Amazon logo are displayed on home page
		driver.findElement(By.xpath("//html")).isDisplayed();                             //Verify that feature products are displayed on home page
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).isDisplayed(); //Verify that Search functionality are present on home page
		WebElement Searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")); //Verify that enter the value in search tab
		Searchbox.sendKeys("iphone");
		Searchbox.submit();
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();       //Verify that search button click or not

		// Verify that Product Details

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,950)");              // To Scroll Down

		driver.findElement(By.xpath("//img[@alt='Apple iPhone 13 (128GB) - Pink']")).isDisplayed(); //Verify that image on product are display
		driver.findElement(By.xpath("//span[normalize-space()='48,799']")).isDisplayed();           // Verify that product amount are display on page
		driver.findElement(By.xpath("//div[@id='feature-bullets']")).isDisplayed();                 // Verify that product Feature & specification are display on page
		//Verify that show different color and select each
		driver.findElement(By.xpath("//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal a-spacing-top-micro swatches swatchesSquare imageSwatches']")).isDisplayed();


		//Verify that Add to Card

		driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")).click();  //Verify that Display Add to Card button and Click
		driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click(); //Verify that Display cart and Click

		Select Quantity = new Select(driver.findElement(By.id("a-autoid-0-announce")));     // Verify that display Quantity selector 
		Quantity.selectByValue("1");                                                        // Verify that Show and Select Quantity 

		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();    // verify that display proceed buy button and click 

		// Verify that Create / sign in Account

		driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("samadhansantre27");   // Verify that display user_id box and enter the input
		driver.findElement(By.xpath("//input[@type='submit']")).click();                          // Verify that display continue button and click

		//Fulfill personal details on sign page

		driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys("7507408877");        // Verify that display Contact box and verify that enter mobile no
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Samadhan Santre");  // Verify that display user_box on page and verify that enter user name
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Sama@123");         // Verify that display Password_box on page and verify that enter user password 
		driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();  

 

	}

}
