import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Selenium2 {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusTreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);

        System.setProperty("webdriver.chrome.driver", "Day10/src/main/resources/chromedriver.exe");
        driver.get("https://www.booking.com/");
//        driver.navigate().to("https://yandex.by/");
//        driver.navigate().back();
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        WebElement el1 = driver.findElement(By.id("ss"));
        el1.sendKeys("Paris");
        WebElement el2 = driver.findElement(By.xpath("//div[@class=\"sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon\"]//span[@class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]"));
        el2.click();
        WebElement el3 = driver.findElement(By.xpath("//td[@data-date=\""+datePlusTreeDays+"\"]"));
        el3.click();
        WebElement el4 = driver.findElement(By.xpath("//td[@data-date=\""+datePlusTenDays+"\"]"));
        el4.click();
        WebElement el5 = driver.findElement(By.xpath("//span[@class=\"xp__guests__count\"]"));
        el5.click();
        WebElement el6 = driver.findElement(By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"][@aria-label=\"Increase number of Adults\"]"));
        el6.click();
        el6.click();
        WebElement el7 = driver.findElement(By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"][@aria-label=\"Increase number of Rooms\"]"));
        el7.click();
        WebElement el8 = driver.findElement(By.xpath("//button[@class=\"sb-searchbox__button \"][@type=\"submit\"]"));
        el8.click();
        WebElement el9 = driver.findElement(By.xpath("//a[@data-id=\"pri-5\"]"));
        el9.click();
        WebElement el10 = driver.findElement(By.xpath("//a[@class=\"sort_option \"][@role=\"button\"][@data-category=\"price\"]"));
        el10.click();
        WebElement el11 = driver.findElement(By.xpath("//div[@id=\"hotellist_inner\"]/div[1]//div[@class=\"bui-price-display__value prco-inline-block-maker-helper\"]"));
        el11.click();


//        el.sendKeys(Keys.ENTER);
//        el.sendKeys(Keys.ENTER);
//        List<WebElement> els1 = driver.findElements(By.name("btnK"));
//        els1.get(1).click();
//
//        driver.navigate().back();
//        el.sendKeys("Погода минск");
//        els1.get(2).click();

//        driver.quit();
    }
}
