package Stepdef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class loginbdd extends env_target {


    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALFISYAHRIN GUSMAN\\IdeaProjects\\Bissmilah_QA\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }

    @When("User fill username and password")
    public void user_fill_username_and_password() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("User verify login result")
    public void user_verify_login_result() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );
        driver.quit();

    }

    @When("User fill password but invalid username")
    public void user_fill_password_but_invalid_username() {
            driver.findElement(By.name("user-name")).sendKeys("mmmmm@gmail.com");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
        }


    @Then("User get error username password not match")
    public void User_get_error_username_password_not_match () {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
        driver.quit();
    }

    @When("User fill valid username and invalid password")
    public void user_fill_valid_username_and_invalid_password() {
        driver.findElement(By.name("user-name")).sendKeys("secret_user");
        driver.findElement(By.id("password")).sendKeys("dummypw");

    }
    @Then("User get error  password not match")
    public void User_get_error_password_not_match () {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
        driver.quit();
    }

    @When("User fill invalid username and invalid password")
    public void userFillInvalidUsernameAndInvalidPassword() {
        driver.findElement(By.name("user-name")).sendKeys("mmmmm@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dummypw");
    }

    @Then("User get error  usernam and password not match")
    public void userGetErrorUsernamAndPasswordNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
        driver.quit();

    }
}
