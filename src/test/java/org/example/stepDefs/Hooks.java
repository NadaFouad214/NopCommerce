package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver ;
    @Before
    public void openBrowser()
    {
       // System.setProperty("Webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @After
    public void quit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();

    }
}
