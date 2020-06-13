import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ColorTest {

    public static void main(String[] args) throws InterruptedException {

        String pathToDriver = "Day10/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriver driver = new ChromeDriver();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date afterOneDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date toOneNight = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateAfterOneDay = dateFormat.format(afterOneDay);
        String dateToOneNight = dateFormat.format(toOneNight);

        driver.get("https://www.booking.com/");

        WebElement cityChoosingField = driver.findElement(By.id("ss"));
        cityChoosingField.sendKeys("Oslo");

        WebElement checkIn = driver.findElement(By.xpath("//div[@class=\"sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon\"]//span[@class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]"));
        checkIn.click();

        WebElement startDate = driver.findElement(By.xpath("//td[@data-date=\"" + dateAfterOneDay + "\"]"));
        startDate.click();

        WebElement finishDate = driver.findElement(By.xpath("//td[@data-date=\"" + dateToOneNight + "\"]"));
        finishDate.click();

        WebElement guestsToggle = driver.findElement(By.xpath("//span[@class=\"xp__guests__count\"]"));
        guestsToggle.click();

        WebElement childrenIncrement = driver.findElement(By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"][@aria-describedby=\"group_children_desc\"]"));
        childrenIncrement.click();
        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"sb-searchbox__button \"][@type=\"submit\"]"));
        searchButton.click();

        WebElement threeStarsCheckbox = driver.findElement(By.xpath("//a[@data-id=\"class-3\"]"));
        threeStarsCheckbox.click();

        WebElement fourStarsCheckbox = driver.findElement(By.xpath("//a[@data-id=\"class-4\"]"));
        fourStarsCheckbox.click();

        Thread.sleep(5000);

        WebElement tenthHotel = driver.findElement(By.xpath("//div[@id=\"hotellist_inner\"]/div[10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", tenthHotel);

        WebElement hotelName = driver.findElement(By.xpath("//div[@id=\"hotellist_inner\"]/div[10]//h3/a/span[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", hotelName);

        Assert.assertEquals("hotelName color should be red",
                "color: red;", hotelName.getAttribute("style"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotelName);
    }
}
