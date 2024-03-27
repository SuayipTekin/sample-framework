package com.di_request;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiRequest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dentalintel.com/");

        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement demoButton = driver.findElement(By.xpath("//a[text()='Get a Demo']"));

        wait.until(ExpectedConditions.visibilityOf(demoButton));
        System.out.println(demoButton.getText());
        wait.until(ExpectedConditions.elementToBeClickable(demoButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(demoButton).click().perform();

        WebElement firstName=driver.findElement(By.id("First-Name"));

        firstName.sendKeys("Suayip");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}