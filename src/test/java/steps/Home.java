package steps;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home {

	WebDriver driver = null;
	String toDoName = "Framework Design Task";
	String baseURL = "https://todomvc.com/examples/vue/";

	@Given("user launching browser")
	public void user_is_on_todo_page() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user navigates to todo page")
	public void user_navigates_to_todo_page() {
		driver.navigate().to(baseURL);
	}

	@When("user enters todo name")
	public void user_enter_todo_name() {
		driver.findElement(By.className("new-todo")).sendKeys(toDoName);
	}

	@And("click on enter")
	public void click_on_enter() {
		driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
	}

	@And("close browser")
	public void close_browser() {
		// driver.close();
	}

	@Then("todo is added in the list")
	public void todo_is_added_in_the_list() {
		boolean isLabelPresent = true;
		try {
			driver.findElement(By.xpath("/html/body/section/section/ul/li/div/label"));
		} catch (NoSuchElementException e) {
			isLabelPresent = false;
		}
		Assert.assertTrue(isLabelPresent);

	}

	@When("click on delele todo")
	public void click_on_delele_todo() throws InterruptedException {
		
		WebElement destroyToDo = driver.findElement(By.className("destroy"));
		WebElement toDoName = driver.findElement(By.xpath("/html/body/section/section/ul/li/div/label"));
		Actions action = new Actions(driver);
		action.moveToElement(toDoName).build().perform();
		destroyToDo.click();
	}

	@Then("todo should be deleted from list")
	public void todo_should_be_deleted_from_list() {
		Assert.assertFalse(driver.findElements(By.xpath("/html/body/section/section/ul/li/div/label")).size() != 0);

	}
	
	
	@And("select todo created")
	public void select_todo_created() {
		driver.findElement(By.className("toggle")).click();
	}
	
	
	@Then("todo should be completed")
	public void todo_should_be_completed() {
		Assert.assertTrue(driver.findElements(By.className("clear-completed")).size() == 1);
	}

}
