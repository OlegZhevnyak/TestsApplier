import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HighestPriceTest {

    public static void main(String[] args) throws InterruptedException {

        String pathToDriver = "Day10/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriver driver = new ChromeDriver();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusTreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);

        driver.get("https://www.booking.com/");

        WebElement cityChoosingField = driver.findElement(By.id("ss"));
        cityChoosingField.sendKeys("Paris");
        WebElement checkIn = driver.findElement(By.xpath("//div[@class=\"sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon\"]//span[@class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]"));
        checkIn.click();
        WebElement startDate = driver.findElement(By.xpath("//td[@data-date=\"" + datePlusTreeDays + "\"]"));
        startDate.click();
        WebElement finishDate = driver.findElement(By.xpath("//td[@data-date=\"" + datePlusTenDays + "\"]"));
        finishDate.click();
        WebElement guestsToggle = driver.findElement(By.xpath("//span[@class=\"xp__guests__count\"]"));
        guestsToggle.click();
        WebElement adultsIncrement = driver.findElement(By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"][@aria-describedby=\"group_adults_desc\"]"));
        adultsIncrement.click();
        adultsIncrement.click();
        WebElement roomsIncrement = driver.findElement(By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"][@aria-describedby=\"no_rooms_desc\"]"));
        roomsIncrement.click();
        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"sb-searchbox__button \"][@type=\"submit\"]"));
        searchButton.click();

        WebElement sortByLowestPrice = driver.findElement(By.xpath("//a[@class=\"sort_option \"][@role=\"button\"][@data-category=\"price\"]"));
        sortByLowestPrice.click();

        WebElement highestPricePhilter = driver.findElement(By.xpath("//a[@data-id=\"pri-5\"]"));
        highestPricePhilter.click();

        WebElement highestPrice = driver.findElement(By.xpath("//a[@data-id=\"pri-5\"]//span"));
        String highestPriceString = highestPrice.getText();
        System.out.println(highestPriceString);
        highestPriceString = highestPriceString.replaceAll("[^0-9]+", "");
        int highestPricePerDay = Integer.parseInt(highestPriceString);
        System.out.println(highestPricePerDay);

        Thread.sleep(5000);

        WebElement lowestFromHighestPrice = driver.findElement(By.xpath("//div[@id=\"hotellist_inner\"]/div[1]//div[@class=\"room_details \"]//div[2][@class=\"prco-ltr-right-align-helper\"]/div"));

        String priceTextFinal = lowestFromHighestPrice.getText();
        System.out.println(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int pricePerDay = Integer.parseInt(priceTextFinal) / 7;
        System.out.println("Price per day: " + pricePerDay);

        Assert.assertTrue("highestPricePerDay should be >= then pricePerDay", highestPricePerDay >= pricePerDay);
    }
}
