package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class kayak {

    WebDriver driver = null;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/aparna/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }


    @After
    public void afterClass() {
        driver.quit();
    }


    @Given("user is on kayak page")
    public void user_is_on_simplified_calculator_page() {
        driver.get("https://www.kayak.ch");
    }


    @When("user accept privacy")
    public void user_enters_an_integer_in_the_first_edit_box() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Akzeptieren')]")));
        element.click();
    }


    @When("select data")
    public void selectTrip() throws InterruptedException {

        setDeparture();
        setArrival();
        search();

    }


    @Then("user is on result page")
    public void isOnResultPage() throws InterruptedException {

        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.kayak.ch/flights/"));
    }

    @And("user set Departure and Arrival Date")
    public void setDepartureAndArrivalDate()  {
        setStartAndArrivalDate();
    }

    @And("user set price")
    public void setPrice(){

        driver.findElement(By.xpath("//div[contains(@id,'price-title')]")).click();

        String currentRange = driver.findElement(By.xpath("//div[contains(@id,'price-slider-rangeLabel')]")).getText();

    }


    public void setDeparture() throws InterruptedException {
        driver.findElement(By.cssSelector("div[aria-label='Eingabe Abflughafen']")).click();
        driver.findElements(By.cssSelector("div[role='textbox']")).get(0).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.cssSelector("input[class='k_my-input']")).sendKeys("Rom, Italien (ROM)");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[class='k_my-input']")).sendKeys(Keys.ENTER);
    }


    public void setArrival() throws InterruptedException {
        driver.findElement(By.cssSelector("div[aria-label='Eingabe Flugziel']")).click();
        driver.findElements(By.cssSelector("div[role='textbox']")).get(1).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.cssSelector("input[class='k_my-input']")).sendKeys("Zürich (ZRH)");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[class='k_my-input']")).sendKeys(Keys.ENTER);
    }

    public void search() {
        driver.findElement(By.cssSelector("button[aria-label='Suchen']")).click();
    }

    public void setStartAndArrivalDate() {

        driver.findElement(By.xpath("//div[contains(@class,'travel-dates')]")).click();
        driver.findElements(By.xpath("//div[contains(@id,'departDate')]")).get(1).sendKeys("10.10.2022");
        driver.findElements(By.xpath("//div[contains(@id,'returnDate')]")).get(1).sendKeys("15.11.2022");
        driver.findElements(By.xpath("//div[contains(@id,'returnDate')]")).get(1).sendKeys(Keys.ENTER);

    }





}


