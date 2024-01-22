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

public class ShopBDD extends env_target {
    @Given("User is already succesfully login on Product page")
    public void user_is_already_succesfully_login_on_product_page() {
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
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @And("User clicking login button")
    public void user_clicking_login_button() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("The products must shown up")
    public void the_products_must_shown_up() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory_container\"]/div"))

        );


    }
//TC_SHOP_B_02//

    @When("User click Add button")
    public void userClickAddButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("The cart badge pops up")
    public void theCartBadgePopsUp() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge"))
        );

    }


    @And("User click the cart")
    public void userClickTheCart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("User redirected to Your Cart page")
    public void userRedirectedToYourCartPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span"))
        );
    }

    @And("User click remove button")
    public void userClickRemoveButton() {
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();

    }

    @Then("The cart are being empty")
    public void theCartAreBeingEmpty() {
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]"));
        driver.quit();
    }

    //TC_SHOP_B_03//
    @And("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span"))
        );
    }

    @And("User fill the user data")
    public void userFillTheUserData() {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Alfi");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Gusman");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("11123");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout_summary_container\"]/div"))
        );


    }

    @And("User click Finish button")
    public void userClickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("The page will show order invoice")
    public void thePageWillShowOrderInvoice() {
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout_complete_container\"]"));
        driver.quit();
    }

    @Then("The cart are empty")
    public void theCartAreEmpty() {
        ExpectedConditions.visibilityOfElementLocated(By.className("removed_cart_item"));
    }

    @Then("User cannot doing chekout and errormessage are showed")
    public void userCannotDoingChekoutAndErrormessageAreShowed() {
        assert !driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isEnabled();

    }


}
