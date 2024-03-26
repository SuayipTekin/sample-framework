package com.date_picker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerWithMethod {
    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        // initiating the chrome driver object
        driver = new ChromeDriver();


        // Opening the browser
        driver.get("https://seleniumpractise.blogspot.com/search?q=date");

        // Clicking on the calendar
        driver.findElement(By.id("datepicker")).click();

        // Waiting the webelement appear on the page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

        selectDate("3", "June", "2024");
    }

    public static String[] getMonthAndYear(String monthYearVal){
        return monthYearVal.split(" ");
    }

    public static void selectDate(String exDay, String exMonth, String exYear) {
        String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();

        System.out.println("Month and Year value: " + monthYearValue);

        while (!getMonthAndYear(monthYearValue)[0].equals(exMonth) && !!getMonthAndYear(monthYearValue)[1].equals(exYear)) {
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
        }

        driver.findElement(By.xpath("//a[text()='" + exDay + "']")).click();
    }

}
