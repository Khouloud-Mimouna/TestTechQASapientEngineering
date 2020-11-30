package com.step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class StepDefinitions {
    public StepDefinitions(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    private final WebDriver driver;

    @Given("^the user open google$")
    public void the_user_open_google() throws Exception {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");

    }
    @When("^the user search for \"([^\"]*)\"$")
    public void theUserWriteTheInTheSearchBar(String arg0) throws Throwable {
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys(arg0);
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }


    @Then("^the search result start with \"([^\"]*)\" is displayed$")
    public void theSearchIsDisplayed(String arg0) throws Throwable {
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().toLowerCase().startsWith(arg0);
            }
        });
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }







}
