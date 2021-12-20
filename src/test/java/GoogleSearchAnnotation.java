import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchAnnotation {

    @Test
    public void googleSearch() {

//        WebDriverManager.chromedriver().setup();

//        WebDriver driver = new ChromeDriver();

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");
    }
}


