import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LowestPriceTest {

    public static void main(String[] args) throws InterruptedException {

        String pathToDriver = "Day10/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date tenDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fiveDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusTreeDays = dateFormat.format(tenDays);
        String datePlusTenDays = dateFormat.format(fiveDays);

        driver.get("https://www.booking.com/");

        WebElement cityChoosingField = driver.findElement(By.id("ss"));
        cityChoosingField.sendKeys("Moscow");

        WebElement checkIn = driver.findElement(By.xpath("//div[@class=\"sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon\"]//span[@class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]"));
        checkIn.click();

        WebElement startDate = driver.findElement(By.xpath("//td[@data-date=\"" + datePlusTreeDays + "\"]"));
        startDate.click();

        WebElement finishDate = driver.findElement(By.xpath("//td[@data-date=\"" + datePlusTenDays + "\"]"));
        finishDate.click();

        WebElement guestsToggle = driver.findElement(By.xpath("//span[@class=\"xp__guests__count\"]"));
        guestsToggle.click();

        WebElement adultsIncrement = driver.findElement(By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"][@aria-describedby=\"group_adults_desc\"]"));

        actions.click(adultsIncrement).build().perform();
        actions.click(adultsIncrement).build().perform();

        WebElement roomsIncrement = driver.findElement(By.xpath("//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"][@aria-describedby=\"no_rooms_desc\"]"));
        actions.click(roomsIncrement).build().perform();

        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"sb-searchbox__button \"][@type=\"submit\"]"));
        actions.click(searchButton).build().perform();

        WebElement lowestPricePhilter = driver.findElement(By.xpath("//a[@data-id=\"pri-1\"]/label/div"));
        lowestPricePhilter.click();

        WebElement highestOfLowestPriceFromPhilter = driver.findElement(By.xpath("//a[@data-id=\"pri-1\"]//span"));
        String highestPriceString = highestOfLowestPriceFromPhilter.getText();
        System.out.println(highestPriceString);
        highestPriceString = highestPriceString.replaceAll("[^0-9]+", "");
        int highestPricePerDay = Integer.parseInt(highestPriceString);
        System.out.println(highestPricePerDay);

        Thread.sleep(5000);

        WebElement firstPriceFromList = driver.findElement(By.xpath("//div[@id=\"hotellist_inner\"]/div[1]//div[@class=\"room_details \"]//div[2][@class=\"prco-ltr-right-align-helper\"]/div"));

        String priceTextFinal = firstPriceFromList.getText();
        System.out.println(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int pricePerDay = Integer.parseInt(priceTextFinal) / 10;
        System.out.println("Price per day: " + pricePerDay);

        Assert.assertTrue("pricePerDay should be < then highestPricePerDay",
                pricePerDay <= highestPricePerDay);
    }
}
