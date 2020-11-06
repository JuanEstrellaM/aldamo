package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", ".\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void loginExitoso() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("opensourcecms","opensourcecms");
        loginPage.assertPageSuccessful();
    }

    @Test
    public void loginFallido() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("opensourcecms","BADPASS");
        loginPage.assertPageFailed();
    }


    @Test
    public void creacionCliente() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        loginPage.Login("opensourcecms","opensourcecms");
        loginPage.assertPageSuccessful();
        mainPage.addCustomers();
        Thread.sleep(5000);
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
