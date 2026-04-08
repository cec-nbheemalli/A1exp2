package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

class WebPageTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }

    @Test
    public void titleValidationTest() {
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}