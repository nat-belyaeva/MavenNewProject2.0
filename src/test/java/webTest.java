import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class webTest {

    @Test
    public void test1MenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/Programs/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";


        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id ='navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );
        menuBrowseLanguages.click();

        sleep(1000);
        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/']")
        );
        menuStart.click();
        sleep(1000);

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'main']/h2"));

        String actualResult = h2.getText();
        sleep(2000);

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();

    }
}
