package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    By xpathAssertSuccessful = By.xpath("//*[@id=\"option-menu\"]/li[1]");
    By xpathAssertFailed = By.xpath("//*[@id=\"spanMessage\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void Login(String name, String pass){
        driver.findElement(By.xpath("//*[@id=\"divUsername\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(name);
        driver.findElement(By.xpath("/html/body/div[1]/div/img")).click();

        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/input")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
    }

    public void assertPageSuccessful(){
        Assert.assertEquals(driver.findElement(xpathAssertSuccessful).getText(), "Bienvenido Admin");
    }
    public void assertPageFailed(){
        Assert.assertEquals(driver.findElement(xpathAssertFailed).getText(), "Invalid credentials");
    }
}
