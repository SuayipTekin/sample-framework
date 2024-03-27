package com.search.google_search;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        System.out.println(driver.getTitle());

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("book");
        searchBox.submit();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@id, 'tsuid')]/div[2]/div/div/div/div/div[2]/div[1]/div"));
        System.out.println(elements.size());
        for (WebElement element : elements) {
            if (element.getText().contains("Happy Place")) {
                System.out.println("Element text: " + element.getText());
                element.click();
            }
        }
//        driver.close();
    }
}
