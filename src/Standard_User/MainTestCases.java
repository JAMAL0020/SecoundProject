package Standard_User;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases {

	WebDriver driver = new ChromeDriver();

	Random rand = new Random();

	String myWebsite = "https://www.saucedemo.com";
	String userName = "standard_user";
	String passwordInput = "secret_sauce";

	@BeforeTest

	public void MySetup() {

		driver.get(myWebsite);
		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();

	}

	@Test(priority = 1)
	public void Login() {
		// driver.findElement(By.id("user-name")).sendKeys(userName);
		// driver.findElement(By.id("password")).sendKeys(passwordInput);
		// driver.findElement(By.id("login-button")).click();

		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInputField.sendKeys(userName);
		PasswordInputField.sendKeys(passwordInput);
		LoginButton.click();
	}

	@Test(priority = 2, enabled = false)
	public void AddAllItems() {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 1; i < AddToCartButtons.size(); i = i + 2) {
			AddToCartButtons.get(i).click();

		}
		;

		// List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		// AddToCartButtons.get(0).click();

	}

	@Test(priority = 3, enabled = false)
	public void AddCertainNumberOfItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddToCartButtons.size(); i++) {

			if (i == 0 || i == 2) {
				continue;
			}

			AddToCartButtons.get(i).click();

		}

		// correct code
		// List<WebElement> AddToTheCartButton =
		// driver.findElements(By.className("btn"));
		// for(int i = 0 ; i < AddToTheCartButton.size();i++) {
		// AddToTheCartButton.get(i).click();
	}

	@Test(priority = 4, enabled = false)
	public void RemoveItemFromThecart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	}

	@Test(priority = 5, enabled = false)

	public void AddItemsThatStartsWithSauce() {

		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			if (ItemsNames.get(i).getText().startsWith("Sauce")) {
				continue;

			}
			AddToCartButtons.get(i).click();

		}
	}

	@Test(priority = 2)

	public void AddRandomItem() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		int randomIndex = rand.nextInt(AddToCartButtons.size());
		System.out.println(randomIndex);

//		double randomIndex = Math.floor (Math.random()*AddToCartButtons.size());
//		System.out.println(Math.random()*AddToCartButtons.size());
//		System.out.println(Math.floor(6.9));
//		System.out.println(Math.ceil(88.5));
		AddToCartButtons.get(randomIndex).click();

	}

	@Test(priority = 4)
	public void CheckoutProcess() {
		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();
		WebElement CheckOutButton = driver.findElement(By.id("checkout"));
		CheckOutButton.click();

		// Array of random first names
		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };
		int RandomfirstName = rand.nextInt(firstNames.length);

		// Array of random last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		int RandomlastNames = rand.nextInt(lastNames.length);

		String[] postalCodes = {"90210", "10001", "30301", "94105", "33101"};
		int RandompostalCodes = rand.nextInt(postalCodes.length);
		

		WebElement FirstnameInput = driver.findElement(By.id("first-name"));
		WebElement lastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostCodeInput = driver.findElement(By.id("postal-code"));

		FirstnameInput.sendKeys(firstNames[RandomfirstName]);
		lastNameInput.sendKeys(lastNames[RandomlastNames]);
		PostCodeInput.sendKeys(postalCodes[RandompostalCodes]);
		
        WebElement ContinueButton = driver.findElement(By.id("continue"));
        ContinueButton.click();
        WebElement FinishButton = driver.findElement(By.id("finish"));
        FinishButton.click();
	}

	@AfterTest

	public void PostTesting() {

	}

}
