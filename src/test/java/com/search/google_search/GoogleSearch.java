package com.search.google_search;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        System.out.println(driver.getTitle());

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("book");
        searchBox.submit();
//        driver.close();

        driver.get("https://www.google.com/");

        driver.close();

        System.out.println();

        System.out.println("gftyfkfuyfyfu luyfoo");
        System.out.println("");
    }
}
