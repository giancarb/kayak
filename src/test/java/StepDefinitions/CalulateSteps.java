package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class CalulateSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		
		String Projpath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/gianlucacarbone/Dev/IdeaProjects/ubs_exercise/aparna/src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
	}

	@And("user is on simplified calculator page")
	public void user_is_on_simplified_calculator_page() {
		driver.get("https://testpages.herokuapp.com/calculate.php");
	}

	@When("user enters a number {string} in the first edit box")
	public void user_enters_an_integer_in_the_first_edit_box(String Value1) {
		driver.findElement(By.xpath("//input[@id='number1']")).sendKeys(Value1);

	}

	@And("user enters a number {string} in the second edit box")
	public void user_enters_an_integer_in_the_second_edit_box(String Value2) {
		driver.findElement(By.xpath("//input[@id='number2']")).sendKeys(Value2);
	}

	@And("user chose the {string} operator")
	public void user_chose_the_plus_operator(String Operator) {
		Select select = new Select(driver.findElement(By.id("function")));
		if(Operator.equals("plus")) {
			select.selectByVisibleText("plus");
		}
		else if(Operator.equals("times")){
			select.selectByVisibleText("times");
		}
		else if(Operator.equals("minus")){
			select.selectByVisibleText("minus");
		}
		else if(Operator.equals("divide")){
			select.selectByVisibleText("divide");
		}
		
	}

	@And("user hits on Calculate")
	public void user_hits_on_calculate() throws InterruptedException {
		driver.findElement(By.id("calculate")).click();
		Thread.sleep(1000);
	}

	@Then("Validating the sum of {string} and {string} should appear in the Answer")   //\"(.*)\"
	public void sum_of_and_should_appear_in_the_answer_as_result(String val1, String val2) {
		String Val = driver.findElement(By.id("answer")).getText();
		System.out.println(Val);
		if(Val.equals("-0")) {
			Assert.fail("As value is showing as '-0', its incorrect");
			driver.quit();
		}
		else if(val1.contains(".") || val2.contains("."))  {
			try {
				double num1 = Double.parseDouble(val1);
				double num2 = Double.parseDouble(val2);
				double ActResult = Double.parseDouble(Val);
				double ExpResults = num1 + num2;
				if(ActResult == ExpResults) {
					Assert.assertTrue("Sum is correct", true);
				}
				else {
					Assert.fail("Sum is incorrect, Result shows only six decimal points");
					driver.quit();
				}
			}
			catch(Exception e) {
				ERRMethod(Val);
			}
			driver.quit();
		}
		else {
		try {
			Integer num1 = Integer.parseInt(val1);
			Integer num2 = Integer.parseInt(val2);
			Integer ActResult = Integer.parseInt(Val);
			Integer ExpResults = num1 + num2;
			if(ActResult == ExpResults) {
				Assert.assertTrue("Sum is correct", true);
			}
			else {
				Assert.fail("Sum is incorrect");
				driver.quit();
			}
		}
		catch(Exception e) {
			ERRMethod(Val);
		}
		driver.quit();
	}
	}

	@Then("Validating the multiplication of {string} and {string} should appear in the Answer")
	public void validating_the_multiplication_of_and_should_appear_in_the_answer(String NumMulti1, String NumMulti2) {
		String Val = driver.findElement(By.id("answer")).getText();
		System.out.println(Val);
		if(Val.equals("-0")) {
			Assert.fail("As value is showing as '-0', its incorrect");
		}
		else if(NumMulti1.contains(".") || NumMulti2.contains("."))  {
			try {
				double num1 = Double.parseDouble(NumMulti1);
				double num2 = Double.parseDouble(NumMulti2);
				double ActResult = Double.parseDouble(Val);
				double ExpResults = num1 * num2;
				if(ActResult == ExpResults) {
					Assert.assertTrue("Multiplication is correct", true);
				}
				else {
					Assert.fail("Multiplication is incorrect, Result shows only six decimal points");
					driver.quit();
				}
			}
			catch(Exception e) {
				ERRMethod(Val);
			}
			driver.quit();
		}
		else {
		try {
			Integer num1 = Integer.parseInt(NumMulti1);
			Integer num2 = Integer.parseInt(NumMulti2);
			Integer ActResult = Integer.parseInt(Val);
			Integer ExpResults = num1 * num2;
			if(ActResult == ExpResults) {
				Assert.assertTrue("Multiplication is correct", true);
			}
			else {
				Assert.fail("Multiplication is incorrect");
				driver.quit();
			}
		}
		catch(Exception e) {
			ERRMethod(Val);
		}
		driver.quit();
	}
	}
	
	@Then("Validating the subtraction of {string} and {string} should appear in the Answer")
	public void validating_the_subtraction_of_and_should_appear_in_the_answer(String NumSub1, String NumSub2) {
		String Val = driver.findElement(By.id("answer")).getText();
		System.out.println(Val);
		if(Val.equals("-0")) {
			Assert.fail("As value is showing as '-0', its incorrect");
		}
		else if(NumSub1.contains(".") || NumSub2.contains("."))  {
			try {
				double num1 = Double.parseDouble(NumSub1);
				double num2 = Double.parseDouble(NumSub2);
				double ActResult = Double.parseDouble(Val);
				double ExpResults = num1 - num2;
				if(ActResult == ExpResults) {
					Assert.assertTrue("Subtraction is correct", true);
				}
				else {
					Assert.fail("Subtraction is incorrect, Result shows only six decimal points");
					driver.quit();
				}
			}
			catch(Exception e) {
				ERRMethod(Val);
			}
			driver.quit();
		}
		else {
		try {
			Integer num1 = Integer.parseInt(NumSub1);
			Integer num2 = Integer.parseInt(NumSub2);
			Integer ActResult = Integer.parseInt(Val);
			Integer ExpResults = num1 - num2;
			if(ActResult == ExpResults) {
				Assert.assertTrue("Subtraction is incorrect", true);
			}
			else {
				Assert.fail("Subtraction is incorrect");
				driver.quit();
			}
		}
		catch(Exception e) {
			ERRMethod(Val);
		}
		driver.quit();
	}
	}
	@Then("Validating the division of {string} and {string} should appear in the Answer")
	public void validating_the_division_of_and_should_appear_in_the_answer(String NumDiv1, String NumDiv2) {
		String Val = driver.findElement(By.id("answer")).getText();
		System.out.println(Val);
		if(Val.equals("-0")) {
			Assert.fail("As value is showing as '-0', its incorrect");
			driver.quit();
		}
		else if(NumDiv1.contains(".") || NumDiv2.contains("."))  {
			try {
				double num1 = Double.parseDouble(NumDiv1);
				double num2 = Double.parseDouble(NumDiv2);
				double ActResult = Double.parseDouble(Val);
				double ExpResults = num1 / num2;
				if(ActResult == ExpResults) {
					Assert.assertTrue("Division is correct", true);
				}
				else {
					Assert.fail("Division is incorrect, Result shows only six decimal points");
					driver.quit();
				}
			}
			catch(Exception e) {
				ERRMethod(Val);
			}
			driver.quit();
		}
		else {
		try {
			Integer num1 = Integer.parseInt(NumDiv1);
			Integer num2 = Integer.parseInt(NumDiv2);
			Integer ActResult = Integer.parseInt(Val);
			Integer ExpResults = num1 / num2;
			if(ActResult == ExpResults) {
				Assert.assertTrue("Division is incorrect", true);
			}
			else {
				Assert.fail("Division is incorrect");
				driver.quit();
			}
		}
		catch(Exception e) {
			ERRMethod(Val);
		}
		driver.quit();
	}
	
	}
	public static void ERRMethod(String value) {
		String ExpResults = "ERR";
		if(value.equals(ExpResults)) {
			Assert.assertTrue("Application shows expected ERR message", true);
		}
		else {
			Assert.fail("Application does not show expected ERR message");
		}
	}
}