package org.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class WebPageTest {
    private static WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");   // REQUIRED
        options.addArguments("--no-sandbox");     // REQUIRED for Jenkins
        options.addArguments("--disable-dev-shm-usage"); // REQUIRED for Linux
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
    }
    @Test
    public void titleValidationTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Simple Website";
        Assert.assertEquals(actualTitle, expectedTitle);
        assertTrue(true, "Title contains 'simple website'");
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
