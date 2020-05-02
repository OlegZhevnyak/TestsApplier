import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Day10/src/main/resources/chromedriver.exe");
        driver.get("https://www.google.com/");
//        driver.navigate().to("https://yandex.by/");
//        driver.navigate().back();
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("Погода минск");
//        el.sendKeys(Keys.ENTER);
        List<WebElement> els1 = driver.findElements(By.name("btnK"));
        els1.get(1).click();
        
        driver.navigate().back();
        el.sendKeys("Погода минск");
        els1.get(2).click();

//        driver.quit();
    }
}
