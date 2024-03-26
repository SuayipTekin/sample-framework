package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    private static WebDriver driver;

    private Driver(){} //lock Driver object to be created by others

    public static WebDriver getDriver(){
        if(driver == null){
            //TODO
            String browser=ConfigurationReader.getProperty("browser");
            switch (browser.trim()){
                case "chrome":
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--allow-running-insequre-content");
                    options.addArguments("--disable-infobars");
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    DesiredCapabilities capabilities= new DesiredCapabilities().internetExplorer();
                    capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
                    capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, false);
                    capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
                    capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver(capabilities);
                    break;
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
