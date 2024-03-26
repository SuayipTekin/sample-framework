package com.search.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchStepDef {
    ChromeDriver driver;

    @Given("User should be able to go to google search page")
    public void user_should_be_able_to_go_to_google_search_page() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://www.google.com/");
    }

    @When("User searches \"([^\"]*)\"$")
    public void user_search(String string) {

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(string);
        searchBox.submit();
    }

    @Then("User able to see \"([^\"]*)\" on the page$")
    public void user_see_on_the_page(String expectedGogoText) {

        WebElement gogoText = driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']"));

        String actualGogoText = gogoText.getText();

        System.out.println("Actual Gogo text is " + actualGogoText);

        Assert.assertEquals(expectedGogoText, actualGogoText);

        driver.quit();
    }
}
