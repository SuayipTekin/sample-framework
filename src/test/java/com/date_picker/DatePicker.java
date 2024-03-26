package com.date_picker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // initiating the chrome driver object
        WebDriver driver = new ChromeDriver();

        // Opening the browser
        driver.get("https://seleniumpractise.blogspot.com/search?q=date");

        // Clicking on the calendar
        driver.findElement(By.id("datepicker")).click();

        // Waiting the webelement appear on the page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

        String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();

        System.out.println("Month and Year value: " + monthYearValue);

        String month = monthYearValue.split(" ")[0].trim();
        String year = monthYearValue.split(" ")[1].trim();

        while (!month.equals("June") && !year.equals("2024")) {
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
            System.out.println(monthYearValue);
            monthYearValue.split(" ")[0].trim();
            monthYearValue.split(" ")[1].trim();
        }
        driver.findElement(By.xpath("//a[text()='24']")).click();
    }
}
