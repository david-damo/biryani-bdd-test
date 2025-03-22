package com.biryani.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

public class OrderSteps {
    private WebDriver driver;

    @Given("I am on the Biryani Order page")
    public void i_am_on_the_biryani_order_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @When("I enter my name as {string}")
    public void i_enter_my_name_as(String name) {
        WebElement nameField = driver.findElement(By.id("customerName"));
        nameField.sendKeys(name);
    }

    @When("I select {string} Biryani")
    public void i_select_biryani(String biryaniType) {
        WebElement biryaniDropdown = driver.findElement(By.id("biryaniType"));
        biryaniDropdown.sendKeys(biryaniType);
    }

    @When("I enter quantity as {string}")
    public void i_enter_quantity_as(String quantity) {
        WebElement quantityField = driver.findElement(By.id("quantity"));
        quantityField.sendKeys(quantity);
    }

    @When("I place the order")
    public void i_place_the_order() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    @Then("I should see the order status as {string}")
    public void i_should_see_the_order_status_as(String status) throws InterruptedException {
    	Thread.sleep(1000);
        WebElement statusElement = driver.findElement(By.xpath("//h2[text()='Order Status']"));//.id("orderStatus"));
        assertTrue(statusElement.getText().contains(status));
        driver.quit();
    }
}